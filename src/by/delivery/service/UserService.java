package by.delivery.service;

public interface UserService<T> {

    boolean save(T user);
}
