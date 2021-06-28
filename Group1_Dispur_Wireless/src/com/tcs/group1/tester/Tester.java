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
		String Id = null;//to indicate that user did not login yet
		
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
		 		UserRegistration();// go to registration method		 		
		 		break;
		 	case 2:
		 		login(); // go to login method
		 		break;
		 	case 3:
		 		portalView(Id); // view plan without login
		 		break;
		 	case 4:
		 		System.out.print("\nThank you for using our system");
		 		System.exit(0); // terminate the program
		 		
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
		 		custDetails(Id); // method to view customer details based on id
		 		break;
		 	case 2:
		 		System.out.println("\nEnter Customer id: " );
		 		String id = String.valueOf(sc.nextInt());
		 		custSubsDetails(id); // method to view customer subscribed details
		 		break;
		 	case 3:
		 		mainMenu(); // go back to main menu
		 		break;
		 	default:
				System.out.println("\nInvalid Input!");
				
			}
			managerMenu(); //will go too manager menu after perform tasks or invalid selection
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
				 		addPlan(); // method for admin to add new plan
				 		break;
				 	case 2:
				 		planList();
						System.out.print("Enter Plan Id that you wanted to update: ");
						int pId = sc.nextInt();
				 		updatePlan(pId); // method for admin to update plan details
				 		break;
				 	case 3:
				 		removePlan(); //method for admin to remove plan
				 		break;
				 	case 4:
				 		mainMenu(); //go back to main menu
				 		break;
				 		
				 	default:
						System.out.println("Invalid Input!");
						
				 }
				 adminMenu(); // go back to admin page after performing tasks
				 
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
			 		custDetails(Id); // method for customer to view their details
			 		break;
			 	case 2:
			 		updateCustDetails(Id); // method for customer to update their details
			 		break;
			 	case 3:
			 		portalView(Id); // method for customer to view and subscribe plan
			 		break;
			 	case 4:
			 		custSubsDetails(Id); // method for customer to view all the subscribed details
			 		break;
			 	case 5:
			 		unSubs(Id); // method for customer to unsubscribe to any of the plan
			 		break;
			 	case 6:
			 		changePlan(Id); // method for customer to change their subscribed plan
			 		break;
			 	case 7:
			 		mainMenu(); // go back to main menu
			 		break;
			 		
			 	default:
					System.out.println("Invalid Input!");
					
		}
		customerMenu(Id); //go back to customer page after performing tasks
		

	}
	
	//====================================Customer Registration=======================================
	
	public void UserRegistration(){
			
		String[] cust = customerInput();//return values keyed in by user
					
		String id=  String.valueOf(Tester.getRandomIntegerBetweenRange(1,1000));// generate random id number
			
		Customer c= new Customer(id,cust[0],cust[1],cust[2],cust[3]);// create new customer object
			
		System.out.println("Register successfully !!! ");
		System.out.println("Your registerID is " + id);
		System.out.println("Please set a password to your account.\n");
					
		password(c);// go to password setting page			
	}
	
	//=====================================random number generator====================================
	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;// generate random number
	    return x;
	}
	
	//=========================================User Login============================================
	
	public void login(){ // method for login
		
		sc.nextLine();
		ArrayList<Login> loglist=new ArrayList<Login>();
		loglist = daol.fetchLogin(); // fetch id and password from login table

		System.out.println("Enter Your Registration ID: ");
		String id = String.valueOf(sc.nextLine());
		boolean invalid = true;
		for(Login l:loglist) {
			if(id.equals(l.getLogId())) { // check if entered id is matched with one of the id in login table
				do {
					System.out.println("\nEnter Your Password: ");
					String password = sc.nextLine();
					if(password.equals(l.getPassword())) {// check if entered password is matching or not
						if(l.getLogId().equals("Manager")) { // if id is manager, go to manager page
							System.out.println("\nYou have logged in as Relationship Manager");
							managerMenu();
							invalid = false;
						}
						else if(l.getLogId().equals("Admin")) {// if id is admin, go to admin page
							System.out.println("\nYou have logged in as Admin");
							adminMenu();
							invalid = false;
						}
						else if(l.getLogId().equals("Operator")) {// if id is operator, go to operator page
							System.out.println("\nYou have logged in as Company Operator");
							removeCust();
							invalid = false;
						}
						else {
							customerMenu(id);// go to customer page
							invalid = false;
						}
						
					}else {
						System.out.println("Invalid password! ");
					}
				}while(invalid);// if password is invalid, ask user to re-enter password 
			}
		}
		System.out.println("No user id found. Register first.");
		//if no user id found, go back to main menu
		
	}
	
	
	//=====================================Enter password============================================
	
	public void password(Customer c){ // method to set user password
		String pwd,pwd1;
		int i=1;
		
		// ask user to enter password and confirm it. loop until password matched
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
		
		Login l = new Login(c.getRegId(),pwd); // create new login object
		daol.addLogin(l); // add login data into login table
		daoc.addCustomer(c); // add customer data into customer table
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
		
		ArrayList<Customer> list=new ArrayList<Customer>();// fetch customer details from db
		list=daoc.fetchCustomer(Id);
		
		if(list.isEmpty()) {// check if the id contain data in the database or not
			System.out.println("There's no Id " + Id + " in the database");
		}
		else {
			for(Customer c : list)
			{
				System.out.println("\nID:"+c.getRegId()+"\n"+ "Name:"+c.getName()+"\n"+"Address:"+ c.getAddress()+"\n"+"Email ID:"+ c.getEmail()+"\n"+"Contact Number:"+c.getContactNo());
			}
		}
	}
	
	//=========================================Customer Subscription Details=================================================
	
		public void custSubsDetails(String Id) {
			
			ArrayList<Plan> slist=new ArrayList<Plan>();
			slist = daos.fetchSubsById(Id);
			if(slist.isEmpty()) {
				System.out.println("There's no Id " + Id + " in the database");
			}
			else {
				System.out.println("\n------Current Subscribed Plan------");
				for(Plan p : slist)
				{
					 System.out.println("\nPlan ID: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif: "+p.getTariff()+"\n"+"Validity: "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n"); 
					 System.out.println("-----------------------------------");
				}
			}
		
		}
		
		//===================================================Unsub Plan==========================================================
		
		public void unSubs(String Id) {
			
			int ans;
			System.out.println("List of plan that you currently subscribed in Dispur Wireless:");
			custSubsDetails(Id);// call method to view current subscribed list
			
			do {
				System.out.println("Do you really want to continue unsubscribe your current plan?");
				System.out.print("1-Yes || 2-No : ");
				ans = sc.nextInt();
				switch (ans){
					case 1:
						System.out.println("Enter Plan Id that you want to cancel subscription");
						int pln = sc.nextInt();
						daos.delPlan(Id,pln);
						break;
					case 2:
						return;
					default:
						System.out.println("Invalid Input!");
				}
				
			}while(ans != 1 & ans != 2);
			
		}
		
		//========================================Customer Update Their Details=======================================
		
		public void updateCustDetails(String Id) {
			
			String[] cust = customerInput();// call customer input method
			daoc.updateCustDetails(Id, cust[0], cust[1], cust[2], cust[3]);// assign returned data to the database
			return;
			
		}
	
		//=========================================Customer Subscribe to a plan=======================================
		
	public void subscribe(String Id) {
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan(); // fetch list of plan from the database
		boolean sel = true;
		do {	
			
			System.out.println("Enter plan id to view details and subscribe");
			System.out.print("Plan Id: ");
			int planId = sc.nextInt();
			for(Plan p : list)
			{
				 if(planId == p.getPlanId()) {
					 // display details of selected plan
					 System.out.println("Plan Id: "+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+"\n"+"Validity: "+p.getValidity()+"\n");
					 System.out.println("Amount is RM "+p.getTariff() + "/min");// display tariff
					 System.out.println("Proceed with Subscription?");
					 System.out.println("1.Yes"+"\n"+"2.No");
					 int select = sc.nextInt();
					 if(select == 1) {
						 sel = false;
						 Subscribe sub = new Subscribe(Tester.getRandomIntegerBetweenRange(1,100),Id,planId,Tester.getRandomIntegerBetweenRange(1,10));
						 daos.addSubs(sub);
						 break;
					 }else if(select == 2) {
						 System.out.println("\nCancel subscription");
						 sel = false;
						 break;
					 }else {
						 System.out.println("\nInvalid input");
					 }
					 
				 }
			}
			
		}while(sel);
		
		customerMenu(Id);// return to customer menu
		
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
		 		daos.changeSubs(Id, current, changedId);// pass customer id, current plan id, and changed plan id
		 		return;
		 	case 2:
		 		System.out.println("Changing plan cancelled ");
		 		return;// return to customer menu
		 	default:
				System.out.println("Invalid Input!");
			}
		
		}while(ans != 1 & ans!=2);
		
	}
	
	
	//=================================================Admin Add New Plan=====================================================
	
	public void addPlan() {
		
		System.out.println("Enter Plan Details: ");
		
		String[] plan = adminPlanInput();//call method for taking input from admin
		int Id = Tester.getRandomIntegerBetweenRange(1, 100);// generate random number
		
		// create new object called plan
		Plan pln = new Plan(Id,plan[0],plan[1],Double.parseDouble(plan[2]),Integer.parseInt(plan[3]),plan[4]);
		daop.addPlan(pln);// pass plan object to database
		adminMenu();// go back to admin menu
		
	}
	
	//==============================================Admin Update Plan Details=================================================
	
	public void updatePlan(int Id) {
		
		String[] plan = adminPlanInput();// method to call admin input
		//pass received input from admit to the database
		daop.updatePlan(Id, plan[0], plan[1], Double.parseDouble(plan[2]), Integer.parseInt(plan[3]), plan[4]);
		adminMenu(); // return to admin menu
		
	}
	
	//==============================================Admin Remove Plan========================================================
	
	public void removePlan() {
		
		System.out.print("Insert Plan id you want to delete: ");
		int pid =sc.nextInt();// accept id that wanted to delete
		daop.deletePlan(pid);// delete the table content with that id from the database
		adminMenu();// return to admin menu
		
	}
	
	//==============================================Operator Remove Customer======================================================
	
	public void removeCust() {
		
		System.out.println("Insert Customer id you want to delete: ");
		String id =sc.nextLine();		
		custDetails(id); // view customer details
		int ans;
		do {
			System.out.println("Proceed deleting this customer?");
			System.out.println("1-Yes | 2-No");
			ans = sc.nextInt();
			switch(ans) {
				case 1:
					daoc.delCustomer(id); // delete from table customer
					break;
				case 2:
					System.out.println("Action cancelled");
					break;
				default:
					System.out.println("Invalid input!");

			}
			
		}while(ans != 1 & ans !=2);
		
		mainMenu();// back to main menu
		
	}

	
	//============================================Method to view plan list==================================================
	
	public void planList(){
		
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();// fetch all data from plan table
		System.out.println("\n=================List of Plan available in Dispur Wireless==================");
		for(Plan p : list)
		{
			 System.out.println("\nPlan Id: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif (Rate/min): "+p.getTariff()+"/1"+"\n"+"Validity (in days): "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n");
			 System.out.println("-----------------------------");
		}
		
	}
	
	//===========================Method for accepting Customer registration and Update input===========================
	
	public String[] customerInput() {
		
		String[] cust = new String[4];
		
		sc.nextLine();
		System.out.println("====== Enter Your Details ======");
		
		System.out.print("Name: ");// get customer name
		String name= sc.nextLine();
		cust[0] = name;
		
		System.out.print("Address: "); // get customer address
		String address= sc.nextLine();
		cust[1] = address;
		
		System.out.print("Email: "); // get customer email
		String email= sc.nextLine();
		cust[2] = email;
		
		System.out.print("Contact Number: "); //get contact number
		String contactNum= sc.nextLine();
		cust[3] = contactNum;
		
		return cust;
		
	}
	
	//==================================Method for accepting Admin Add and Update Plan===============================
	
	public String[] adminPlanInput() {
		
		String[] pln = new String[5];
		System.out.println("====== Enter Plan Details ======");
		
		sc.nextLine();
		System.out.print("Name: "); // get plan name
		String plnName= sc.nextLine();
		pln[0] = plnName;
		
		System.out.print("Type (Data/Voice): "); // get plan type
		String type= sc.nextLine();
		pln[1] = type;
		
		System.out.print("Tariff (Rate/min): "); // get plan tariff
		String tariff= String.valueOf(sc.nextDouble());
		pln[2] = tariff;
			
		System.out.print("Validity (Days): "); // get plan validity
		String validity= String.valueOf(sc.nextInt());
		pln[3] = validity;
		
		sc.nextLine();
		System.out.print("Rental (Yes/No): "); // get plan rental
		String rental= sc.nextLine();
		pln[4] = rental;
		
		return pln;
		
	}

}