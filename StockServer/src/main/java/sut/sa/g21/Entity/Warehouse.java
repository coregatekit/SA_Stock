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
    @GeneratedValue
    private @NonNull long WH_Id;
    private String WH_Name;
    private String WH_Code;
    private String WH_Address;

   
    // Warehouse --> Stock
    @OneToMany(mappedBy = "warehouse" , fetch= FetchType.LAZY) 
    @JsonManagedReference
    private List<Stock> stocks = new ArrayList<>();
    

    public Warehouse(){}
    
    public void setWHName(String WH_Name) {
        this.WH_Name = WH_Name;
    }
    public void setWHCode(String WH_Code) {
        this.WH_Code = WH_Code;
    }
    public void setWHAddress(String WH_Address) {
        this.WH_Address = WH_Address;
    }
}
