package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_RealStudyTime {
	public static void insert(String serialnum, String studytime, String date, String subject) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/o2b2", "root", "1234");

			String sql = "INSERT INTO RealStudyTime VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, serialnum);
			pstmt.setString(2, studytime);
			pstmt.setString(3, date);
			pstmt.setString(4, subject);

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
