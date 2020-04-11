package by.delivery.service;

import java.util.List;

public interface DishService<T> {

    List<T> find(String category);
}
