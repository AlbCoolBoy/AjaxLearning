package com.example.AjaxLearning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class Servlert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        //这里的后端带么和之前的代码实际上还是一样的
        //只不过这里的out在服务器中进行响应的时候，浏览器端的XMLHttpRequest对象能够获取到这个响应的信息
        out.println("hello ajax");
    }
}
