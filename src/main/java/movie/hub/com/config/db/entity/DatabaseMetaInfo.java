package movie.hub.com.config.db.entity;

import lombok.Data;

@Data
public class DatabaseMetaInfo {
    /* 수정 필요 */
    private String diagDbId;
    private String diagDbType;
    private String diagDbHost;
    private String diagDbPort;
    private String diagDbServiceNm;
    private String diagDbCharset;
    private String diagDbUserNm;
    private String diagDbPw;
}
