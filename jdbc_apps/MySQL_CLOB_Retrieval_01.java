
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class MySQL_CLOB_Retrieval_01 {

	public static void main(String[] args) {
		System.out.println(".......MySQL_CLOB_Insertion_01.......");
		System.out.println("-------------------------------------");
		System.out.println();
		System.out.println();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		Scanner sc = null;
		String id = "";
		String sql = "SELECT * FROM FILES WHERE ID = ?";
		Reader reader = null;
		Writer writer = null;
		int chars_read = 0;
		char[] buffer = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

			sc = new Scanner(System.in);

			if (sc != null) {
				System.out.print("Enter the File ID ");
				id = sc.next();
			}

			if (con != null) {
				pst = con.prepareStatement(sql);
			}

			if (pst != null) {
				pst.setString(1, id);
				rs = pst.executeQuery();
			}

			if (rs != null) {
				if (rs.next()) {
					reader = rs.getCharacterStream(2);
					writer = new FileWriter("D:\\JdbcApplications\\Files\\" + id + ".txt");
					buffer = new char[2048];
					while ((chars_read = reader.read(buffer)) != -1) {
						writer.write(buffer, 0, chars_read);
					}
					System.out.println("CLOB Retrieved Successfully");
				}
			} else {
				System.out.println("CLOB Not Retrieved");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("All the Resources are hereby Cleaned");
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
				if (sc != null)
					sc.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
