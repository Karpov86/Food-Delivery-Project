package by.delivery.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order extends BaseEntity {

    private LocalDateTime dateTime;
    private User user;
    private Dish dish;

    public Order() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(dateTime, order.dateTime) &&
                Objects.equals(user, order.user) &&
                Objects.equals(dish, order.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, user, dish);
    }

public static class Builder {

        private Order newOrder;

        public Builder() {
            newOrder = new Order();
        }

        public Builder setId(Long id) {
            newOrder.setId(id);
            return this;
        }

        public Builder setDateTime(LocalDateTime dateTime) {
            newOrder.dateTime = dateTime;
            return this;
        }

        public Builder setUser(User user) {
            newOrder.user = user;
            return this;
        }

        public Builder setDish(Dish dish) {
            newOrder.dish = dish;
            return this;
        }

        public Order build() {
            return newOrder;
        }
    }
}
