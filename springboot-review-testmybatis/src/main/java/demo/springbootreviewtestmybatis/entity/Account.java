package demo.springbootreviewtestmybatis.entity;


import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
@ToString
public class Account {
    @Id
    private Integer id;
    private String name;
    private float money;
}
