package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Student;
import repository.StudentRepository;
import service.StudentService;
import util.ApplicationContext;

import java.util.logging.Level;

public class StudentServiceImpl extends BaseServiceImpl<Student, Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository) {
        super(repository);
    }

    @Override
    public Student signUp(String firstname, String lastname,long studentNumber) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" signUp start in service");
        Student student = new Student(firstname,lastname,studentNumber);
        return ApplicationContext.getStudentService().save(student);
    }
}
