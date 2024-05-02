package dev.durgesh.BookMyShow.Model;

import com.sun.jdi.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//Getter and setters comes from lombok
//Annotations cant be inherited
@Getter
@Setter
@MappedSuperclass // it indicates that this parent class is super class of all attributes and subclasses
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel { // baseeModel should always be abstract

    //These annotation will help us to build DB without writing a single sql query
    //Also convert java code in the sql easily
    //these annotation only for int id if we want for another attributes then we should have creat separately
    @Id //it tells that the int id is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id; //primary key
    @Column(name = "CREATED_AT")


    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

}
