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

    /*
    // Product --> Classification (Frame)
    @ManyToOne()   
    @JoinColumn(name= "classId")     
    private Classification classification;
    
    // Product --> Country (Frame)
    @ManyToOne()
    @JoinColumn(name= "countryId")
    private Country country;

    // Product --> Type (Frame)
    @ManyToOne()
    @JoinColumn(name= "typeId")
    private Type type;
    */
    
    public Product() {}
    
    /*
    public Product(String productName,String productDetail,double productPrice,String productImgUrl,long classId,long countryId,long typeId){
        Country country = new Country(countryId);
        Classification classification = new Classification(classId);
        Type type = new Type(typeId);
        this.productName = productName;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
        this.productImgUrl = productImgUrl;
        this.country = country;
        this.classification = classification;
        this.type = type;
    }
    */

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }
    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}