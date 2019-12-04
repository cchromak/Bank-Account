package bankAccount;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Bank extends BankAccount {

	
	private ArrayList<BankAccount> AccountList = new ArrayList<>();

	public Bank(){

	}
	
	public ArrayList<BankAccount> getAccountList() {
		return AccountList;
	}
	public void setAccountList(ArrayList<BankAccount> accountList) {
		AccountList = accountList;
	}
	
	public void menu(BankAccount B) {
		boolean a = false;
		B = new BankAccount();
		do {	
			try {

				Scanner kb1 = new Scanner(System.in);
				System.out.println(" _________________________________");
				System.out.println("|                                 |");
				System.out.println("|    Hi, welcome to your bank!    |");
				System.out.println("| What would you like to do today?|");
				System.out.println("|_________________________________|");
				System.out.println("|                                 |");
				System.out.println("|	(1)  Create account"+"  	  |");
				System.out.println("|	(2)  Display account"+" 	  |");
				System.out.println("|	(3)  Modify account"+"   	  |");
				System.out.println("|	(4)  Delete account"+"   	  |");
				System.out.print("|_________________________________|");
				System.out.println(" ");
				menuErrors(); 
				int m = kb1.nextInt();
				switch(m) {
				case 1:
					System.out.println("This will only take a few moments:");
					CreateAccount();
					errors();
					break;
				case 2:
					display();
					System.out.println("Press any number to go back ");
					errors();
					break;
				case 3:
					modify();
					errors();
					break;
				case 4:
					System.out.println("Are you sure you want to delete your account?");
					DeleteAccount(B);
					errors();
					break;
				default: 
					System.out.println("Thank you for using this menu");
					break;
				}
			}catch(NoSuchElementException e){
				System.out.println("WRONG");
			}}while(a==false);
	}
	public void CreateAccount() {
		Scanner kb = new Scanner(System.in);

		BankAccount b = new BankAccount();
		addholder(b);
		b.readBalance(kb);

		AccountList.add(b);
		System.out.println("Thank you for creating an account with us!");
		System.out.println("Your account number is " + b.getAccountNumber());
		System.out.println("Press any number to return to the main menu");
	}

	public void modify() {
		BankAccount b = new BankAccount();
		Scanner kb1 = new Scanner(System.in);
		System.out.println("Enter your account number ");
		int kb = kb1.nextInt();
		kb1.nextLine();
		for(int j = 0;j<AccountList.size();j++) {
			if(AccountList.get(j).getAccountNumber()==kb) {
				try {
					System.out.println("(1) - Withdraw");
					System.out.println("(2) - Deposit ");
					System.out.println("(3) - Set Intrest_rate");
					System.out.println("(Any number) - Go Back");
					int i =kb1.nextInt();
					int w = kb1.nextInt();
					kb1.nextLine();
					switch(i) {
					case(1): 
						AccountList.get(j).withdraw(w);
					break;
					case(2):
						AccountList.get(j).depoist(w);
					break;
					case(3):
						AccountList.get(j).payintrest(w);
					break;
					default:
						menu(b);
						break;
					}
				}catch(NoSuchElementException e) {
					System.out.println("");
					modify();
				}
			}

		}
	}
	public void DeleteAccount(BankAccount B) {
		Scanner kb1 = new Scanner(System.in); 
		int kb = kb1.nextInt();
		for(int j = 0;j<AccountList.size();j++){
			if(AccountList.get(j).getAccountNumber()==kb) {
				AccountList.remove(j).getAccountNumber();
				AccountList.remove(B);
			}
		}
	}
	public void display() {
		if(AccountList.size()<=5) {
			System.out.println("Displaying your account: \n "+ AccountList.toString());
		}else {
			System.out.println("Memory full");
		}
	}
	public String toString() {
		String str =" "+ AccountList.toString();
		return str;
	}
	public void errors() {
		boolean done = false;
		do {
			try {
				Scanner kb = new Scanner(System.in);
				int x = kb.nextInt();
				done = true;
			}catch(InputMismatchException e) {
				System.out.println("Sorry, I didnt get that please re-enter integers: ");
				done = false;

			}	
		}while(done == false);
	}
	public void menuErrors() {
		boolean done = false;
		do {
			try {	
				done = true;
			}catch(InputMismatchException e) {
				System.out.println("Sorry, I didnt get that please re-enter integers: ");
				done = false;
			}	
		}while(done == false);
	}


}