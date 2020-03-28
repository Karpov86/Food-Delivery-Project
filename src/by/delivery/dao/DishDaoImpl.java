package by.delivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao<Dish, Category> {

    private static final String FIND_DISHES_FROM_CATEGORY_QUERY = "SELECT * FROM dishes WHERE category = ?;";
    private static DishDaoImpl INSTANCE;

    private DishDaoImpl() {

    }

    public static DishDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (DishDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DishDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Dish> find(Category category) {
        List<Dish> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_DISHES_FROM_CATEGORY_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(new Dish.Builder()
                        .setName(resultSet.getString("name"))
                        .setPrice(resultSet.getFloat("price"))
                        .setIsSale(resultSet.getBoolean("sale"))
                        .setCategory(Category.valueof(resultSet.getString("category")))
                        .build());
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
