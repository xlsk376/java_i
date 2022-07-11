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
		int index = 0;
		int cnt = 0;
		for(int i = 0; i < data.length; i++) {
			int temp = Integer.parseInt(data[i][1]);
			result[i] = new Node1();
			if(temp >= 60) {
//				result[i].number = Integer.parseInt(data[i][0]);
//				result[i].score = Integer.parseInt(data[i][1]);
				index = i;
				cnt += 1;
			}
		}
		result = new Node1[cnt]; 
		for(int i = 0; i < cnt; i++) {
			result[i] = new Node1();
			result[i].number = Integer.parseInt(data[index][0]);
			result[i].score = Integer.parseInt(data[index][1]);
			index += 1;
		}
		return result;
	}
	
	Node1 getRank1(String[][] data) {	
		
		//����2) ��ü�л��� 1���л� �Ѹ��� �����͸�  result �� ������ ����		
		Node1 result = null;
		result = new Node1();
		int max = 0;
		int index = 0;
		for(int i = 0; i < data.length; i++) {
			int temp = Integer.parseInt(data[i][1]);
			if(max < temp) {
				max = temp;
				index = i;
			}
		}
		result.number = Integer.parseInt(data[index][0]);
		result.score = max;
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
		System.out.println();
		Node1 getRank1 = re.getRank1(data);
		getRank1.print();
	}
}