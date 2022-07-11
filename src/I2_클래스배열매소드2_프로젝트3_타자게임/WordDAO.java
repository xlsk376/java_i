package I2_Ŭ�����迭�żҵ�2_������Ʈ3_Ÿ�ڰ���;

import java.util.Random;
import java.util.Scanner;

public class WordDAO {
	
	Scanner scan = new Scanner(System.in);
	String[] wordList;
	int wordCount;

	void init(int size) {
		wordList = new String[size];
		wordCount = 0;
	}
	
	void insertSampleList() {
		String [] sampleList = {"banana" , "apple" , "jsp" , "android" , "java",
				"c++" , "father" ,"mother" , "love" , "spring"};
		
		for(int i = 0; i < sampleList.length; i++) {
			insertWord(sampleList[i]);
		}
	}
	
	void print() {
		for(int i = 0; i < wordCount; i++) {
			System.out.println( (i + 1) +"��) " +  wordList[i]);
		}
	}
	void insertWord(String word) {
		wordList[wordCount] = word;
		wordCount += 1;
	}
	void removeWord(String word) {
		int index = -1;
		for(int i = 0; i < wordCount; i++) {
			if(word.equals(wordList[i])) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("�����Ҵܾ �����ϴ�.");
		}else {
			for(int i = index; i < wordCount-1; i++) {
				wordList[i] =wordList[i + 1];
			}
			wordCount -= 1;
		}
	}
	int getSize() {
		return wordCount;
	}
	String[] getRandomWordList(int count) {
		Random ran = new Random();
		String [] sampleList =new String[count];
		
		for(int i = 0; i < 1000; i++) {
			int r = ran.nextInt(wordCount);
			String temp = wordList[r];
			wordList[r] = wordList[0];
			wordList[0] = temp;
		}
		
		for(int i = 0; i < count; i++) {
			sampleList[i] = wordList[i];
		}	
		return sampleList;
	}
	
	
	void insertWord() {
		System.out.println("�߰��� �ܾ� �Է� : ");
		String word = scan.next();
		insertWord(word);
	}
	void removeWord() {
		System.out.println("������ �ܾ� �Է� : ");
		String word = scan.next();
		removeWord(word);
	}
	
	void gameStart(Member member , int gameCount , ScoreDAO scoreDAO) {
		int size = getSize();
		if(size < gameCount) {
			System.out.println("�ܾ ��������ʾ� ������ �����Ҽ������ϴ�.");
			System.out.println("�ּ� " + gameCount + "���� ������ �ʿ��մϴ�.");
			return;
		}
				
		String[] gameWord = getRandomWordList(gameCount);
		int score = 0;
		int i = 0;
		while(true) {
			System.out.println("���� : " + gameWord[i]);
			String input = scan.next();
			if(input.equals(gameWord[i])) {
				score += 1;
				System.out.println("[����]");
			}else {
				System.out.println("[��]");
			}
			i += 1;
			
			if(gameCount == i) {
				System.out.println("[��繮���� Ǯ�����ϴ�]");
				break;
			}
			
		}	
		int rank = scoreDAO.saveScore(member.id , score);
		if(rank == -1) {
			System.out.println("�ƽ��Ե� ������ ���� ���߽��ϴ�.");
		}else {
			System.out.println(rank + "�� �Դϴ�. �����մϴ�.");
		}
		
	}
	
}
