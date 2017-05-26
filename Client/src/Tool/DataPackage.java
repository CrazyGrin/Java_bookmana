package Tool;

import Model.*;

/**
 * Created by yunhan on 2017/4/28.
 */
public class DataPackage {
    public static String bookToString(BookModel bookModel, String operation) {
        String packageData = operation + ";" + bookModel.getBookNum() + ";" + bookModel.getBookName() + ";" + bookModel.getBookAuthor() + ";" + bookModel.getBookPrice();
        return packageData;
    }

    public static String bookToString(String key, String operation) {
        String packageData = operation + ";" + key;
        return packageData;
    }

    public static void bookResponseToHuman(String bookResponse) {
        System.out.println(bookResponse);
        String[] bookResponseArr = bookResponse.split(";");

        if (bookResponseArr.length % 5 == 0) {
            for (int i = 0; i <= bookResponseArr.length; i = i + 5) {
                if (i == bookResponseArr.length) {
                    break;
                }
                System.out.println("-----------------------------");
                System.out.println("书ID: " + bookResponseArr[i]);
                System.out.println("书号: " + bookResponseArr[i + 1]);
                System.out.println("书名: " + bookResponseArr[i + 2]);
                System.out.println("作者: " + bookResponseArr[i + 3]);
                System.out.println("价格: " + bookResponseArr[i + 4]);
                System.out.println("-----------------------------");
            }
        }
        else {
            System.out.println(bookResponseArr[0]);
        }
    }
}
