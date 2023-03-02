package com.aegisisc.pvt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDrivenCollectionStudent {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=null;
        con=DriverManager.getConnection("jdbc:mysql://localhost/db1", "root", "root");
        System.out.println("Database connection granted");
        Statement stmt=con.createStatement();
    	String sql= "create table Student " +
                "(s_RollNo integer not null, " +
  		        "s_Name varchar(255)," +
                  "s_ContactNo varchar(255)," +
  		        "s_EmailId varchar(255)," +
                  "s_Standard varchar(255)," +
                  "primary key (s_RollNo))";
         stmt.executeUpdate(sql);
        System.out.println("table created in db1 database");
        int s_RollNo;
        String s_Name;
        String s_ContactNo;
        String s_EmailId;
        String s_Standard;
    	while(true)
        {
     	   System.out.println("1.Add");
     	   System.out.println("2.display details");
     	   System.out.println("3.update details");
     	   System.out.println("4.delete details");
     	   System.out.println("5.Exit");
 		   List<Student> li=new ArrayList<>();

     	   System.out.println("Enter your choice::");
     	   Scanner s=new Scanner(System.in);
     	   int choice =s.nextInt();
     	   switch(choice)
     	   {
     	   		case 1:
     	   			String c=" ";
     		          do
     		          {
      		        	 String sqladd="insert into Student(s_RollNo,s_Name,s_ContactNo,s_EmailId,s_Standard) values(?,?,?,?,?)";
      		        	 PreparedStatement ps=con.prepareStatement(sqladd);
      		        	 Scanner s1=new Scanner(System.in);
      		     	   	 System.out.println("Enter RollNumber");
      		     	   	 int roll=s1.nextInt();  
      		     	   	 System.out.println("Enter Name");
      		     	   	 String name=s1.next(); 
      		     	     System.out.println("Enter Contact Number");
      		    	   	 String cn=s1.next(); 
      		    	   	 System.out.println("Enter EmailId");
      		    	   	 String email=s1.next();
      		    	     System.out.println("Enter standard");
      		    	     String std=s1.next();
      		    	     ps.setInt(1, roll);
      	     	   	     ps.setString(2, name);
      	     	         ps.setString(3, cn);
      	    	   	     ps.setString(4, email);
      	    	   	     ps.setString(5, std);
      		        	 ps.executeUpdate();
      		        	 System.out.println("Record Added");
      		        	 System.out.println("Do your want to continue  enter Y/N");
      		        	 c=s1.nextLine();
     		        	  
     		          }while(c.equalsIgnoreCase("Y"));
     		       break;
     	   		case 2:
     	   		PreparedStatement prestmt1=con.prepareStatement("select * from Student");
       			ResultSet rs = prestmt1.executeQuery();
       			while(rs.next())
       			{
       				Student l = new Student();
       				l.setS_RollNo(rs.getInt("s_RollNo"));
       				l.setS_Name(rs.getString("s_Name"));
       				l.setS_ContactNo(rs.getString("s_ContactNo"));
       				l.setS_EmailId(rs.getString("s_EmailId"));
       				l.setS_Standard(rs.getString("s_Standard"));
       				li.add(l);
       			}
       			for(Student lt : li)
       			{
       				System.out.println("s_RollNo: "+lt.getS_RollNo());
       				System.out.println("s_name : "+lt.getS_Name());
       				System.out.println("s_contactNo: "+lt.getS_ContactNo());
       				System.out.println("s_EmailId: "+lt.getS_EmailId());
       				System.out.println("s_Standard: "+lt.getS_Standard());
       			}
       			break;
     	   	case 3:
     	   		   break;
     	   	case 4:
     	   			break;
     	   	case 5:
     	   			System.exit(0);
  
     	   }
        }
	}

}
