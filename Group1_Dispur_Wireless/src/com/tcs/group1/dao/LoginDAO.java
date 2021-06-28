package com.tcs.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.group1.bean.Customer;
import com.tcs.group1.bean.Login;
import com.tcs.group1.util.DBUtil;


public class LoginDAO {
	
	//connection setup
	Connection con=null;  //establsih the connection
	PreparedStatement ps=null;//Exceute SQL staements
	ResultSet rs=null;//select 
	
	public int addLogin(Login l)
	{
		int result=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("insert into Login values(?,?)");
            ps.setString(1, l.getLogId()); 
            ps.setString(2, l.getPassword());
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
	
	public ArrayList<Login> fetchLogin()
	{
		
		ArrayList<Login> loglist=new ArrayList<Login>();
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("select * from Login");
//			ps.setString(1, LogId);
			rs=ps.executeQuery();  //select
			while(rs.next())
			{
				
				String id=rs.getString(1);
				String password=rs.getString(2);
				
				Login l=new Login(id,password);
				loglist.add(l);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loglist;
	}

}
