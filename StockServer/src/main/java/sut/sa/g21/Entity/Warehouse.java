package sut.sa.g21.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter @Setter
@Table(name="Warehouse")
public class Warehouse {
    @Id
	@SequenceGenerator(name="warehouse_seq",sequenceName="warehouse_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="warehouse_seq")      
	@Column(name="Warehouse_id",unique = true, nullable = true)
	private @NonNull Long id;
    private String Name;
    private String Code;
    private String Address;

   
    // Warehouse --> Stock
    @OneToMany(mappedBy = "warehouse" , fetch= FetchType.LAZY) 
    @JsonManagedReference
    private List<Stock> stocks = new ArrayList<>();
    

    public Warehouse(){}
    
    /*
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setCode(String code) {
        this.Code = Code;
    }
    public void setAddress(String adress) {
        this.Address = Address;
    }
    */
}
