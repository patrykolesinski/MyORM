package orm;

import additional.AllClassFinder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 28.05.2017.
 */
public class Invoker {
    public static void main(String[] args) {
        List<Class> classes = AllClassFinder.findClasses();
        List<Class> entities = EntityFinder.findEntities(classes);
        //@TODO Zrobic wybor bazy w tym miejscu
        TableCreator tableCreator = new TableCreatorMySql();
        tableCreator.createTables(entities);
    }
}
