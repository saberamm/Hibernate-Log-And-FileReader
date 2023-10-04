package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Teacher;
import entity.enums.TeacherRate;
import repository.TeacherRepository;
import service.TeacherService;
import util.ApplicationContext;

public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {
    public TeacherServiceImpl(TeacherRepository repository) {
        super(repository);
    }

    @Override
    public Teacher signUp(String firstname, String lastname, TeacherRate teacherRate) {
        Teacher teacher = new Teacher(firstname, lastname,teacherRate);
        return ApplicationContext.getTeacherService().save(teacher);
    }
}
