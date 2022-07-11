package I1_Ŭ�����迭�żҵ�1_�˰���;

import java.util.Arrays;

/*
�Ʒ� data�� ȸ�� ��ȣ�� �̸� �Ǹűݾ� �� ���ڿ��� �����ѵ������̴�.
*/
class Node2{
	int number;
	String name;
	int price;
	void print() {
		System.out.println(number + " " + name + " " + price);
	}
}
class Return2{
	Node2[] getList(String data) {
		/*
		 ����1) �Ʒ��Ͱ��� Ŭ�����迭�� ����� ���� 
		  =====================
			10001 ��ö�� 2670
			10002 �̿��� 1950
			10003 ���缮 4080
			10004 �ڸ�� 7130
		   =====================		  
		 */
		
		Node2[] result = null;
		String clientList[] = data.split("\n");
		Node2 temp[] = new Node2[clientList.length];
		for(int i = 0; i < clientList.length; i++) {
			String clientTo[] = clientList[i].split("/");
			temp[i] = new Node2();
			temp[i].number = Integer.parseInt(clientTo[0]);
			temp[i].name = clientTo[1];
			temp[i].price = Integer.parseInt(clientTo[2]);
			//System.out.println(temp[i].number + " ");
			for(int j = i; j < clientList.length; j++) {
				
			}
		}
		Node2 temp1[] = new Node2[clientList.length];
		temp1 = new Node2[clientList.length];
		for(int i = 0; i < clientList.length; i++) {
			temp1[i] = new Node2();
			temp1[i].number = 0;
			temp1[i].name = "";
			temp1[i].price = 0;
		}
		int index = 0;
		for(int i = 0; i < clientList.length; i++) {
			temp1[i] = new Node2();
			boolean check = false;
			for(int j = 0; j < clientList.length; j++) {
				if(temp[i].number == temp1[j].number) {
					check = true;
					break;
				}
			}
			if(check == false) {
				temp1[index].number = temp[i].number;
				temp1[index].name = temp[i].name;
				index += 1;
			}
		}
		for(int i = 0; i < index; i++) {
			for(int j = 0; j < clientList.length; j++) {
				if(temp1[i].number == temp[j].number) {
					temp1[i].price += temp[j].price;
				}
			}
		}
		result = new Node2[index];
		for(int i = 0; i < index; i++) {
			result[i] = new Node2();
			result[i].number = temp1[i].number;
			result[i].name = temp1[i].name;
			result[i].price = temp1[i].price;
		}
		
		return result;
	}
	
	Node2 getRank1(String data) {		
		/*
		 ����2) �Ǹűݾ��� 1���� ȸ������ ����
		 */
		Node2 result = null;
		result = new Node2();
		Return2 price = new Return2();
		Node2 temp[] = price.getList(data);
		int max = 0;
		int index = 0;
		for(int i = 0; i < temp.length; i++) {
			if(max < temp[i].price) {
				max = temp[i].price;
				index = i;
			}
		}
		result.number = temp[index].number;
		result.name = temp[index].name;
		result.price = temp[index].price;
		
		return result;
	}	
}
public class I1_Ŭ�����迭1_�򰡹���_����2 {
	public static void main(String[] args) {				
		String data ="";
		data += "10001/��ö��/600\n";
		data += "10002/�̿���/800\n";
		data += "10001/��ö��/1400\n";
		data += "10003/���缮/780\n";
		data += "10002/�̿���/950\n";
		data += "10004/�ڸ��/330\n";
		data += "10001/��ö��/670\n";
		data += "10003/���缮/3300\n";
		data += "10002/�̿���/200\n";
		data += "10004/�ڸ��/6800\n";
		data = data.substring(0 , data.length()-1); // ������ �ۻ��� 
		//System.out.println(data);
		
		Return2 re = new Return2();
		Node2[] list = re.getList(data);
		for(int i = 0; i < list.length; i++) {
			list[i].print();
		}
		System.out.println();
		//------------------------------------------------
		Node2 rank1 = re.getRank1(data);
		rank1.print();
	}
}