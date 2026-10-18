package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DTO.Employee;
import com.connection.*;
import com.DTO.*;

public class MethodImplementation implements Methods{
	Connection con = null;
	Scanner sc = null;
	
	@Override
	// All details of the emp
	public List<Employee> getemp() {
		
		ArrayList<Employee> a1 = new ArrayList<>();
		try {
			con = ConnectionClass.requestConnection();
			String q = "SELECT * FROM employee";
			Statement stmt =con.createStatement();
			ResultSet res = stmt.executeQuery(q);
			
			
			while(res.next()) {
			int id = res.getInt("eid");
			String name = res.getString("ename");
			int phnum  = res.getInt("eph");
			Employee e = new Employee(id,name,phnum);
			a1.add(e);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return a1;
	}

	@Override
	public Employee getid(int eid) {
		Employee e = null;
		try {
			con = ConnectionClass.requestConnection();
			sc = new Scanner(System.in);
			System.out.println("Enter the id to get the details:");
			int idd = sc.nextInt();
			String q = "SELECT * FROM employee WHERE eid = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1,idd);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				int phnum = res.getInt(3);
				e = new Employee(id,name,phnum);
			}
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		System.out.println(e);
		return e;
	}

	@Override
	public boolean insert(int eid, String ename, int eph) {
		
		try {
			con = ConnectionClass.requestConnection();
			sc = new Scanner(System.in);
			String q = "INSERT INTO employee(`eid`,`ename`,`eph`) values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(q);
			
			System.out.println("Enter the size you want to insert");
			int size = sc.nextInt();
			for(int i =1;i <= size;i++) {
				System.out.println("enter the eid:");
				int id = sc.nextInt();
				pstmt.setInt(1, id);
				System.out.println("Enter the name:");
				String name = sc.next();
				pstmt.setString(2, name);
				System.out.println("Enter the phnum:");
				int ph = sc.nextInt();
				pstmt.setInt(3, ph);
				pstmt.addBatch();
			}
					pstmt.executeBatch();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Employee e) {
		
		try {
			con = ConnectionClass.requestConnection();
			String q = "UPDATE employee SET ename = ? WHERE eid = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			System.out.println("Enter the name you want to update:");
			String name = sc.next();
			pstmt.setString(1, name);
			System.out.println("Enter the id:");
			int id = sc.nextInt();
			pstmt.setInt(2, id);
			pstmt.execute();
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		finally {
			
		}
		return false;
	}

	@Override
	public boolean delete(int eid) {
		try {
			sc = new Scanner(System.in);
			con = ConnectionClass.requestConnection();
			String q = "DELETE FROM employee WHERE eid = ?";
			PreparedStatement pstmt = con.prepareStatement(q);
			System.out.println("Enter the id want to delete:");
			int num = sc.nextInt();
			pstmt.setInt(1, num);
			pstmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
