package by.delivery.service;

import by.delivery.dao.DishDaoImpl;
import by.delivery.entity.Category;
import by.delivery.entity.Dish;

import java.util.List;

public class DishServiceImpl implements DishService<Dish, Category> {

    public List<Dish> find(Category category){
       List<Dish> dishesList = DishDaoImpl.getInstance().find(category);
       return dishesList;
    }
}
