package com.sample.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.product.entity.Product;
import com.sample.product.entity.PurchaseOrder;

public class ProductDAODB implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> getList(){
		String sql = "SELECT * FROM product ";
		return getList(sql);
	}

	public  List <PurchaseOrder> getpList(){
		String sql = "SELECT * FROM purchaseorder ";
		return getpList(sql);
	}
	
	public List<Product> getReorderList() {
		String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
		return getList(sql);
	}
	
	public List<Product> getList2a(){
		String sql = "SELECT * FROM product  WHERE category = 'movie' ";
		return getList(sql);
	}
	
	public List<Product> getList2b(){
		String sql = "SELECT * FROM product  WHERE category = 'opera' ";
		return getList(sql);
	}
	
	public List<Product> getList2c(){
		String sql = "SELECT * FROM product  WHERE category = 'cartoon' ";
		return getList(sql);
	}
	
	public List<Product> getList2d(){
		String sql = "SELECT * FROM product  WHERE category = 'art' ";
		return getList(sql);
	}
	

	public List<Product> getList2e(){
		String sql = "SELECT * FROM product  WHERE category = 'music' ";
		return getList(sql);
	}
	

	public List<Product> getList3(){
		String sql = "SELECT * FROM product  WHERE desc Like '%?%' ";
		return getList(sql);
	}
	// make it a generic method for different conditions
	public List<Product> getList(String sql) {
					
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setId(rs.getInt("productID"));			
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setActor(rs.getString("actor"));
				aProduct.setDirector(rs.getString("director"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setDate(rs.getString("date"));
				aProduct.setPrice(rs.getInt("price"));
				aProduct.setSpecial_p_d(rs.getString("special_p_d"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				productList.add(aProduct);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return productList;
	}
		  
	public  List <PurchaseOrder> getpList(String sql) {
		
		List <PurchaseOrder> PurchaseOrder = new ArrayList<PurchaseOrder>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				PurchaseOrder apurchase= new PurchaseOrder();
				apurchase.setId(rs.getInt("id"));			
				apurchase.setProductId(rs.getInt("ProductId"));
				apurchase.setQuantity(rs.getInt("quantity"));
				
				PurchaseOrder.add(apurchase);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return PurchaseOrder;
	}
	
	public void insert(Product aProduct) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product (Category, Description, Actor, Director, Company, Date, Price, Special_p_d, Inventory, ReorderPoint) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getCategory());
			smt.setString(2, aProduct.getDesc());
			smt.setString(3, aProduct.getActor());
			smt.setString(4, aProduct.getDirector());
			smt.setString(5, aProduct.getCompany());
			smt.setString(6, aProduct.getDate());
			smt.setInt(7, aProduct.getPrice());
			smt.setString(8, aProduct.getSpecial_p_d());
			smt.setInt(9, aProduct.getInventory());
			smt.setInt(10, aProduct.getReorderPoint());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	public Product get(long id) {
		Product aProduct = new Product();
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setId(rs.getInt("productID"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return aProduct;
	}
	
	public void update(Product aProduct) {
		
		String sql = "UPDATE product SET Category=?, Description=?, Actor=?, Director=?, Company=?, Date=?, Price=?, Special_p_d=?, Inventory=?, ReorderPoint=? "
				+ "WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getCategory());
			smt.setString(2, aProduct.getDesc());
			smt.setString(3, aProduct.getActor());
			smt.setString(4, aProduct.getDirector());
			smt.setString(5, aProduct.getCompany());
			smt.setString(6, aProduct.getDate());
			smt.setInt(7, aProduct.getPrice());
			smt.setString(8, aProduct.getSpecial_p_d());
			smt.setInt(9, aProduct.getInventory());
			smt.setInt(10, aProduct.getReorderPoint());
			smt.setLong(11, aProduct.getId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	public void delete(long id) {
		
		String sql = "DELETE FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	
	public int count(){
		return 0; //no longer needed
	}
	
	
	public int sellProduct(List<Long> pList) throws SQLException {
	    
		if (pList.size() == 0){
			return 0; // if nothing in the shopping cart
		}
		long orderID = 0;
		int result = 0;
		int count = 0; // count how many sales order items were processed successfully
		
	    PreparedStatement stCreateOrder = null;
		PreparedStatement stUpdateProduct = null;
		PreparedStatement stInsertOrderItem = null;


		try {
		      
			//Connect to a database
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); //make it a transaction
			/*
			String sql = "INSERT INTO salesOrder (OrderTime) VALUES(Now())";
			st1 = conn.prepareStatement(sql);
			st1.executeUpdate();
			st1.close();
		    */
			
			// get order id for MS Access and SQL Server
			/*
			st2 = conn.prepareStatement("SELECT @@IDENTITY");
			ResultSet rs = st2.executeQuery();
		      if (rs != null && rs.next()) {
		    	  orderID = rs.getInt(1);
		      }
		      st2.close();
		      //System.out.println(orderID+"is created");
			*/
		      
			// get order id for MySQL
			
			String sqlCreateOrder = "INSERT INTO salesOrder (OrderTime) VALUES(Now())";
		    stCreateOrder  = conn.prepareStatement(sqlCreateOrder, PreparedStatement.RETURN_GENERATED_KEYS);
		    result = stCreateOrder.executeUpdate();
		    ResultSet rs = stCreateOrder.getGeneratedKeys();
		    if (rs != null && rs.next()) {
		    	orderID = rs.getLong(1);
		    }
		    System.out.println("order id:"+orderID);
		    stCreateOrder.close();		    
		      
		    for (long productID:pList){
		    	//the following two SQL have to be done in the same transaction
		    	//Issue a query and get a result
		    	stUpdateProduct = conn.prepareStatement("UPDATE product SET Inventory = Inventory - 1 WHERE ProductId = ?");
		    	stUpdateProduct.setLong(1,productID);
		    	result = stUpdateProduct.executeUpdate();
		    	stUpdateProduct.close();
		    	System.out.println(productID+"is updated");
		    	String sqlInsertOrderItem = "INSERT INTO salesOrderItem (SOID, ProductID, Quantity) VALUES(?, ?, 1)";
		    	stInsertOrderItem = conn.prepareStatement(sqlInsertOrderItem);
		    	stInsertOrderItem.setLong(1,orderID);
		    	stInsertOrderItem.setLong(2,productID);
		    	result = stInsertOrderItem.executeUpdate();
		    	stInsertOrderItem.close();
		    	System.out.println(productID+"is processed");
		    	count ++;
		      }// for all products on the cart
		      
		      conn.commit();
		      conn.close();
		      
		} // try
    	catch (Exception e) {
    		count = 0;
    		e.printStackTrace();
	  		if (conn!= null) { 
	  			try { 
	  				System.err.print("Transaction is being rolled back"); 
	  				conn.rollback(); } 
	  			catch(SQLException excep){
	  				e.printStackTrace(); 
	  			}
	  		}
	    } finally { 
		  	  if (stCreateOrder != null) {
		  	   stCreateOrder.close(); }
		  	  if (stUpdateProduct != null) { 
		  	   stUpdateProduct.close(); }
		  	  if (stInsertOrderItem != null) { 
			  	   stInsertOrderItem.close(); }
		  	  conn.close();
		} 
	    return count;
	} //sellProduct

	@Override

	public Product get(Product aProduct) {
		
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setId(rs.getInt("productID"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				
				aProduct.setPrice(rs.getInt("price"));
	
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return aProduct;
	}



}//ProductDAOBean
