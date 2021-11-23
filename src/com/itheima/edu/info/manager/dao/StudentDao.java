package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

/**
 * @Author: shenz
 * @Date：2021/11/22 - 13:57
 * @Description：com.itheima.edu.info.manager.dao
 * @version：1.0
 */
public class StudentDao {
    // 1. 创建学生对象数组
    private static Student[] stus = new Student[5];
    // 静态代码块，初始化一些学生信息
    static {
        Student stu1 = new Student("张三","jason001","1998-12-5","23");
        Student stu2 = new Student("李四","jason002","1998-12-5","23");
        Student stu3 = new Student("王五","jason003","1998-12-5","23");
        Student stu4 = new Student("赵六","jason004","1998-12-5","23");

        stus[0] = stu1;
        stus[1] = stu2;
        stus[2] = stu3;
        stus[3] = stu4;
    }

    public boolean addStudent(Student stu) {

        // 2. 添加学生到数组
        // 2.1 定义变量index为-1，假设数组已经全部存满，没有null的元素
        int index = -1;
        // 2.2 遍历数组取出每一个元素，判断是否为null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                // 2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
                break;
            }
        }
        // 3. 返回是否添加成功的boolean状态
        if (index == -1) {
            // 装满了
            return false;
        } else {
            // 没有装满
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        // 2. 将该索引位置，使用null元素覆盖
        stus[index] = null;
    }

    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
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
        // 2. 将该索引位置，使用null元素覆盖
        stus[index] = stu;
    }
}
