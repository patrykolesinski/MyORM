package orm;

import annotation.Entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Asus on 28.05.2017.
 */
public class EntityFinder {
    public static List<Class> findEntities(List<Class> classes) {
        return classes.stream()
                .filter(c -> c.isAnnotationPresent(Entity.class))
                .collect(Collectors.toList());
    }
}
