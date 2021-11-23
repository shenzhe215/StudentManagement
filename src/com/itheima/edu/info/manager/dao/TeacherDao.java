package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 7:55
 * @Description：com.itheima.edu.info.manager.dao
 * @version：1.0
 */
public class TeacherDao {
    // static设置为共享数据
    private static Teacher[] teachers = new Teacher[5];

    public boolean addTeacher(Teacher teacher) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("装满了");
            return false;
        }else {
            teachers[index] = teacher;
            return true;
        }
    }

    public void deleteTeacherById(String delId) {
        int index = getIndex(delId);
        teachers[index] = null;
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if ((teacher != null) && teacher.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public void updateTeacher(String updateId, Teacher teacher) {
        int index = getIndex(updateId);
        teachers[index] = teacher;
    }
}
