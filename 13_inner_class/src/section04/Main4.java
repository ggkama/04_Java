package section04;

public class Main4 {

	public static void main(String[] args) {
		
		/* 보통은 인터페이스를 구현한 클래스(구현체)를 이용해서
		 * 객체를 생성
		 * 
		 * 익명 내부 클래스는
		 * 별도의 클래스없이 필요할때 즉석으로 
		 * 미완성 부분인(추상 메서드) 정의
		 */
		
		Animal dog = new Animal() {
			/* Animal 인터페이스를 상속받아 구현하는 
			 * 클래스 선언(클래스명) 없이
			 * 즉석에서 추상 메서드를 오버라이딩
			 * -> 완성된 클래스가 되지만 이름이 없음.
			 *  == 익명 클래스
			 */
			
			@Override
			public void move() {
				System.out.println("dog move");
			}
			
			@Override
			public void eat() {
				System.out.println("dog eat");
			}
		}; // 끝에 ; 필수!
		
		// 익명 내부 클래스는 1회용
		// -> 필요시 다시 정의해야함
		Animal cat = new Animal() {
			
			@Override
			public void move() {
				// TODO Auto-generated method stub
			System.out.println("cat move");	
			}
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("cat eat");
			}
		};
		
		dog.move();
		dog.eat();
		cat.move();
		cat.eat();
		
	}
}
