package movie.hub.com.config.db;

import org.springframework.beans.factory.annotation.Value;

public class DynamicDataSourceContextHolder {

	@Value("${datasource.default.prefix}")
	private static String defaultPrefix;
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

	public static void setDataSourceTypeDefault() {
        contextHolder.set(defaultPrefix);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}