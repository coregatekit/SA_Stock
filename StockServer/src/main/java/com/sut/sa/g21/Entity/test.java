package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Getter @Setter
@Table(name = "Preorder")
public class Preorder{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long preId;
    private long productNum;
    private double sumPrice;
    private Boolean orderStatus;
    @ManyToOne()   
    @JoinColumn(name= "statusId")     
    private Status status;
    
    
    
    @ManyToOne() 
    @JoinColumn(name= "userId")     
    private User user;

    
    @ManyToOne() 
    @JoinColumn(name= "productId")     
    private Product product;

    public Preorder(){}
    public Preorder(long preId){
        this.preId = preId;
    }
    /*
    public Preorder(long userId,long productId,long productNum,double sumPrice,long statusId){
        User user = new User(userId);
        Product product = new Product(productId);
        Status status = new Status(statusId);
        this.user = user;
        this.product = product;
        this.productNum = productNum;
        this.sumPrice = sumPrice;
        this.status = status;
    }
    */
}
