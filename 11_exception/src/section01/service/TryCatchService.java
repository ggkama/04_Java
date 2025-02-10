package section01.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchService {
	
	private Scanner sc = new Scanner(System.in);
	/* Exception(예외) : 코드로 해결 가능한 에러
	 * (if, try-catch, throws)
	 * 
	 * Exception Handling(예외 처리)
	 *  발생된 예외를 처리하는 구문(try-catch, throws)
	 */
	
	/** try-catch 작성법
	 * <pre>
	 * try {예외가 발생할 것 같은 구문}
	 * - 예외가 발생할 가능성이 있는 코드를 시도하는 구문
	 * 
	 * catch(예외 참조 변수){}
	 * - try에서 던져진 예외를 ()안의 예외 참조변수가 잡아서 처리하는 구문
	 *   -> 잡아서 처리하면 예외가 사라짐
	 *   -> 프로그램이 종료되지 않고 계속 정상수행
	 * 
	 * </pre>
	 */
	public void test1() {

		System.out.println("입력받은 두 정수를 나눈 몫 계산하기_v1");
		
		System.out.println("첫번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		try {
		
		System.out.println("몫: " + num1/num2);
		// ArithmeticException: / by zero
		// -> 산술적 예외 : 0으로 나눌 수 없음
		// + 예외 발생 시 프로그램 비정상 종료
		} catch(ArithmeticException e) {
			// try에서 ArithmeticException 객체가 던져지면
			// 매개변수 e를 이용해서 잡음
			// -> 잡아서 처리 -> 예외 사라짐 -> 프로그램 정상 작동
			System.out.println("0으로 나눌 수 없습니다");
		}
		System.out.println("--- 프로그램 종료 ---");
		
	}
	
	
	public void test2() {
		
		System.out.println("입력받은 두 정수를 나눈 몫 계산하기_v2");
		
		try {
			System.out.println("첫번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두번째 정수 : ");
			int num2 = sc.nextInt();
			
			System.out.println("몫 : " + num1 / num2);
			
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		} catch(InputMismatchException e) {
			// catch는 여러번 작성 가능
			// -> try에서 예외 발생 시
			// 던져진 예외를 잡아서 처리할 수 있는 catch문을
			// 위에서 부터 순서대로 탐색
			// -> 알맞은 catch문에서 예외처리 수행
			System.out.println("정수만 입력해 주세요");
		}
		
		System.out.println("=== 프로그램 종료 ===");
	}
	
	
	/**
	 * 예외처리(try-catch) + 다형성(업 캐스팅)
	 */
	public void test3() {
		
		System.out.println("입력받은 두 정수를 나눈 몫 계산하기_v3");
		
		try {
			System.out.println("첫번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두번째 정수 : ");
			int num2 = sc.nextInt();
			
			System.out.println("몫 : " + num1 / num2);
			
		}catch(RuntimeException e) {
			// ArithemticException과 InputMismatchException의
			// 공통 부모 타입을 매개변수로 선언
			
			// - try에서 예외 발생 시 "예외 객체 참조주소"가 던져짐
			
			// - 업캐스팅 : 
			//   부모타입 참조변수 = 자식객체 참조주소
			
			// * 결론 : 부모 타입 예외 참조 변수로
			//         던져지는 모든 자식 예외를 잡겠다.
			System.out.println("프로그램 실행 중 예외 발생");
			
			// 장점 : 코드 길이 줄이기 가능
			// 단점 : 세세한 예외처리 불가능
			
		}
		
		System.out.println("=== 프로그램 종료 ===");
		
		
	}
	
	/**
	 * 예외처리(try-catch) + 다형성(업 캐스팅) + catch 작성 순서
	 * 
	 * -> catch문은 하위 타입부터 작성
	 * - 서로 상속 관계가 아닌 Exception에 대한 catch 순서는 관계 없음
	 */
	public void test4() {
		
		System.out.println("입력받은 두 정수를 나눈 몫 계산하기_v4");
		
		try {
			System.out.println("첫번째 정수 : ");
			int num1 = sc.nextInt();
			
			System.out.println("두번째 정수 : ");
			int num2 = sc.nextInt();
			
			System.out.println("몫 : " + num1 / num2);
			
			// 강제 예외 발생
			int[] arr = new int[3];
			arr[10] = 100;
			//ArrayIndexOutOfBoundsException: 배열 인덱스 범위 초과
			
		/* [부모타입] 예외처리 구문을 먼저 작성하면 
		 * [자식] 예외처리 구문까지 모두 잡기 때문에
		 * 뒤에있는 [자식] catch문이 절대로 실행될 수 없다
		 * */
		} 
			
			// Unreachable catch block for InputMismatchException.
			// -> 도달할 수 없는 InputMismatchException catch 블록이다
			// == 절대로 실행되지 않는 코드!!
			// It is already handled by the catch block for RuntimeException
			// -> 이미 RuntimeExceptio에서 다루어짐
		catch(InputMismatchException e) {
			System.out.println("정수만 입력해주세요");
			
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
			/* 부모 타입의 catch문은 마지막에 작성*/
		}catch(RuntimeException e) {
			System.out.println("실행 중 예외 발생");
		}
		System.out.println("=== 프로그램 종료 ===");
	}

	/** catch문에 다형성 업캐스팅적용 + 예외 강제 발생
	 *  + 예외 강제 발생(예외를 만들어 던짐)
	 *  
	 *  - 예외도 클래스 -> 객체로 만들 수 있다 -> new 연산자를 사용
	 *  
	 *  - 예외 강제 발생 구문 : throw new 예외클래스();
	 *  
	 */
	public void test5() {
		
		int input = 0;
		
		do {
			System.out.println("---강제로 발생시켜 던질 예외 선택---");
			
			System.out.println("1. ArithmeticException");
			System.out.println("2. ArrayIndexOutOfBoundsException");
			System.out.println("3. RuntimeException");
			System.out.println("4. IOException");
			System.out.println("5. Exception");
			System.out.println("0. 종료");
			
			try {
			System.out.println("예외 선택 >>");
			input = sc.nextInt(); // InputMismatchException 발생가능성 있음
			
			switch(input) {
			case 1:
				throw new ArithmeticException(); /* break; */
			case 2: throw new ArrayIndexOutOfBoundsException();
			case 3: throw new RuntimeException();
			case 4: throw new IOException();
			case 5: throw new Exception();
			}
			
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해주세요");
				sc.nextLine(); // 입력 버퍼에 남은 문자열 제거
				input = -1; // 잘못 입력된 경우 종료되는 것을 방지
			}catch(ArithmeticException e) {
				System.out.println("ArithmeticException() 처리 완료");
				
			}catch(RuntimeException e) {
				System.out.println("ArrayIndexOutOfBoundsException() 처리완료");
				System.out.println("또는");
				System.out.println("RuntimeException 처리 완료");
			
			}catch(Exception e) {
				System.out.println("예외 최상위 부모 Exception으로");
				System.out.println("나머지 모든 예외 잡아서 처리");
			}
			
			
		} while(input !=0);
		
		System.out.println("===프로그램 정상 종료===");
	}

	/* finally{} : 
	 * - 뜻 : 마침내, 마지막으로
	 * - try 구문에서 예외 발생여부 관계없이
	 *   마지막에 무조건 실행되어야하는 코드를 작성하는 구문
	 *   
	 * - 중간에 프로그램이 종료되거나 메서드 리턴되어도 무조건 실행
	 * 
	 * - 외부 프로그램/장치와의 연결을 끊어낼 때 주로 사용
	 * 
	 */
	public void test6() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("1. 정상수행 / 2. 예외 강제 발생");
			int input = sc.nextInt();
			
			if(input == 1) {
				System.out.println("예외없이 정상수행");
			}
			else {
				System.out.println("[예외 강제 발생]");
				throw new Exception("강제로 던져진 예외");
			}
//			} System.out.println("<<<프로그램종료>>>");
		}catch (Exception e) {
			// 예외 객체 참조 변수 e
			// - 예외와 관련된 기능 제공
			
			     /* 에러 출력 */
			System.err.println(e.getMessage());
			// 예외가 던져질 때 담긴 메시지 얻어오기
			return; // 메서드를 종료하고 호출한 곳으로 돌아가기
			
		}finally {
			// try에서 예외 발생 여부 관계 없이 무조건 수행
			System.out.println("<<<프로그램 종료>>>");
			sc.close(); // 키보드와 연결에 사용된 자원 반환
		}
	}
	
	
}
