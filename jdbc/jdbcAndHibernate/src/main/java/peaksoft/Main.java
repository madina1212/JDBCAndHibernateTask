package peaksoft;

import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Util.connectionToDatabase();
//        UserServiceImpl service = new UserServiceImpl();
//        System.out.println( "<<<COMMANDS>>>"+
//                "1 button-> createUsersTable" +
//                "2 button-> dropUsersTable" +
//                "3 button-> saveUser" +
//                "4 button-> removeUserById" +
//                "5 button-> getAllUsers" +
//                "6 button-> cleanUsersTable");
//        Scanner scanner = new Scanner(System.in);
//        while (true){
//            int num = scanner.nextInt();
//            switch (num){
//                case 1:
//                    service.createUsersTable();
//                    break;
//                case 2:
//                    service.dropUsersTable();
//                    break;
//                case 3:
//                    service.saveUser("Tom", "Holand", (byte)19 );
//                    service.saveUser("Peter", "Parker", (byte)30 );
//                    service.saveUser("Tim", "Cook", (byte)27 );
//                    service.saveUser("Elon", "Mucsk", (byte)48 );
//                    break;
//                case 4:
//                    service.removeUserById(3);
//                    break;
//                case 5:
//                    System.out.println(service.getAllUsers());
//                    break;
//                case 6:
//                    service.cleanUsersTable();
//                    break;
//                default:
//                    System.out.println("Your method is complete!");
//            }
//        }
        Util.getSession();

    }
}
