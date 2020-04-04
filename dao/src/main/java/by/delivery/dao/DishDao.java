package by.delivery.dao;

import java.util.List;

public interface DishDao<T, V> {

    List<T> find(V category);

}
