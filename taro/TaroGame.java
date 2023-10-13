package taro;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TaroGame {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TaroCards taroCards = new TaroCards();
		
		 
		int number;  // 참여 인원 수
		int count = 0;  // 게임 진행 횟수
		
		while(true) {
			
			try {
				log.info("참여할 인원 수를 입력하세요.");
				number = sc.nextInt();
				
				break;
			} catch(InputMismatchException e) {   // 정수 이외값 입력했을 때
				log.info("숫자만 입력하세요.");
				sc.nextLine();  // 입력 버퍼 비우기
			} // try-catch
			
		} // while
		
		// 덱셔플
		taroCards.deckShuffle();
		
		//게임 시작
		while(number > count) {
			
			log.info("이름을 입력하세요. (종료하려면 'exit'키 입력)");
			String name = sc.next();
			
			if(name.equals("exit")) {
				log.info("게임을 종료합니다.");
				break;
			} // if
			
			List<String> myCards = taroCards.drawCards(1);
			
			for(String card : myCards) {
				log.info("카드번호[{}],의미: {}", card, taroCards.getCardDescription(card));
				count++;
			} // for
			
		} // while
		
		log.info("게임을 종료합니다.");
		sc.close();

	} // main

} // end class
