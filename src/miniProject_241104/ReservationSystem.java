package miniProject_241104;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReservationSystem extends JFrame {

	private ReservationDAO reservationDAO;
	private JTextField nameField;
	private JTextField dateField;
	private JTextField timeField;
	private JTextArea displayArea;
	private JTextField searchField;

	public ReservationSystem() {
		reservationDAO = new ReservationDAO();
		initComponents();
	}

	private void initComponents() {
		setTitle("예약 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel inputPanel = createInputPanel();
		add(inputPanel, BorderLayout.NORTH);

		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		displayArea.setBackground(new Color(245, 245, 245));
		JScrollPane scrollPane = new JScrollPane(displayArea);
		scrollPane.setBorder(BorderFactory.createTitledBorder("예약 목록"));
		add(scrollPane, BorderLayout.CENTER);
	}

	private JPanel createInputPanel() {
		JPanel inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		inputPanel.setBackground(new Color(230, 240, 255));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		nameField = new JTextField(20);
		dateField = new JTextField(20);
		timeField = new JTextField(20);
		searchField = new JTextField(15);


		JButton addButton = createButton("예약 추가", e -> addReservation());
		JButton viewButton = createButton("예약 조회", e -> viewReservations());
		JButton cancelButton = createButton("예약 취소", e -> cancelReservation());
		JButton updateButton = createButton("예약 수정", e -> updateReservation());
		JButton searchButton = createButton("검색", e -> searchReservations());

		// 레이아웃 설정
		addComponent(inputPanel, gbc, new JLabel("예약자 이름:"), 0, 0);
		addComponent(inputPanel, gbc, nameField, 1, 0);
		addComponent(inputPanel, gbc, new JLabel("예약 날짜 (YYYY-MM-DD):"), 0, 1);
		addComponent(inputPanel, gbc, dateField, 1, 1);
		addComponent(inputPanel, gbc, new JLabel("예약 시간 (HH:MM):"), 0, 2);
		addComponent(inputPanel, gbc, timeField, 1, 2);
		addComponent(inputPanel, gbc, addButton, 0, 3, 2);
		addComponent(inputPanel, gbc, viewButton, 0, 4, 2);
		addComponent(inputPanel, gbc, cancelButton, 0, 5, 2);
		addComponent(inputPanel, gbc, updateButton, 0, 6, 2);

		JPanel searchPanel = new JPanel(new BorderLayout());
		searchPanel.add(searchField, BorderLayout.CENTER);
		searchPanel.add(searchButton, BorderLayout.EAST);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		inputPanel.add(searchPanel, gbc);

		return inputPanel;
	}

	private JButton createButton(String text, ActionListener listener) {
		JButton button = new JButton(text);
		button.addActionListener(listener);
		button.setBackground(new Color(70, 130, 180));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setFont(new Font("SansSerif", Font.PLAIN, 14));
		return button;
	}

	private void addComponent(JPanel panel, GridBagConstraints gbc, Component component, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(component, gbc);
	}

	private void addComponent(JPanel panel, GridBagConstraints gbc, Component component, int x, int y, int width) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		panel.add(component, gbc);
	}

	// 예약 추가 메서드
	private void addReservation() {
		String name = nameField.getText();
		String date = dateField.getText();
		String time = timeField.getText();
		ReservationDTO reservation = new ReservationDTO(name, date, time);
		if (reservationDAO.addReservation(reservation)) {
			displayArea.append("예약 추가 완료: " + name + "\n");
		} else {
			displayArea.append("예약 추가 실패\n");
		}
	}

	// 예약 조회 메서드
	private void viewReservations() {
		displayArea.setText("");
		List<ReservationDTO> reservations = reservationDAO.getReservations();
		for (ReservationDTO reservation : reservations) {
			displayArea.append(reservation.toString() + "\n");
		}
	}

	// 예약 취소 메서드
	private void cancelReservation() {
		String name = nameField.getText();
		List<ReservationDTO> reservations = reservationDAO.searchReservations(name);
		if (!reservations.isEmpty()) {
			reservationDAO.cancelReservation(reservations.get(0).getReservationId());
			displayArea.append("예약 취소 완료: " + name + "\n");
		} else {
			displayArea.append("예약이 없습니다.\n");
		}
	}

	// 예약 수정 메서드
	private void updateReservation() {
		String name = nameField.getText();
		String date = dateField.getText();
		String time = timeField.getText();
		List<ReservationDTO> reservations = reservationDAO.searchReservations(name);
		if (!reservations.isEmpty()) {
			ReservationDTO reservation = reservations.get(0);
			reservation.setReservationDate(date);
			reservation.setReservationTime(time);
			reservationDAO.updateReservation(reservation);
			displayArea.append("예약 수정 완료: " + name + "\n");
		} else {
			displayArea.append("예약이 없습니다.\n");
		}
	}

	// 예약 검색 메서드
	private void searchReservations() {
		String name = searchField.getText();
		displayArea.setText("");
		List<ReservationDTO> reservations = reservationDAO.searchReservations(name);
		if (reservations.isEmpty()) {
			displayArea.append("검색 결과가 없습니다.\n");
		} else {
			for (ReservationDTO reservation : reservations) {
				displayArea.append(reservation.toString() + "\n");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ReservationSystem system = new ReservationSystem();
			system.setVisible(true);
		});
	}
}
