package taro;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class TaroCards {
	private Properties props;   // 카드의 이름,의미 저장
	private String path;        // 파일 경로 저장
	private List<String> deck;  // 카드 담을 덱
	
	public TaroCards() {
		props = new Properties();
		deck = new Vector<String>();
		
		path = TaroCards.
			   class.
			   getResource("database.properties").
			   getPath();
		
		try {
		path = URLDecoder.decode(path,"utf-8");
		props.load(new FileReader(path));
		
		// 덱에 카드 이름 넣기
		deck.addAll(props.stringPropertyNames());
		} catch(IOException e) {   // 파일을 읽는 과정에서 발생하는 오류 잡기
			e.printStackTrace();
		} // try-catch
		
	} // Constructor
	
	//덱셔플
	public void deckShuffle() {
		Collections.shuffle(deck);
		log.info("덱을 셔플합니다.");
	} // deckShuffle
	
	//카드뽑기
	public List<String> drawCards(int num) {
		List<String> drawCards = new ArrayList<String>();   // 뽑은카드 저장
		
		// 덱에 카드가 부족할때 그대로 반환
		if(deck.size() < (num*1) ) {
			log.info("덱에 카드가 부족합니다.");
			return drawCards;
		}
		
		// 덱에서 뽑은카드 저장후 제거
		drawCards.add(deck.remove(0));
		
		log.info("뽑은 카드 번호: {}", drawCards);
		return drawCards;
		
	} // drawCards
	
	// 카드 의미 담기
	public String getCardDescription(String card) {
		return props.getProperty(card);
		
	} // getCardDescription
	
} // end class
