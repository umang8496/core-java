
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class MySQL_BLOB_Retrieval_02 {

	public static void main(String[] args) {
		System.out.println(".......MySQL_BLOB_Retrieval_02.......");
		System.out.println("-------------------------------------");
		System.out.println();

		Scanner sc = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String img_name = "";
		String sql = "SELECT * FROM GALLERY WHERE img_name=?";
		FileOutputStream fout = null;

		byte[] buffer = null;
		Blob blob = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				//System.out.println("Enter the img_name:::");
				img_name = "img06";
				System.out.println("img_name : "+img_name);
			}

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

			if (con != null) {
				pst = con.prepareStatement(sql);
			}

			if (pst != null) {
				pst.setString(1, img_name);
				rs = pst.executeQuery();
			}

			if (rs.next()) {
				blob = rs.getBlob(2);
				//buffer = new byte[4096];
				buffer = blob.getBytes(1,(int)blob.length());
				
				fout = new FileOutputStream("D:\\JdbcApplications\\Images\\" + img_name + ".jpg");
				fout.write(buffer);
				
				System.out.println("Image Retrieved Successfully.");
				System.out.println("-----------------------------");
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
			try {
				if (fout != null)
					fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
