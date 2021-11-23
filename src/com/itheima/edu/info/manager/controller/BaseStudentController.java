package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

/**
 * @Author: shenz
 * @Date：2021/11/22 - 13:57
 * @Description：com.itheima.edu.info.manager.controller
 * @version：1.0
 */
public class BaseStudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    // 开启学生管理系统，并展示学生管理系统菜单
    public void start() {
        studentLoop:
        while (true) {
            // 学生菜单搭建
            System.out.println("-----------欢迎来到<学生>管理系统-----------");
            System.out.println("请输入您的选择：1.添加学生 2.删除学生 3.修改学生 4.查看学生  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // System.out.println("添加");
                    OtherStudentController studentController = new OtherStudentController();
                    studentController.start();
                    break;
                case "2":
                    // System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    // System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    // System.out.println("查询");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统，再见！");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    public void updateStudent() {
        String updateId = inputStudentId();
        // 2. 将学生信息封装为学生对象
        Student newStu = inputStudentInfo(updateId);
        studentService.updateStudent(updateId,newStu);
        System.out.println("修改成功");

    }

    public void deleteStudentById() {
        String delId = inputStudentId();
        // 3. 调用业务员中的deleteStudentById根据id，删除学生
        studentService.deleteStudentById(delId);
        // 4. 提示删除成功
      System.out.println("删除成功");
    }

    public void findAllStudent() {
        // 1. 调用业务员中的方法，得到学生的对象数组
        Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址，是否为null
        if (stus == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        // 3. 遍历数组，获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null) {
                System.out.println(student.getId() + "\t\t" + student.getName() + "\t" +
                        student.getAge() + "\t" + student.getBirthday());
            }
        }
    }

    public void addStudent() {
        // 1. 键盘接受学生信息
        String id = null;
        while (true) {
            System.out.println("请输入学生id：");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("学号已被占用，请重新输入");
            } else {
                break;
            }
        }
        Student stu = inputStudentInfo(id);
        // 3. 将学生对象传递给StudentServive(业务员)中的addStudent方法
        boolean result = studentService.addStudent(stu);
        // 4. 根据返回的boolean类型结果，在控制台打印成功\失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 键盘录入学生id
    public String inputStudentId(){
        String id;
        while (true){
            System.out.println("请输入学生id");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if(exists){
                break;
            }else {
                System.out.println("您输入的id不存在，请重新输入");
            }
        }
        return id;
    }

    // 键盘录入学生信息
    // 开闭原则：对扩展内容开放，对修改内容关闭
    public Student inputStudentInfo(String id){
        return null;
    }
}
