package mule_soft;

import java.sql.*;
import java.util.Scanner;  
public class Movies {  
    public static void main(String[] args) {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/movie", "mulesoft", "mulesoft");  
            Statement s = con.createStatement();  
            s.execute("DROP TABLE IF EXISTS `movie_details`"); // create a table  
            s.execute("CREATE TABLE `movie_details` (  `name` varchar(9) DEFAULT NULL,  `actor` varchar(19) DEFAULT NULL,  `actress` varchar(17) DEFAULT NULL,  `director` varchar(14) DEFAULT NULL,  `year` smallint(6) DEFAULT NULL)"); // insert first row into the table   
            s.execute("INSERT INTO `movie_details` VALUES ('KGF','YASH','SRINIDHI SHETTY','PRASHANTH NEEL',2018),('Shershaah','Sidharth Malhotra','Kiara Advani','Vishnuvardhan',2021),('Roberrt','Darshan Thoogudeepa','Asha Bhat','Tharun Sudhir',2020),('Pogaru','Dhruva Sarja','Rashmika Mandanna','Nanda Kishore',2020),('PUSHPA','ALU ARJUN','RASHMIKA MANDANA','SUKUMAR',2022)"); // insert second row into the table   
            
            ResultSet rs = s.executeQuery("select * from movie_details");
            
        	
            if (rs != null) // if rs == null, then there is no record in ResultSet to show  
                while (rs.next()) // By this line we will step through our data row-by-row  
            {  
                System.out.println("________________________________________");  
                System.out.println("Movie Name: " + rs.getString(1));  
                System.out.println("Actor Name: " + rs.getString(2));  
                System.out.println("Actress Name: " + rs.getString(3));
                System.out.println("Director: " + rs.getString(4));  
                System.out.println("Year: " + rs.getString(5));  
                System.out.println("________________________________________");  
            }
            
            
            //2nd Query
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
            System.out.print("Enter a string: ");
            String str= sc.nextLine(); 
        	s.execute("select name from movie_details where actor=\""+ str +"\"");
        	ResultSet ms = s.executeQuery("select name from movie_details where actor=\""+ str +"\"");
        	if (ms != null) // if rs == null, then there is no record in ResultSet to show  
                while (ms.next()) // By this line we will step through our data row-by-row  
            {  
                System.out.println("________________________________________");  
                System.out.println("Movie Name: " + ms.getString(1)); 
            }
            
            s.close(); // close the Statement to let the database know we're done with it  
            con.close(); // close the Connection to let the database know we're done with it  
        } catch (SQLException err) {  
            System.out.println("ERROR: " + err);  
        } catch (Exception err) {  
            System.out.println("ERROR: " + err);  
        }
        
       
    }  
}  
