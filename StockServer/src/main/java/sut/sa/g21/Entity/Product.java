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
	@Column(name="productId",unique = true, nullable = true)
	private @NonNull Long productId;
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
}