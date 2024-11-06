package miniProject_241104;

public class ReservationDTO {
	private int reservationId;
	private String customerName;
	private String reservationDate;
	private String reservationTime;

	// 전체 필드를 사용하는 생성자
	public ReservationDTO(int reservationId, String customerName, String reservationDate, String reservationTime) {
		this.reservationId = reservationId;
		this.customerName = customerName;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}

	// 예약 추가용 생성자 
	public ReservationDTO(String customerName, String reservationDate, String reservationTime) {
		this.customerName = customerName;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}

	// Getter 및 Setter 메서드
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	@Override
	public String toString() {
		return "예약 ID: " + reservationId + ", 예약자: " + customerName + ", 날짜: " + reservationDate + ", 시간: "
				+ reservationTime;
	}
}
