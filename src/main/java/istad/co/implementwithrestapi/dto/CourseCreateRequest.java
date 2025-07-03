package istad.co.implementwithrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseCreateRequest(
        @NotBlank(message = "Title is required")
        String title,
        @NotNull(message = "Price is required")
        Double price
) {
}
