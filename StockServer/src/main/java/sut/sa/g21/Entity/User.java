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
	@Column(name="userId",unique = true, nullable = true)
    private @NonNull Long userId;
    @Column(name="userName", unique = true)
    private @NonNull String userUsername;
    private @NonNull String userPassword;
    private @NonNull String userFirstName;
    private @NonNull String userLastName;
    private @NonNull String userEmail;
    private @NonNull String userTelephone;
    private @NonNull String userAddress;

    @ManyToOne()   
    @JoinColumn(name= "genderId")     
    private Gender genders;    

    public User(){}

    public User(int id) {
        Gender genders = new Gender(id);
        this.genders = genders;
    }
}