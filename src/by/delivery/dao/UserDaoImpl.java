package by.delivery.dao;

import by.delivery.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao<User> {

    private static final String INSERT_QUERY = "INSERT INTO users (name, surname, address, email, phone_number, password) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE users SET name = ?, surname = ?, address = ?, email = ?, phone_number = ?, password = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?;";
    private static final String FIND_USER_QUERY = "SELECT * FROM users WHERE id = ?;";
    private static UserDaoImpl INSTANCE;

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
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getPassword());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Long id, User newUser) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, newUser.getName());
            statement.setString(2, newUser.getSurname());
            statement.setString(3, newUser.getAddress());
            statement.setString(4, newUser.getEmail());
            statement.setString(5, newUser.getPhoneNumber());
            statement.setString(6, newUser.getPassword());
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
                user = new User.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .setAddress(resultSet.getString("address"))
                        .setEmail(resultSet.getString("email"))
                        .setPhoneNumber(resultSet.getString("phone_number"))
                        .setPassword(resultSet.getString("password"))
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
