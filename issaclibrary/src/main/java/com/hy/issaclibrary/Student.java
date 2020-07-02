package com.hy.issaclibrary;

/**
 * @author issac
 * @version 1.0.0
 * @Description
 * @Date 2020/7/2 9:56
 */
public class Student {
    private String name;

    private String id;

    public Student(String id,String name ) {
        this.name = name;

        this.id = id;
    }

    public Student() {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
