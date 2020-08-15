package ink.zfei;

import org.apache.catalina.User;
import org.apache.catalina.connector.Response;
import org.apache.catalina.session.StandardSession;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Bootstrap {


   static   Map<String, StandardSession> userSessions = new ConcurrentHashMap<>();
    static ThreadLocal<UserInfo> userInfoCache = new ThreadLocal();

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8090);

        while (true) {

            try {
                Socket socket = serverSocket.accept();
                InputStream stream = socket.getInputStream();
                byte[] bytes = new byte[20480];
                stream.read(bytes);  //3s钟
                String request = new String(bytes);
                System.out.println(request);

                OutputStream outputStream = socket.getOutputStream();
                String content = "hello crome!";
                StringBuffer httpResponse = new StringBuffer();
                httpResponse.append("HTTP/1.1 200 OK\n");


                boolean isFisrt = true;

                if (new String(bytes).contains("Cookie")) {
                    isFisrt = false;
                }


                boolean isLoginRequest = getPathFromRequest(request);
                if (isLoginRequest) {
                    String username = getValueFromRequest(request, "username");
                    String password = getValueFromRequest(request, "password");
                    //验证用户名密码是否匹配
                    //执行sql：select password from user where username = '+username+';
                    if (password.equals("查出来的password")) {
                        UserInfo userInfo = new UserInfo(); //从数据库查用户信息
                        String sessionId = generat();
                        StandardSession session = new StandardSession(null);
                        session.setAttribute("userInfo",userInfo);
                        userSessions.put(sessionId, session);
                        httpResponse.append("Cookie: jsessionId="+sessionId+"\n");
                        userInfoCache.set(userInfo);

                    }
                }

                String jsessionId = getValueFromRequest(request,"jsessionId");
                if(jsessionId==null)
                {
                    System.out.println("未登陆");
                }else if (!userSessions.containsKey(jsessionId))
                {
                    System.out.println("未登陆,非法请求或登陆已过期！");
                }else
                {
                    StandardSession session =  userSessions.get(jsessionId);
                    session.setMaxInactiveInterval(60*30);


                    UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
                    if(userInfo == null)
                    {
                        System.out.println("登陆已过期，请重新登陆！");
                    }
                }

                //如果请求path=logout
                //拿到jsessionId,拿到session，
                //session.removeAttribute("userInfo");



                if (isFisrt) {
                    httpResponse.append("Set-Cookie: name=zhangsan\n")
                            .append("\r\n")
                            .append(content);
                } else {
                    httpResponse.append("\r\n")
                            .append(content);
                }

                Response response = new Response();
                Cookie cookie = new Cookie("name", "zhangsan");
//                cookie.setMaxAge(600);
                response.addCookie(cookie);


                System.out.println(httpResponse.toString());
                outputStream.write(httpResponse.toString().getBytes());
                outputStream.flush();
//                MyServlet myServlet  =  new MyServlet();
//                ServletRequest servletRequest = new MyServletRequest(new String(bytes));
//                ServletResponse response = new MyServletResponse(outputStream);
//                myServlet.service(servletRequest,response);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private static String generat() {

        return UUID.randomUUID().toString();
    }

    static class UserInfo {
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        private String userId;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        private String name;
        private String icon;

    }

    private static String getValueFromRequest(String request, String key) {

        if ("username".equals(key)) {
            return "zhangsan";
        }
        if ("password".equals(key)) {
            return "123456";
        }
        if ("jsessionId".equals(key)) {
            return "dddddaffsad";
        }
        return null;

    }

    private static boolean getPathFromRequest(String request) {

        if (request.contains("login")) {
            return true;
        }
        return false;
    }

    private static String from(String request) {

        if (request.contains("Jsessionid")) {
            return "zhangsan";
        }
        return null;
    }

    static class MyServletResponse implements ServletResponse {

        OutputStream outputStream;

        public void setRes(String res) {
            this.res = res;
        }

        String res;

        public MyServletResponse(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public String getCharacterEncoding() {
            return null;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return null;
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return null;
        }

        @Override
        public void setCharacterEncoding(String s) {

        }

        @Override
        public void setContentLength(int i) {

        }

        @Override
        public void setContentLengthLong(long l) {

        }

        @Override
        public void setContentType(String s) {

        }

        @Override
        public void setBufferSize(int i) {

        }

        @Override
        public int getBufferSize() {
            return 0;
        }

        @Override
        public void flushBuffer() throws IOException {

            outputStream.write(res.getBytes());
            outputStream.flush();

        }

        @Override
        public void resetBuffer() {

        }

        @Override
        public boolean isCommitted() {
            return false;
        }

        @Override
        public void reset() {

        }

        @Override
        public void setLocale(Locale locale) {

        }

        @Override
        public Locale getLocale() {
            return null;
        }
    }


    static class MyServletRequest implements ServletRequest {

        private String orginContent;

        public MyServletRequest(String s) {
            orginContent = s;
        }

        @Override
        public Object getAttribute(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String getCharacterEncoding() {
            return null;
        }

        @Override
        public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

        }

        @Override
        public int getContentLength() {
            return 0;
        }

        @Override
        public long getContentLengthLong() {
            return 0;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        @Override
        public String getParameter(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return null;
        }

        @Override
        public String[] getParameterValues(String s) {
            return new String[0];
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return null;
        }

        @Override
        public String getProtocol() {
            return null;
        }

        @Override
        public String getScheme() {
            return null;
        }

        @Override
        public String getServerName() {
            return null;
        }

        @Override
        public int getServerPort() {
            return 0;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return null;
        }

        @Override
        public String getRemoteAddr() {
            return null;
        }

        @Override
        public String getRemoteHost() {
            return null;
        }

        @Override
        public void setAttribute(String s, Object o) {

        }

        @Override
        public void removeAttribute(String s) {

        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return null;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String s) {
            return null;
        }

        @Override
        public String getRealPath(String s) {
            return null;
        }

        @Override
        public int getRemotePort() {
            return 0;
        }

        @Override
        public String getLocalName() {
            return null;
        }

        @Override
        public String getLocalAddr() {
            return null;
        }

        @Override
        public int getLocalPort() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            return null;
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            return false;
        }

        @Override
        public AsyncContext getAsyncContext() {
            return null;
        }

        @Override
        public DispatcherType getDispatcherType() {
            return null;
        }
    }

}
