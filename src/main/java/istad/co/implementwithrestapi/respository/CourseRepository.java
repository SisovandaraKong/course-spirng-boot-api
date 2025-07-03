package istad.co.implementwithrestapi.respository;

import istad.co.implementwithrestapi.domain.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseRepository implements Repository<Course,Integer>{
    private final List<Course> courses = new ArrayList<>(List.of(
            new Course(1, "2505433c-2a38-4c3a-86a6-2f153017f8dd", "Spring Boot", 50.99, true),
            new Course(2, "b1a5e8f0-9c2e-48a6-bb45-231f4f9ec2a3", "React for Beginners", 39.99, true),
            new Course(3, "3e62c56a-2fc5-4a19-85d3-3c9cbf94b0e6", "Docker & Kubernetes", 59.49, false),
            new Course(4, "1faefb91-b671-4aef-a1c6-1d15843f36c1", "Data Structures in Java", 44.00, true),
            new Course(5, "e3dc1b9b-8323-4c53-b27f-103298aa7c73", "Python for Data Science", 69.95, true)

    ));
    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Integer save(Course course) {
        courses.add(course);
        return 1;
    }

    @Override
    public Integer delete(String uuid) {
        courses.removeIf(course -> course.getCode().equals(uuid));
        return 1;
    }
}
