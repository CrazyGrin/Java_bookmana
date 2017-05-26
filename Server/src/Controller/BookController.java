package Controller;

import Model.BookModel;
import Repositories.BookRepository;
import Tool.DataPackage;


/**
 * Created by yunhan on 2017/4/28.
 */
public class BookController {
    private BookModel bookModel = null;
    private BookRepository bookRepository = null;

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    public BookController() {
        System.out.println("Init BookController Server");
        this.bookRepository = new BookRepository();
    }

    public void bookModelInit(String[] bookString) {
        this.bookModel = new BookModel();

        this.bookModel.setBookNum(bookString[1]);
        this.bookModel.setBookName(bookString[2]);
        this.bookModel.setBookAuthor(bookString[3]);
        this.bookModel.setBookPrice(bookString[4]);

    }

    public void addBook() {
        String[] bookData = DataPackage.bookToString(this.bookModel);
        this.bookRepository.addBook(bookData);

    }

    public String selectBook() {
        System.out.println("select book");
        String resultData = this.bookRepository.SelectAllBook();

        return resultData;
    }

    public void deleteBook(String key) {
        System.out.println("delete book");
        String resultData = this.bookRepository.DeleteBookById(key);
    }

    public void updateBook(String num,String key,String value) {
        System.out.println("delete book");
        String resultData = this.bookRepository.UpdateBookByNum(num,key,value);
    }


}
