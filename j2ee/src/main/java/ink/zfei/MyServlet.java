package ink.zfei;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("chushihua");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        Bootstrap.MyServletResponse response = (Bootstrap.MyServletResponse) servletResponse;

        String content = "hello crome!";
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Set-Cookie: testCookie=book\n")
                .append("\r\n")
                .append(content);
        response.setRes(httpResponse.toString());
        response.getWriter().flush();
        response.flushBuffer();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
