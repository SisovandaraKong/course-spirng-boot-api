package istad.co.implementwithrestapi.service.impl;

import istad.co.implementwithrestapi.domain.Course;
import istad.co.implementwithrestapi.dto.CourseCreateRequest;
import istad.co.implementwithrestapi.dto.CourseResponseDto;
import istad.co.implementwithrestapi.dto.CourseUpdateRequest;
import istad.co.implementwithrestapi.respository.CourseRepository;
import istad.co.implementwithrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponseDto> getAllCourses(Boolean status) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getStatus().equals(status) || status == null)
                .map(course -> new CourseResponseDto(
                course.getCode(),
                        course.getTitle(),
                        course.getPrice(),
                        course.getStatus()
        )).toList();
    }

    @Override
    public List<CourseResponseDto> getCoursesByTitle(String title, Boolean status) {
        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getStatus().equals(status) && course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .map(course -> new CourseResponseDto(
                        course.getCode(),
                        course.getTitle(),
                        course.getPrice(),
                        course.getStatus()
                ))
                .toList();
    }

    @Override
    public CourseResponseDto getCourseByCode(String code) {
        return courseRepository.findAll().stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst()
                .map(course -> new CourseResponseDto(
                        course.getCode(),
                        course.getTitle(),
                        course.getPrice(),
                        course.getStatus()
                )).orElseThrow();
    }

    @Override
    public CourseResponseDto getCourseById(int id) {
        return courseRepository.findAll().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .map(course -> new CourseResponseDto(
                        course.getCode(),
                        course.getTitle(),
                        course.getPrice(),
                        course.getStatus()
                )).orElseThrow();
    }

        @Override
        public CourseResponseDto addCourse(CourseCreateRequest courseCreateRequest) {
            Course newCourse = new Course();
            newCourse.setId(new Random().nextInt(9999));
            newCourse.setCode(UUID.randomUUID().toString());
            newCourse.setTitle(courseCreateRequest.title());
            newCourse.setPrice(courseCreateRequest.price());
            newCourse.setStatus(true);
            courseRepository.save(newCourse);
            return new CourseResponseDto(
                    newCourse.getCode(),
                    newCourse.getTitle(),
                    newCourse.getPrice(),
                    newCourse.getStatus()
            );
        }

    @Override
    public Integer deleteCourseByCode(String code) {
        return courseRepository.delete(code);
    }

    @Override
    public CourseResponseDto updateCourseByCode(String code, CourseUpdateRequest courseUpdateRequest) {
        return courseRepository.findAll().stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst()
                .map(course -> {
                    course.setTitle(courseUpdateRequest.title());
                    course.setPrice(courseUpdateRequest.price());
                    return new CourseResponseDto(
                            course.getCode(),
                            course.getTitle(),
                            course.getPrice(),
                            course.getStatus()
                    );
                }).orElseThrow();
    }
}
