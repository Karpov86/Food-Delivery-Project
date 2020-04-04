package by.delivery.service;

import java.util.List;

public interface DishService<T, V> {

    List<T> find(V category);
}
