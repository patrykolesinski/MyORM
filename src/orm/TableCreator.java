package orm;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 28.05.2017.
 */
public interface TableCreator {
    void createTables(List<Class> entities);
}
