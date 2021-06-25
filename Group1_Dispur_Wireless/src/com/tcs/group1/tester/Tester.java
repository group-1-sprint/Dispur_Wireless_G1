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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tester main = new Tester();

		//Call the showMenu method
		main.mainMenu();
				
	}
	
	//=====================================Main Menu=========================================
	
	public void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		int selection;
//		boolean loginStatus = false;
		String Id = null;
		System.out.println("=============================================== ");
		System.out.println("|             1.Manager                         |");
		System.out.println("|             2.Admin                           | ");
		System.out.println("|             3.Registration                    | ");
		System.out.println("|             4.Login                           | ");
		System.out.println("|             5.Portal                          | ");
		System.out.println("|             6.Exit                            | ");
		System.out.println("=============================================== ");
		
		System.out.print("Please make a selection: ");
		selection =sc.nextInt();
	
		 switch (selection){
		 	case 1:
		 		managerMenu();
		 		break;
		 	case 2:
		 		adminMenu();
		 		break;
		 	case 3:
		 		UserRegistration();
		 		break;
		 	case 4:
		 		login();
		 		break;
		 	case 5:
		 		portalView(Id);
		 		break;
		 	case 6:
		 		System.out.print("Thank you for using our system");
		 		break;
		 		
		 	default:
				System.out.println("Invalid Input!");
				mainMenu();
		 }
		 
		
	}
	
	//================================Customer Management Portal======================================
	
	public void customerMenu(String Id)
	{
		Scanner sc = new Scanner(System.in);
		int selection;
		System.out.println("=============================================== ");
		System.out.println("|             1.View details                    |");
		System.out.println("|             2.Portal                          | ");
		System.out.println("|             3.Subscribed plan                 | ");
		System.out.println("|             4.Unsubscribe plan                | ");
		System.out.println("|             5.Change plan                     | ");
		System.out.println("|             6.Back to main menu               | ");
		System.out.println("=============================================== ");
			
			System.out.print("Please make a selection: ");
			selection =sc.nextInt();
		
			 switch (selection){
			 	case 1:
			 		custDetails(Id);
			 		break;
			 	case 2:
			 		portalView(Id);
			 		customerMenu(Id);
			 		break;
			 	case 3:
//			 		viewSubs();
			 		break;
			 	case 4:
//			 		unSubs();
			 		break;
			 	case 5:
			 		changePlan(Id);
			 		break;
			 	case 6:
			 		mainMenu();
			 		break;
			 		
			 	default:
					System.out.println("Invalid Input!");
		}
		customerMenu(Id);

	}
	
	//====================================Customer Registration=======================================
	
	public void UserRegistration(){
			
		Scanner sc = new Scanner(System.in);
		System.out.println("====== Enter Your Details ======");
			System.out.print("Name: ");
			String name= sc.nextLine();
			
			System.out.print("Address: ");
			String address= sc.nextLine();
			
			System.out.print("Email: ");
			String email= sc.nextLine();
			
			System.out.print("Contact Number: ");
			String contactNum= sc.nextLine();
					
			String id=  String.valueOf(Tester.getRandomIntegerBetweenRange(1,1000));
			
			Customer c= new Customer(id,name,address,email,contactNum);
			
			System.out.println("Register successfully !!! ");
			System.out.println("Your registerID is " + id);
			System.out.println("Please set a password to your account.");
			System.out.println("\n");
			
			password(c);
			mainMenu();
			
		}
	
	//=====================================random number generator====================================
	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	//=========================================User Login============================================
	
	public void login(){
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Login> loglist=new ArrayList<Login>();
		loglist = daol.fetchLogin();

		System.out.println("Enter Your Registration ID: ");
		String id = String.valueOf(sc.nextLine());
		for(Login l:loglist) {
			System.out.println("inside loop");
			if(id.equals(l.getLogId())) {
				System.out.println("Enter Your Password: ");
				String password = sc.nextLine();
				if(password.equals(l.getPassword())) {
					break;
					
				}else {
					System.out.println("Invalid password! ");
				}
				
			}
		}
		customerMenu(id);
		
	}
	
