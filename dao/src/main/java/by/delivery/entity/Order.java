package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
@Column(name = "date")
    private LocalDateTime dateTime;
@Column(name = "user_id")
private User user;
@Column(name = "dish_id")
    private Dish dish;

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
