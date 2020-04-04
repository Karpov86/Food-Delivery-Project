package by.delivery.dao;

public interface OrderDao<T, V, D> {

    boolean save(T t, V v, D d);

}
