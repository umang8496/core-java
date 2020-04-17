
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class MySQL_CLOB_Insertion_01 {

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
		String file_path = "";
		String sql = "INSERT INTO FILES VALUES(?,?)";
		File file = null;
		Reader reader = null;
		int result = -1;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

			sc = new Scanner(System.in);

			if (sc != null) {
				System.out.print("Enter the File ID ");
				id = sc.next();

				System.out.print("Enter the File Path ");
				file_path = sc.next();
				//file_path = D:\documents\CLOB01.txt
			}

			if (con != null) {
				pst = con.prepareStatement(sql);
				file = new File(file_path);
				reader = new FileReader(file);
			}

			if (pst != null) {
				pst.setString(1, id);
				pst.setCharacterStream(2, reader, (int) file.length());
			}

			if (pst != null) {
				result = pst.executeUpdate();
				if (result == -1) {
					System.out.println("CLOB Not Inserted");
				} else {
					System.out.println("CLOB Inserted");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
