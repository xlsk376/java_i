package I1_Ŭ�����迭�żҵ�1_�⺻�̷�;

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
			System.out.print("�� ");
		}
		else {
			System.out.print("�� ");
		}
	}
}

public class I1_Ŭ�����迭1_�⺻�̷�4_���� {
	public static void main(String[] args) {
		boolean run = true;
		Seat [] seatList = new Seat[8]; // �Ӹ� 8��
		for(int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat(); //���� 8��
			seatList[i].setData(i + 1, false); // 1~8 , 8�� false
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
			System.out.println("��ȣ�� �Է��ϼ��� >> ");
			int sel = scan.nextInt();
			sel -= 1;
			
			if(seatList[sel].check == false) {
				seatList[sel].check = true;
				cnt -= 1;
			}
			
		}

		
	}
}