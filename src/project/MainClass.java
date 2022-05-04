package project;

public class MainClass {
    public static void main(String[] args) throws Exception {

        MemberManager memberManager = new MemberManager();


        System.out.print("""
                #############################
                ### 회원 관리 프로그램 START ###
                #############################
                """);

        memberManager.readMenu();


        System.out.print("""
                #############################
                ### GOOD-BYE 프로그램 종료 ###
                #############################
                """);


    }
}
