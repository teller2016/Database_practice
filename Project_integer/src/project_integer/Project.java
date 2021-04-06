package project_integer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Project {

	 public static void main(String[] args){
	        //��ȯ�� ����Ʈ
	        List<List<String>> ret = new ArrayList<List<String>>();
	        BufferedReader br = null;
	        
	        try{
	            br = Files.newBufferedReader(Paths.get("C:\\OS\\Station.csv"));
	            //Charset.forName("UTF-8");
	            String line = "";
	            
	            while((line = br.readLine()) != null){
	                //CSV 1���� �����ϴ� ����Ʈ
	                List<String> tmpList = new ArrayList<String>();
	                String array[] = line.split(",");
	                //�迭���� ����Ʈ ��ȯ
	                tmpList = Arrays.asList(array);
	                System.out.println(tmpList);
	                ret.add(tmpList);
	            }
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(br != null){
	                    br.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	    }

}
