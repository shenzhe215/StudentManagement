package com.itheima.edu.info.manager.domain;

/**
 * @Author: shenz
 * @Date：2021/11/23 - 9:16
 * @Description：com.itheima.edu.info.manager.domain
 * @version：1.0
 */
public class Person {
    private String name; // 姓名
    private String id; // id
    private String birthday; // 生日
    private String age ; // 年龄

    public Person() {
    }

    public Person(String name, String id, String birthday, String age) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
