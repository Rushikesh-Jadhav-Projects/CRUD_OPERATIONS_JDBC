package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class CRUD {
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
	System.out.println("1 ----enter for insert the data ");
	System.out.println("2-----enter for update the data");
	System.out.println("3-----enter for delete the data");
	System.out.println("4-----enter for serch the data");
	System.out.println("5-----enter for end the program");
	int choice;
	do{System.out.println("please enter your choice");
	 choice=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rushikesh","root","root");
	switch(choice) {
	case 1:
		System.out.println("please enter your id : ");
		int empid=sc.nextInt();
		System.out.println("please ente your empname");
		String empname=sc.next();
		System.out.println("enter your designation");
		String designation=sc.next();
		PreparedStatement ps=con.prepareStatement("insert into employee(EmpID,EmpName,Designation)values(?,?,?) ");
	ps.setInt(1, empid);
	ps.setString(2, empname);
	ps.setString(3,designation );
	ps.execute();
	System.out.println("inserted succesfully");
	break;
	case 2:PreparedStatement ps2=con.prepareStatement("update employee set EmpName=?,Designation=?   where EmpId=? ");
	System.out.println("please enter your id which you want to update ");
	int empid1=sc.nextInt();
	System.out.println("please ente  empname which update");
	String empname1=sc.next();
	System.out.println("enter your designation which you want to update");
	String designation1=sc.next();
	ps2.setInt(3, empid1);
	ps2.setString(1, empname1);
	ps2.setString(2, designation1);
	ps2.execute();
	System.out.println("succesfully updated");
		break;
	case 3:
		PreparedStatement ps22=con.prepareStatement("delete from  employee  where EmpId=? ");
		System.out.println("please enter your id which you want to delete ");
		int empid11=sc.nextInt();
		ps22.setInt(1, empid11);
		ps22.execute();
		System.out.println("succesfully deleted");
		
		break;
	case 4:
		System.out.println("enter the id for search");
		int id=sc.nextInt();
		PreparedStatement ps1=con.prepareStatement("select * from employee where EmpID=? ");
	ps1.setInt(1, id);
	ResultSet rs1=ps1.executeQuery();
	 while(rs1.next()) {
		
			System.out.print(rs1.getInt(1)+" ");
			System.out.print(rs1.getString(2)+" ");
			System.out.print(rs1.getString(3)+" ");		
		}

	 break;
	case 5:System.out.println("program is ended");
	System.exit(0);
	break;
	}
	}while(choice!=5);
}}
