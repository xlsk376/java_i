package I2_Ŭ�����迭�żҵ�2_������Ʈ2_��ȭ����;
import java.util.Scanner;
public class SeatDAO {
	Scanner scan;
	Seat[] seatList;
	int max;
	void init() {
		max = 8;
		scan = new Scanner(System.in);
		seatList = new Seat[max];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat();
			seatList[i].number = i + 1;
			seatList[i].userID = "";
			seatList[i].check = false;
		}
	}

	void printSeat() {
		for (int i = 0; i < seatList.length; i++) {
			System.out.print("[" + seatList[i].number + "]");
		}
		System.out.println();

		for (int i = 0; i < seatList.length; i++) {
			if (seatList[i].check == false) {
				System.out.print("[x]");
			} else {
				System.out.print("[o]");
			}
		}
		System.out.println();
	}

	void ticketing(String log) {
		printSeat();
		System.out.println("[����] ��ȣ�� �Է� : ");
		int sel = scan.nextInt();
		if(sel <= 0 || sel > max) {
			return;
		}
		sel -= 1;
		if(seatList[sel].check == false) {
			seatList[sel].userID = log;
			seatList[sel].check = true;
			System.out.println("[���޿Ϸ�]");
			printSeat();
		}else {
			System.out.println("[�����Ҽ������ϴ�]");
		}
		
	}
	
}
