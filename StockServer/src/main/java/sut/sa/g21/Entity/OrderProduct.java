package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter @Setter
@Table(name="OrderProduct")
public class OrderProduct {
    @Id
	@SequenceGenerator(name="orderproduct_seq",sequenceName="orderproduct_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderproduct_seq")      
	@Column(name="OrderProduct_id",unique = true, nullable = true)
	private @NonNull Long id;
    private int Amount;
    private double TotalPrice;

    
    public OrderProduct(){}
    public OrderProduct(int Amount, double TotalPrice){
        this.Amount = Amount;
        this.TotalPrice = TotalPrice;
    }
}
