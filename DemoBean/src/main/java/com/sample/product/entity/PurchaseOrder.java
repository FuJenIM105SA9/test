package com.sample.product.entity;

import java.sql.Date;

public class PurchaseOrder {
	private long id;
    private long ProductId;
  
	private  int quantity; 
	
	 private Date orderTime;
	 
	private Date stockArrivalTime;

	        
	public long  getId(){
        return id;
}
   public void setId(long id){
	this.id= id;
}        

    /* getters and setters */
    public long getProductId(){
            return ProductId;
    }
    public void setProductId(long ProductId){
    	this.ProductId= ProductId;
    }
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	 public void setQuantity(int quantity){
	    	this.quantity=quantity;
	    }

	 public Date getOrderTime(){
			return orderTime;
		}
	    public void setOrderTime(Date orderTime){
	    	this.orderTime = orderTime;
	    }

	    public Date getStockArrivalTime(){
			return stockArrivalTime;
		}
	    public void setStockArrivalTime(Date stockArrivalTime){
	    	this.stockArrivalTime = stockArrivalTime;
	    }


}//Product
