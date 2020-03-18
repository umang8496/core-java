
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Oracle_BLOB_Insertion_02 {
	public static void main(String[] args) {
		System.out.println(".......Oracle_BLOB_Insertion_02.......");
		System.out.println("-------------------------------------");
		System.out.println();

		Scanner sc = null;
		int result = -1;
		String img_name = "";
		String img_path = "";
		FileInputStream fin = null;
		// File file = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				// img_name = "img01";
				// img_path = "D:\\pics\\mysql.png";

				// img_name = "img02";
				// img_path = "D:\\pics\\sqlhome.png";

				// img_name = "img03";
				// img_path = "D:\\pics\\javahome.png";

				 img_name = "img04";
				 img_path = "D:\\pics\\oracle.png";

				// img_name = "img05";
				// img_path = "D:\\pics\\html5.png";

				// img_name = "img06";
				// img_path = "D:\\pics\\css3.jpg";

				System.out.println("img_name : " + img_name);
				System.out.println("img_path : " + img_path);
			}
			fin = new FileInputStream(img_path);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			pst = con.prepareStatement("INSERT INTO GALLERY VALUES(?,?)");

			if (pst != null) {
				pst.setString(1, img_name);
				// public abstract void setBinaryStream(int,
				// java.io.InputStream,
				// long) throws java.sql.SQLException;
				pst.setBinaryStream(2, fin, fin.available());
			}

			if (pst != null) {
				result = pst.executeUpdate();
			}

			if (result != -1) {
				System.out.println("BLOB Inserted");
			} else {
				System.out.println("BLOB Not Inserted");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			try {
				if (fin != null)
					fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (sc != null)
					sc.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}
	}
}
