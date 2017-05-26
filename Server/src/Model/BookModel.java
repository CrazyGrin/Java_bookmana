package Model;

/**
 * Created by yunhan on 2017/4/27.
 */
public class BookModel {

    private String bookNum;
    private String bookPrice;
    private String bookName;
    private String bookAuthor;
    private String tableName = "java_book";

    public boolean isInit() {
        if (this.getBookNum().equals("")) {
            System.out.println("Num isn't init");
            return false;
        }
        if (this.getBookName().equals("")) {
            System.out.println("Name isn't init");
            return false;
        }
        if (this.getBookAuthor().equals("")) {
            System.out.println("Author isn't init");
            return false;
        }
        if (this.getBookPrice().equals("")) {
            System.out.println("Price isn't init");
            return false;
        } else {
            System.out.println("Init !");
            return true;
        }
    }

    public BookModel() {
        System.out.println("Init BookModel Server");
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

}