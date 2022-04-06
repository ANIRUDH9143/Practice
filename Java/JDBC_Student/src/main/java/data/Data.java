package data;

import com.studentPack.Course;
import com.studentPack.Student;

import java.util.ArrayList;
import java.util.List;

public class Data extends Student {
    public Data(){
        Student s1=new Student();
        s1.setStd_id(101);
        s1.setStd_name("Anirudh ");

        Student s2=new Student();
        s2.setStd_id(102);
        s2.setStd_name("Abhinav ");

        Course c1=new Course();
        c1.setCourse_id(301);
        c1.setCourse_name("Course1 ");

        List<Course> courseList=new ArrayList<Course>();
        courseList.add(c1);

        s1.setCourseClassList(courseList);
        s2.setCourseClassList(courseList);

        studentList.add(s1);
        studentList.add(s2);

    }
    public static List<Student> studentList=new ArrayList<Student>();
    public List getDetails(){
        return studentList;
    }
    public Student getStudentById(int id){
        for(Student i : studentList){
            if(i.getStd_id()==id){
                return(i);
            }
        }
        return null;
    }

    public Student deleteStudentById(int id){
        Student val=null;
        for(Student i : studentList){
            if(i.getStd_id()==id){
                val=i;
                studentList.remove(i);
            }
        }
        return val;
    }
}
