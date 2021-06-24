package com.tcs.group1.tester;
import java.util.ArrayList;
import java.util.Scanner;
import com.tcs.group1.bean.Customer;
import com.tcs.group1.bean.Login;
import com.tcs.group1.bean.Plan;
import com.tcs.group1.dao.CustomerDAO;
import com.tcs.group1.dao.LoginDAO;
import com.tcs.group1.dao.PlanDAO;

public class Tester {
	
	Customer customer = new Customer();
	Login login = new Login();
	CustomerDAO daoc = new CustomerDAO();
	PlanDAO daop = new PlanDAO();
	LoginDAO daol = new LoginDAO(); 
	
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
		System.out.println("=============================================== ");
		System.out.println("Welcome to Dispur Wireless System");
		System.out.println("1.Customer Management Portal");
		System.out.println("2.Tariff Plan Management Portal");
		System.out.println("3.Exit");
		System.out.println("=============================================== ");
		
		System.out.print("Please make a selection: ");
		selection =sc.nextInt();
	
		 switch (selection){
		 	case 1:
		 		customerMenu();
		 		break;
		 	case 2:
		 		planMenu();
		 		break;
		 	case 3:
		 		System.out.print("Thank you for using our system");
		 		break;
		 		
		 	default:
				System.out.println("Invalid Input!");
		 }
		
	}
	
	//================================Customer Management Portal======================================
	
	public void customerMenu()
	{
		Scanner sc = new Scanner(System.in);
		int selection;
		System.out.println("=============================================== ");
		System.out.println("|             1.Register customer              |");
		System.out.println("|             2.Login                          | ");
		System.out.println("|             3.Exit                           | ");
		System.out.println("|             4.Manager                        | ");
		System.out.println("=============================================== ");
			
			System.out.print("Please make a selection: ");
			selection =sc.nextInt();
		
			 switch (selection){
			 	case 1:
			 		UserRegistration();
			 		break;
			 	case 2:
			 		login();
			 		break;
			 	case 3:
			 		mainMenu();
			 		break;
			 	case 4:
			 		custDetails();
			 		break;
			 		
			 	default:
					System.out.println("Invalid Input!");
		}

	}
	
	//================================Tariff Plan Management Portal======================================
	
		public void planMenu()
		{ 
			Scanner sc = new Scanner(System.in);
			int selection;
			boolean loginStatus = true;
			System.out.println("=============================================== ");
			System.out.println("|             1.Portal             			   |");
			System.out.println("|             2.Login                          | ");
			System.out.println("|             3.Exit                           | ");
			System.out.println("=============================================== ");
				
				
				System.out.print("Please make a selection: ");
				selection =sc.nextInt();
			
				 switch (selection){
				 	case 1:
				 		portalView(loginStatus);
				 		break;
				 	case 2:
				 		login();
				 		break;
				 	case 3:
				 		mainMenu();
				 		break;
				 		
				 	default:
						System.out.println("Invalid Input!");
				 }

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
			customerMenu();
			
		}
	
	//=====================================random number generator====================================
	
	public static int getRandomIntegerBetweenRange(int min, int max){
	    int x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	//=========================================User Login============================================
	
	public void login(){
		
		System.out.println("====== Enter Your Registration ID and Password ======");
		
		
	}
	
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
	
	public void portalView(boolean status) {
		Scanner sc = new Scanner(System.in);
		System.out.println("List of plan available in Dispur Wireless:");
		ArrayList<Plan> list=new ArrayList<Plan>();
		list=daop.fetchPlan();
		 for(Plan p : list)
		 {
			 System.out.println("Plan Id: "+p.getPlanId()+"\n"+"Plan Name: "+p.getPlanName()+"\n"+"Plan Type: "+p.getPlanType()+" \n"+ "Tarrif: "+p.getTariff()+"\n"+"Validity: "+p.getValidity()+"\n"+"Rental: "+p.getRental()+"\n\n");
		 }
		 if(status) {
			 System.out.println("Do you want to subscribe to a plan?");
			 System.out.println("1-Yes || 2-No : ");
			 int ans = sc.nextInt();
			 
			 switch (ans){
			 	case 1:
			 		subscribe();
			 		break;
			 	case 2:
			 		planMenu();
			 		break;
			 	default:
					System.out.println("Invalid Input!");
			 }
			 
		 }
		
	}
	
	public void custDetails() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> list=new ArrayList<Customer>();
		System.out.print("Enter number id:");
		String Id = String.valueOf(sc.nextInt());
		list=daoc.fetchCustomer(Id);
		for(Customer c : list)
		{
			System.out.println("ID:"+c.getRegId()+"\n"+ "Name:"+c.getName()+"\n"+"Address:"+ c.getAddress()+"\n"+"Email ID:"+ c.getEmail()+"\n"+"Contact Number:"+c.getContactNo());
		}
		
	}
	
	public void subscribe() {
		
		System.out.println("Enter plan id to view details and subscribe");
		System.out.print("Plan Id: ");
		
//		do {
//			
//			int chId = sc.nextInt();
//			
//		}while(chId);
		
	}
	
}