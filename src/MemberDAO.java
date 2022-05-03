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
    private final String MEMBER_LIST = "SELECT * FROM member";
    private final String MEMBER_INSERT = "INSERT INTO member VALUES (?, ?, ?)";
    private final String MEMBER_UPDATE = "UPDATE member set phone_number = ? WHERE member_id = ?";
    private final String MEMBER_DELETE = "DELETE member WHERE member_id = ?";


    // MEMBER 테이블 관련 CRUD 메소드

    // 회원 삭제
    public void deleteMember(String memberID) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1, memberID);
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
            stmt.setString(1, vo.getPhoneNumber());
            stmt.setString(2, vo.getMemberID());
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
            stmt.setString(1, vo.getMemberID());
            stmt.setString(2, vo.getName());
            stmt.setString(3, vo.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }


    // 회원목록 조회
    public List<MemberVO> getMemberList() {
        List<MemberVO> memberList = new ArrayList<MemberVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                MemberVO memberVO = new MemberVO();
                memberVO.setMemberId(rs.getString("MEMBER_ID"));
                memberVO.setName(rs.getString("NAME"));
                memberVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                memberList.add(memberVO);
            }
        } catch (SQLException | IsEmptyException e) {
            e.printStackTrace();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return memberList;
    }

    public void getMemList() throws ListEmptyException {
        List<MemberVO> memberList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                MemberVO memberVO = new MemberVO();
                memberVO.setMemberId(rs.getString("MEMBER_ID"));
                memberVO.setName(rs.getString("NAME"));
                memberVO.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                memberList.add(memberVO);
            }

        } catch (SQLException | IsEmptyException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        if (memberList.isEmpty()) {
            throw new ListEmptyException("회원 조회 오류");
        }

        System.out.println("현재 등록된 회원 목록입니다.");
        System.out.println("---> Member" + memberList);
    }
}