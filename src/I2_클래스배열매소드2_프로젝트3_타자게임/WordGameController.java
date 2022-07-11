package I2_Ŭ�����迭�żҵ�2_������Ʈ3_Ÿ�ڰ���;

import java.util.Scanner;

public class WordGameController {
	Scanner scan; 

	WordDAO wordDAO;
	ScoreDAO scoreDAO;
	MemberDAO memberDAO;
	Member memberlog;
	
	void init() {
		scan = new Scanner(System.in);

		wordDAO = new WordDAO();			
		scoreDAO = new ScoreDAO();
		memberDAO = new MemberDAO();
		
		
		memberDAO.init(100);		
		wordDAO.init(100);
		scoreDAO.init(5);
		wordDAO.insertSampleList();		
		memberlog = null;
				
		mainMeue();
	}
	
	
	void mainMeue() {
		while(true) {
			System.out.println("[1] ȸ������ [2] �α��� [0] ����");
			int sel = scan.nextInt();
			if(sel == 1) {
				memberDAO.join();
			}
			else if(sel == 2) {
				memberlog = memberDAO.login();
				if(memberlog == null) {
					System.out.println("[�α��ν���]");
				}else {
					System.out.println("[�α��μ���]");
					gameMenu();
				}
			}
			else if(sel == 0) {
				System.out.println("[����]");
				break;
			}
		}
	}
	void gameMenu() {		
		while(true) {
			String menu = "[1] �ܾ��߰� [2] �ܾ���� [3] ���� [4] ��ŷȮ�� [0] �α׾ƿ�\n";
			System.out.println(menu);
			int sel = scan.nextInt();
			
			if(sel == 0) {
				System.out.println("[�α׾ƿ�]");
				break;
			}else if(sel == 1) {
				wordDAO.insertWord();
			}else if(sel == 2) {
				wordDAO.removeWord();
			}else if(sel == 3) {
				wordDAO.gameStart(memberlog, 10 , scoreDAO);
			}else if(sel == 4) {
				scoreDAO.printRank();
			}
		}
		
	}
	
	
}
