package imagedemo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDao {

	public static int uploadFile(String firstName, String lastName, InputStream input) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO users_img (first_Name, last_Name, photo) value(?, ?, ?)";
		int row = 0;
		
		Connection con = MyConnection.getConnection();
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			
			if(input != null) {
				pstmt.setBlob(3, input);
			}
			row = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

}
