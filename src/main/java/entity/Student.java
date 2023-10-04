package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "student_table")
public class Student extends Person {
    @NotNull(message = "studentNumber cannot be null")
    protected long studentNumber;
    @NotNull(message = "fieldOfStudy cannot be null")
    protected String fieldOfStudy;
    @NotNull(message = "enteringYear cannot be null")
    protected LocalDate enteringYear;

    public Student(long studentNumber, String fieldOfStudy, LocalDate enteringYear) {
        this.studentNumber = studentNumber;
        this.fieldOfStudy = fieldOfStudy;
        this.enteringYear = enteringYear;
    }

    public Student(String firstName, String lastName, String username, String password, LocalDate birthDate, long studentNumber, String fieldOfStudy, LocalDate enteringYear) {
        super(firstName, lastName, username, password, birthDate);
        this.studentNumber = studentNumber;
        this.fieldOfStudy = fieldOfStudy;
        this.enteringYear = enteringYear;
    }


    public Student() {
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, long studentNumber) {
        super(firstName, lastName);
        this.studentNumber = studentNumber;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public LocalDate getEnteringYear() {
        return enteringYear;
    }

    public void setEnteringYear(LocalDate enteringYear) {
        this.enteringYear = enteringYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", enteringYear=" + enteringYear +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", id=" + id +
                '}';
    }
}
