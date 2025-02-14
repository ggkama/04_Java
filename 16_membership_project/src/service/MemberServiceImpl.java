package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NameList;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
 * - 인터페이스를 상속 받아 구현하면
 *   모든 자식 클래스가 똑같은 기능을 가지게되어
 *   비슷하게 생김!
 *
 *  -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
 *    ==> 유지보수성 증가
 */

// MemberService를 상속 받아 구현
public class MemberServiceImpl implements MemberService{

    // dao 객체 부모 참조 변수 선언
    private MemberDAO dao = null;
    private String[] gradeArr = {"일반", "골드", "다이아"};


    // 기본 생성자
    // - MemberServiceImpl 객체 생성 시
    //   MemberDAOImpl 객체도 생성
    public MemberServiceImpl() 
    		throws FileNotFoundException, ClassNotFoundException, IOException {
        dao = new MemberDAOImpl();
    }

    
    //********************************
    // 추가, 수정 삭제 기능이 수행되면
    // 무조건 dao.saveFile() 수행!
    //********************************

    // 회원 추가
    @Override
    public boolean addMember(String name, String phone) throws IOException {
    	for(Member m : dao.getMemberList()) {
    		if(m.getPhone().equals(phone)) {
    			return false;
    		}
    	}
    		if(name == null || phone == null) {
    			return false;
    		}
    		Member member = new Member(name,phone,0,0);
    		if(!dao.addMember(member)) {
    			return false;
    		}
        return true;
    }


    // DAO에서 조회한 memberList를 그대로 반환
    @Override
    public List<Member> getMemberList() {
    	
        return dao.getMemberList();
    }


    // 이름 검색
    @Override
    public List<Member> selectName(String searchName) {
        List<Member> resultList = new ArrayList<>(); 
        for (Member member : dao.getMemberList()) { 
            if (member.getName().equals(searchName)) {
                resultList.add(member);
            }
        }
        return resultList;
    }


    // 금액 누적
    // 1. 기존 금액에 새로운 금액 추가
    // 2. 등급 변경 기능
    // 3. 변경된 내용 dao 저장
    // 4. 등급 변경 결과 메시지 출력
    @Override
    public String updateAmount(Member target, int acc) throws IOException {
    // 기존 금액에 새로운 금액을 추가
    int prevAmount = target.getAmount();
    int newAmount = prevAmount + acc;
    target.setAmount(newAmount);

    // 등급 변경 기능
    int prevGradeIndex = target.getGrade();
    int newGradeIndex;

    if (newAmount >= 1000000) {
        newGradeIndex = Member.DIAMOND; // 다이아
    } else if (newAmount >= 100000) {
        newGradeIndex = Member.GOLD; // 골드
    } else {
        newGradeIndex = Member.COMMON; // 일반
    }

    target.setGrade(newGradeIndex);

    // 변경 사항 저장
    dao.saveFile();

    // 결과 메시지 반환
    String result = prevAmount + " -> " + newAmount;
    if (prevGradeIndex != newGradeIndex) {
        result += "\n * " + gradeArr[newGradeIndex] + " * 등급으로 변경 되셨습니다.";
    }

    return result;
}
    	
    


    //회원 정보(전화번호) 수정
  
    @Override
    public String updateMember(Member target, String phone) throws IOException {
    	String prePhone = target.getPhone();
    	
    	for(Member m : dao.getMemberList()) {
    		if(m.getPhone().equals(phone)) {
    			return "### 중복되는 휴대폰 번호가 존재합니다 ###";
    		}
    	}
    	
      // 전화번호 변경
      target.setPhone(phone);

      // 변경 사항 저장
      dao.saveFile();

      // 결과 메시지 반환
      return target.getName() + "님의 전화번호가 변경 되었습니다.\n" 
      + prePhone + " -> " + phone;
      
      
    }



    // 회원 탈퇴
    @Override
    public String deleteMember(Member target) throws IOException {
    	int index = dao.getMemberList().indexOf(target);
    	dao.getMemberList().remove(index);
//    	boolean res = dao.getMemberList().remove(target);
    	// 변경사항 저장 
    	dao.saveFile();
//    	res()
      return null;
    }
    
    

}