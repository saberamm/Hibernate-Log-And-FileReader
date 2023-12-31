package service;

import base.service.BaseService;
import entity.Student;

public interface StudentService extends BaseService<Student, Long> {
    Student signUp (String firstname, String lastname,long studentNumber);
}
