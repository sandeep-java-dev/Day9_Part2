package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Courses;

public class DatabaseConnectionClass {

	Connection con; // holds connection in between java & database
	PreparedStatement ps; // executes SQL queies

	
	public DatabaseConnectionClass() throws SQLException, ClassNotFoundException {
		String path = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "user1";
		String password = "user1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(path, username, password);
		System.out.println(" Connection Establish ----->> " + con);
	}
	
	// insert,delete,update 
	// use executeUpdate();
	public boolean doInsertCourse(String courseName,String category,int duration,int tests)throws SQLException
	{
		
		String query = "insert into COURSES values(?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, courseName);
		ps.setString(2, category);
		ps.setInt(3, duration);
		ps.setInt(4, tests);
		
		int i = ps.executeUpdate();
		if(i >0) return true;
		else return false;
	}
	
	// only for select statement use executeQuery
	public List<Courses> getAllCourses()throws SQLException
	{
		String sql = "select * from Courses";// 
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<Courses> list = new ArrayList<>(); // empty list
		
		while(rs.next())
		{
			String courseName = rs.getString("COURSENAME");
			String category = rs.getString("CATEGORY");
			int duration = rs.getInt("DURATION");
			int numberOfTests = rs.getInt("TESTINCLUDE");
			
			list.add(new Courses(courseName, category, duration, numberOfTests));
			
			
		}	//end of rs	
		return list;
	}
	
	
	public void transactionCode()throws SQLException
	{
		
		
		try {
		
			con.setAutoCommit(false); // JDBC -> do not commit by own
			
			String query = "insert into COURSES values(?,?,?,?)";
			ps = con.prepareStatement(query);
			
			int i = ps.executeUpdate();
			
			String query2 = "insert into OnlineClasses values(?,?,?,?)";
			ps = con.prepareStatement(query);
			int i2 = ps.executeUpdate();
			
			con.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
		}
		
	}
	
	
	
	public List<Courses> getCourseByDurationAndCategory(int duration,String category)throws SQLException
	{
		//String sql = "select * from courses where category like '"+category+"' and duration = "+duration;
		String sql = "select * from courses where category like ? and duration = ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, category);
		ps.setInt(2, duration);
		
		
		ResultSet rs = ps.executeQuery();
		List<Courses> list = new ArrayList<>(); // empty list
		
		while(rs.next())
		{
			String courseName = rs.getString("COURSENAME");
			String category2 = rs.getString("CATEGORY");
			int duration2 = rs.getInt("DURATION");
			int numberOfTests = rs.getInt("TESTINCLUDE");
			
			list.add(new Courses(courseName, category2, duration2, numberOfTests));
			
			
		}	//end of rs	
		return list;
	}

	public static void main(String[] args) {
		
		try {
			DatabaseConnectionClass obj = new DatabaseConnectionClass();
			
			   boolean result =  obj.doInsertCourse("AI","Technical",50,3);
			   System.out.println(result);
			 
			//List<Courses> courses = obj.getAllCourses();
			
			//List<Courses> courses = obj.getCourseByDurationAndCategory(40,"Technical");
			
			/*
			 * for (Courses course : courses) { System.out.println(course); }
			 */
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
}
