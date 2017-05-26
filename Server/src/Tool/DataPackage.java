package Tool;

import Model.BookModel;

/**
 * Created by yunhan on 2017/4/28.
 */
public class DataPackage {
    //num name author price(未应用)
    public static BookModel stringToBook(String bookString) {
        BookModel bookModel = new BookModel();

        return bookModel;
    }

    public static String[] bookToString(BookModel bookModel) {
        String[] bookData = new String[4];

        bookData[0] = bookModel.getBookNum();
        bookData[1] = bookModel.getBookName();
        bookData[2] = bookModel.getBookAuthor();
        bookData[3] = bookModel.getBookPrice();

        return bookData;
    }

    public static String responseToString() {
        String responseDate = "";

        return responseDate;
    }
}
