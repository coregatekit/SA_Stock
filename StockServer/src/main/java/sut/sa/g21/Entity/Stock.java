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
	@SequenceGenerator(name="stock_seq",sequenceName="stock_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="stock_seq")      
	@Column(name="stockId",unique = true, nullable = true)
    private @NonNull Long stockId;

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
    @JoinColumn(name = "orderProductId")
    private OrderProduct orderProduct;

    public Stock(){}

    public void setProductId(Product id) {
        this.product = id;
    }
    public void setWarehouseId(Warehouse id) {
        this.warehouse = id;
    }
    public void setOrderProductId(OrderProduct id) {
        this.orderProduct = id;
    }

}