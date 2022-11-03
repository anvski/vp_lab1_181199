package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderStudent;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    public List<Student> findAllStudents(){
        return DataHolderStudent.studentList;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return DataHolderStudent.studentList.stream().filter(student -> student.getName().contains(text) || student.getSurname().contains(text)).collect(Collectors.toList());
    }

    public Student save(Student student){
        if(student == null || (student.getUsername() == null || student.getUsername().isEmpty())
                || (student.getPassword() == null || student.getPassword().isEmpty())
                || (student.getName() == null || student.getName().isEmpty())
                || (student.getSurname() == null || student.getSurname().isEmpty())) return null;

        if(DataHolderStudent.studentList.stream().filter(s -> s.getUsername().equals(student.getUsername())).count() > 0) return null;

        DataHolderStudent.studentList.add(student);
        return student;
    }
}
