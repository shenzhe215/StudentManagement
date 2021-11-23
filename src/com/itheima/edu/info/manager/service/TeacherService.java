package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 7:56
 * @Description：com.itheima.edu.info.manager.service
 * @version：1.0
 */
public class TeacherService {
    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public void deleteTeacherById(String delId) {
        teacherDao.deleteTeacherById(delId);
    }

    public Teacher[] findAllTeacher() {
        // 1. 调用库管对象的findAllTeacher获取老师对象数组
        Teacher[] allTeacher = teacherDao.findAllTeacher();
        // 2. 判断数组中是否有学生信息（有：返回地址，没有：返回null）
        // 思路：数组中只要存在一个不是null的元素，那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allTeacher.length; i++) {
            Teacher teacher = allTeacher[i];
            if (teacher != null) {
                flag = true;
                break;
            }
        }
        if (flag) {
            //有信息
            return allTeacher;
        } else {
            return null;
        }
    }

    public void updateTeacher(String updateId, Teacher teacher) {
        teacherDao.updateTeacher(updateId, teacher);
    }

    public boolean isExists(String id) {
        int index = teacherDao.getIndex(id);
        if(index == -1){
            return false;
        }else {
            return true;
        }
    }
}
