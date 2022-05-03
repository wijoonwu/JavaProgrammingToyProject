import java.util.List;

public class SelectTest {

    public static void main(String[] args) throws IsEmptyException {
        MemberDAO dao = new MemberDAO();

        // 2. 목록을 조회한다.
        List<MemberVO> memberList = dao.getMemberList();
    }
}