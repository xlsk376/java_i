package I2_Ŭ�����迭�żҵ�2_������Ʈ2_��ȭ����;

import java.util.Scanner;

public class TicketController {
	Scanner scan = new Scanner(System.in);
	SeatDAO seatDAO;
	UserDAO userDAO;
	String log;

	void init() {
		seatDAO = new SeatDAO();
		userDAO = new UserDAO();
		userDAO.init();
		seatDAO.init();
		log = null;
	}

	void run() {
		loginMenu();
	}
	void loginMenu() {		
		while (true) {			
			System.out.println("1)�α��� 0)����");
			int sel = scan.nextInt();
			if(sel == 1) {
				log = userDAO.loginCheck();
				if(log != null) {
					seatMenu();
				}
			}else if(sel ==0) {
				System.out.println("[����]");
				break;
			}					
		}
	}
	void seatMenu() {
		while(true) {
			System.out.println("1)��ȭ���� 2)������� 3)����Ȯ�� 0)�α׾ƿ�");
			int sel = scan.nextInt();
			if(sel == 1) {
				seatDAO.ticketing(log);
			}else if(sel == 2) {
				seatDAO.ticketCancel(log);
			}else if(sel == 3) {
				seatDAO.printAll(log);
			}else if(sel == 0) {
				System.out.println("[�α׾ƿ�]");
				break;
			}
		}
	}
}
