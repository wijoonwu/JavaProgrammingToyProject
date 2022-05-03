import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberTest {
        static String memberID;
        static String name;
        static String phoneNumber;
        static Scanner sc = new Scanner(System.in);

        public static void guideLine () {

        System.out.print("목록을 원하시면 1번을 입력하세요.\n" +
                "등록을 원하시면 2번을 입력하세요.\n" +
                "수정을 원하시면 3번을 입력하세요.\n" +
                "삭제를 원하시면 4번을 입력하세요.\n" +
                "종료를 원하시면 0번을 입력하세요.\n");
        task = sc.nextInt();
    }

        static int task;

        public static void main (String[]args) throws SQLException, IsEmptyException {


            MemberDAO dao = new MemberDAO();
            MemberVO vo = new MemberVO();

        System.out.println("#############################");
        System.out.println("### 회원 관리 프로그램 START ##");
        System.out.println("#############################");
        guideLine();

        while (task !=0){
            switch (task) {
                case 1:
                    try {
                        System.out.println(dao.getMemberList());
                    } catch (IsEmptyException e) {
                        System.out.println("등록된 회원이 없습니다.");
                    } finally {
                        guideLine();
                    }
                    break;

                case 2:
                    try {

                        System.out.print("아이디를 입력하세요. (형식 M-00001):");
                        String br = sc.nextLine();
                        memberID = sc.nextLine();
                        vo.setMEMBER_ID(memberID);
                    }
                    catch (IsEmptyException e) {
                        System.out.println("아이디는 필수입력 항목입니다.");
                        guideLine();
                        break;
                    }

                    try {
                        System.out.print("이름을 입력하세요 :");
                        name = sc.nextLine();
                        vo.setNAME(name);
                    } catch (IsEmptyException e) {
                        System.out.println("이름은 필수입력 항목입니다.");
                        guideLine();
                        break;
                    }

                    try {
                        System.out.print("전화번호를 입력하세요 :");
                        phoneNumber = sc.nextLine();
                        vo.setPHONE_NUMBER(phoneNumber);
                    }
                    catch (IsEmptyException e) {
                         System.out.println("전화번호는 필수입력 항목입니다.");
                        guideLine();
                        break;
                    }
                        dao.insertMember(vo);
                        System.out.println("---> 회원가입에 성공하셨습니다.");
                        guideLine();
                        break;


                case 3:
                    System.out.print("수정할 아이디를 입력하세요. (형식 M-00001):");
                    String editMemberID = sc.next();
                    System.out.print("수정할 전화번호를 입력하세요 :");
                    String editPhoneNumber = sc.next();
                    System.out.println("---> 회원수정에 성공하셨습니다.");

                    UpdateTest updateTest = new UpdateTest(editMemberID, editPhoneNumber);
                    guideLine();
                    break;

                case 4:
                    System.out.print("삭제할 아이디를 입력하세요. (형식 M-00001):");
                    String delMemberID = sc.next();
                    DeleteTest deleteTest = new DeleteTest(delMemberID);
                    System.out.println(delMemberID + "회원 삭제에 성공하셨습니다.");
                    guideLine();
                    break;

                default: break;

            }
        }
        if (task ==0){
                System.out.println("#############################");
                System.out.println("### GOOD-BYE 프로그램 종료 ###");
                System.out.println("#############################");
        }

    }
}



