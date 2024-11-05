package miniProject_241104;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERID = "scott";
	private final String PASSWD = "tiger";

	public ReservationDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 예약 추가
	public boolean addReservation(ReservationDTO reservation) {
		String sql = "INSERT INTO reservations (reservation_id, customer_name, reservation_date, reservation_time) VALUES (reservations_seq.NEXTVAL, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
		try (Connection conn = DriverManager.getConnection(URL, USERID, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, reservation.getCustomerName());
			pstmt.setString(2, reservation.getReservationDate());
			pstmt.setString(3, reservation.getReservationTime());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 예약 취소
	public boolean cancelReservation(int reservationId) {
		String sql = "DELETE FROM reservations WHERE reservation_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USERID, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, reservationId);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 예약 수정
	public boolean updateReservation(ReservationDTO reservation) {
		String sql = "UPDATE reservations SET customer_name = ?, reservation_date = TO_DATE(?, 'YYYY-MM-DD'), reservation_time = ? WHERE reservation_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USERID, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, reservation.getCustomerName());
			pstmt.setString(2, reservation.getReservationDate());
			pstmt.setString(3, reservation.getReservationTime());
			pstmt.setInt(4, reservation.getReservationId());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 예약 검색
	public List<ReservationDTO> searchReservations(String customerName) {
		List<ReservationDTO> reservations = new ArrayList<>();
		String sql = "SELECT reservation_id, customer_name, TO_CHAR(reservation_date, 'YYYY-MM-DD') AS reservation_date, reservation_time FROM reservations WHERE customer_name LIKE ? ORDER BY reservation_date, reservation_time";
		try (Connection conn = DriverManager.getConnection(URL, USERID, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + customerName + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				reservations.add(new ReservationDTO(rs.getInt("reservation_id"), rs.getString("customer_name"),
						rs.getString("reservation_date"), rs.getString("reservation_time")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	// 예약 목록 조회
	public List<ReservationDTO> getReservations() {
		List<ReservationDTO> reservations = new ArrayList<>();
		String sql = "SELECT reservation_id, customer_name, TO_CHAR(reservation_date, 'YYYY-MM-DD') AS reservation_date, reservation_time FROM reservations ORDER BY reservation_date, reservation_time";
		try (Connection conn = DriverManager.getConnection(URL, USERID, PASSWD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				reservations.add(new ReservationDTO(rs.getInt("reservation_id"), rs.getString("customer_name"),
						rs.getString("reservation_date"), rs.getString("reservation_time")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}
}
