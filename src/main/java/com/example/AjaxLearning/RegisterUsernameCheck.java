package com.example.AjaxLearning;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * <h3>AjaxLearning</h3>
 * <p>验证注册用户名是否可用</p>
 *
 * @author : ALB
 * @date : 2022-07-31 10:03
 **/
@WebServlet("/ajaxrequest4")
public class RegisterUsernameCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean taken = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "smt020528");
            String sql = "select * from account where username=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //存在用户
                taken = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        if(taken==true){
            out.print("<h4>用户名已存在</h4>");
        }else{
            out.print("<h4>用户名可以使用</h4>");
        }

    }

}
