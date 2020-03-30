package by.delivery.entity;

import java.util.Objects;

public class Dish extends BaseEntity {

    private Float price;
    private Boolean isSale;
    private String name;
    private Category category;

    public Dish() {
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(price, dish.price) &&
                Objects.equals(isSale, dish.isSale) &&
                Objects.equals(name, dish.name) &&
                category == dish.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, isSale, name, category);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", isSale=" + isSale +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
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
