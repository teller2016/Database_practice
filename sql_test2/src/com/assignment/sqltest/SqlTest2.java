package com.assignment.sqltest;
import java.util.Scanner;
import java.sql.*;

public class SqlTest2 {
	
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
			qry.execute("drop table IF EXISTS College CASCADE");
			qry.execute("drop table IF EXISTS Student CASCADE");
			qry.execute("drop table IF EXISTS Apply CASCADE");
			/*
			 * qry.execute("drop table if exists College");
			 * qry.execute("drop table if exists Student");
			 * qry.execute("drop table if exists Apply");
			 */
			
			qry.execute("create table College(cName varchar(20), state char(2), enrollment int);");
			qry.execute("create table Student(sID int, sName varchar(20), GPA numeric(2,1), sizeHS int);");
			qry.execute("create table Apply(sID int, cName varchar(20), major varchar(20), decision char);");
			
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
			
			/////////////////////////////////////////////////////////////////////////////Query 1
			System.out.println("Trigger test 1");
			//R1 Trigger
			String sql1 = "create or replace function r1() returns trigger as $$"
					+ " begin"
					+ " insert into Apply values(New.sID, 'Stanford', 'geology', null);"
					+ " insert into Apply values(New.sID, 'MIT', 'biology', null);"
					+ " return New;"
					+ " end;"
					+ " $$"
					+ " language 'plpgsql';"
					+ " create trigger R1"
					+ " after insert on Student"
					+ " for each row"
					+ " when (New.GPA>3.3 and New.GPA<=3.6)"
					+ " execute procedure r1();";
			
			qry.execute(sql1);
			
			//Insert문
			stu.setInt(1, 111);
			stu.setString(2, "Kevin");
			stu.setDouble(3, 3.5);
			stu.setInt(4, 1000);
			stu.executeUpdate();
			
			stu.setInt(1, 222);
			stu.setString(2, "Lori");
			stu.setDouble(3, 3.8);
			stu.setInt(4, 1000);
			stu.executeUpdate();
			  
			//query 1실행
			PreparedStatement q1_1 = connection.prepareStatement("select * from Student");
			ResultSet res1_1 = q1_1.executeQuery();
			
			System.out.println("\n[sID/sName/GPA/sizeHS]");
			while(res1_1.next()) {
				int sid=res1_1.getInt(1);
				String sname=res1_1.getString(2);
				double gpa=res1_1.getDouble(3);
				int sizehs=res1_1.getInt(4);
				System.out.println(sid+"/"+sname+"/"+gpa+"/"+sizehs);
			}
			
			PreparedStatement q1_2 = connection.prepareStatement("select * from Apply");
			ResultSet res1_2 = q1_2.executeQuery();
			
			System.out.println("\n[sID/cName/major/decision]");
			while(res1_2.next()) {
				int sid=res1_2.getInt(1);
				String cname=res1_2.getString(2);
				String major=res1_2.getString(3);
				String decision=res1_2.getString(4);
				System.out.println(sid+"/"+cname+"/"+major+"/"+decision);
			}
			
			
			/////////////////////////////////////////////////////////////////////////////Query 2
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			
			System.out.println("Trigger test 2");
			//Trigger 2
			String sql2 = "create or replace function r3() returns trigger as $$"
					+ " begin"
					+ " update Apply"
					+ " set cName = New.cName"
					+ " where cName=Old.cName;"
					+ " return New;"
					+ " end;"
					+ " $$"
					+ " language 'plpgsql';"
					+ " create trigger R3"
					+ " after update of cName on College"
					+ " for each row"
					+ " execute procedure r3();";
			
			qry.execute(sql2);
			
			//update문
			qry.execute("update College set cName = 'The Farm' where cName = 'Stanford';");
			qry.execute("update College set cName = 'Bezerkeley' where cName = 'Berkeley';");
			
			//query2 실행
			PreparedStatement q2 = connection.prepareStatement("select * from College");
			ResultSet res2 = q2.executeQuery();
			
			System.out.println("\n[cName/state/enrollment]");
			while(res2.next()) {
				String cname=res2.getString(1);
				String state=res2.getString(2);
				int enrollment=res2.getInt(3);
				System.out.println(cname+"/"+state+"/"+enrollment);
			}
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////리셋!
			
			qry.execute("drop table if exists College cascade");
			qry.execute("drop table if exists Student cascade");
			qry.execute("drop table if exists Apply cascade");
			
