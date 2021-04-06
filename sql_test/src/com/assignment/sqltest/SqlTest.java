package com.assignment.sqltest;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class SqlTest {
	
	public static void main(String[] args) throws SQLException{
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("SQL Programming Test");
			System.out.println("Connecting PostgreSQL database");
			
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "postgres";
			String password="nomorewaiting75";
			
			Connection connection=DriverManager.getConnection(url, user, password);
			
			if(connection!=null) {
				System.out.println("연결 성공");
			}
			else {
				System.out.println("연결 실패");
			}
			
			System.out.println("Creating College, Student, Apply relations");
			// 3개 테이블 생성: Create table문 이용
			Statement qry = connection.createStatement();
			qry.execute("drop table if exists College");
			qry.execute("drop table if exists Student");
			qry.execute("drop table if exists Apply");
			
			qry.execute("create table College(cName varchar(20), state char(2), enrollment int, primary key(cName));");
			qry.execute("create table Student(sID int, sName varchar(20), GPA numeric(2,1), sizeHS int, primary key(sID));");
			qry.execute("create table Apply(sID int, cName varchar(20), major varchar(20), decision char, primary key(sID, cName, major));");
			
			System.out.println("Inserting tuples to College, Student, Apply relations");
			// 3개 테이블에 튜플 생성: Insert문 이용
			String in_col="insert into College (cName, state, enrollment) values(?,?,?);";
			String in_stu="insert into Student (sID, sName, GPA, sizeHS) values(?,?,?,?);";
			String in_app="insert into Apply (sID, cName, major, decision) values(?,?,?,?);";
			PreparedStatement col = connection.prepareStatement(in_col);
			PreparedStatement stu = connection.prepareStatement(in_stu);
			PreparedStatement app = connection.prepareStatement(in_app);
			
			col.setString(1, "Stanford");
			col.setString(2, "CA");
			col.setInt(3, 15000);
			col.executeUpdate();

			col.setString(1, "Berkeley");
			col.setString(2, "CA");
			col.setInt(3, 36000);
			col.executeUpdate();
			
			col.setString(1, "MIT");
			col.setString(2, "MA");
			col.setInt(3, 10000);
			col.executeUpdate();
			
			col.setString(1, "Cornell");
			col.setString(2, "NY");
			col.setInt(3, 21000);
			col.executeUpdate();
			////////////////////////////////////////////////
			stu.setInt(1, 123);
			stu.setString(2, "Amy");
			stu.setDouble(3, 3.9);
			stu.setInt(4, 1000);
			stu.executeUpdate();
			
			stu.setInt(1, 234);
			stu.setString(2, "Bob");
			stu.setDouble(3, 3.6);
			stu.setInt(4, 1500);
			stu.executeUpdate();

			stu.setInt(1, 345);
			stu.setString(2, "Craig");
			stu.setDouble(3, 3.5);
			stu.setInt(4, 500);
			stu.executeUpdate();
			
			stu.setInt(1, 456);
			stu.setString(2, "Doris");
			stu.setDouble(3, 3.9);
			stu.setInt(4, 1000);
			stu.executeUpdate();
			
			stu.setInt(1, 567);
			stu.setString(2, "Edward");
			stu.setDouble(3, 2.9);
			stu.setInt(4, 2000);
			stu.executeUpdate();
			
			stu.setInt(1, 678);
			stu.setString(2, "Fay");
			stu.setDouble(3, 3.8);
			stu.setInt(4, 200);
			stu.executeUpdate();
			
			stu.setInt(1, 789);
			stu.setString(2, "Gary");
			stu.setDouble(3, 3.4);
			stu.setInt(4, 800);
			stu.executeUpdate();
			
			stu.setInt(1, 987);
			stu.setString(2, "Helen");
			stu.setDouble(3, 3.7);
			stu.setInt(4, 800);
			stu.executeUpdate();
			
			stu.setInt(1, 876);
			stu.setString(2, "Irene");
			stu.setDouble(3, 3.9);
			stu.setInt(4, 400);
			stu.executeUpdate();
			
			stu.setInt(1, 765);
			stu.setString(2, "Jay");
			stu.setDouble(3, 2.9);
			stu.setInt(4, 1500);
			stu.executeUpdate();
			
			stu.setInt(1, 654);
			stu.setString(2, "Amy");
			stu.setDouble(3, 3.9);
			stu.setInt(4, 1000);
			stu.executeUpdate();
			
			stu.setInt(1, 543);
			stu.setString(2, "Craig");
			stu.setDouble(3, 3.4);
			stu.setInt(4, 2000);
			stu.executeUpdate();
			
			//////////////////////////////////////////
			app.setInt(1,123);
			app.setString(2, "Stanford");
			app.setString(3, "CS");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,123);
			app.setString(2, "Stanford");
			app.setString(3, "EE");
			app.setString(4,"N");
			app.executeUpdate();
			
			app.setInt(1,123);
			app.setString(2, "Berkeley");
			app.setString(3, "CS");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,123);
			app.setString(2, "Cornell");
			app.setString(3, "EE");
			app.setString(4,"Y");
			app.executeUpdate();
			///
			app.setInt(1,234);
			app.setString(2, "Berkeley");
			app.setString(3, "biology");
			app.setString(4,"N");
			app.executeUpdate();
			///
			app.setInt(1,345);
			app.setString(2, "MIT");
			app.setString(3, "bioengineering");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,345);
			app.setString(2, "Cornell");
			app.setString(3, "bioengineering");
			app.setString(4,"N");
			app.executeUpdate();
			
			app.setInt(1,345);
			app.setString(2, "Cornell");
			app.setString(3, "CS");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,345);
			app.setString(2, "Cornell");
			app.setString(3, "EE");
			app.setString(4,"N");
			app.executeUpdate();
			///
			app.setInt(1,678);
			app.setString(2, "Stanford");
			app.setString(3, "history");
			app.setString(4,"Y");
			app.executeUpdate();
			///
			app.setInt(1,987);
			app.setString(2, "Stanford");
			app.setString(3, "CS");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,987);
			app.setString(2, "Berkeley");
			app.setString(3, "CS");
			app.setString(4,"Y");
			app.executeUpdate();
			///
			app.setInt(1,876);
			app.setString(2, "Stanford");
			app.setString(3, "CS");
			app.setString(4,"N");
			app.executeUpdate();
			
			app.setInt(1,876);
			app.setString(2, "MIT");
			app.setString(3, "biology");
			app.setString(4,"N");
			app.executeUpdate();
			
			app.setInt(1,876);
			app.setString(2, "MIT");
			app.setString(3, "marine biology");
			app.setString(4,"N");
			app.executeUpdate();
			///
			app.setInt(1,765);
			app.setString(2, "Stanford");
			app.setString(3, "history");
			app.setString(4,"Y");
			app.executeUpdate();
			
			app.setInt(1,765);
			app.setString(2, "Cornell");
			app.setString(3, "history");
			app.setString(4,"N");
			app.executeUpdate();
			
			app.setInt(1,765);
			app.setString(2, "Cornell");
			app.setString(3, "psychology");
			app.setString(4,"Y");
			app.executeUpdate();
			///
			app.setInt(1,543);
			app.setString(2, "MIT");
			app.setString(3, "CS");
			app.setString(4,"N");
			app.executeUpdate();
			/////////////////////
			  
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine();
			System.out.println("Query 1"); 
			// Query 1을 실행: Select문 이용 
			// Query 처리 결과는 적절한Print문을 이용해 Display
			PreparedStatement q1 = connection.prepareStatement("select * from College");
			ResultSet res1 = q1.executeQuery();
			
			System.out.println("[cName/state/enrollment]");
			while(res1.next()) {
				String cname=res1.getString(1);
				String state=res1.getString(2);
				int enrollment=res1.getInt(3);
				System.out.println(cname+"/"+state+"/"+enrollment);
			}
			  
			//////////////////////////////////////////
			
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			System.out.println("Query 2"); 
			// Query 1을 실행: Select문 이용 
			// Query 처리 결과는 적절한Print문을 이용해 Display
			PreparedStatement q2 = connection.prepareStatement("select * from Student");
			ResultSet res2 = q2.executeQuery();
			
			System.out.println("[sID/sName/GPA/sizeHS]");
			while(res2.next()) {
				int sid=res2.getInt(1);
				String sname=res2.getString(2);
				double gpa=res2.getDouble(3);
				int sizehs=res2.getInt(4);
				System.out.println(sid+"/"+sname+"/"+gpa+"/"+sizehs);
			}
			
			///////////////////////////////////////////
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			System.out.println("Query 3");
			
			PreparedStatement q3 = connection.prepareStatement("select * from Apply");
			ResultSet res3 = q3.executeQuery();
			
			System.out.println("[sID/cName/major/decision]");
			while(res3.next()) {
				int sid=res3.getInt(1);
				String cname=res3.getString(2);
				String major=res3.getString(3);
				String decision=res3.getString(4);
				System.out.println(sid+"/"+cname+"/"+major+"/"+decision);
			}
			
			/////////////////////////////////////////////
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			System.out.println("Query 4");
			
			PreparedStatement q4 = connection.prepareStatement("select * from Student S1 where (select count(*) from Student S2 where S2.sID <> S1.sID and S2.GPA = S1.GPA) = (select count(*) from Student S2 where S2.sID <> S1.sID and S2.sizeHS = S1.sizeHS);");
			ResultSet res4 = q4.executeQuery();
			
			System.out.println("[sID/sName/GPA/sizeHS]");
			while(res4.next()) {
				int sid=res4.getInt(1);
				String sname=res4.getString(2);
				double gpa=res4.getDouble(3);
				int sizehs=res4.getInt(4);
				System.out.println(sid+"/"+sname+"/"+gpa+"/"+sizehs);
			}
			///////////////////////////////////
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			System.out.println("Query 5");
			
			PreparedStatement q5 = connection.prepareStatement("select Student.sID, sName, count(distinct cName) from Student, Apply where Student.sID = Apply.sID group by Student.sID, sName;");
			ResultSet res5 = q5.executeQuery();
			System.out.println("[sID/sName/count(distinct cName)]");
			while(res5.next()) {
				int sid=res5.getInt(1);
				String sname=res5.getString(2);
				int count=res5.getInt(3);
				System.out.println(sid+"/"+sname+"/"+count);
			}
			////////////////////////////////////////
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			System.out.println("Query 6");  
			
			PreparedStatement q6 = connection.prepareStatement("select major from Student, Apply where Student.sID = Apply.sID group by major having max(GPA) < (select avg(GPA) from Student);");
			ResultSet res6 = q6.executeQuery();
			
			System.out.println("[major]");
			while(res6.next()) {
				String major = res6.getString(1);
				System.out.println(major);
			}
			////////////////////////////////////////////
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine();
			System.out.println("Query 7"); 
			
			System.out.println("sizeHS: ");
			int sizehs=scan.nextInt();
			System.out.println("major: ");
			String major=scan.next();
			System.out.println("cName: ");
			String cname=scan.next();
			
			PreparedStatement q7 = connection.prepareStatement("select sName, GPA from Student join Apply on Student.sID = Apply.sID where sizeHS < ? and major = ? and cName = ?;");
			
			q7.setInt(1, sizehs);
			q7.setString(2, major);
			q7.setString(3, cname);
			
			ResultSet res7 = q7.executeQuery();
			
			System.out.println("[sName/GPA]");
			while(res7.next()) {
				String sname=res7.getString(1);
				double gpa=res7.getDouble(2);
				System.out.println(sname+"/"+gpa);
			}
			
			// Query 7을 실행: Select문 이용 
			// 사용자에게 sizeHS,major, cName 값으로 1000, CS, Stanford 입력 받음 
			// 입력 받은 값을 넣어 Query를 처리하고 
			// 결과는적절한 Print문을 이용해 Display
			  
		
			 
		}
		catch(SQLException ex) {
			throw ex;
		}
	}
}
