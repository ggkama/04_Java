package loop.practice;

import java.util.Scanner;

/**
 * 기능 제공용 클래스
 */


public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
	 * 단, 입력한 수는 1보다 크거나 같아야 합니다.
	 * 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요
	 */
	
	public void practice1() {
		 
		 System.out.print("숫자 입력 : ");
		 int num = sc.nextInt();
		 
		 for(int i = num ; i >= 1 ; i-- ) {
			 System.out.print(i);
		 } 
		 if(num <= 0){
			 System.out.println(" 1 이상의 숫자를 입력하세요 ");
		 }
	}
	
	/**
	 * 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
	 * 단, 입력한 수는 1보다 크거나 같아야 합니
	 */
	public void practice2() {
		 
		 System.out.print("숫자 입력 : ");
		 int num = sc.nextInt();
		 
		 for(int i=num ; i >= 1 ; i--) {
			 System.out.print(i);
		 } 
		 if(num <= 0){
			 System.out.println(" 1 이상의 숫자를 입력하세요 ");
		 }
	}
	
	/**
	 * 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 for문을 이용하여 출력하세요
	 */
		
		public void practice3() {
			System.out.print("숫자 입력 : ");
			 int num = sc.nextInt();
			 
			 int sum = 0;
			 
			 for (int i = 1 ; i <= num ; i++) {
				 
				 System.out.print(sum);
			 }
		}
		
		
		/**
		 * 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		 * 만일 1 미만의 숫자가 입력됐다면 “1 이상의 숫자를 입력해주세요“를 출력하세요
		 */
		
		public void practice4() {
			System.out.print("숫자1 입력 : ");
			 int num1 = sc.nextInt();
				System.out.print("숫자2 입력 : ");
				 int num2 = sc.nextInt();
				 
				 int start = num1;
					int end = num2;
					
					if(num1 <= 0) {
						System.out.println("1 이상의 숫자만 입력해주세요.");
						return;
					} else if (num2 <= 0) {
						System.out.println("1 이상의 숫자만 입력해주세요.");
						return;
					}
					
					if(num1 > num2) {
						start = num2;
						end = num1;				
					}
					for(int i=start ; i<=end ; i++) {
						System.out.print(i + " ");
					} 
		}
					
					
					
		public void practice5() {
			System.out.print("숫자 : ");
			int dan = sc.nextInt();
			System.out.printf("==== %d단 ====\n", dan);
			
			for(int i=1 ; i<=9 ; i++) {
				System.out.printf("%2d x %2d = %2d\n", dan, i, dan*i);
				
			}
			
		}
		
		
		
		public void practice6() {
			
			System.out.print("숫자 : ");
			int num = sc.nextInt();
			if( 2>= num || num >= 10) {
				System.out.printf("2~9사이 숫자만 입력해주세요");
				return;
			}
			int dan = num;
			
			for(int i=2 ; i<=9 ; i++) {
				System.out.printf("==== %d단 ====\n", dan);
				System.out.printf("%2d x %2d = %2d\n", dan, i, dan*i);
				
			}
		}
				 
		
		
		
		
		
		
