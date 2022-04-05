package com.studentPack;
import java.util.*;
public class Student extends Course {

    int std_id;
    String std_name;
    public List<Course> courseClassList;

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public List<Course> getCourseClassList() {
        return courseClassList;
    }

    public void setCourseClassList(List<Course> courseClassList) {
        this.courseClassList = courseClassList;
    }

    @Override
    public String toString() {
        return(std_id+"\n"+std_name+"\n"+courseClassList);
    }
}
