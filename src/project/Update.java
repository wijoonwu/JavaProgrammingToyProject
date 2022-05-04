package project;

import java.util.List;

public class Update {
    public Update(String memberID, String phoneNumber) {

        MemberDAO dao = new MemberDAO();
        List<MemberVO> memberList = dao.getMemberList();
        for (MemberVO member : memberList) {
            if (member.getMemberID().equals(memberID)) {
                member.setPhoneNumber(phoneNumber);
                dao.updateMember(member);
            }
        }
    }

}