			qry.execute("create table College(cName varchar(20), state char(2), enrollment int);");
			qry.execute("create table Student(sID int, sName varchar(20), GPA numeric(2,1), sizeHS int);");
			qry.execute("create table Apply(sID int, cName varchar(20), major varchar(20), decision char);");
			
		
			// 3개 테이블에 튜플 생성: Insert문 이용
			
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
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////리셋!
			
			/////////////////////////////////////////////////////////////////////////////Query 3
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			
			System.out.println("View test 1");
			//View 1
			String sql3 = "create view CSaccept as"
					+ " select sID, cName"
					+ " from Apply"
					+ " where major = 'CS' and decision='Y';";
			
			qry.execute(sql3);
			
			//query3 실행
			PreparedStatement q3=connection.prepareStatement("select * from CSaccept;");
			ResultSet res3=q3.executeQuery();
			
			System.out.println("\n[sID/cName]");
			while(res3.next()) {
				String sid=res3.getString(1);
				String cname=res3.getString(2);
				System.out.println(sid+"/"+cname);
			}
		
			
			
			
			/////////////////////////////////////////////////////////////////////////////Query 4
			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			
			System.out.println("View test 2");
			
			String sql4 = "create or replace function csacceptdelete() returns trigger as $$"
					+ " begin"
					+ " delete from Apply"
					+ " where sID = Old.sID"
					+ " and cName = Old.cName"
					+ " and major = 'CS' and decision = 'Y';"
					+ " return New;"
					+ " end;"
					+ " $$"
					+ " language 'plpgsql';"
					+ " create trigger CSacceptDelete"
					+ " instead of delete on CSaccept"
					+ " for each row"
					+ " execute procedure csacceptdelete();";
			
			qry.execute(sql4);
			
			//delete문
			qry.execute("delete from CSaccept where sID = 123;");
			
			//Print
			PreparedStatement q4=connection.prepareStatement("select * from CSaccept;");
			ResultSet res4=q4.executeQuery();
			
			System.out.println("\n[sID/cName]");
			while(res4.next()) {
				String sid=res4.getString(1);
				String cname=res4.getString(2);
				System.out.println(sid+"/"+cname);
			}
			
			PreparedStatement q4_2 = connection.prepareStatement("select * from Apply");
			ResultSet res4_2 = q4_2.executeQuery();
			
			System.out.println("\n[sID/cName/major/decision]");
			while(res4_2.next()) {
				int sid=res4_2.getInt(1);
				String cname=res4_2.getString(2);
				String major=res4_2.getString(3);
				String decision=res4_2.getString(4);
				System.out.println(sid+"/"+cname+"/"+major+"/"+decision);
			}
			
			/////////////////////////////////////////////////////////////////////////////Query 5

			System.out.println("Continue? (Enter 1 for continue)"); 
			scan.nextLine(); 
			
			System.out.println("View test 3");
			
			String sql5 = "create or replace function csacceptupdate() returns trigger as $$"
					+ " begin"
					+ " update Apply"
					+ " set cName = New.cName"
					+ " where sID = Old.sID"
					+ " and cName = Old.cName"
					+ " and major = 'CS' and decision='Y';"
					+ " return New;"
					+ " end;"
					+ " $$"
					+ " language 'plpgsql';"
					+ " create trigger CSacceptUpdate"
					+ " instead of update on CSaccept"
					+ " for each row"
					+ " execute procedure csacceptupdate();";
			
			qry.execute(sql5);
			
			//update문
			qry.execute("update CSaccept set cName = 'CMU' where sID = 345;");
			
			//Print
			PreparedStatement q5=connection.prepareStatement("select * from CSaccept;");
			ResultSet res5=q5.executeQuery();
			
			System.out.println("\n[sID/cName]");
			while(res5.next()) {
				String sid=res5.getString(1);
				String cname=res5.getString(2);
				System.out.println(sid+"/"+cname);
			}
			
			PreparedStatement q5_2 = connection.prepareStatement("select * from Apply");
			ResultSet res5_2 = q5_2.executeQuery();
			
			System.out.println("\n[sID/cName/major/decision]");
			while(res5_2.next()) {
				int sid=res5_2.getInt(1);
				String cname=res5_2.getString(2);
				String major=res5_2.getString(3);
				String decision=res5_2.getString(4);
				System.out.println(sid+"/"+cname+"/"+major+"/"+decision);
			}
			
			  
		
			 
		}
		catch(SQLException ex) {
			throw ex;
		}
	}
}
