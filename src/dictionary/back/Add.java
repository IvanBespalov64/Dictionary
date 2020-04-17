package dictionary.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;  

public class Add {
	
	static Connection conn = null;
	
	public static void push(Book arg0) {
		Statement stat = null;
        try{   
        	connect();
        	stat = conn.createStatement();

    		String sql = "INSERT INTO data(name, author, num) VALUES('" + arg0.name +
    				"','" + arg0.author + "'," + arg0.num + ")";  
            System.out.println(sql);
    		stat.executeUpdate(sql);  
            JOptionPane.showMessageDialog(null, "Succesful");
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println(e.getMessage());  
        }
	}
	
	public static void connect() {  
        conn = null;  
        try {  
            String url = "jdbc:sqlite:data.db";  
            conn = DriverManager.getConnection(url);  
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
    }  
	
	public static void close() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
