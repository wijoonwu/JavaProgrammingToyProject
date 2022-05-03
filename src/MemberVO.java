import java.util.List;

public class MemberVO {

    // private 멤버변수 선언
    private String MEMBER_ID;
    private String NAME;
    private String PHONE_NUMBER;


    // 2. 목록을 조회한다.


    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    //case2 등록
    public void setMEMBER_ID(String memberId) throws IsEmptyException, ListEmptyException {
        this.MEMBER_ID = memberId;
        if (MEMBER_ID.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류1");
        }
    }

    //case1 목록조회
    public void setMemberId(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) throws IsEmptyException {
        this.NAME = NAME;
        if (NAME.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류2");
        }
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;

    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) throws IsEmptyException {
        this.PHONE_NUMBER = PHONE_NUMBER;
        if (PHONE_NUMBER.equals("")) {
            throw new IsEmptyException("필수입력 항목 오류3");
        }
    }

    public MemberVO() throws ListEmptyException {
    }

    public MemberVO(String MEMBER_ID, String NAME, String PHONE_NUMBER) throws ListEmptyException {
        this.MEMBER_ID = MEMBER_ID;
        this.NAME = NAME;
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    @Override
    public String toString() {
        return
                "memberId='" + MEMBER_ID + '\'' +
                        ", name='" + NAME + '\'' +
                        ", phoneNumber='" + PHONE_NUMBER + '\'';
    }

}