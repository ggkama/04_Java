package view;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

// View : 사용자에게 보여지는 역할을 하는 클래스/객체
// - 보여줄 화면을 출력 / 필요한 데이터를 입력
public class MemberView {

	private MemberService service = null;
	private Scanner sc = null;
	BufferedReader br = null;

	/**
	 * 기본 생성자 - MemberView 객체 생성 시 필드 초기화 - MemberService 초기화 시 예외가 발생할 수 있으므로 try -
	 * catch 작성
	 */
	public MemberView() {

		try {
			// 객체 생성 중 발생한 예외를 View에 모아서 처리
			service = new MemberServiceImpl();

			// 키보드를 입력 받기 위한 스트림 생성
			sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

		} catch (Exception e) {

			System.out.println("*** 프로그램 실행 중 오류 발생 ***");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
	}

	// -------------------------------------------------------------------
	// [메인 메뉴]
	public void mainMenu() {

		int input = 0;
		do {

			try {
				// 메뉴 출력 후 입력된 번호를 반환 받기
				System.out.println("\n===== 회원 관리 프로그램 =====\n");

				System.out.println("1. 회원 가입(추가)");
				System.out.println("2. 회원 전체 조회");
				System.out.println("3. 이름 검색(동명이인 있으면 모두 조회)");
				System.out.println("4. 특정 회원 사용 금액 누적하기");
				System.out.println("5. 회원 정보 수정");
				System.out.println("6. 회원 탈퇴");
				System.out.println("0. 종료");

				System.out.print("메뉴 선택 >>> ");

				// 입력 받은 문자열을 int 형태로 변환
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				System.out.println(); // 줄바꿈

				// 선택된 메뉴 번호에 따라 case 선택
				switch (input) {
				case 1: addMember(); break;
				case 2: selectAll(); break;
				case 3:	selectName(); break;
				case 4: updateAmount();	break;
				case 5:	updateMember();	break;
				case 6:	deleteMember();	break;
				case 0:	System.out.println("*** 프로그램 종료 ***");	break;
				default:	System.out.println("### 메뉴에 작성된 번호만 입력 해주세요 ###");
				}
				System.out.println("==========================================");

				
				/* 모든 메서드에서 던져진 예외를 모아서 처리*/
			} catch (NumberFormatException e) {
				System.out.println("\n### 숫자만 입력 해주세요 ###\n");
				input = -1; // 첫 반복에서 종료되지 않게 값 변경

			} catch (IOException e) {
				System.out.println("\n### 입출력 관련 예외 발생 ###\n");
				e.printStackTrace(); // 예외 추적

			} catch (Exception e) { // 나머지 예외 처리
				e.printStackTrace();
			}

		} while (input != 0);
	}

	
	// ---------------------------------------------------------------
	// [1. 회원 가입(추가)]
	public void addMember() throws IOException {
		System.out.println("\n----- 회원 가입(추가) -----\n");

		System.out.println("이름 입력 : ");
		String name = sc.next();
		
		System.out.println("전화번호 입력 : ");
		String phone = sc.next();
		
		boolean result = service.addMember(name, phone);
		
		if(result) {
			System.out.println("추가완료");
		}else {
			System.out.println("추가실패");
		}

	}

	
	// -------------------------------------------------------------
	// [2. 회원 전체 조회]
	public void selectAll() {
		System.out.println("\n----- 회원 전체 조회 -----\n");
		
		// view <-> service <-> dao
		List<Member> memberList = service.getMemberList();
		// 회원 목록 출력 (추가해야함)
		memberList.stream().forEach(member -> System.out.println(member));
		
	}

	// ------------------------------------------------------------------------
	// [3. 이름으로 검색(동명이인)]
	public void selectName() throws IOException {
		System.out.println("\n----- 이름 검색(동명이인 있으면 모두 조회) -----\n");
		System.out.println("검색할 이름 입력 : ");
		String name = sc.next();
		 List<Member> searchResults = service.getMemberList();
		
		if (searchResults.isEmpty()) {
      System.out.println("검색 결과가 없습니다.");
  } else {
      System.out.println("\n검색 결과:");
      for (Member member : searchResults) {
          System.out.println(member); // Member 클래스의 toString()이 정의되어 있어야 함
      }
  }
		

	}

	// ------------------------------------------------------------
	// [4. 특정 회원 사용 금액 누적하기]
	// 중복된 회원이 있는지 확인 - for
	// 1. 중복된 값이 없을때 - 이름이없다 출력 
	// 2. 있음 if
	// 2-1. 회원이름이 2개이상일때 - 이름 출력 
	// 2-1-1 이름 선택
	// 3. 회원이름 1개일때 금액 입력 받기
	// 4. 누적금액 출력 
	// 5. 등급 출력
	public void updateAmount() throws IOException {

		List<Member> searchResults = null; // 이름이같은 멤버를 받을 리스트
		int num = 0;// 선택할 인덱스 받을 int
		
		System.out.println("\n----- 특정 회원 사용 금액 누적하기 -----\n");
		// 회원이름 받기
		System.out.println("회원 이름 입력 : ");
		String name = sc.next();

		searchResults = service.selectName(name);
		
		if(searchResults.isEmpty()) {// searchResults가 비었을때
			System.out.println("이름이 존재하지 않음");
		}else { // searchResults에 멤버가 있을때 
			if(searchResults.size()!=1) {// 2-1. 회원이름이 2개이상일때 - 이름 출력 
				System.out.println(" *** 대상 회원을 선택 *** ");
				for(int i = 0; i < searchResults.size(); i++) {
					System.out.printf("%d) %s (%s)\n",i+1,searchResults.get(i).getName(),searchResults.get(i).getPhone());
					
				}
				System.out.println("선택할 회원의 번호를 입력 : "); //2-1-1 이름 선택
				num = sc.nextInt();
			} 	
		}
		// 누적금액 입력받기
		System.out.println("누적할 금액 입력 : ");
		int acc = sc.nextInt();
		// 00000 -> 100000 출력
		String result = service.updateAmount(searchResults.get(num-1),acc);
		
		// * OO * 등급으로 변경 되었습니다. 출력
		System.out.println(result);
		
	}
	

	// -----------------------------------------------------------------
	// [5.회원 정보 수정]
	
	// 1. 이름 입력받기
	// 2. 이름이 없을때 -> 없음 출력
	// 2.1 이름이 1개있을때 -> 전화번호 수정으로 이동
	// 2.2 이름이 2개이상있을때 -> 이름 선택창 출력
	// 2.2.1 수정할 이름 선택 -> 전화번호 수정으로 이동
	// 3. 전화번호 수정값 받기
	// 4. 완료메세지 출력
	
	public void updateMember() throws IOException {
		List<Member> searchResults = null;
		int num = 0;
		
		System.out.println("\n----- 회원 정보 수정 -----\n");
		System.out.println("수정할 회원 이름 입력 : "); // 이름 입력받기
		String name= sc.next();
		
		searchResults = service.selectName(name);
		
		if(searchResults.isEmpty()) { // 이름이 없을때 -> 없음 출력
			System.out.println("이름이 존재하지 않음");
		}else 
			if(searchResults.size()!=1) {// 2-1. 회원이름이 2개이상일때 - 이름 출력 
			System.out.println(" *** 대상 회원을 선택 *** ");
			for(int i = 0; i < searchResults.size(); i++) {
				System.out.printf("%d) %s (%s)\n",i+1,searchResults.get(i).getName(),searchResults.get(i).getPhone());
				
			}
			System.out.println("선택할 회원의 번호를 입력 : "); //2-1-1 이름 선택
			num = sc.nextInt();
		} 	
		// 변경할 전화번호 입력받기
		System.out.println("수정할 전화번호 입력 : ");
		String phone = sc.next();
		
		String result = service.updateMember(searchResults.get(num-1),phone);
		
		System.out.println(result);
		
		
		
	}

	
	// ------------------------------------------------------------
	// [6.회원 탈퇴]
	
	// 1. 회원 이름 입력받기
	// 2. 이름이 없을때 -> 존재하지않는이름 출력
	// 3. 이름이 있을때 
	// 3.1 1개인경우 -> 4로 이동
	// 3.2 2개이상인 경우 ->이름 선택창 출력 -> 4로 이동
	// 4. 삭제여부 물어보기 출력 y/n
	// 4.1 y일때 삭제 서비스 호출 
	// 4.2 n일때 삭제 안함 메시지 출력
	// 4.3 y/n 둘다 아닐때 잘못입력했다는 메시지
	// 5. 삭제 후 삭제완료 출력
	public void deleteMember() throws IOException {
		List<Member> searchResults = null;
		int num = 0;
		
		System.out.println("\n ----- 회원 탈퇴 ----- \n");
		System.out.println("회원 이름 입력 : "); // 회원이름 입력받기
		String name = sc.next();
		searchResults = service.selectName(name);
		
		if(searchResults.isEmpty()) { // 이름이 없을때 -> 없음 출력
			System.out.println("이름이 존재하지 않음");
		}else 
			if(searchResults.size()!=1) {// 회원이름이 2개이상일때 - 이름 출력 
			System.out.println(" *** 대상 회원을 선택 *** ");
			for(int i = 0; i < searchResults.size(); i++) {
				System.out.printf("%d) %s (%s)\n",i+1,searchResults.get(i).getName(),searchResults.get(i).getPhone());
				
			}
			System.out.println("선택할 회원의 번호를 입력 : "); // 이름 선택
			num = sc.nextInt()-1;
		}
		
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
    String confirm = sc.next();
    
    if (confirm.equals("y")) {
        String result = service.deleteMember(searchResults.get(num));
        System.out.println(result);
    } else if (confirm.equals("n")) {
        System.out.println("회원 삭제를 취소하였습니다.");
    } else {
        System.out.println("잘못 입력하셨습니다.");
    }
}
		
		
	}
