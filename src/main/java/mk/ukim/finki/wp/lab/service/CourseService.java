package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService{

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseService(CourseRepository courseRepository, StudentService studentService){
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student studentToAdd = studentService.listAll().stream().filter(student -> student.getUsername().equals(username)).findFirst().orElse(null);
        Course courseToAddTo = courseRepository.findById(courseId);

        if(studentToAdd == null || courseToAddTo == null) return null;
        return courseRepository.addStudentToCourse(studentToAdd, courseToAddTo);
    }
}
