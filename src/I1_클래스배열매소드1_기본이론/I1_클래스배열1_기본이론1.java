package I1_Ŭ�����迭�żҵ�1_�⺻�̷�;
class Product{
	String name;
	int price;
	
	void init(String name , int price) {
		this.name = name;
		this.price = price;
	}
	
	void printData() {
		System.out.println(name + " " + price);
		
	}
}
public class I1_Ŭ�����迭1_�⺻�̷�1 {
	public static void main(String[] args) {
				
		//-------------------------------------------------		
		Product [] prList = new Product[2]; // �Ӹ� �� ���� ������ ��ġ�ؾ���
		prList[0] = new Product(); // ����
		prList[1] = new Product(); // ����
		
		prList[0].name = "�����";
		prList[1].name = "����";		
		prList[0].price = 1000;
		prList[1].price = 2000;		
			
		for(int i = 0; i < prList.length; i++) {
			prList[i].printData();
		}
		System.out.println("----------------------");
		
		Product [] prList2 = new Product[2];
		prList2[0] = new Product();
		prList2[1] = new Product();
		
		
		prList2[0].init("�����", 1000);
		prList2[1].init("����", 2000);
		
		for(int i = 0; i < prList.length; i++) {
			prList2[i].printData();
		}
		
	}
}