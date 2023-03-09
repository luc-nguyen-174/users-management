package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserService userManager;

    public UserServlet() {
        userManager = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        showSelectAll(request,response);
    }

    private void showSelectAll(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userManager.selectAllUser();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
