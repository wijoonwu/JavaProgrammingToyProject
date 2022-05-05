package project;

public class MainClass {
    public static void startProgram() {
        System.out.print("""
                #############################
                ### 회원 관리 프로그램 START ###
                #############################
                """);
    }

    public static void endProgram() {
        System.out.print("""
                #############################
                ### GOOD-BYE 프로그램 종료 ###
                #############################
                """);
    }

    public static void main(String[] args) throws Exception {

        startProgram();
        MemberManager.readMenu();
        endProgram();


    }
}
