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
    private @NonNull long P_Id;
    private @NonNull String P_Name;
    @Column(length = 100)
    private String P_Detail;
    private String P_ImgUrl;
    private double P_Price;

    // Product --> Stock
    @OneToMany(
            mappedBy="product",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Stock> stocks = new ArrayList<>();
    
    

    public Product() {}
    
    public Product(String P_Detail, double P_Price, String P_ImgUrl){
        this.P_Detail = P_Detail;
        this.P_Price = P_Price;
        this.P_ImgUrl = P_ImgUrl;
    }

    public void setName(String P_Name) {
        this.P_Name = P_Name;
    }
    public void setDetaiol(String P_Detail) {
        this.P_Detail = P_Detail;
    }
    public void setImgUrl(String P_ImgUrl) {
        this.P_ImgUrl = P_ImgUrl;
    }
    public void setPrice(double P_Price) {
        this.P_Price = P_Price;
    }

}