//		public void practice7() {
//			System.out.print("정수 입력 : ");
//			int num = sc.nextInt();
//			
//				for (int i = 1; i <= num; i++) {
//      
//          for (int j = 1; j <= i; j++) {
//          	System.out.printf("*");
//          }
//          System.out.println();
//		}
//				
//		}
		
		// 강사님 답
		public void practice7() {
			System.out.print("정수 입력");
			int input = sc.nextInt();
			
			for(int row =1 ; row <= input; row++) {
				for(int col = 1 ; col<= input ; col++) {
					System.out.printf("*");
				}
				System.out.println();
			}
		}
		
		
		
		public void practice8() {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			
				for (int i = num ; i >= 1; i--) {
      
          for (int j = 1; j <= i ; j++) {
          	System.out.printf("*");
          }
          System.out.println();
		}
				
		}
		
		
		
		public void practice9() {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			
				for (int i = 1; i <= num; i++) {
      
          for (int j = 1; j <= num-i; j++) {
          	System.out.printf(" ");
          }
          for (int k = 1; k <= i; k++) {
          	System.out.printf("*");
          }
          System.out.println();
		}
			
		}
		
		
		public void practice10() {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			for (int i = 1; i <= num; i++) {
	      
        for (int j = 1; j <= i; j++) {
        	System.out.printf("*");
        }
System.out.println();
      }
			
			for (int i = num-1; i >= 1; i--) {
	      
        for (int j = 1; j <= i; j++) {
        	System.out.printf("*");
        }
        System.out.println();
			}
		}
		
		
		public void practice11() { //2n-1
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			
				for (int i = 1; i <= num; i++) {
      
          for (int j = 1; j <= 2*i-1; j++) {
          	System.out.printf(" ");
        }
          for (int k = 1; k <= i; k++) {
          	System.out.printf("*");
        }
          System.out.println();
		}
		}
		
		

		
		
		
		
		
		public void practice12() {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
	
			
			for (int i = 1; i <= num; i++) {
				
				for(int j=1 ; j <= num ; j++) {
					
					if(i == 1 || i == num || j == 1 || j == num) {
					
					System.out.print("*");
				}else {
				System.out.println(" ");
        }
					
				}}
		}
    
			


	
		
		
		
		public void practice13() {
			System.out.print(" 자연수 하나를 입력 : ");
			int num = sc.nextInt();
			
			System.out.println("2와 3의 배수 : ");
      int count = 0; 
      for (int i = 1; i <= num; i++) {
          if (i % 2 == 0 || i % 3 == 0) {
              System.out.print(i + " ");
           
              if (i % 2 == 0 && i % 3 == 0) {
                  count++;
              }
          }
      }     
      System.out.println();

      System.out.println("count: " + count);
		}
		

		
		public void practice14() {
			System.out.print(" 숫자 입력 : ");
			int num = sc.nextInt();
			int count = 0;
			
			if(num < 2) {
				System.out.println(" 잘못 입력하셨습니다.");
				return;
			}
			
			for( int i = 1 ; i<=num ; i ++) {
				if(num%i == 0) {
					count ++;
				}
			}
			if(count == 2) {
				System.out.println("소수입니다.");
			} else {
				System.out.println("소수가 아닙니다.");
			}
			
		}
		
		
		public void practice15() {
			System.out.print(" 숫자 입력 : ");
			int num = sc.nextInt();
			int count = 0;
			
			if(num < 2) {
				System.out.println(" 잘못 .");
				return;
			}
			
			for( int i = 1 ; i<=num ; i ++) {
				if(num%i == 0) {
					count ++;
				}
			}
			if(count == 2) {
				System.out.println("소수입니다.");
			} else {
				System.out.println("소수가 아닙니다.");
			}
			
		}
		
		
		
		public void practice16() {
			System.out.print("숫자 : ");
			int num = sc.nextInt();
			
			int count = 0; // 소수의 개수를 세기 위한 변수
			
			// 2부터 입력 받은 수 까지 1개씩 접근하는 for문
			for(int i=2 ; i<=num ; i++) {
				boolean flag = true;
				// true인 경우 : 소수 O
				// false인 경우 : 소수 X
				
				// 1과 자기자신(num)을 뺀 정수를 한개씩 접근
				for(int x=2 ; x<i ; x++) {
				
					if (i % x == 0) { // 1. 자기자신 빼고 나누어 떨어지는 수 존재
						flag = false;
						break;
					}
				}
				if(flag) { // 소수라고 판별된 경우 수행
					System.out.print(i + " ");
					count++;
				}
			}
			System.out.printf("\n2부터 %d까지 소수의 개수는 %d개 입니다 : " , num, count);
			
			
		}
}





		


		
		
	


