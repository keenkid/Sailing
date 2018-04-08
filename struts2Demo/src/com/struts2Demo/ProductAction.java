package com.struts2Demo;

//import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

public class ProductAction {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 644441412116645755L;
	
	private int id;  
	private String name;  
	private float price; 
	
	public int getId() {  
	    return id;  
	}
	
	@RequiredFieldValidator
	public void setId(int id) {  
	    this.id = id;  
	}
	
	public String getName() {  
	    return name;  
	}
	
	@RequiredStringValidator(message = "Please input product name.")
	public void setName(String name) {  
	    this.name = name;  
	}
	
	public float getPrice() {  
	    return price;  
	}
	
	@RequiredFieldValidator
	public void setPrice(float price) {  
	    this.price = price;  
	}  
	  
	public String execute(){
		if(name.equalsIgnoreCase("maoyufeng")){
			return "success";
		}else{
			return "failure";
		}
	}
}
