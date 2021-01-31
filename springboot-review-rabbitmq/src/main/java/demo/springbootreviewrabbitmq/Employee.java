package demo.springbootreviewrabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
    private String empno;
    private String name;
    private Integer age;
}
