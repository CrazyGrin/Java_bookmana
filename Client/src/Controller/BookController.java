package Controller;

import Model.BookModel;
import Tool.TCPConnect;
import Tool.DataPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by yunhan on 2017/4/27.
 */
public class BookController {
    BookModel bookModel = null;

    TCPConnect tcPconnect = null;

    public BookController() {
        System.out.println("Init BookController Client");
        this.bookModel = new BookModel();
        this.tcPconnect = new TCPConnect();
        this.bookModel.setBookName("");
        this.bookModel.setBookNum("");
        this.bookModel.setBookAuthor("");
        this.bookModel.setBookPrice("");
    }

    public void bookModelInit() {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        try {
            while (flag) {
                System.out.println("Name of the book that you want to add :");
                bookModel.setBookName(input.readLine());
                System.out.println("Num of the book that you want to add :");
                bookModel.setBookNum(input.readLine());
                System.out.println("Author of the book that you want to add :");
                bookModel.setBookAuthor(input.readLine());
                System.out.println("Price of the book that you want to add :");
                bookModel.setBookPrice(input.readLine());
                if (bookModel.isInit()) {
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {
        this.bookModelInit();
        this.tcPconnect.sendMsg(DataPackage.bookToString(this.bookModel, "add"));
    }

    public void selectBook() {
        this.tcPconnect.sendMsg("select");
    }

    public void deleteBook() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Id of the book that you want to delete");
            String key = input.readLine();
            this.tcPconnect.sendMsg(DataPackage.bookToString(key, "delete"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook() {
        this.tcPconnect.sendMsg("update");
    }
}
