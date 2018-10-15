package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter @Setter
@Table(name="User")
public class User{

    @Id
	@SequenceGenerator(name="user_seq",sequenceName="user_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")      
	@Column(name="User_id",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String userUsername;
    private @NonNull String userPassword;
    private @NonNull String userFirstName;
    private @NonNull String userLastName;
    private @NonNull String userEmail;
    private @NonNull String userTelephone;

    @ManyToOne()   
    @JoinColumn(name= "Gender_id")     
    private Gender genders;    

    public User(){}

    public User(int id) {
        Gender genders = new Gender(id);
        this.genders = genders;
    }
}