package util;

import base.repository.impl.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import repository.PersonRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import repository.impl.PersonRepositoryImpl;
import repository.impl.StudentRepositoryImpl;
import repository.impl.TeacherRepositoryImpl;
import service.PersonService;
import service.StudentService;
import service.TeacherService;
import service.impl.PersonServiceImpl;
import dto.DtoMapper;
import dto.DtoMapperImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationContext {
    protected static final Logger logger = Logger.getLogger(ApplicationContext.class.getSimpleName());

    static {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(ApplicationContext.class.getSimpleName() + ".log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }


    //------------person application context------------------//

    private static final PersonService personService;

    static {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        DtoMapper dtoMapper = new DtoMapperImpl();
        PersonRepository personRepository = new PersonRepositoryImpl(entityManager);
        personService = new PersonServiceImpl(personRepository, dtoMapper);
    }

    public static PersonService getPersonService() {
        logger.log(Level.INFO,"getPersonService called in application context");
        return personService;
    }

    //------------student application context------------------//

    private static final StudentService studentService;


    static {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        StudentRepository studentRepository = new StudentRepositoryImpl(entityManager);
        studentService = new StudentServiceImpl(studentRepository);
    }

    public static StudentService getStudentService() {
        logger.log(Level.INFO,"getStudentService called in application context");
        return studentService;
    }

    //------------teacher application context------------------//

    private static final TeacherService teacherService;


    static {
        EntityManager entityManager = HibernateUtils.getEntityManagerFactory().createEntityManager();
        TeacherRepository teacherRepository = new TeacherRepositoryImpl(entityManager);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    public static TeacherService getTeacherService() {
        logger.log(Level.INFO,"getTeacherService called in application context");
        return teacherService;
    }
}
