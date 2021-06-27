package com.tcs.group1.tester;
import java.util.ArrayList;

import java.util.Scanner;
import com.tcs.group1.bean.Customer;
import com.tcs.group1.bean.Login;
import com.tcs.group1.bean.Plan;
import com.tcs.group1.bean.Subscribe;
import com.tcs.group1.dao.CustomerDAO;
import com.tcs.group1.dao.LoginDAO;
import com.tcs.group1.dao.PlanDAO;
import com.tcs.group1.dao.SubscribeDAO;

public class Tester {
	
	CustomerDAO daoc = new CustomerDAO();
	PlanDAO daop = new PlanDAO();
	LoginDAO daol = new LoginDAO();
	SubscribeDAO daos = new SubscribeDAO();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tester main = new Tester();

		//Call the showMenu method
		main.mainMenu();
				
	}
	
	//=====================================Main Menu=========================================
	
	public void mainMenu() {
		
		int selection;
		String Id = null;
		
		System.out.println("\n==================Main Menu====================");
		System.out.println("=============================================== ");
		System.out.println("|             1.Registration                    | ");
		System.out.println("|             2.Login                           | ");
		System.out.println("|             3.View Plan                       | ");
		System.out.println("|             4.Exit                            | ");
		System.out.println("=============================================== ");
		
		System.out.print("\nPlease make a selection: ");
		selection =sc.nextInt();
	
		 switch (selection){
		 	case 1:
		 		UserRegistration();		 		
		 		break;
		 	case 2:
		 		login();
		 		break;
		 	case 3:
		 		portalView(Id);
		 		break;
		 	case 4:
		 		System.out.print("\nThank you for using our system");
		 		System.exit(0);
		 		
		 	default:
				System.out.println("Invalid Input!");
		 }
		 mainMenu();
		
	}
	
	//=====================================manager menu=================================================================
	
		public void managerMenu() {
			
			int selection;
			System.out.println("\n==================Manager Menu====================");
			System.out.println("=============================================== ");
			System.out.println("|             1.View Customer Details           |");
			System.out.println("|             2.View Customer Subscribe Details | ");
			System.out.println("|             3.Main Menu                       | ");
			System.out.println("=============================================== ");
			
			System.out.print("\nPlease make a selection: ");
			selection =sc.nextInt();

			switch (selection){
		 	case 1:
				System.out.print("\nEnter Customer Id:");
				String Id = String.valueOf(sc.nextInt());
		 		custDetails(Id);
		 		managerMenu();
		 		break;
		 	case 2:
		 		System.out.println("\nEnter Customer id: " );
		 		String id = String.valueOf(sc.nextInt());
		 		custSubsDetails(id);
		 		managerMenu();
		 		break;
		 	case 3:
		 		mainMenu();
		 		break;
		 	default:
				System.out.println("\nInvalid Input!");
				managerMenu();
			}
			
		}
		
		//==============================================admin menu==========================================================
		
		public void adminMenu() {
			
			int selection;

			System.out.println("\n==================Admin Menu====================");
			System.out.println("=============================================== ");
			System.out.println("|             1.Add new plan                   |");
			System.out.println("|             2.Update plan                    | ");
			System.out.println("|             3.Remove plan                    | ");
			System.out.println("|             4.Exit                           | ");
			System.out.println("=============================================== ");
				
				
				System.out.print("Please make a selection: ");
				selection =sc.nextInt();
			
				 switch (selection){
				 	case 1:
				 		addPlan();
				 		break;
				 	case 2:
				 		planList();
						System.out.print("Enter Plan Id that you wanted to update: ");
						int pId = sc.nextInt();
				 		updatePlan(pId);
				 		break;
				 	case 3:
				 		removePlan();
				 		break;
				 	case 4:
				 		mainMenu();
				 		break;
				 		
				 	default:
						System.out.println("Invalid Input!");
						
				 }
				 adminMenu();
				 
		}
	
	//================================Customer Management Portal======================================
	
	public void customerMenu(String Id)
	{
		int selection;
		System.out.println("\n==================User Menu====================");
		System.out.println("=============================================== ");
		System.out.println("|             1.View details                    |");
		System.out.println("|             2.Update details                  |");
		System.out.println("|             3.Portal                          | ");
		System.out.println("|             4.Subscribed plan                 | ");
		System.out.println("|             5.Unsubscribe plan                | ");
		System.out.println("|             6.Change plan                     | ");
		System.out.println("|             7.Back to main menu               | ");
		System.out.println("=============================================== ");
			
			System.out.print("Please make a selection: ");
			selection =sc.nextInt();
		
			 switch (selection){
			 	case 1:
			 		custDetails(Id);
			 		break;
			 	case 2:
			 		updateCustDetails(Id);
			 		break;
			 	case 3:
			 		portalView(Id);
			 		break;
			 	case 4:
			 		custSubsDetails(Id);
			 		break;
			 	case 5:
			 		unSubs(Id);
			 		break;
			 	case 6:
			 		changePlan(Id);
			 		break;
			 	case 7:
			 		mainMenu();
			 		break;
			 		
			 	default:
					System.out.println("Invalid Input!");
					
		}
		customerMenu(Id);
		

	}
	
	//====================================Customer Registration=======================================
	
	public void UserRegistration(){
			
		String[] cust = customerInput();//return values keyed in by user
					
		String id=  String.valueOf(Tester.getRandomIntegerBetweenRange(1,1000));
			
		Customer c= new Customer(id,cust[0],cust[1],cust[2],cust[3]);
			
		System.out.println("Register successfully !!! ");
		System.out.println("Your registerID is " + id);
		System.out.println("Please set a password to your account.");
		System.out.println("\n");
			
		password(c);			
	}
	
	//=====================================random number generator====================================
	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	//=========================================User Login============================================
	
	public void login(){
		
		sc.nextLine();
		ArrayList<Login> loglist=new ArrayList<Login>();
		loglist = daol.fetchLogin();

		System.out.println("Enter Your Registration ID: ");
		String id = String.valueOf(sc.nextLine());
		boolean invalid = true;
		for(Login l:loglist) {
			if(id.equals(l.getLogId())) {
				do {
					System.out.println("\nEnter Your Password: ");
					String password = sc.nextLine();
					if(password.equals(l.getPassword())) {
						if(l.getLogId().equals("Manager")) {
							System.out.println("\nYou have logged in as Relationship Manager");
							managerMenu();
							invalid = false;
						}
						else if(l.getLogId().equals("Admin")) {
							System.out.println("\nYou have logged in as Admin");
							adminMenu();
							invalid = false;
						}
						else if(l.getLogId().equals("Operator")) {
							System.out.println("\nYou have logged in as Company Operator");
							removeCust();
							invalid = false;
						}
						else {
							customerMenu(id);
							invalid = false;
						}
						
					}else {
						System.out.println("Invalid password! ");
					}
				}while(invalid);
			}
		}
		System.out.println("No user id found. Register first.");
		
	}
	
	
	//=====================================Enter password============================================
	
	public void password(Customer c){
		String pwd,pwd1;
		int i=1;
		
		do{
			System.out.print("Password: ");
			pwd= sc.nextLine();
			
			System.out.print("Confirm Password: ");
			pwd1= sc.nextLine();
		
			if(!pwd.equals(pwd1)){
				System.out.println("The password is not match.");
				System.out.println("Please enter the password again.");
				System.out.println("\n");
			}
		
		}while (!pwd.equals(pwd1));		
		
		Login l = new Login(c.getRegId(),pwd);
		daol.addLogin(l);
		daoc.addCustomer(c);
		System.out.println("The registration is successfully complete!!");
		System.out.println("\n");
			
	}
	
	//===============================================View Portal===========================================================
	
	public void portalView(String Id) {
		
		System.out.println("List of plan available in Dispur Wireless:");
		planList();// call method to view plan list
		int ans;
		// check if user is logged in or not
		 if(Id != null) {
			 do {
				 System.out.println("Do you want to subscribe to a plan?");
				 System.out.print("1-Yes || 2-No : ");
				 ans = sc.nextInt();
				 
				 switch (ans){
				 	case 1:
				 		subscribe(Id);
				 		break;
				 	case 2:
				 		return;
				 	default:
						System.out.println("Invalid Input!");
				 }
				
			}while(ans != 1 & ans!=2);
			 
		 }else {
			 do {
				 System.out.print("1-Main Menu || 2-Exit : ");
				 ans = sc.nextInt();
				 switch (ans){
				 	case 1:
				 		mainMenu();
				 		break;
				 	case 2:
				 		System.out.print("Thank you for using our system");
				 		System.exit(0);
				 	default:
						System.out.println("Invalid Input!");
				 }
				
			}while(ans != 1 & ans!=2);
			 
		 }
		
	}
	
	//============================================Print Customer Details==============================================
	
	public void custDetails(String Id) {
		
		ArrayList<Customer> list=new ArrayList<Customer>();
		list=daoc.fetchCustomer(Id);
		for(Customer c : list)
		{
			System.out.println("\nID:"+c.getRegId()+"\n"+ "Name:"+c.getName()+"\n"+"Address:"+ c.getAddress()+"\n"+"Email ID:"+ c.getEmail()+"\n"+"Contact Number:"+c.getContactNo());
		}
		
	}
	
	//=========================================Customer Subscription Details=================================================
	
		public void custSubsDetails(String Id) {
			
			System.out.println("\n------Current Subscribed Plan------");
			ArrayList<Plan> slist=new ArrayList<Plan>();
			slist = daos.fetchSubsById(Id);
			 for(Plan p : slist)
			 {
				 System.out.println("\nPlan ID: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif: "+p.getTariff()+"\n"+"Validity: "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n"); 
				 System.out.println("-----------------------------------");
			 }
			 
			
		}
		
		//===================================================Unsub Plan==========================================================
		
		public void unSubs(String Id) {
			
			int ans;
			System.out.println("List of plan that you currently subscribed in Dispur Wireless:");
			custSubsDetails(Id);// call method to view current subscribed list
				 
			System.out.println("Do you really want to continue unsubscribe your current plan?");
			System.out.print("1-Yes || 2-No : ");
			ans = sc.nextInt();
			 
			switch (ans){
				case 1:
					System.out.println("Enter Plan Id that you want to cancel subscription");
					ans = sc.nextInt();
					
					daos.delPlan(Id,ans);
					break;
				case 2:
					return;
				default:
					System.out.println("Invalid Input!");
			}
			
		}
		
		//========================================Customer Update Their Details=======================================
		
		public void updateCustDetails(String Id) {
			
//			System.out.println("Proceed with updating details?");
//			System.out.print("1-Yes | 2-No : ");
			String[] cust = customerInput();
			daoc.updateCustDetails(Id, cust[0], cust[1], cust[2], cust[3]);
			return;
			
		}
	
		//=========================================Customer Subscribe to a plan=======================================
		
	public void subscribe(String Id) {
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();
		boolean sel = true;
		do {	
			
			System.out.println("Enter plan id to view details and subscribe");
			System.out.print("Plan Id: ");
			int planId = sc.nextInt();
			for(Plan p : list)
			{
				 if(planId == p.getPlanId()) {
					 System.out.println("Plan Id: "+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+"\n"+"Validity: "+p.getValidity()+"\n");
					 System.out.println("Amount is RM "+p.getTariff());
					 System.out.println("Proceed with Subscription?");
					 System.out.println("1.Yes"+"\n"+"2.No");
					 int select = sc.nextInt();
					 if(select == 1) {
						 sel = false;
						 Subscribe sub = new Subscribe(Tester.getRandomIntegerBetweenRange(1,100),Id,planId,Tester.getRandomIntegerBetweenRange(1,10));
						 daos.addSubs(sub);
						 break;
					 }
				 }
			}
			
		}while(sel);
		
		customerMenu(Id);
		
	}
	
	//=================================================Customer Change Plan=================================================
	
	public void changePlan(String Id) {
				
		System.out.println("Enter plan id: ");
		int current = sc.nextInt();
		System.out.println("You want to change to plan : ");
		int changedId = sc.nextInt();
		System.out.println("Changing Plan from " +current+ " to "+ changedId +" ?");
		int ans;
		do {
			System.out.println("1-Yes | 2-No");
			ans = sc.nextInt();
			switch (ans){
		 	case 1:
		 		daos.changeSubs(Id, current, changedId);
		 		return;
		 	case 2:
		 		return;
		 	default:
				System.out.println("Invalid Input!");
			}
		
		}while(ans != 1 & ans!=2);
		
	}
	
	
	//=================================================Admin Add New Plan=====================================================
	
	public void addPlan() {
		
		System.out.println("Enter Plan Details: ");
		
		String[] plan = adminPlanInput();//return details of plan from admin input
		int Id = Tester.getRandomIntegerBetweenRange(1, 100);
		Plan pln = new Plan(Id,plan[0],plan[1],Double.parseDouble(plan[2]),Integer.parseInt(plan[3]),plan[4]);
		daop.addPlan(pln);
		adminMenu();
		
	}
	
	//==============================================Admin Update Plan Details=================================================
	
	public void updatePlan(int Id) {
		
		String[] plan = adminPlanInput();
		daop.updatePlan(Id, plan[0], plan[1], Double.parseDouble(plan[2]), Integer.parseInt(plan[3]), plan[4]);
		adminMenu();
		
	}
	
	//==============================================Admin Remove Plan========================================================
	
	public void removePlan() {
		
		System.out.print("Insert Plan id you want to delete: ");
		int pid =sc.nextInt();
		daop.deletePlan(pid);
		adminMenu();
		
	}
	
	//==============================================Admin Remove Customer======================================================
	
	public void removeCust() {
		
		System.out.print("Insert Customer id you want to delete: ");
		String id =sc.nextLine();
		daoc.delCustomer(id);
		mainMenu();
		
	}

	
	//============================================Method to view plan list==================================================
	
	public void planList(){
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();
		 for(Plan p : list)
		 {
			 System.out.println("\nPlan Id: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif: "+p.getTariff()+"\n"+"Validity: "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n");
		 }
		
	}
	
	//===========================Method for accepting Customer registration and Update input===========================
	
	public String[] customerInput() {
		
		String[] cust = new String[4];
		
		sc.nextLine();
		System.out.println("====== Enter Your Details ======");
		System.out.print("Name: ");
		String name= sc.nextLine();
		cust[0] = name;
		
		System.out.print("Address: ");
		String address= sc.nextLine();
		cust[1] = address;
		
		System.out.print("Email: ");
		String email= sc.nextLine();
		cust[2] = email;
		
		System.out.print("Contact Number: ");
		String contactNum= sc.nextLine();
		cust[3] = contactNum;
		
		return cust;
		
	}
	
	//==================================Method for accepting Admin Add and Update Plan===============================
	
	public String[] adminPlanInput() {
		
		String[] pln = new String[5];
		System.out.println("====== Enter Plan Details ======");
		sc.nextLine();
		System.out.print("Name: ");
		String plnName= sc.nextLine();
		pln[0] = plnName;
		
		System.out.print("Type: ");
		String type= sc.nextLine();
		pln[1] = type;
		
		System.out.print("Tariff: ");
		String tariff= String.valueOf(sc.nextDouble());
		pln[2] = tariff;
			
		System.out.print("Validity: ");
		String validity= String.valueOf(sc.nextInt());
		pln[3] = validity;
		
		sc.nextLine();
		System.out.print("Rental: ");
		String rental= sc.nextLine();
		pln[4] = rental;
		
		return pln;
		
	}
	
//	public void checkDuration() {
//		
//	}
}