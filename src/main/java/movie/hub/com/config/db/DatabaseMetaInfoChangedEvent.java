package movie.hub.com.config.db;

import org.springframework.context.ApplicationEvent;

public class DatabaseMetaInfoChangedEvent extends ApplicationEvent {
    public DatabaseMetaInfoChangedEvent(Object source) {
        super(source);
    }
}