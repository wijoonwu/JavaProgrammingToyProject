import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MemberDAO {

    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // MEMBER 테이블 관련 SQL 명령어
    private final String MEMBER_LIST = "select * from MEMBER";
    private final String MEMBER_INSERT = "insert into MEMBER values(?, ?, ?)";
    private final String MEMBER_UPDATE = "update MEMBER set NAME = ?, PHONE_NUMBER = ? where MEMBER_ID = ?";
    private final String MEMBER_DELETE = "delete MEMBER where MEMBER_ID = ?";


    // MEMBER 테이블 관련 CRUD 메소드

    // 회원 삭제
    public void deleteMember(String MemberID) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, MemberID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }


    // 회원 수정
    public void updateMember(MemberVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_UPDATE);
            stmt.setString(1, vo.getMEMBER_ID());
            stmt.setString(2, vo.getNAME());
            stmt.setString(3, vo.getPHONE_NUMBER());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }


    // 회원 등록

    public void insertMember(MemberVO vo) throws SQLException {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, vo.getMEMBER_ID());
            stmt.setString(2, vo.getNAME());
            stmt.setString(3, vo.getPHONE_NUMBER());
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
       } finally {
            JDBCUtil.close(stmt, conn);
        }
    }


    // 회원목록 조회
    public List<MemberVO> getMemberList() throws ListEmptyException{
        List<MemberVO> memberList = new ArrayList<MemberVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_LIST);
            rs = stmt.executeQuery();
                while (rs.next()) {
                    MemberVO memberVO = new MemberVO();
                    memberVO.setMemberId(rs.getString("MEMBER_ID"));
                    memberVO.setNAME(rs.getString("NAME"));
                    memberVO.setPHONE_NUMBER(rs.getString("PHONE_NUMBER"));
                    memberList.add(memberVO);
                }

        } catch (SQLException | IsEmptyException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        if(memberList.isEmpty()){
            throw new ListEmptyException("회원 조회 오류");
        }

        return memberList;
    }

}