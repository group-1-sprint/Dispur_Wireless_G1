package com.tcs.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.group1.bean.Plan;
import com.tcs.group1.util.DBUtil;

public class PlanDAO {
	
	//connection setup
	Connection con=null;  //establsih the connection
	PreparedStatement ps=null;//Exceute SQL staements
	ResultSet rs=null;//select 
	
	
	//=======================================Add plan===============================================
	
	public int addPlan(Plan p)
	{
		int result=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("insert into Plan values(?,?,?,?,?,?)");
            ps.setInt(1, p.getPlanId()); 
            ps.setString(2, p.getPlanName());
            ps.setString(3, p.getPlanType());
            ps.setDouble(4, p.getTariff());
            ps.setInt(5, p.getValidity());
            ps.setString(6, p.getRental());
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
	
//	===========================================delete plan==========================================
	
	public int deletePlan(int id)
	{
		int rows=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("delete from Plan where planId=?");
			ps.setInt(1, id);
			System.out.println("Successfully deleted the plan!!");
			rows=ps.executeUpdate(); //dml insert,delete ,update
			
			
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
	
//	==============================================update plan========================================
	
	public int updatePlan(int id,String pName,String pType,double tariff,int valid, String rental)
	
	{
		int res=0;
		con=DBUtil.getConnection();
		try {
			ps=con.prepareStatement("update Plan set planName=?,planType=?,tariff=?,validity=?,rental=? where  planId=?");
			ps.setString(1, pName);
			ps.setString(2, pType);
			ps.setDouble(3, tariff);
			ps.setInt(4, valid);
			ps.setString(5, rental);
			ps.setInt(6, id);
			res=ps.executeUpdate();  //return int (rows affected)
			
			System.out.println("Plan details with id "+id+" updated");
			
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
	
	//===========================================fetch all Plan=======================================
		public ArrayList<Plan> fetchPlan()
		{
			
			ArrayList<Plan> list=new ArrayList<Plan>();
			con=DBUtil.getConnection();
			try {
				ps=con.prepareStatement("select * from Plan");
				rs=ps.executeQuery();  
				while(rs.next())
				{
					
					int planId=rs.getInt(1);
					String planName=rs.getString(2);
					String planType =rs.getString(3);
					double tariff=rs.getDouble(4);
					int validity=rs.getInt(5);
					String rental =rs.getString(6);
					
					Plan e=new Plan(planId, planName, planType, tariff, validity,rental);
					list.add(e);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}

}
