package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(address, user.address) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, name, surname, address, email, password);
    }

    public static class Builder {

        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setId(Long id) {
            newUser.setId(id);
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            newUser.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public Builder setAddress(String address) {
            newUser.address = address;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}

