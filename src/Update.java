import java.util.List;

public class Update {
    public Update(String memberID, String phoneNumber) throws IsEmptyException, ListEmptyException, OverlapIdException {

        MemberDAO dao = new MemberDAO();
        List<MemberVO> memberList = dao.getMemberList();
        for (MemberVO member : memberList) {
            if (member.getMEMBER_ID().equals(memberID)) {
                member.setPHONE_NUMBER(phoneNumber);
                dao.updateMember(member);
            }
        }
    }

}



