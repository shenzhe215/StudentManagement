package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.util.ArrayList;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 13:31
 * @Description：com.itheima.edu.info.manager.dao
 * @version：1.0
 */
public class OtherStudentDao implements BaseStudentDao{
    // 1. 集合容器
    private static ArrayList<Student> stus = new ArrayList<>();

    // 静态代码块，初始化一些学生信息
    static {
        Student stu1 = new Student("张三", "jason001", "1998-12-5", "23");
        Student stu2 = new Student("李四", "jason002", "1998-12-5", "23");
        Student stu3 = new Student("王五", "jason003", "1998-12-5", "23");
        Student stu4 = new Student("赵六", "jason004", "1998-12-5", "23");

        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);
        stus.add(stu4);
    }

    public boolean addStudent(Student stu) {
        stus.add(stu);
        return true;
    }

    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < stus.size(); i++) {
            students[i] = stus.get(i);
        }
        return students;
    }

    public void deleteStudentById(String delId) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        // 2. 将该索引位置，使用null元素覆盖
        stus.remove(index);
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String id, Student stu) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(id);
        stus.set(index, stu);
    }
}
