package by.delivery.dao;

import java.util.List;

public interface DishDao<T> {

    List<T> find(String category);

}
