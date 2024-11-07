package miniProject_241104;

import java.util.Scanner;

public class PhoneManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("인원수 >> ");
	        int numPeople = scanner.nextInt();
	        scanner.nextLine();
	        
	        Phone[] phoneBook = new Phone[numPeople];
	        
	        // 연락처 입력
	        for (int i = 0; i < numPeople; i++) {
	            System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소 >> ");
	            String name = scanner.next();
	            String tel = scanner.next();
	            String address = scanner.next();
	            scanner.nextLine();
	            phoneBook[i] = new Phone(name, tel, address);
	        }
	        
	        System.out.println("저장되었습니다...");

	        // 연락처 검색
	        while (true) {
	            System.out.print("검색할 이름 >> ");
	            String searchName = scanner.nextLine();
	            
	            if (searchName.equalsIgnoreCase("exit")) {
	                System.out.println("프로그램을 종료합니다...");
	                break;
	            }
	            
	            boolean found = false;
	            for (Phone person : phoneBook) {
	                if (person.getName().equals(searchName)) {
	                    System.out.println(person.getName() + "의 번호와 주소는 " 
	                                       + person.getTel() + ", " + person.getAddress() + " 입니다.");
	                    found = true;
	                    break;
	                }
	            }
	            
	            if (!found) {
	                System.out.println(searchName + " 은(는) 없습니다.");
	            }
	        }
	        
	        scanner.close();
	    }

	}

