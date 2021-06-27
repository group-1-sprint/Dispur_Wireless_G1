package com.tcs.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.group1.bean.Plan;
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
				
				System.out.println("You have successfully changed from plan " +planId+ " to "+ changedPlanId);
				
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
		
		//============================================fetch subs by customer id===============================================
		
		public ArrayList<Plan> fetchSubsById(String cId)
		{
			
			ArrayList<Plan> sublist=new ArrayList<Plan>();
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("select Subscription.planId, Plan.planName, Plan.planType, Plan.tariff, Plan.validity, Plan.rental from Subscription join Plan on Subscription.planId=Plan.planId where Subscription.custId=?");
				
				ps.setString(1, cId);
				rs=ps.executeQuery(); 
				while(rs.next())
				{
					int planId= rs.getInt(1);
					String planName= rs.getString(2);
					String planType = rs.getString(3);
					double tariff= rs.getDouble(4);
					int validity= rs.getInt(5);
					String rental = rs.getString(6);
					
					Plan s=new Plan(planId, planName, planType, tariff, validity,rental);
					sublist.add(s);
					
				}
				
				
			} catch (SQLException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			}
			return sublist;
		}
		
		//============================================customer unsubscribe plan================================
		
		public int delPlan(String CustId,int PlanId)
		{
			int row = 0;
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("DELETE FROM subscription where custId=? and planId=?");
				ps.setString(1, CustId);
				ps.setInt(2, PlanId);
				System.out.println("Successfully cancel the current plan "+ PlanId);
				rs=ps.executeQuery();  //delete
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row;
		}
		
//		//==========================================Delete Subscription==============================================
//		
//		public int delSub(String CustId)
//		{
//			int row = 0;
//			con=DBUtil.getConnection();
//			try {
//				ps=con.prepareStatement("DELETE FROM Subscription where regId=?");
//				ps.setString(1, CustId);
//				row=ps.executeUpdate();  //delete
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return row;
//		}
		
		

}
