package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="Product")
public class Product{

    @Id
	@SequenceGenerator(name="product_seq",sequenceName="product_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")      
	@Column(name="Prdouct_id",unique = true, nullable = true)
	private @NonNull Long id;
    private @NonNull String productName;
    private String productDetail;
    private String productImgUrl;
    private Double productPrice;

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

    
    public void setProductName(String Name) {
        this.productName = Name;
    }
    public void setProductDetail(String Detail) {
        this.productDetail = Detail;
    }
    public void setProductImgUrl(String ImgUrl) {
        this.productImgUrl = ImgUrl;
    }
    public void setProductPrice(Double Price) {
        this.productPrice = Price;
    }
    
}