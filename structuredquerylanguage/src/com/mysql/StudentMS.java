package com.mysql;
import java.sql.*;
import java.util.Scanner;
public class StudentMS {

	public static void main(String[] args) {
		int choice =0;
		while(choice!=8008)
		{
     System.out.println("Welcome to SMS(Student Management System)");
     System.out.println("Please Authenticate System:");
     System.out.print("Enter choice : \n 1: login \n 2: signup \n 3: Exit \n");
     int menu =0;
     Scanner sc = new Scanner(System.in);
     menu = sc.nextInt();
     switch(menu)
     {
     case 1:
    boolean result = login();
    if(result)
    {
        System.out.println("Login success");
    }
    else
    {
    	System.out.println("wrong creditials or not record found.");
    }
    	 break;
     case 2:
    	 signup();
    	 break;
     case 3:
    	 choice = 8008;
    	 break;
     }
	}	
     
} 
//login method
	
 static boolean login()
{
	boolean loginSuccess = false;
	String id1="",pass="";
	String id="",password="";
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter ID:");
	id = sc.nextLine();
	System.out.print("Enter password:");
	password = sc.nextLine();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jbdc:mysql://localhost:3306/dbjoin","root","root");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select *from login");
	while(rs.next()) {
		id1 = rs.getString(1);
		pass = rs.getString(2);
	}
	if(id.equals(id1)&& password.equals(pass))
		loginSuccess = true;
	else
		loginSuccess=false;
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return loginSuccess;
	}
 // signup method
 static void signup()
 {
	 int loop=0;
	 int code=0;
	 String id="",password="",name="";
	 while(loop!=8008) {
		 Scanner sc =  new Scanner(System.in);
	     System.out.print("signup: Two-step verification: \n");
	     code=sc.nextInt();
	     if(code==8008) {
	    	 Scanner data=new Scanner(System.in);
	    	 System.out.print("Enter ID:");
	    	 id = data.nextLine();
	    	 System.out.print("Enter password:");
	    	 password = data.nextLine();
	    	 System.out.print("Enter Name:");
	    	 name = data.nextLine();
	    	 try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con=DriverManager.getConnection("jbdc:mysql://localhost:3306/dbjoin","root","root");
	    	String query = "insert into signup(id,password,name)"+"values(?,?,?)";
	    	String query1 = "insert into login(id,password)"+" values(?,?)";
	        PreparedStatement ps = con.prepareStatement(query);
	        PreparedStatement ps1 = con.prepareStatement(query1);
	        ps.setString(1,id);
	        ps.setString(2,password);
	        ps.setString(3,name);
	        ps.addBatch();
	        ps.close();
	        ps1.setString(1, id);
	        ps1.setString(2,password);
	        ps1.addBatch();
	        ps1.close();
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 
	    	 }
	     }
	     }
  }
 }