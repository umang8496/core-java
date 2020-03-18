
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Oracle_BLOB_Retrieval_01 {

	public static void main(String[] args) {
		System.out.println(".......Oracle_BLOB_Retrieval_01.......");
		System.out.println("-------------------------------------");
		System.out.println();

		Scanner sc = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String img_name = "";
		String sql = "SELECT * FROM GALLERY WHERE img_name=?";
		InputStream is = null;
		OutputStream os = null;
		int bytesRead = 0;
		byte[] buffer = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				img_name = "img02";
				System.out.println("Entered img_name : "+img_name);
			}

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			if (con != null) {
				pst = con.prepareStatement(sql);
			}

			if (pst != null) {
				pst.setString(1, img_name);
				rs = pst.executeQuery();
			}
			
			if(rs.next()){
				is = rs.getBinaryStream(2);
				os = new FileOutputStream("D:\\JdbcApplications\\Images\\"+img_name+".png");
				buffer = new byte[4096];
				while((bytesRead=is.read(buffer))!=-1){
					os.write(buffer,0,bytesRead);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
