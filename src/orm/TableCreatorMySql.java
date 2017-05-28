package orm;

import annotation.Column;
import annotation.Entity;
import database.Database;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 28.05.2017.
 */
public class TableCreatorMySql implements TableCreator{

    @Override
    public void createTables(List<Class> entities) {
        Database database = new Database();
        //@TODO Jako parametr to z pliku np
        database.prepareConnection("jdbc:mysql://localhost:3306/orm?user=root");
        entities.forEach(e -> {
            String query = prepareQuery(e);
            database.executeCreate(query);
        });
    }

    private String prepareQuery(Class e) {
        String query = "CREATE TABLE ";
        Entity entity = (Entity) e.getAnnotation(Entity.class);
        String entityName = entity.name();
        if (entityName.equals("default")) {
            query = query.concat(e.getSimpleName());
        } else {
            query = query.concat(entity.name());
        }
        query = query.concat(" ( ");
        Field[] fields = e.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Column.class)) {
                Column column = f.getAnnotation(Column.class);
                if (column.name().equals("default")) {
                    //@TODO Wybór typu pola w bazie
                    query = query.concat(f.getName() + " TEXT, ");
                } else {
                    query = query.concat(column.name() + " TEXT, ");
                }
            } else {
                query = query.concat(f.getName() + " TEXT, ");
            }
        }
        query = query.substring(0, query.length() - 2);
        query = query.concat(" );");
        return query;
    }
}
