package istad.co.implementwithrestapi.service;

import istad.co.implementwithrestapi.domain.Course;
import istad.co.implementwithrestapi.dto.CourseCreateRequest;
import istad.co.implementwithrestapi.dto.CourseResponseDto;
import istad.co.implementwithrestapi.dto.CourseUpdateRequest;

import java.util.List;

public interface CourseService {
    List<CourseResponseDto> getAllCourses(Boolean status);
    List<CourseResponseDto> getCoursesByTitle(String title, Boolean status);
    CourseResponseDto getCourseByCode(String code);
    CourseResponseDto getCourseById(int id);
    CourseResponseDto addCourse(CourseCreateRequest courseCreateRequest);
    Integer deleteCourseByCode(String code);
    CourseResponseDto updateCourseByCode(String code, CourseUpdateRequest courseUpdateRequest);
}
