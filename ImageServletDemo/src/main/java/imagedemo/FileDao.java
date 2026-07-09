package imagedemo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FileDao {
	
	

    public void saveFile(String name, String type, InputStream data) throws Exception {
    	
        String sql = "INSERT INTO files (file_name, file_type, file_data) VALUES (?, ?, ?)";
        try (Connection conn = MyConnection.getConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setBlob(3, data);
            ps.executeUpdate();
        }
    }

//    public FileModel getFile(int id) throws Exception {
//        String sql = "SELECT file_name, file_type, file_data FROM files WHERE id=?";
//        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new FileModel(rs.getString("file_name"), rs.getString("file_type"), rs.getBlob("file_data"));
//            }
//        }
//        return null;
//    }
}

