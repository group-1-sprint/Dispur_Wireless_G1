package com.tcs.group1.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.group1.bean.Customer;
import com.tcs.group1.util.DBUtil;

public class CustomerDAO {
	
	//connection setup
	Connection con=null;  //establsih the connection
	PreparedStatement ps=null;//Exceute SQL staements
	ResultSet rs=null;//select 
	
	//======================================Add Customer==============================================
	
	public int addCustomer(Customer c)
	{
		int result=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("insert into Customer values(?,?,?,?,?)");
            ps.setString(1, c.getRegId()); 
            ps.setString(2, c.getName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getContactNo());
            result=ps.executeUpdate(); //dml 
		
		
		} catch (SQLException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		finally
		{
			DBUtil.closeConnection(con);
		}
		return result;
		
	}
	
	//========================================Fetch customer details by id=============================================
	
		public ArrayList<Customer> fetchCustomer(String CustId)
		{
			
			ArrayList<Customer> list=new ArrayList<Customer>();
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("select * from Customer where regId=?");
				ps.setString(1, CustId);
				rs=ps.executeQuery();  //select
				while(rs.next())
				{
					
					String id=rs.getString(1);
					String name=rs.getString(2);
					String address=rs.getString(3);
					String emailId=rs.getString(4);
					String contactNo=rs.getString(5);
					
					
					Customer e=new Customer(id,name,address, emailId, contactNo);
					list.add(e);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	
	//========================================Update customer Details==========================================
	
	public int updateCustDetails(String id,String name, String address, String email, String contactNo)
	{
		int res=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("update Customer set name=?,address=?,email=?,contactNo=? where regId=?");
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, email);
			ps.setString(4, contactNo);
			ps.setString(5, id);
			res=ps.executeUpdate();  //return int (rows affected)
			System.out.println("Update details successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
		
		return res;
		
	}
	
	//====================================Admin Delete Customer Details=====================================================
	
//	public ArrayList<Customer> delCustomer(String CustId)
//	{
//		int rows = 0;
//		ArrayList<Customer> list=new ArrayList<Customer>();
//		con=DBUtil.getConnection();
//		try {
//			ps=con.prepareStatement("delete from Subscription where planId=?");
//			ps.setString(1, CustId);
//			rows=ps.executeUpdate(); //dml insert,delete ,update
//			
//			ps=con.prepareStatement("DELETE FROM Customer where regId=?");
//			ps.setString(1, CustId);
//			System.out.println("Successfully delete customer with id "+ CustId);
//			rs=ps.executeQuery();  //delete
//			
//			ps=con.prepareStatement("delete from Login where logId=?");
//			ps.setString(1, CustId);
//			rows=ps.executeUpdate(); //dml insert,delete ,update
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	public int delCustomer(String CustId)
	{
		int rows=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("delete from Subscription where custId=?");
			ps.setString(1, CustId);
			rows=ps.executeUpdate(); //dml insert,delete ,update
			
			ps=con.prepareStatement("DELETE FROM Customer where regId=?");
			ps.setString(1, CustId);
			rows=ps.executeUpdate();  //delete
			
			ps=con.prepareStatement("delete from Login where logId=?");
			ps.setString(1, CustId);
			rows=ps.executeUpdate(); //dml insert,delete ,update
			
			System.out.println("Successfully delete customer with id "+ CustId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeConnection(con);
		}
		
		return rows;
		
	}

}
