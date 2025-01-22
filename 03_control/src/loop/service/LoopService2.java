package loop.service;

import java.util.Scanner;

public class LoopService2 {
	
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("[LoopService2]");
		System.out.println("1. method1()");
		System.out.println("2. method2()");
		System.out.println("3. method3()");
		System.out.println("4. method4()");
		System.out.println("5. method5()");
		System.out.println("6. method6()");

		System.out.print("번호입력 >> ");
		int input =sc.nextInt();
		
		switch(input) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;

		default : System.out.println("잘못 입력");
		}
	}
	
	// 정수 입력 
	// System.out.print("정수 입력 : ");
	// int start = sc.nextInt();

	
	/** 다음 모양 출력하기
	 * <pre>
	 * (0, 0) (0, 1) (0, 2)
	 * (1, 0) (1, 1) (1, 2)
	 * (2, 0) (2, 1) (2, 2)
	 * (3, 0) (3, 1) (3, 2)
	 * </pre>
	 */
	public void method1() {
		// 행 0~3
		// 열 0~2
		for(int row=0 ; row <4 ; row++) {
			for(int col=0 ; col<3 ; col++) {
				
				System.out.printf("(%d, %d) ", row, col);
			}
			System.out.println(); // 줄바꿈
		}
	}
	
	/* 분기문
	 * - break : 현재 반복 종료
	 * 
	 * - continue : 다음 반복으로 넘어가기
	 */
	
	
	/**
	 * 1~20까지 출력
	 * 단, 입력 받은 수에서 반복 멈추기
	 */
	public void method2() {
		
		System.out.printf("stop number: ");
		int stop = sc.nextInt();
		for( int i=1 ; i <= 20 ; i++) {
			System.out.printf(i + " ");
			
			if(i == stop) { // 입력값과 i가 같으면 반복 종료
				break;
			}
		}
	}
	
	/**
	 * 1 ~ 20 까지 출력
	 * 단, 입력 받은 수의 배수는 출력 x
	 */
	public void method3() {
		System.out.printf("continue number: ");
		int con = sc.nextInt();
		for( int i=1 ; i <= 20 ; i++) {
			
			if(i % con == 0) { // 입력값과 i가 같으면 건너뛰기
				continue;
	}
			System.out.printf(i + " ");
		}
	}
	
	/**
	 * 0이 입력 될 때 까지
	 * 입력된 모든 숫자 합계 구하기
	 */
	public void method4() {
		int sum = 0;
		int input = -1;
		while(input != 0) { // 0이 아닐때 반복
			System.out.print("정수 입력 : ");
			input = sc.nextInt(); 
			// 입력 받은 수를 input에 저장 -> while 조건 비교
			sum += input;
			
		}
		
		System.out.printf("합계 : " +sum);
		
	}
	
	
	/* do ~ while 문
	 * 
	 * - while문의 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * 
	 * - 최소 1회 이상의 반복이 보장
	 * 
	 * [작성법[
	 * 
	 * do{
	 * 
	 * 
	 * } while(조건식);
	 * 
	 * 
	 */
	public void method5() {
		int sum = 0;
		int input = 0; // input에 int 기본값 (0) 대입
		
		do{  // 일단 1회 이상은 무조건 방법
			System.out.print("정수 입력 : ");
			input = sc.nextInt(); 
			// 입력 받은 수를 input에 저장 -> while 조건 비교
			sum += input;
			
		}while(input != 0);
		
		System.out.printf("합계 : " +sum);
	}
	
	
	
	
	
}
