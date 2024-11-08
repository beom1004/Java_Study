package movie.hub.com.config.db;

import lombok.extern.slf4j.Slf4j;
import movie.hub.com.config.db.service.DatabaseMetaInfoService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@MapperScan(basePackages = {"movie.hub.**.DAO", "movie.hub.**.**.DAO"}) // 매퍼 인터페이스의 위치 지정
public class DataSourceConfig {

	@Autowired
    private DatabaseMetaInfoService dbMetaInfoService;

	@Value("${datasource.url}")
	private String mainJdbcUrl;

	@Value("${datasource.username}")
	private String mainUsername;

	@Value("${datasource.password}")
	private String mainPassword;

	@Value("${datasource.default.prefix}")
	private String defaultPrefix;

	private DynamicRoutingDataSource dynamicRoutingDataSource;

	@Bean
    public DataSource dataSource() throws SQLException {
        dynamicRoutingDataSource = new DynamicRoutingDataSource();
        initializeDataSources();

        return dynamicRoutingDataSource;
    }

	/*
	* DB 변경 이벤트 리스너(DB 등록/수정/삭제 시 이벤트 호출)
	*/
	@EventListener
    public void handleDatabaseMetaInfoChangedEvent(DatabaseMetaInfoChangedEvent event) throws SQLException {
		log.info("XXXhandleDatabaseMetaInfoChangedEvent");
        initializeDataSources();
    }

	private void initializeDataSources() throws SQLException {
		log.info("XXXinitializeDataSources");

		Map<Object, Object> dataSourceMap = new HashMap<>();

		/*// H2 메인 데이터 소스
        HikariDataSource h2DataSource = new HikariDataSource();
        h2DataSource.setJdbcUrl(mainJdbcUrl);
        h2DataSource.setUsername(mainUsername);
        h2DataSource.setPassword(mainPassword);
        dataSourceMap.put(defaultPrefix, h2DataSource); // 메인DB(h2)

		// 대상 DB 데이터 소스 추가
		ArrayList<DatabaseMetaInfo> metaInfoList = dbMetaInfoService.getAllDatabaseMetaInfo();
        for (DatabaseMetaInfo metaInfo : metaInfoList) {
			String dbKndCd = metaInfo.getDiagDbType();				//DB종류코드 (Oracle/Cubrid/Tibero/MariaDB)
			String dbHost = metaInfo.getDiagDbHost();				//DB호스트명
			String dbPort = metaInfo.getDiagDbPort();				//DB포트
			String dbSid = metaInfo.getDiagDbServiceNm();			//DBSID
			String dbCharTypCd = metaInfo.getDiagDbCharset();		//문자집합유형코드 (UTF-8/EUC-KR/ISO-8859-1)
			String dbUrl = "";

            HikariDataSource dataSource = new HikariDataSource();
			switch (dbKndCd) {
				case "Oracle" :
					dbUrl = "jdbc:log4jdbc:oracle:thin:@"+dbHost+":"+dbPort+":"+dbSid;
//					dbUrl += "?characterEncoding=" + dbCharTypCd;
					break;
				case "Cubrid" :
					dbUrl = "jdbc:log4jdbc:cubrid:"+dbHost+":"+dbPort+":"+dbSid+":::";
					dbUrl += "?charset=" + dbCharTypCd;
					break;
				case "Tibero" :
					dbUrl = "jdbc:log4jdbc:tibero:thin:@"+dbHost+":"+dbPort+":"+dbSid;
					dbUrl += "?characterEncoding=" + dbCharTypCd;
					break;
			}
            dataSource.setJdbcUrl(dbUrl);
            dataSource.setUsername(metaInfo.getDiagDbUserNm());
            dataSource.setPassword(metaInfo.getDiagDbPw());
            dataSourceMap.put(metaInfo.getDiagDbId(), dataSource); // 대상DB는 구분명을 DB ID로*/
//        }

//		dynamicRoutingDataSource.setDefaultTargetDataSource(h2DataSource);
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        dynamicRoutingDataSource.afterPropertiesSet();
    }

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        // MyBatis 설정 파일 위치 지정
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("movie.hub.**.entity, movie.hub.**.**.entity, movie.hub.com.util");

		// MyBatis 인터셉터 설정
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{new QueryInterceptor()});

        return sqlSessionFactoryBean.getObject();
    }
}