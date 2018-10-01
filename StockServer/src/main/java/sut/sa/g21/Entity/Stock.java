package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Getter @Setter
@Table(name="Stock")
public class Stock{

    @Id
    @GeneratedValue
    private @NonNull long stockId;
    @Column(length = 100)
    private int stockProductAmount;

    // Stock --> Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "productId")
    @JsonBackReference
    private Product product;
    
    // Stock --> Warehouse
    @ManyToOne(fetch = FetchType.LAZY)   
    @JoinColumn(name= "warehouseId")     
    @JsonBackReference 
    private Warehouse warehouse;    

    // Stock --> OrderProduct
    @OneToOne
    @JoinColumn(name = "oderproductId")
    private OrderProduct orderProduct;

    public Stock(){}
    public Stock(int stockProductAmount){
        this.stockProductAmount = stockProductAmount;
    }

}