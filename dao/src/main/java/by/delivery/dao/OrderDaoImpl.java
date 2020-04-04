package by.delivery.dao;

import by.delivery.entity.Dish;
import by.delivery.entity.Order;
import by.delivery.entity.User;

import java.sql.*;

public class OrderDaoImpl implements OrderDao<User, Dish, Order> {

    private final static String INSERT_QUERY = "INSERT INTO orders (user_id, dish_id, date) VALUES (?, ?, ?);";
    private static final String FIND_ORDER_QUERY = "SELECT * FROM orders WHERE id = ?;";
    private static OrderDaoImpl INSTANCE;

    private OrderDaoImpl() {

    }

    public static OrderDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean save(User user, Dish dish, Order order) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, user.getId());
            statement.setLong(2, dish.getId());
            statement.setDate(3, Date.valueOf(String.valueOf(order.getDateTime())));
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
