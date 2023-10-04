package entity;

import entity.enums.TeacherRate;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "teacher_table")
public class Teacher extends Person{
    @NotNull(message = "teacherNumber cannot be null")
    protected long teacherNumber;
    @NotNull(message = "degree cannot be null")
    protected String degree;
    @NotNull(message = "salary cannot be null")
    protected long salary;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "teacherRate cannot be null")
    protected TeacherRate teacherRate;

    public Teacher(long teacherNumber, String degree, long salary, TeacherRate teacherRate) {
        this.teacherNumber = teacherNumber;
        this.degree = degree;
        this.salary = salary;
        this.teacherRate = teacherRate;
    }

    public Teacher(String firstName, String lastName, String username, String password, LocalDate birthDate, long teacherNumber, String degree, long salary, TeacherRate teacherRate) {
        super(firstName, lastName, username, password, birthDate);
        this.teacherNumber = teacherNumber;
        this.degree = degree;
        this.salary = salary;
        this.teacherRate = teacherRate;
    }

    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher(String firstName, String lastName, TeacherRate teacherRate) {
        super(firstName, lastName);
        this.teacherRate = teacherRate;
    }

    public long getTeacherId() {
        return teacherNumber;
    }

    public void setTeacherId(long teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public TeacherRate getTeacherRate() {
        return teacherRate;
    }

    public void setTeacherRate(TeacherRate teacherRate) {
        this.teacherRate = teacherRate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherNumber=" + teacherNumber +
                ", degree='" + degree + '\'' +
                ", salary=" + salary +
                ", teacherRate=" + teacherRate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", id=" + id +
                '}';
    }
}
