package dictionary.back;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Save {
	public static void save() {
		try {
			Add.connect();
			ResultSet rs = Add.conn.createStatement().executeQuery("select * from data");
			String data = "<books>\n";
			while(rs.next()) {
				data += "<book>\n";
				data += "<id>" + String.valueOf(rs.getInt("index")) + "</id>\n";
				data += "<name>" + rs.getString("name") + "</name>\n";
				data += "<author>" + rs.getString("author") + "</author>\n";
				data += "<num>" + String.valueOf(rs.getInt("num")) + "</num>\n";
				data += "</book>\n";
			}
			data += "</books>";
			Files.write(Paths.get("data.xml"), data.getBytes());
			JOptionPane.showMessageDialog(null, "Succesful");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
	}
}
