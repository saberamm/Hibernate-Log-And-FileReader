package service;

import base.service.BaseService;
import entity.Teacher;
import entity.enums.TeacherRate;

public interface TeacherService extends BaseService<Teacher, Long> {
    Teacher signUp (String firstname, String lastname, TeacherRate teacherRate);
}
