package com;
import java.sql.*;
import java.util.*;
class emp{
	Connection con;
	PreparedStatement st;
	emp(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Rgukt@123");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void insertion() {
		try {
			st=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.print("Id:");
			int id=sc.nextInt();
			System.out.print("Name:");
			String name=sc.next();
			System.out.print("age:");
			int age=sc.nextInt();
			System.out.print("salary:");
			int salary=sc.nextInt();
			System.out.print("designation:");
			String desig=sc.next();
			
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, age);
			st.setInt(4, salary);
			st.setString(5, desig);
			System.out.println("Data inserted successfull...");
			st.execute();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void list() {
		System.out.println("1)insertion");
		System.out.println("2)Fetching");
		System.out.println("3)update");
		System.out.println("4)deletion");
		System.out.println("5)exit");
		System.out.print("select an option:");
	}
	void display() {
		try {
			System.out.println("***fetching the entire data***");
			ResultSet r=st.executeQuery("select* from emp");
			while(r.next()) {
				System.out.println("Id:"+r.getInt(1)+"\nName:"+r.getString(2)+"\nage:"+r.getInt(3)+"\nSalary:"+r.getInt(4)+"\nDesignation"+r.getString(5));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void update() {
		try {
			st=con.prepareStatement("update emp set desig=? where id=?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id to update designation:");
			int id2=sc.nextInt();
			System.out.println("Enter designation to update:");
			String desig2=sc.next();
			st.setString(1, desig2);
			st.setInt(2,id2);
			st.execute();
			System.out.println("Table updated successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void deletion() {
		try {
		Scanner sc=new Scanner(System.in);
		st=con.prepareStatement("delete from emp where id=?");
		System.out.println("enter id to delete:");
		int id2=sc.nextInt();
		st.setInt(1,id2);
		st.execute();
		System.out.println("Data deleted successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
public class Jdb {
	public static void main(String[] args) {
	emp e=new emp();
	
	
	System.out.println("1)insertion");
	System.out.println("2)Fetching");
	System.out.println("3)update");
	System.out.println("4)deletion");
	System.out.println("5)exit");
	System.out.println("select an option:");
	Scanner sc=new Scanner(System.in);
	while(true) {
		int n=sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("***Inserting Data***");
			e.insertion();
			e.list();
			break;
		case 2:
			System.out.println("***Displaying Data***");
			e.display();
			e.list();
			break;
		case 3:
			System.out.println("***Updating Data***");
			e.update();
			e.list();
			break;
		case 4:
			System.out.println("***Deleting the data***");
			e.deletion();
			e.list();
			break;
		case 5:
			System.out.println("***Exiting...***");
			System.out.println("If you really want to exit enter 0 otherwise enter 1 to continue:");
			int ch=sc.nextInt();
			if(ch==0) {
				System.out.print("You have choosen to Exit...Thank you....!");
				System.exit(0);
				break;
			}
			if(ch==1) {
				e.list();
				break;
			}
			break;
		}	
	}
	}

}

