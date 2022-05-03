public class DeleteTest {
    public DeleteTest(String id) throws IsEmptyException{

        // 1. StudentDAO 객체를 생성한다.
        MemberDAO dao = new MemberDAO();

        // 2. 학생 정보를 삭제한다.
        dao.deleteMember(id);

    }
}