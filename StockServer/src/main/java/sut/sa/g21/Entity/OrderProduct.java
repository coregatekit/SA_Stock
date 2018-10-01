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
    private @NonNull long OP_Id;
    @Column(length = 100)
    private int OP_OrderAmount;
    private double OP_Total_Price;

    
    protected OrderProduct(){}
    public OrderProduct(int P_OrderAmount, double OP_Total_Price){
        this.OP_OrderAmount = P_OrderAmount;
        this.OP_Total_Price = OP_Total_Price;
    }
}
