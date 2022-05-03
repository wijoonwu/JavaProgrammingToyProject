
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class MemberManager {
    static Scanner sc = new Scanner(System.in);

    public static void readMenu() {

        System.out.print("목록을 원하시면 1번을 입력하세요.\n" +
                "등록을 원하시면 2번을 입력하세요.\n" +
                "수정을 원하시면 3번을 입력하세요.\n" +
                "삭제를 원하시면 4번을 입력하세요.\n" +
                "종료를 원하시면 0번을 입력하세요.\n");
        task = sc.nextInt();
    }

    static int task;

    public static <function> void main(String[] args) throws SQLException, IsEmptyException, ListEmptyException {

        MemberDAO dao = new MemberDAO();
        MemberVO vo = new MemberVO();


        System.out.println("#############################");
        System.out.println("### 회원 관리 프로그램 START ##");
        System.out.println("#############################");
        readMenu();

        while (true) {
            switch (task) {
                case 1:
                    try {
                        dao.getMemList();
                    } catch (ListEmptyException e) {
                        System.out.println("등록된 회원이 없습니다.");
                    } finally {
                        readMenu();
                        break;
                    }

                case 2:
                    String memberID = null;
                    try {
                        System.out.print("아이디를 입력하세요. (형식 M-00001):");
                        String br = sc.nextLine();
                        memberID = sc.nextLine();

                        if (idExistsCheck(memberID)) {
                            System.out.println(memberID + "가 이미 존재합니다.");
                            readMenu();
                            break;
                        } else if (!IdFormCheck(memberID)) {
                            System.out.println("아이디는 'M-'로 시작해야 하며, M-를 포함하여 7개의 문자로 구성해야 합니다.");
                            readMenu();
                            break;

                        } else {
                            vo.setMEMBER_ID(memberID);
                        }
                    } catch (IsEmptyException e) {
                        System.out.println("아이디는 필수입력 항목입니다.");
                        readMenu();
                        break;
                    } catch (ListEmptyException l) {
                        vo.setMEMBER_ID(memberID);
                    }


                    try {
                        System.out.print("이름을 입력하세요 :");
                        String name = sc.nextLine();
                        vo.setNAME(name);

                    } catch (IsEmptyException e) {
                        System.out.println("이름은 필수입력 항목입니다.");
                        readMenu();
                        break;
                    }

                    try {
                        System.out.print("전화번호를 입력하세요 :");
                        String phoneNumber = sc.nextLine();

                        if (!PhoneNumberCheck(phoneNumber)) {
                            System.out.println("전화번호는 두 개의 '-'를 포함하여 총 13개의 문자로 구성해야 합니다.");
                            readMenu();
                            break;
                        } else vo.setPHONE_NUMBER(phoneNumber);

                    } catch (IsEmptyException e) {
                        System.out.println("전화번호는 필수입력 항목입니다.");
                        readMenu();
                        break;
                    }
                    dao.insertMember(vo);
                    System.out.println("---> 회원가입에 성공하셨습니다.");
                    readMenu();
                    break;

                case 3:
                    System.out.print("수정할 아이디를 입력하세요. (형식 M-00001):");
                    String editMemberID = sc.next();
                    if (idExistsCheck(editMemberID)) {
                        System.out.print("수정할 전화번호를 입력하세요 :");
                        String editPhoneNumber = sc.next();
                        System.out.println("---> 회원수정에 성공하셨습니다.");
                        new Update(editMemberID, editPhoneNumber);
                    } else {
                        System.out.printf("수정할 %s회원 정보가 존재하지 않습니다.\n", editMemberID);
                    }
                    readMenu();
                    break;

                case 4:
                    System.out.print("삭제할 아이디를 입력하세요. (형식 M-00001):");
                    String delMemberID = sc.next();
                    if (!idExistsCheck(delMemberID)) {
                        System.out.printf("삭제할 %s회원 정보가 존재하지 않습니다.\n", delMemberID);
                        readMenu();
                        break;
                    }
                    new Delete(delMemberID);
                    System.out.println(delMemberID + "회원 삭제에 성공하셨습니다.");
                    readMenu();
                    break;

                default:
                    readMenu();
                    break;

            }
            if (task == 0) {
                System.out.println("#############################");
                System.out.println("### GOOD-BYE 프로그램 종료 ###");
                System.out.println("#############################");
                return;
            }
        }

    }

    public static boolean idExistsCheck(String memberId) throws ListEmptyException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> memberList = dao.getMemberList();
        boolean ok = false;
        int i = 0;
        for (MemberVO member : memberList) {
            ok = member.getMEMBER_ID().equals(memberId);
            if (ok) {
                i++;
            }
        }
        if (i > 0) {
            ok = true;
        }
        return ok;
    }

    public static boolean IdFormCheck(String memberId) {
        String check = memberId.substring(0, 2);
        boolean ok;
        ok = check.equals("M-") && memberId.length() == 7;
        return ok;
    }

    public static boolean PhoneNumberCheck(String phoneNumber) {
        boolean ok;
        ok = phoneNumber.contains("-") && phoneNumber.length() == 13;
        return ok;
    }


}


