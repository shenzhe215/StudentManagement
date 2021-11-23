package com.itheima.edu.info.manager.factory;

import com.itheima.edu.info.manager.dao.BaseStudentDao;
import com.itheima.edu.info.manager.dao.OtherStudentDao;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 18:12
 * @Description：com.itheima.edu.info.manager.factory
 * @version：1.0
 */
public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}
