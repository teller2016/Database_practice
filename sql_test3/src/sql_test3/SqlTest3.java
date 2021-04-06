package sql_test3;

import java.util.Scanner;
import java.sql.*;

public class SqlTest3 {

	public static void main(String[] args) throws SQLException {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("SQL Programming Test");
			System.out.println("Connecting PostgreSQL database");

			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "postgres";
			String password = "nomorewaiting75";

			Connection connection = DriverManager.getConnection(url, user, password);

			if (connection != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

			
			Statement qry = connection.createStatement();
			///////////////////////////
			////////////recursive query1
			///////////////////////////
			
			System.out.println("Recursive test 1");
			
			
			String sql1="with recursive"
					+ " Ancestor(a,d) as (select parent as a, child as d from ParentOf"
					+ " union"
					+ " select Ancestor.a, ParentOf.child as d"
					+ " from Ancestor, ParentOf"
					+ " where Ancestor.d = ParentOf.parent)"
					+ " select a from Ancestor where d = 'Mary'";

			
			PreparedStatement q1=connection.prepareStatement(sql1);
			ResultSet res1 = q1.executeQuery();
			
			System.out.println("\n[a]");
			while(res1.next()) {
				String a=res1.getString(1);
				
				System.out.println(a);
			}
			
			
			
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			
			
			///////////////////////////
			////////////recursive query2
			///////////////////////////

			System.out.println("Recursive test 2");
			
			String sql2="with recursive"
					+ " Route(orig,dest,total) as"
					+ " (select orig, dest, cost as total from Flight"
					+ " union"
					+ " select R.orig, F.dest, cost+total as total"
					+ " from Route R, Flight F"
					+ " where R.dest = F.orig)"
					+ " select * from Route"
					+ " where orig = 'A' and dest = 'B'";
			
			PreparedStatement q2=connection.prepareStatement(sql2);
			ResultSet res2 = q2.executeQuery();
			
			System.out.println("\n[orig/dest/total]");
			while(res2.next()){
				String orig=res2.getString(1);
				String dest=res2.getString(2);
				int total=res2.getInt(3);
				
				System.out.println(orig+"/"+dest+"/"+total);
			}
			
			
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			
			
			///////////////////////////
			////////////recursive query3
			///////////////////////////
			System.out.println("Recursive test 3");
			
			String sql3="with recursive"
					+ " ToB(orig,total) as"
					+ " (select orig, cost as total from Flight where dest = 'B'"
					+ " union"
					+ " select F.orig, cost+total as total"
					+ " from Flight F, ToB TB"
					+ " where F.dest = TB.orig)"
					+ " select min(total) from ToB where orig = 'A'";
			
			PreparedStatement q3=connection.prepareStatement(sql3);
			ResultSet res3 = q3.executeQuery();
			
			System.out.println("\n[min]");
			while(res3.next()){
				int min=res3.getInt(1);
				
				System.out.println(min);
			}
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			
			
			
			///////////////////////////
			////////////OLAP query1
			///////////////////////////
			System.out.println("OLAP test 1");
			
			String sql4="select storeID, itemID, custID, sum(price)"
					+ " from Sales"
					+ " group by cube(storeID, itemID, custID)"
					+ " order by storeID, itemID, custID";
			
			PreparedStatement q4=connection.prepareStatement(sql4);
			ResultSet res4 = q4.executeQuery();
			
			System.out.println("\n[storeID, itemID, custID, Sum]");
			while(res4.next()) {
				String store = res4.getString(1);
				String item = res4.getString(2);
				String cust = res4.getString(3);
				int sum = res4.getInt(4);
				
				System.out.println(store+"/"+item+"/"+cust+"/"+sum);
			}
			
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			
			
			///////////////////////////
			////////////OLAP query2
			///////////////////////////
			System.out.println("OLAP test 2");
			
			String sql5="select storeID, itemID, custID, sum(price)"
					+ " from Sales F"
					+ " group by itemID, cube(storeID, custID)"
					+ " order by storeID, itemID, custID";
			
			PreparedStatement q5=connection.prepareStatement(sql5);
			ResultSet res5 = q5.executeQuery();
			
			System.out.println("\n[storeID, itemID, custID, Sum]");
			while(res5.next()) {
				String store = res5.getString(1);
				String item = res5.getString(2);
				String cust = res5.getString(3);
				int sum = res5.getInt(4);
				
				System.out.println(store+"/"+item+"/"+cust+"/"+sum);
			}
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			
			
			
			///////////////////////////
			////////////OLAP query3
			///////////////////////////
			System.out.println("OLAP test 3");
			
			String sql6="select storeID, itemID, custID, sum(price)"
					+ " from sales F"
					+ " group by rollup(storeID, itemID, custID)"
					+ " order by storeID, itemID, custID";
			
			PreparedStatement q6=connection.prepareStatement(sql6);
			ResultSet res6 = q6.executeQuery();
			
			System.out.println("\n[storeID, itemID, custID, Sum]");
			while(res6.next()) {
				String store = res6.getString(1);
				String item = res6.getString(2);
				String cust = res6.getString(3);
				int sum = res6.getInt(4);
				
				System.out.println(store+"/"+item+"/"+cust+"/"+sum);
			}
			
			System.out.println("Continue? (Enter 1 for continue)");
			scan.nextLine();
			/////////////////////////////////////////////////////////////////////////////Query 4

		} catch (SQLException ex) {
			throw ex;
		}
	}
}
