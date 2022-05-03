import java.sql.SQLException;

public class MemberVO {

    // private 멤버변수 선언
    private String MEMBER_ID;
    private String NAME;
    private String PHONE_NUMBER;

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) throws IsEmptyException {
        this.MEMBER_ID = MEMBER_ID;
        if(MEMBER_ID.equals("")){
            throw new IsEmptyException("필수입력 항목 오류");
        }
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) throws IsEmptyException {
        this.NAME = NAME;
        if(NAME.equals("")){
            throw new IsEmptyException("필수입력 항목 오류");
        }
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;

    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) throws IsEmptyException {
        this.PHONE_NUMBER = PHONE_NUMBER;
        if(PHONE_NUMBER.equals("")){
            throw new IsEmptyException("필수입력 항목 오류");
        }
    }

    public MemberVO() {
    }

    public MemberVO(String MEMBER_ID, String NAME, String PHONE_NUMBER) {
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