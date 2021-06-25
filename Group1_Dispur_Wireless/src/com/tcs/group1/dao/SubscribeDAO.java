package com.tcs.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.group1.bean.Subscribe;
import com.tcs.group1.util.DBUtil;

public class SubscribeDAO {
	
	//connection setup
		Connection con=null;  //establsih the connection
		PreparedStatement ps=null;//Exceute SQL staements
		ResultSet rs=null;//select 
		
		//============================================add subscription================================================
		
		public int addSubs(Subscribe s)
		{
			int result=0;
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("insert into Subscription values(?,?,?,?)");
	            ps.setInt(1, s.getSubId()); 
	            ps.setString(2, s.getCustId());
	            ps.setInt(3, s.getPlanId());
	            ps.setInt(4, s.getDuration());
	            System.out.println("Your subscription is successfull");
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
		
//		==============================================update subscription========================================
		
		public int changeSubs(String custId,int planId,int changedPlanId)
		
		{
			int res=0;
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("update Subscription set planId=? where custId = ? AND planId = ?");
				ps.setInt(1, changedPlanId);
				ps.setString(2, custId);
				ps.setInt(3, planId);
				
				res=ps.executeUpdate();  //return int (rows affected)
				
				System.out.println("You have successfully changed from plan");
				
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

}
