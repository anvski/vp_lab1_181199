package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderZCourse {
    public static List<Course> courseList = new ArrayList<>();

    @PostConstruct
    public void init(){
        //Long courseId, String name, String description, List<Student> students
        List<Student> studentList = DataHolderStudent.studentList;
        courseList.add(new Course(1001L, "VP", "test course", new ArrayList<>(studentList.subList(1,2))));
        courseList.add(new Course(1002L, "Napredno", "test course", new ArrayList<>(studentList.subList(0,3))));
        courseList.add(new Course(1003L, "Aud", "test course", new ArrayList<>(studentList.subList(2,4))));
        courseList.add(new Course(1004L, "Ezi", "test course", new ArrayList<>(studentList.subList(1,4))));
        courseList.add(new Course(1005L, "Opa", "test course", new ArrayList<>(studentList.subList(0,4))));
    }
}
