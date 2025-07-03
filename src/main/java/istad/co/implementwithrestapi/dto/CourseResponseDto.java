package istad.co.implementwithrestapi.dto;

public record CourseResponseDto (
        String code,
        String title,
        Double price,
        Boolean status
){
}
