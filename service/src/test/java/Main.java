import by.delivery.dao.DishDaoImpl;
import by.delivery.entity.Dish;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Dish> dishes = DishDaoImpl.getInstance().find("pizza");
        System.out.println(dishes);
        /*DishServiceImpl dishService = new DishServiceImpl();
        List<Dish> dishes = dishService.find(Category.valueOf("PIZZA"));
        dishes.toString();*/
    }
}
