package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 7:55
 * @Description：com.itheima.edu.info.manager.controller
 * @version：1.0
 */
public class TeacherController {
    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    // 开启老师管理系统，并展示老师管理系统菜单
    public void start() {
        teacherLoop:
        while (true) {
            // 老师菜单搭建
            System.out.println("-----------欢迎来到<老师>管理系统-----------");
            System.out.println("1.添加老师 2.删除老师 3.修改老师 4.查看老师  5.退出");
            System.out.println("请输入您的选择");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // System.out.println("添加");
                    addTeacher();
                    break;
                case "2":
                    // System.out.println("删除");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改");
                    updateTeacher();
                    break;
                case "4":
                    // System.out.println("查询");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统，再见！");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void updateTeacher() {
        String updateId = inputTeacherId();
        Teacher teacher = inputTeacherInfo(updateId);
        teacherService.updateTeacher(updateId, teacher);
        System.out.println("更新成功");
    }

    private void findAllTeacher() {
        Teacher[] teachers = teacherService.findAllTeacher();
        // 2. 判断数组的内存地址，是否为null
        if (teachers == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        // 3. 遍历数组，获取老师信息并打印在控制台
        System.out.println("工号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null) {
                System.out.println(teacher.getId() + "\t\t" + teacher.getName() + "\t" +
                        teacher.getAge() + "\t" + teacher.getBirthday());
            }
        }
    }

    private void deleteTeacherById() {
        String delId = inputTeacherId();
        teacherService.deleteTeacherById(delId);
        System.out.println("删除成功");
    }

    public void addTeacher() {
        String id = null;
        while (true) {
            System.out.println("请输入老师id：");
            id = sc.next();
            boolean flag = teacherService.isExists(id);
            if (flag) {
                System.out.println("学号已被占用，请重新输入");
            } else {
                break;
            }
        }
        Teacher teacher = inputTeacherInfo(id);
        // 3. 将老师对象传递给TeacherServive(业务员)中的addTeacher方法
        boolean result = teacherService.addTeacher(teacher);
        // 4. 根据返回的boolean类型结果，在控制台打印成功\失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 键盘录入老师id
    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入老师id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if (exists) {
                break;
            } else {
                System.out.println("您输入的id不存在，请重新输入");
            }
        }
        return id;
    }

    // 键盘录入老师信息
    public Teacher inputTeacherInfo(String id) {
        System.out.println("请输入老师姓名：");
        String name = sc.next();
        System.out.println("请输入老师年龄：");
        String age = sc.next();
        System.out.println("请输入老师生日：");
        String birthday = sc.next();
        // 2. 将老师信息封装为老师对象
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setBirthday(birthday);
        return teacher;
    }

}
