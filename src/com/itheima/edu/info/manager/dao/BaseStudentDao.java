package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

/**
 * @Author: shenz
 * @Date：2021/11/22 - 13:57
 * @Description：com.itheima.edu.info.manager.dao
 * @version：1.0
 */
public interface BaseStudentDao {

    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String delId);

    public abstract int getIndex(String id);

    public abstract void updateStudent(String id, Student stu);
}
