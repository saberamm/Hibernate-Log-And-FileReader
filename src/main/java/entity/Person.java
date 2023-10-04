package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person_table")
public class Person extends BaseEntity<Long> {
    @Max(value = 50, message = "Name should not be greater than 50")
    @NotNull(message = "Name cannot be null")
    protected String firstName;
    @Max(value = 50, message = "Lastname should not be greater than 50")
    @NotNull(message = "Lastname cannot be null")
    protected String lastName;
    @Max(value = 50, message = "Username should not be greater than 50")
    @NotNull(message = "Username cannot be null")
    @Column(unique = true)
    protected String username;
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @NotNull(message = "Password cannot be null")
    protected String password;
    @NotNull(message = "BirthDate cannot be null")
    protected LocalDate birthDate;

    public Person() {
    }

    public Person(String firstName, String lastName, String username, String password, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", id=" + id +
                '}';
    }
}
