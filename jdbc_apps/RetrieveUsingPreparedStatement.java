
//public abstract java.sql.PreparedStatement prepareStatement(java.lang.String) throws java.sql.SQLException;

//public abstract java.sql.PreparedStatement prepareStatement(java.lang.String, int, int) throws java.sql.SQLException;

//public abstract java.sql.PreparedStatement prepareStatement(java.lang.String, int, int, int) throws java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RetrieveUsingPreparedStatement {

	public static void main(String[] args) {
		System.out.println(".......INSIDE PSVM.......");
		System.out.println("-------------------------");
		System.out.println();

		Connection con = null;
		PreparedStatement pst = null;
		String sql = "SELECT * FROM EMP";
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
											ResultSet.CONCUR_UPDATABLE,
											ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = pst.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("RIGHT ALIGNED OUTPUT");
		System.out.println("--------------------");

		try {
			while (rs.next()) {
				System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s%n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7),
						rs.getString(8));
				// System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
