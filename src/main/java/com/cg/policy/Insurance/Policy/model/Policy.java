package com.cg.policy.Insurance.Policy.model;                                                        
                                                                                                     
import javax.persistence.Column;                                                                     
import javax.persistence.Entity;                                                                     
import javax.persistence.GeneratedValue;                                                             
import javax.persistence.GenerationType;                                                             
import javax.persistence.Id;                                                                         
import javax.persistence.Table;                                                                      
                                                                                                     
/**                                                                                                  
 * @author Aymomin This class includes declaration of parameters of                                  
 *         policy class, default constructor, parameterized constructors, getter                     
 *         and setter methods of parameters and toString method to display.                          
 */                                                                                                  
/**
 * @author aymomin
 *
 */
@Entity                                                                                              
@Table(name = "Policy_Table")                                                                        
public class Policy {                                                                                
                                                                                                     
	@Id                                                                                              
	@GeneratedValue(strategy = GenerationType.AUTO)                                                  
	@Column(name = "planId")                                                                         
	private int planId;                                                                              
	@Column(name = "Name")                                                                           
	private String name;                                                                             
	@Column(name = "cost")                                                                           
	private Double cost;  
	@Column(name = "DeductableAmount")                                                                        
	private String detuctableAmount; 
	
	@Column(name = "Details")                                                                        
	private String details;                                                                          
	                                                                                                 
	@Column(name = "status")                                                                         
	private boolean deleted;                                                                         
                                                                                                     
	public Policy() {                                                                                
		super();                                                                                     
		                                                                                             
	}

	public Policy(int planId, String name, Double cost, String detuctableAmount, String details, boolean deleted) {
		super();
		this.planId = planId;
		this.name = name;
		this.cost = cost;
		this.detuctableAmount = detuctableAmount;
		this.details = details;
		this.deleted = deleted;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDetuctableAmount() {
		return detuctableAmount;
	}

	public void setDetuctableAmount(String detuctableAmount) {
		this.detuctableAmount = detuctableAmount;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Policy [planId=" + planId + ", name=" + name + ", cost=" + cost + ", detuctableAmount="
				+ detuctableAmount + ", details=" + details + ", deleted=" + deleted + "]";
	}                                                                                                
                                                                                                     
	                                                                                      
	                                                                                                 
	                                                                                                 
                                                                                                     
	                                                                                                 
}                                                                                                    
                                                                                                     