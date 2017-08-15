import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("GET");
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //取出URL中的账号密码参数
        String phoneNumber = request.getParameter(User.PHONENUMBER);
        String passWord = request.getParameter(User.PASSWORD);
        UserDAO userDAO = new UserDAO();
        //验证过程
        
       
        if ( userDAO.isLoginOK(phoneNumber, passWord)) {
            out.println("OK");
        }else {
            out.println("Wrong");
        }

        out.flush();
        out.close();
    }

}