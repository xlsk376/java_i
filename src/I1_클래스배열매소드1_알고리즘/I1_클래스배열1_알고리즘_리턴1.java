package I1_Ŭ�����迭�żҵ�1_�˰���;
import java.util.Arrays;
/*
�Ʒ� data�� �л� ��ȣ�� ������ ���ڿ��� �����ѵ������̴�.
��ȣ�� 1001������ 1004 ���̰�,
������ 0~100�� �����̰� , 60���̻��� �հ��̴�.
*/
class Node1{
	int number;
	int score;
	void print() {
		System.out.println(number + " " + score);
	}
}
class Return1{	
	Node1[] getWinnerList(String[][] data) {	
		//����1) ������ 60���̻��� �հݻ��̴�.
		// �հݻ����� result �� ������ ���� 		
		Node1[] result = null;		
		result = new Node1[data.length];
		for(int i = 0; i < data.length; i++) {
			int temp = Integer.parseInt(data[i][1]);
			result[i] = new Node1();
			if(temp >= 60) {
				result[i].number = Integer.parseInt(data[i][0]);
				result[i].score = Integer.parseInt(data[i][1]);
			}
		}
		
		
		return result;
	}
	
	Node1 getRank1(String[][] data) {	
		
		//����2) ��ü�л��� 1���л� �Ѹ��� �����͸�  result �� ������ ����		
		Node1 result = null;		
		return result;
	}
}

public class I1_Ŭ�����迭1_�˰���_����1 {
	public static void main(String[] args) {
				
		String data[][] = {
				{"1001","34"},
				{"1002","46"},
				{"1003","81"},
				{"1004","10"},
		};	
			
		Return1 re = new Return1();
		Node1 winList[] = re.getWinnerList(data);
		for(int i = 0; i < winList.length; i++) {
			winList[i].print();
		}
		//------------------------------------------
		
		//Node1 getRank1 = re.getRank1(data);
		//getRank1.print();
	}
}