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
    private @NonNull long warehouseId;
    private String warehouseName;
    private String warehouseCode;
    private String warehouseAddress;

   
    // Warehouse --> Stock
    @OneToMany(mappedBy = "warehouse" , fetch= FetchType.LAZY) 
    @JsonManagedReference
    private List<Stock> stocks = new ArrayList<>();
    

    public Warehouse(){}
    
    public void setWHName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    public void setWHCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
    public void setWHAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}