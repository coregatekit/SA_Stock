package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter @Setter
@Table(name="Preorder")

public class Preorder{

    @Id
	@SequenceGenerator(name="preorder_seq",sequenceName="preorder_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="preorder_seq")      
	@Column(name="Preorder_id",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String test;

    public Preorder(){}
    public Preorder(String test){
        this.test = test;
    }

}