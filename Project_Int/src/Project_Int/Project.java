package Project_Int;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project {

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
			  
			qry.execute("drop table if exists Station");
			qry.execute("drop table if exists Congestion");
			  
			qry.execute("create table Station(line varchar(10), sName varchar(10), region varchar(10))");
			qry.execute("create table Congestion(day varchar(10), line varchar(10), sName varchar(10), time6cong float, time12cong float, time18cong float )");
			
			////////////////////////////// csv 파일 읽어오기
			List<List<String>> ret = new ArrayList<List<String>>();
			BufferedReader br = null;

			try {
				br = Files.newBufferedReader(Paths.get("C:\\OS\\Station.csv"));
				// Charset.forName("UTF-8");
				String line = "";

				while ((line = br.readLine()) != null) {
					// CSV 1행을 저장하는 리스트
					List<String> tmpList = new ArrayList<String>();
					String array[] = line.split(",");
					// 배열에서 리스트 반환
					tmpList = Arrays.asList(array);
					// System.out.println(tmpList);
					ret.add(tmpList);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Inserting tuples to Station relations");

			String insert_station = "insert into Station (line, sName, region) values(?,?,?);";
			PreparedStatement station = connection.prepareStatement(insert_station);

			for (int i = 1; i < ret.size(); i++) {
				for (int j = 0; j < ret.get(i).size(); j++) {
					//System.out.print(ret.get(i).get(j) + "\t");
					station.setString(j+1, ret.get(i).get(j));
					
				}
				//System.out.println();
				station.executeUpdate();
			}

			
			PreparedStatement q1 = connection.prepareStatement("select * from Station");
			ResultSet res1 = q1.executeQuery();
			
			System.out.println("[line/sName/region]");
			while(res1.next()) {
				String line=res1.getString(1);
				String sname=res1.getString(2);
				String region=res1.getString(3);
				System.out.println(line+"/"+sname+"/"+region);
			}
			
			//////////////////////////////////////////////////////////////////////////////////////
			
			List<List<String>> ret2 = new ArrayList<List<String>>();
			BufferedReader br2 = null;

			try {
				br2 = Files.newBufferedReader(Paths.get("C:\\OS\\Congestion.csv"));
				// Charset.forName("UTF-8");
				String line = "";

				while ((line = br2.readLine()) != null) {
					// CSV 1행을 저장하는 리스트
					List<String> tmpList = new ArrayList<String>();
					String array[] = line.split(",");
					// 배열에서 리스트 반환
					tmpList = Arrays.asList(array);
					// System.out.println(tmpList);
					ret2.add(tmpList);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br2 != null) {
						br2.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Inserting tuples to Congestion relations");
			
			 
			String insert_congestion = "insert into Congestion (day, line, sName,time6cong, time12cong, time18cong ) values(?,?,?,?,?,?);";
			PreparedStatement congestion = connection.prepareStatement(insert_congestion);

			for (int i = 1; i < ret2.size(); i++) {
				
				String day = ret2.get(i).get(0);
	            String line = ret2.get(i).get(1);
	            String sName = ret2.get(i).get(2);

	            float time6cong = Float.parseFloat(ret2.get(i).get(3));
                float time12cong = Float.parseFloat(ret2.get(i).get(4));
                float time18cong = Float.parseFloat(ret2.get(i).get(5));

                congestion.setString(1, day);
                congestion.setString(2, line);
                congestion.setString(3, sName);
                congestion.setFloat(4, time6cong);
                congestion.setFloat(5, time12cong);
                congestion.setFloat(6, time18cong);
                
                congestion.executeUpdate();

			}
			
			PreparedStatement q2 = connection.prepareStatement("select * from Congestion");
			ResultSet res2 = q2.executeQuery();
			
			System.out.println("[day/line/sName/time6cong/time12cong/time18cong]");
			while(res2.next()) {
				String day = res2.getString(1);
                String line = res2.getString(2);
                String sName = res2.getString(3);
                float a1 = res2.getFloat(4);
                float a2 = res2.getFloat(5);
                float a3 = res2.getFloat(6);

				System.out.println(day+"/"+line+"/"+sName+"/"+a1+"/"+a2+"/"+a3);
			}

			

		} catch (SQLException ex) {
			throw ex;
		}
	}
}
