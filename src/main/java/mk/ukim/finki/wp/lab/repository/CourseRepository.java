package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolderZCourse;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    //Имплементирајте метод List<Course> findAllCourses(); кој само ќе ја врати листата од курсеви.
    //Имплементирајте метод Course findById(Long courseId); кој само ќе го врати курсот со соодветното id.
    //Имплементирајте метод List<Student> findAllStudentsByCourse(Long courseId); кој ќе врати листа од студенти кои слушаат одреден курс.
    //Имплементирајте метод Course addStudentToCourse(Student student, Course course); кој ќе направи додавање на нов студент во листата од студенти.

    public List<Course> findAllCourses(){
        return DataHolderZCourse.courseList;
    }

    public Course findById(Long courseId){
        return DataHolderZCourse.courseList
                .stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst().orElse(null);
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
       Course courseToFind = DataHolderZCourse.courseList
               .stream()
               .filter(course -> course.getCourseId().equals(courseId))
               .findFirst().orElse(null);

       if(courseToFind != null) return courseToFind.getStudents();

       return null;
    }

    public Course addStudentToCourse(Student student, Course course){
        if(course.getStudents().contains(student)) return null;
        if(course != null) {
            course.getStudents().add(student);
            return course;
        }
        return null;
    }



}
