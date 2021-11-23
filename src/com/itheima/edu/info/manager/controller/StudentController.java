package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;

import java.util.Scanner;

/**
 * @Author: shenz
 * @Date：2021/11/22 - 13:57
 * @Description：com.itheima.edu.info.manager.controller
 * @version：1.0
 */
public class StudentController extends BaseStudentController{
    private Scanner sc = new Scanner(System.in);

    // 键盘录入学生信息
    // 开闭原则：对扩展内容开放，对修改内容关闭
    public Student inputStudentInfo(String id){
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();
        // 2. 将学生信息封装为学生对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
