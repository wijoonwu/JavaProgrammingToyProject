package project;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MemberManager {
    private static final Scanner sc = new Scanner(System.in);
    static String memberID;

    static void readMenu() throws IsEmptyException {

        MemberDAO dao = new MemberDAO();
        MemberVO vo = new MemberVO();

        while (true) {
            System.out.print("""
                    목록을 원하시면 1번을 입력하세요.
                    등록을 원하시면 2번을 입력하세요.
                    수정을 원하시면 3번을 입력하세요.
                    삭제를 원하시면 4번을 입력하세요.
                    종료를 원하시면 0번을 입력하세요.
                    """);
            int task = sc.nextInt();

            switch (task) {
                case 0 -> {
                    return;
                }
                //회원 목록 조회
                case 1 -> {
                    List<MemberVO> memberList = dao.getMemberList();
                    if (memberList.isEmpty()) {
                        System.out.println("등록된 회원이 없습니다.");
                    } else {
                        System.out.println("현재 등록된 회원 목록입니다.");
                        System.out.print("---> Member");
                        System.out.println(memberList);
                    }
                }

                //  회원 등록
                case 2 -> {
                    try {
                        System.out.print("아이디를 입력하세요. (형식 M-00001):");
                        String br = sc.nextLine();
                        memberID = sc.nextLine();

                        if (idExistsCheck(memberID)) {
                            System.out.println(memberID + "가 이미 존재합니다.");
                            break;
                        } else if (IdFormCheck(memberID)) {
                            vo.setMemberID(memberID);
                        } else {
                            System.out.println("아이디는 'M-'로 시작해야 하며, M-를 포함하여 7개의 문자로 구성해야 합니다.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("아이디는 필수입력 항목입니다.");
                        break;
                    }
                    try {
                        System.out.print("이름을 입력하세요 :");
                        String name = sc.nextLine();
                        vo.setName(name);

                    } catch (IsEmptyException e) {
                        System.out.println("이름은 필수입력 항목입니다.");
                        break;
                    }
                    System.out.print("전화번호를 입력하세요 :");
                    String phoneNumber = sc.nextLine();

                    if (phoneNumber == "") {
                        System.out.println("전화번호는 필수입력 항목입니다.");
                        break;
                    } else if (!PhoneNumberCheck(phoneNumber)) {
                        System.out.println("전화번호는 두 개의 '-'를 포함하여 총 13개의 문자로 구성해야 합니다.");
                        break;
                    } else vo.setPhoneNumber(phoneNumber);


                    try {
                        dao.insertMember(vo);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("---> 회원가입에 성공하셨습니다.");
                }

                // 회원 정보 수정
                case 3 -> {
                    System.out.print("수정할 아이디를 입력하세요. (형식 M-00001):");
                    String editMemberID = sc.next();
                    if (idExistsCheck(editMemberID)) {
                        System.out.print("수정할 전화번호를 입력하세요 :");
                        String editPhoneNumber = sc.next();
                        System.out.println("---> 회원수정에 성공하셨습니다.");
                        try {
                            new Update(editMemberID, editPhoneNumber);
                        } catch (IsEmptyException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.printf("수정할 %s회원 정보가 존재하지 않습니다.\n", editMemberID);
                    }
                }

                // 회원 삭제
                case 4 -> {
                    System.out.print("삭제할 아이디를 입력하세요. (형식 M-00001):");
                    String delMemberID = sc.next();
                    if (!idExistsCheck(delMemberID)) {
                        System.out.printf("삭제할 %s회원 정보가 존재하지 않습니다.\n", delMemberID);
                        break;
                    }
                    dao.deleteMember(delMemberID);
                    System.out.println(delMemberID + "회원 삭제에 성공하셨습니다.");
                }
                default -> readMenu();
            }
        }

    }


    // ID 중복 체크 및 회원 수정, 회원 삭제 시 ID 존재 검증
    public static boolean idExistsCheck(String memberId) {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> memberList = dao.getMemberList();
        boolean ok = false;
        int i = 0;
        for (MemberVO member : memberList) {
            if (member.getMemberID().equals(memberId)) {
                i++;
            }
        }
        if (i > 0) {
            ok = true;
        }
        return ok;
    }

    // 회원등록 시 ID 형식 체크
    public static boolean IdFormCheck(String memberId) {
        return Pattern.matches("^(M)-\\d{5}$", memberId);
    }

    // 회원등록 시 전화번호 형식 체크
    public static boolean PhoneNumberCheck(String phoneNumber) {
        return Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", phoneNumber);
    }


}