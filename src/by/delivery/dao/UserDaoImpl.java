package by.delivery.dao;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao<User> {

    private static UserDaoImpl INSTANCE;
    private static final String INSERT_QUERY = "INSERT INTO users (name, surname, address, email, phone_number) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, surname = ?, address = ?, email = ?, phone_number = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?;";
    private static final String FIND_USER_QUERY = "SELECT * FROM users WHERE id = ?;";

    private UserDaoImpl() {

    }

    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean save(User user) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getEmail());
            statement.setLong(5, user.getPhoneNumber);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Long id, User newUserData) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, newUserData.getName());
            statement.setString(2, newUserData.getSurname());
            statement.setString(3, newUserData.getAddress());
            statement.setString(4, newUserData.getEmail());
            statement.setLong(5, newUserData.getLong());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setLong(1, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public User find(Long id) {

        User user = null;
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_QUERY);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = new User.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .setAddress(resultSet.getString("address"))
                        .setEmail(resultSet.getString("email"))
                        .setPhoneNumber(resultSet.getLong("phone_number"))
                        .build();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
