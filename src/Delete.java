public class Delete {
    public Delete(String memberId) throws IsEmptyException{

        // 1. 회원 객체를 생성한다.
        MemberDAO dao = new MemberDAO();

        // 2. 회원 정보를 삭제한다.
        dao.deleteMember(memberId);

    }
}