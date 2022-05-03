public class UpdateTest {

    public UpdateTest(String id, String phoneNumber) throws IsEmptyException {

        // 1. StudentDAO 객체를 생성한다.
        MemberDAO dao = new MemberDAO();

        // 2. 회원 정보를 수정한다.
        MemberVO vo = new MemberVO();
        vo.setMEMBER_ID(id);
        vo.setPHONE_NUMBER(phoneNumber);
        dao.updateMember(vo);

    }


    }
