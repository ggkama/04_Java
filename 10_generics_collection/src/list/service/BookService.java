package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공
 */
public class BookService {
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	// 기본 생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다","한강",15000,"창비"));
		bookList.add(new BookDTO("초역 부처의 말","코이케 류노스케",17800,"포레스트북스"));
		bookList.add(new BookDTO("채식주의자","한강",15000,"창비"));
		bookList.add(new BookDTO("작별하지 않는다","한강",16800,"문학동네"));
		bookList.add(new BookDTO("모순","양귀자",13000,"창비"));
	}

	
	
	public List<BookDTO> getBookList() {
		return bookList;
	}

	/** 전달 받은 index 번째 bookList 요소 반환
	 * 단, 범위 초과시 null 반환
	 * @param index
	 * @return BookDTO 참조 주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		
		// 범위초과 검사 -> 초과시
		if(checkIndex(index) == false) {
			return null;
		}
		
		return bookList.get(index);
	}
	
	/**
	 * 전달받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정산 true, 아니면 false
	 */
	public boolean checkIndex(int index) {
		
		// 범위 초과시 false
		if(index < 0 || index >= bookList.size()) {
			return false;
		}
		return true; // 정상 범위 true
	}
	
	/** 전달받은 book을 bookList에 추가
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가X
	 * @param book
	 * @return 추가 O : true, 추가 X : false 반환
	 */
	public boolean addBook(BookDTO book) {
		
		// 책 정보 비교 방법 1) 필드값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용
//		for ( BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// BookDTO의 equals()를 오버라이딩했기 때문에
		// List가 제공하는 contains() (포합하는지 확인) 사용 가능
		if(bookList.contains(book)) return false;
		
		return bookList.add(book); 
		// 컬렉션은 크기 제한이 없기때문에 무조건 추가 성공 (true 반환 고정)
		
		
	}

	/** 전달받은 index번째 요소의 가격을 newPrice로 수정
	 * 
	 * @param index
	 * @param newPrice
	 * @return "[책제목] 가격이 [이전가격] -> [수정된 가격]으로 수정되었습니다"
	 */
	public String modifyBookPrice2(int index, int newPrice) {
//		selectIndex(index);
		BookDTO target = bookList.get(index); // 인덱스번째 요소 얻어오기
		int oldPrice = target.getPrice(); // 이전 가격 저장
		target.setPrice(newPrice); // 새 가격으로 수정
		
		return String.format("[%s] 가격이 [%d]원 -> [%d]원으로 수정되었습니다.\n", target.getTitle(), oldPrice, newPrice);
	}
	
	/** index번째 BookDTO 제거
	 * 단, 없으면 null반환
	 * @param index 
	 */
	public BookDTO removeBook(int index) {
	
	if(checkIndex(index) == false) return null;
	
	return bookList.remove(index);
	// bookList에서 index번째 요소를 제거
	// == index번째 요소를 뽑아냄
	}
	
	/** 제목이 일치하는 책 반환
	 * @param title : 찾으려는 책 제목
	 */
	public BookDTO selectTitle(String title) {
		for(BookDTO book : bookList) { //bookList에서 하나씩 꺼냄
			
			// 꺼낸 책의 제목과 전달 받은 책의 제목이 같을경우
			if(book.getTitle().equals(title))return book;
			
		}return null; // 책을 못찾은 경우
	}

	public boolean removeBookTitle(String title) {
		for(BookDTO book : bookList) {
			if(book.getTitle().equals(title)) {
				return bookList.remove(book);
			}
		}return false;
	}
	
	// 출판사명으로 모두 조회하기
	public List<BookDTO> selectPublisherAll(String publisher) {
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList ) {
			if(book.getPublisher().equals(publisher)) {
				box.add(book);
			}
		}
		return box; 
	}
	
	// 저자명 모두 조회하기
	public List<BookDTO> selectAuthorAll(String author) {
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList ) {
			if(book.getAuthor().equals(author)) {
				box.add(book);
			}
		}
		return box; 
	}
	
	// 검색어가 제목,저자에 포함된 모든 책 조회하기
	public List<BookDTO> searchBook(String keyword) {
		List<BookDTO> box = new ArrayList<BookDTO>();
		for(BookDTO book : bookList ) {
			if(book.getTitle().contains(keyword) 
					|| book.getAuthor().contains(keyword)) {
				box.add(book);
			}
		}
		return box; 
	}
	
	public void bookListSorting() {
		
		Collections.sort(bookList);
		// 원본 리스트가 정렬된 형태로 변경
		
	}
	
	
}