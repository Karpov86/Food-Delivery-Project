package by.delivery.service;

import by.delivery.dao.DishDaoImpl;
import by.delivery.entity.Dish;

import java.util.List;

public class DishServiceImpl implements DishService<Dish> {

    public List<Dish> find(String category) {
        return DishDaoImpl.getInstance().find(category);
    }
}
