package istad.co.implementwithrestapi.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String code;
    private String title;
    private Double price;
    private Boolean status;
}
