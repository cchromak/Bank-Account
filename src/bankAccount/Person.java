package bankAccount;


import java.util.InputMismatchException;
import java.util.Scanner;
public class Person {

	private String firstname,lastname,address,DOB;
	private int SSN;

	public Person() {
		firstname = "No name";
		lastname = " no name";
		address = "No household data";
		SSN = 0;
		DOB = "mm/dd/yyy";
	}
	public Person(String f,String l,String a,int s) {

		firstname = f;
		lastname = l;
		address = a;
		SSN = s;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public String toString() {
		String str = " First Name & Last Name: "+ firstname  + ", "  +lastname+ "\n"+" Social Security: "+SSN+"\n"    +  " Address: "+address;
		return str;
	}
	public void read(Scanner kb){
		boolean done = false;
		do {
			try {
				System.out.print("Enter First name: ");
				firstname=kb.nextLine();
				System.out.print("Enter Last name: ");
				lastname=kb.nextLine();
				System.out.print("Enter Address: ");
				address=kb.nextLine();
				System.out.print("Enter SSN: ");
				SSN=kb.nextInt();
				done = true;
			}catch(InputMismatchException e) {
				System.out.println("Sorry Please re-enter integers only.");
				done = false;
			}
			done = true;
		}while(done == false);
	
	}


}