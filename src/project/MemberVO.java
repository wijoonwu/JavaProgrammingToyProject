package project;

public class MemberVO {

    // private 멤버변수 선언
    private String memberID;
    private String name;
    private String phoneNumber;


    // 2. 목록을 조회한다.


    public String getMemberID() {
        return memberID;
    }

    //case2 등록
    public void setMemberID(String memberId) throws IsEmptyException {
        this.memberID = memberId;
        if (memberID.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류1");
        }
    }

    //case1 목록조회
    public void setMemberId(String MEMBER_ID) {
        this.memberID = MEMBER_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IsEmptyException {
        this.name = name;
        if (name.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류2");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) throws IsEmptyException {
        if (phoneNumber.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류3");
        }
        this.phoneNumber = phoneNumber;
    }


    public MemberVO() {
    }

    public MemberVO(String memberID, String name, String phoneNumber)  {
        this.memberID = memberID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "memberId='" + memberID + '\'' +
                        ", name='" + name + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'';
    }

}