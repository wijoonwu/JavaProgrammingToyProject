import java.util.List;

public class CheckID {
    public static void main(String[] args) throws ListEmptyException {
    // 1. MemberDAO 객체를 생성한다.
    MemberDAO dao = new MemberDAO();

    // 2. 목록을 조회한다.
    List<MemberVO> memberList = dao.getMemberList();

    System.out.println("회원 ID 확인");
    for (MemberVO member : memberList) {
        System.out.println(member.getMEMBER_ID());
    }
}

}
