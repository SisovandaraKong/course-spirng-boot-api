package istad.co.implementwithrestapi.controller;

import istad.co.implementwithrestapi.dto.CourseCreateRequest;
import istad.co.implementwithrestapi.dto.CourseResponseDto;
import istad.co.implementwithrestapi.dto.CourseUpdateRequest;
import istad.co.implementwithrestapi.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Map<String, Object> getAllCourses(@RequestParam(required = false) Boolean status) {
        return Map.of(
                "courses", courseService.getAllCourses(status),
                "size", courseService.getAllCourses(status).size()
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title")
    public Map<String,Object> getCoursesByTitle(@RequestParam String title,@RequestParam Boolean status){
        return Map.of(
                "courses", courseService.getCoursesByTitle(title, status)
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{code}")
    public Map<String,Object> getCourseByCode(@PathVariable String code){
        return Map.of(
                "courses", courseService.getCourseByCode(code)
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Map<String,Object> getCourseById(@PathVariable int id){
        return Map.of(
                "courses", courseService.getCourseById(id)
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Map<String,Object> addCourse(@Valid @RequestBody CourseCreateRequest courseCreateRequest){
        return Map.of(
                "courses", courseService.addCourse(courseCreateRequest)
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{code}")
    public Map<String,Object> deleteCourseByCode(@PathVariable String code){
        return Map.of(
                "rowEffected", courseService.deleteCourseByCode(code),
                "message", "delete successfully"
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{code}")
    public Map<String,Object> updateCourseByCode(@PathVariable String code,@RequestBody CourseUpdateRequest courseUpdateRequest){
        return Map.of(
                "courses", courseService.updateCourseByCode(code, courseUpdateRequest),
                "message", "update successfully"
        );
    }

}
