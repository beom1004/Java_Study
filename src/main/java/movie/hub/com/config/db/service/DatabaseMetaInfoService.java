package movie.hub.com.config.db.service;

import lombok.extern.slf4j.Slf4j;
import movie.hub.com.config.db.entity.DatabaseMetaInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Slf4j
@Service
public class DatabaseMetaInfoService {
	@Value("${datasource.url}")
	private String mainJdbcUrl;

	@Value("${datasource.username}")
	private String mainUsername;

	@Value("${datasource.password}")
	private String mainPassword;

	/*
	* 대상 DB 목록 조회
	*/
    public ArrayList<DatabaseMetaInfo> getAllDatabaseMetaInfo() throws SQLException {
		ArrayList<DatabaseMetaInfo> metaInfoList = new ArrayList<>();
//		String sql = "SELECT DIAG_DB_ID, DIAG_DB_TYPE, DIAG_DB_HOST, DIAG_DB_PORT, DIAG_DB_SERVICE_NM, DIAG_DB_CHARSET, DIAG_DB_USER_NM, DIAG_DB_PW FROM TB_DIAG_DB";
//
//		Connection conn = DriverManager.getConnection(mainJdbcUrl, mainUsername, mainPassword);
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//
//		while (rs.next()) {
//			DatabaseMetaInfo info = new DatabaseMetaInfo();
//			info.setDiagDbId(rs.getString(1));
//			info.setDiagDbType(rs.getString(2));
//			info.setDiagDbHost(rs.getString(3));
//			info.setDiagDbPort(rs.getString(4));
//			info.setDiagDbServiceNm(rs.getString(5));
//			info.setDiagDbCharset(rs.getString(6));
//			info.setDiagDbUserNm(rs.getString(7));
//			info.setDiagDbPw(rs.getString(8));
//			metaInfoList.add(info);
//		}
//
//		log.info("######### 현재 DB 목록 조회 #########: " + sql);
//		log.info("#########  조회된 DB 개수  #########: " + metaInfoList.size());
//
//		rs.close();
//		pstmt.close();
//		conn.close();

        return metaInfoList;
    }
}