package com.example.AjaxLearning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h3>AjaxLearning</h3>
 * <p></p>
 *
 * @author : ALB
 * @date : 2022-07-30 10:46
 **/
@WebServlet("/ajaxServlet")
public class Ajax_With_jQuery extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");

        System.out.println(username);
        response.getWriter().write("hello:"+username);
    }
}
