import entity.Person;
import entity.Student;
import entity.Teacher;
import entity.enums.TeacherRate;
import util.ApplicationContext;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {


//--------------------person----------------------------------------


        Person person = new Person("ali", "ahmadi", "all", "word@tres", LocalDate.of(2010, 5, 5));

        ApplicationContext.getPersonService().save(person);

        //ApplicationContext.getPersonService().signUp("asghar","shalqam");

//        System.out.println(ApplicationContext.getPersonService().findById(1L));
//
//        System.out.println(ApplicationContext.getPersonService().findAll());
//
//        System.out.println(ApplicationContext.getPersonService().findPersonByUsername("all"));
//
//        System.out.println(ApplicationContext.getPersonService().isContainById(1L));
//
//        Person d = ApplicationContext.getPersonService().findById(1L);
//        ApplicationContext.getPersonService().delete(d);
//
//        Person doo = ApplicationContext.getPersonService().findById(1L);
//        doo.setFirstName("reza");
//        ApplicationContext.getPersonService().update(doo);


//--------------------student----------------------------------------


        Student student = new Student("amin", "asghari", "aminam", "qwerqwer",
                LocalDate.of(2000, 3, 8), 4, "Mathematics",
                LocalDate.of(2020, 7, 7));

        //ApplicationContext.getStudentService().save(student);

        //ApplicationContext.getStudentService().signUp("shahram","salami",9L);

        //System.out.println(ApplicationContext.getStudentService().findById(1L));

        //System.out.println(ApplicationContext.getStudentService().findAll());

        //System.out.println(ApplicationContext.getStudentService().isContainById(1L));

        /*Student d = ApplicationContext.getStudentService().findById(2L);
        ApplicationContext.getStudentService().delete(d);*/

        /*Student d = ApplicationContext.getStudentService().findById(1L);
        d.setFirstName("reza");
        ApplicationContext.getStudentService().update(d);*/


//--------------------student----------------------------------------


        Teacher teacher = new Teacher("mamad", "rezie", "fardad", "123123*r",
                LocalDate.of(1999, 9, 9), 9, "phd",
                555555L, TeacherRate.SENIOR);

        //ApplicationContext.getTeacherService().save(teacher);

        //ApplicationContext.getTeacherService().signUp("farhad","shams",TeacherRate.ADVANCE);

        //System.out.println(ApplicationContext.getTeacherService().findById(52L));

        //System.out.println(ApplicationContext.getTeacherService().findAll());

        //System.out.println(ApplicationContext.getTeacherService().isContainById(52L));

        /*Teacher d = ApplicationContext.getTeacherService().findById(52L);
        ApplicationContext.getTeacherService().delete(d);*/

        /*Teacher d = ApplicationContext.getTeacherService().findById(102L);
        d.setFirstName("reza");
        ApplicationContext.getTeacherService().update(d);*/


    }
}