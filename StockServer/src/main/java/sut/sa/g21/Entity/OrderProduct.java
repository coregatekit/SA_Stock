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
    @GeneratedValue
    private @NonNull long oderproductId;
    @Column(length = 100)
    private int oderproductOrderAmount;
    private double oderproductTotalPrice;

    
    public OrderProduct(){}
    public OrderProduct(int oderproductOrderAmount, double oderproductTotalPrice){
        this.oderproductOrderAmount = oderproductOrderAmount;
        this.oderproductTotalPrice = oderproductTotalPrice;
    }
}
