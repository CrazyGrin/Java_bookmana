package Tool;

import Controller.BookController;

/**
 * Created by yunhan on 2017/4/28.
 */
public class Route {
    //模拟request和response
    private String[] request;

    private String[] response;

    public String[] getRequest() {
        return request;
    }

    public void setRequest(String[] request) {
        this.request = request;
    }

    public String[] getResponse() {
        return response;
    }

    public void setResponse(String[] response) {
        this.response = response;
    }

    public Route(String[] request) {

        System.out.println("Init Route Server");
        this.request = request;

    }

    //和书相关的路由
    public String sendRequest_bookModule() {
        if (this.request[0].equals("add")) {
            //初始化控制器
            BookController bookController = new BookController();
            bookController.bookModelInit(this.request);

            //添加操作
            bookController.addBook();

            return "Successful Added";
        }
        else if (this.request[0].equals("delete")) {
            //初始化控制器
            BookController bookController = new BookController();

            //删除操作
            bookController.deleteBook(this.request[1]);

            return "Successful Deleted";
        }
        else if (this.request[0].equals("select")) {
            //初始化控制器
            BookController bookController = new BookController();

            //选择操作
            String resultData = bookController.selectBook();

            return resultData;
        }
        else if (this.request[0].equals("update")) {
            //初始化控制器
            BookController bookController = new BookController();

            //更新操作
//            bookController.updateBook("");

            return "Successful Deleted";
        }
        else {
            return "Wrong Method";
        }
    }
}
