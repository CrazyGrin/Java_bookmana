package Repositories;

import Tool.DBConnection;

/**
 * Created by yunhan on 2017/4/27.
 */

public class BookRepository {

    private String bookSql = "";

    private DBConnection dbConnection = null;

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public BookRepository() {
        System.out.println("Init BookRepository Server");
        this.dbConnection = new DBConnection();
    }

    public String getBookSql() {
        return bookSql;
    }

    public void setBookSql(String bookSql) {
        this.bookSql = bookSql;
    }

    public void addBook(String[] bookData) {
        this.setBookSql("INSERT INTO java_book " +
                "(book_num,book_name,book_author,book_price) " +
                "VALUES ('" + bookData[0] + "','" + bookData[1] + "','" + bookData[2] + "','" + bookData[3] + "')");
        System.out.println(this.getBookSql());

        this.dbConnection.excuteSqlWithoutResult(this.getBookSql());
    }

    public void SelectBookByName(String bookName) {
        this.setBookSql("SELECT * FROM " +
                "java_book " +
                "WHERE book_name ='" + bookName + "'");
    }

    public void SelectBookByNum(String bookNum) {
        this.setBookSql("SELECT * FROM " +
                "java_book " +
                "WHERE book_num ='" + bookNum + "'");
    }

    public void SelectBookByAuthor(String bookAuthor) {
        this.setBookSql("SELECT * FROM " +
                "java_book " +
                "WHERE book_author ='" + bookAuthor + "'");
    }

    public String SelectAllBook() {
        this.setBookSql("SELECT * FROM " +
                "java_book " +
                "WHERE book_status=1");
        System.out.println(this.getBookSql());

        String resultData = this.dbConnection.excuteSqlWithResult(this.getBookSql());

        return resultData;
    }

    public String DeleteBookById(String Id) {
        this.setBookSql("UPDATE java_book " +
                "SET book_status=0 " +
                "WHERE book_id='" + Id + "'");

        System.out.println(this.getBookSql());

        this.dbConnection.excuteSqlWithoutResult(this.getBookSql());

        return "delete";
    }

    public String UpdateBookByNum(String num, String key, String value) {
        this.setBookSql("UPDATE java_book " +
                "SET " + key + "='" + value + "' " +
                "WHERE book_num='" + num + "'");

        System.out.println(this.getBookSql());

        this.dbConnection.excuteSqlWithoutResult(this.getBookSql());

        return "update";
    }
}
