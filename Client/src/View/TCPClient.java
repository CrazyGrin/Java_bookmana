package View;

import java.util.Scanner;

import Controller.*;

/**
 * Created by yunhan on 2017/4/28.
 */
public class TCPClient {

    public TCPClient() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("添加一本图书(Data)..........1");
            System.out.println("删除一本图书(ByID)..........2");
            System.out.println("查看所有图书(All)...........3");
            System.out.println("更新一本图书(ByID)..........4");
            System.out.println("退出图书系统(Exit)..........5");
            System.out.println("-----------------------------");
            String choice = scanner.next();
            if (Integer.valueOf(choice) == 1) {
                this.bookOpreation("add");
            } else if (Integer.valueOf(choice) == 2) {
                this.bookOpreation("delete");
            } else if (Integer.valueOf(choice) == 3) {
                this.bookOpreation("select");
            } else if (Integer.valueOf(choice) == 4) {
                this.bookOpreation("update");
            } else if (Integer.valueOf(choice) == 5) {
                System.out.print("Exit System!");
                return;
            } else {
                System.out.println("Wrong direction");
                return;
            }
        }
    }

    public void bookOpreation(String op) {
        BookController bookController = new BookController();
        if (op.equals("add")) {
            bookController.addBook();
        } else if (op.equals("delete")) {
            bookController.deleteBook();
        } else if (op.equals("select")) {
            bookController.selectBook();
        } else if (op.equals("update")) {
            bookController.updateBook();
        } else {
            System.out.println("Wrong method");
            return;
        }
    }

    public static void main(String[] args) {
        new TCPClient();
    }
}