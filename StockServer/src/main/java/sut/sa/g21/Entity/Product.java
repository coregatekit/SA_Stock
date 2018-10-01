package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="Product")
public class Product{

    @Id
    @GeneratedValue
    private @NonNull long productId;
    private @NonNull String productName;
    @Column(length = 100)
    private String productDetail;
    private String productImgUrl;
    private double productPrice;

    // Product --> Stock
    @OneToMany(
            mappedBy="product",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Stock> stocks = new ArrayList<>();
    
    
    public Product() {}
    
    public Product(String productDetail, double productPrice, String productImgUrl){
        this.productDetail = productDetail;
        this.productPrice = productPrice;
        this.productImgUrl = productImgUrl;
    }

    public void setName(String productName) {
        this.productName = productName;
    }
    public void setDetaiol(String productDetail) {
        this.productDetail = productDetail;
    }
    public void setImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }
    public void setPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}