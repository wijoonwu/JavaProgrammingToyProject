import java.util.List;

public class Update {
    public Update(String id, String number) throws IsEmptyException, ListEmptyException, OverlapIdException {

            MemberDAO dao = new MemberDAO();
            List<MemberVO> memberList = dao.getMemberList();
            for (MemberVO member : memberList) {
                if (member.getMEMBER_ID().equals(id)) {
                    member.setPHONE_NUMBER(number);
                    dao.updateMember(member);
                }
            }
        }

        }



