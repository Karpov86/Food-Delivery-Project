package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity {

    @Column(name = "price")
    private Float price;
    @Column(name = "sale")
    private Boolean isSale;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(price, dish.price)
                && Objects.equals(isSale, dish.isSale)
                && Objects.equals(name, dish.name)
                && category == dish.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, isSale, name, category);
    }

    public static class Builder {

        private Dish newDish;

        public Builder() {
            newDish = new Dish();
        }

        public Builder setId(Long id) {
            newDish.setId(id);
            return this;
        }

        public Builder setPrice(Float price) {
            newDish.price = price;
            return this;
        }

        public Builder setIsSale(Boolean isSale) {
            newDish.isSale = isSale;
            return this;
        }

        public Builder setName(String name) {
            newDish.name = name;
            return this;
        }

        public Builder setCategory(Category category) {
            newDish.category = category;
            return this;
        }

        public Dish build() {
            return newDish;
        }
    }
}
