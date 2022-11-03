package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolderStudent {
    public static List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init(){
        studentList.add(new Student("andrej181199", "samplepw", "andrej", "veljanovski"));
        studentList.add(new Student("testuser1", "samplepw1", "test1", "velj1"));
        studentList.add(new Student("testuser2", "samplepw2", "test2", "velj2"));
        studentList.add(new Student("testuser3", "samplepw3", "test3", "velj3"));
        studentList.add(new Student("testuser4", "samplepw4", "test4", "velj4"));
    }

}
