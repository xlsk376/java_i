package I1_클래스배열매소드1_기본이론;

import java.util.Scanner;

class Seat{
	int num;
	boolean check;
	void setData(int num , boolean check) {
		this.num = num;
		this.check = check;
	}
	
	void showNum() {
		System.out.print(num + " ");
	}
	void showData() {
		
		if(check == true) {
			System.out.print("■ ");
		}
		else {
			System.out.print("□ ");
		}
	}
}

public class I1_클래스배열1_기본이론4_예매 {
	public static void main(String[] args) {
		boolean run = true;
		Seat [] seatList = new Seat[8]; // 머리 8개
		for(int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat(); //몸통 8개
			seatList[i].setData(i + 1, false); // 1~8 , 8개 false
		}
		Scanner scan = new Scanner(System.in);
		int cnt = seatList.length;
		while(run) {
			for(int i = 0; i< seatList.length; i++) {
				seatList[i].showNum();
			}
			System.out.println();
			for(int i = 0; i< seatList.length; i++) {
				seatList[i].showData();
			}
			if(cnt == 0) {
				break;
			}
			System.out.println();
			System.out.println("번호를 입력하세요 >> ");
			int sel = scan.nextInt();
			sel -= 1;
			
			if(seatList[sel].check == false) {
				seatList[sel].check = true;
				cnt -= 1;
			}
			
		}

		
	}
}