//	public void Login(){
//
//		Scanner s = new Scanner(System.in);
//		System.out.println("\n        Login Page");
//		System.out.println("===============================");
//
//		System.out.println (" Enter your User ID : ");
//		String id = s.next();
//		LoginDAO cred=new LoginDAO();
//		//create new array list that stored all login table data
//		ArrayList<Login> viewlog = new ArrayList<Login>();
//		viewlog = cred.fetchLogin(id);
//			for (Login L :viewlog){ //iterate data in table
//				if(id.equals(L.getLogId())){ // check if entered id is matched with current id in table
//					
//					System.out.println(" Enter your password :");
//					String password = s.next();
//					
//					if (password.equals(L.getPassword())) {// check if password entered is matching with the stored password
//						System.out.println("Login Successful !");
//						
//						CustomerDAO cred1=new CustomerDAO();
//						ArrayList<Customer> viewcred = new ArrayList<Customer>();
//						viewcred = cred1.fetchCustomer(id);
//						
//						for (Customer C :viewcred){
//							System.out.println("ID:"+C.getRegId()+"\n"+ "Name:"+C.getName()+"\n"+"Address:"+ C.getAddress()+"\n"+"Email ID:"+ C.getEmail()+"\n"+"Contact Number:"+C.getContactNo());
//						}
//						customerMenu(id);// go to customer menu
//
//					}
//					else{
//						System.out.println("Invalid password");
//						Login();
//					}
//				}
//				else
//				{
//					System.out.println("No User found with this ID");
//					mainMenu();
//				}
//			}
//			
//	}
	
	//=====================================Enter password============================================
	
	public void password(Customer c){
		String pwd,pwd1;
		int i=1;
		do{
		Scanner x=new Scanner(System.in);
		System.out.print("Password: ");
		pwd= x.nextLine();
			
		System.out.print("Confirm Password: ");
		pwd1= x.nextLine();
		
		if(!pwd.equals(pwd1)){
			System.out.println("The password is not match.");
			System.out.println("Please enter the password again.");
			System.out.println("\n");
		}
		
		}while (!pwd.equals(pwd1));				
		{	
			Login l = new Login(c.getRegId(),pwd);
			daol.addLogin(l);
			daoc.addCustomer(c);
			System.out.println("The registration is successfully complete!!");
			System.out.println("\n");
		}
			
	}
	
	//===============================================View Portal===========================================================
	
	public void portalView(String Id) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("List of plan available in Dispur Wireless:");
		planList();// call method to view plan list
		
		// check if user is logged in or not
		 if(Id != null) {
			 System.out.println("Do you want to subscribe to a plan?");
			 System.out.print("1-Yes || 2-No : ");
			 int ans = sc.nextInt();
			 
			 switch (ans){
			 	case 1:
			 		subscribe(Id);
			 		break;
			 	case 2:
			 		customerMenu(Id);
			 		break;
			 	default:
					System.out.println("Invalid Input!");
			 }
		 }else {
			 
			 System.out.print("1-Main Menu || 2-Exit : ");
			 int ans = sc.nextInt();
			 switch (ans){
			 	case 1:
			 		mainMenu();
			 		break;
			 	case 2:
			 		System.out.print("Thank you for using our system");
			 		break;
			 	default:
					System.out.println("Invalid Input!");
			 }
			 
		 }
		
	}
	
	public void custDetails(String Id) {
		
		ArrayList<Customer> list=new ArrayList<Customer>();
		list=daoc.fetchCustomer(Id);
		for(Customer c : list)
		{
			System.out.println("ID:"+c.getRegId()+"\n"+ "Name:"+c.getName()+"\n"+"Address:"+ c.getAddress()+"\n"+"Email ID:"+ c.getEmail()+"\n"+"Contact Number:"+c.getContactNo());
		}
		
	}
	
	public void subscribe(String Id) {
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter plan id to view details and subscribe");
		System.out.print("Plan Id: ");
		boolean sel = true;
		do {
			
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
						 Subscribe sub = new Subscribe(Tester.getRandomIntegerBetweenRange(1,100),Id,planId,Tester.getRandomIntegerBetweenRange(1,5));
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
		
		int current = 94;
		int changedId = 34;
		System.out.println("Changing Plan from " +current+ " to "+ changedId);
		daos.changeSubs(Id, current, changedId);
		
	}
	
	
	//=====================================manager menu=================================================================
	public void managerMenu() {
		
		Scanner sc = new Scanner(System.in);
		int selection;
		System.out.println("=============================================== ");
		System.out.println("|             1.View Customer Details           |");
		System.out.println("|             2.View Customer Subscribe Details | ");
		System.out.println("|             3.Exit                            | ");
		System.out.println("=============================================== ");
		
		System.out.print("Please make a selection: ");
		selection =sc.nextInt();

		switch (selection){
	 	case 1:
			System.out.print("Enter number id:");
			String Id = String.valueOf(sc.nextInt());
	 		custDetails(Id);
	 		managerMenu();
	 		break;
	 	case 2:
	 		System.out.print("Work in progress!!");
	 		break;
	 	case 3:
//	 		System.out.print("Thank you for using our system");
	 		mainMenu();
	 		break;
	 		
	 	default:
			System.out.println("Invalid Input!");
		}
		
		managerMenu();
	}
	
	//==============================================admin menu==========================================================
	public void adminMenu() {
		
		Scanner sc = new Scanner(System.in);
		int selection;
//		boolean loginStatus = false;
		System.out.println("=============================================== ");
		System.out.println("|             1.Add new plan                   |");
		System.out.println("|             2.Update plan                    | ");
		System.out.println("|             3.Remove plan                    | ");
		System.out.println("|             4.Remove Customer                | ");
		System.out.println("|             5.Exit                           | ");
		System.out.println("=============================================== ");
			
			
			System.out.print("Please make a selection: ");
			selection =sc.nextInt();
		
			 switch (selection){
			 	case 1:
			 		addPlan();
			 		break;
			 	case 2:
					System.out.print("Enter Plan Id that you wanted to update: ");
					int pId = sc.nextInt();
			 		updatePlan(pId);
			 		break;
			 	case 3:
			 		removePlan();
			 		break;
			 	case 4:
			 		removeCust();
			 		break;
			 	case 5:
			 		mainMenu();
			 		break;
			 		
			 	default:
					System.out.println("Invalid Input!");
					adminMenu();
			 }
			 
	}
	
	public void addPlan() {
		
		System.out.println("Work in progress!!");
		adminMenu();
		
	}
	
	public void updatePlan(int Id) {
		
//		System.out.println("Work in progress!!");
		Scanner sc = new Scanner(System.in);
		System.out.println("====== Enter Plan Details ======");
		
		System.out.print("Name: ");
		String name= sc.nextLine();
			
		System.out.print("Type: ");
		String type= sc.nextLine();
			
		System.out.print("Tariff: ");
		double tariff= sc.nextDouble();
			
		System.out.print("Validity: ");
		int validity= sc.nextInt();
		
		sc.nextLine();
		System.out.print("Rental: ");
		String rental= sc.nextLine();
		
		daop.updatePlan(Id, name, type, tariff, validity, rental);
		adminMenu();
		
	}
	
	public void removePlan() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert Plan id you want to delete: ");
		int pid =sc.nextInt();
		daop.deletePlan(pid);
		adminMenu();
		
	}
	
	public void removeCust() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert Customer id you want to delete: ");
		String id =sc.nextLine();
		daoc.delCustomer(id);
		adminMenu();
		
	}

	
	//============================================Method to view plan list==================================================
	public void planList(){
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();
		 for(Plan p : list)
		 {
			 System.out.println("Plan Id: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif: "+p.getTariff()+"\n"+"Validity: "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n\n");
		 }
		
	}
}