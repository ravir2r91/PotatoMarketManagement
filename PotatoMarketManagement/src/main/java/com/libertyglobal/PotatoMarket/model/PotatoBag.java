package com.libertyglobal.PotatoMarket.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.libertyglobal.PotatoMarket.annotations.CheckSupplier;

/**
 * Model Class defining the structure of resource Potato Bag. 
 * 
 * @author Rabindra Rakshit
 */

@Entity
public class PotatoBag {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
		
	@NotNull
	@Min(value = 1, message = "Number of potatoes should not be less than 1")
    @Max(value = 100, message = "Price should not be greater than 100")
	private int numberOfPotatoes;
	
	@CheckSupplier(message="Invalid Supplier")
	private String supplier;  // must be one of "De Coster","Owel","Patatas Ruben","Yunnan Spices"
	
	private LocalDateTime packagedDateTime;
	
	@NotNull
	@Min(value = 1, message = "Price should not be less than 1")
    @Max(value = 50, message = "Price should not be greater than 50")
	private int price;  // number from 1 to 50
	
	public PotatoBag(){
		
	}
	
	public PotatoBag(long id,int numberOfPotatoes, String supplier, LocalDateTime packagedDateTime,
			int price){
		this.id=id;
		this.numberOfPotatoes=numberOfPotatoes;
		this.supplier=supplier;
		this.packagedDateTime=packagedDateTime;
		this.price=price;
	}
	
	

	public int getNumberOfPotatoes() {
		return numberOfPotatoes;
	}
	public void setNumberOfPotatoes(int numberOfPotatoes) {
		this.numberOfPotatoes = numberOfPotatoes;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public LocalDateTime getPackagedDateTime() {
		return packagedDateTime;
	}
	public void setPackagedDateTime(LocalDateTime packagedDateTime) {
		this.packagedDateTime = packagedDateTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Potato [db_id=" + id + ", numberOfPotatoes=" + numberOfPotatoes + ", supplier=" + supplier + 
				", packagedDateTime="+packagedDateTime+", price="+price+"]";
	}
}

