package com.example.lmo9ef;

import java.io.*;

import com.example.lmo9ef.Repository.AuthRepositroy;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public void init() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthRepositroy authRepositroy = new AuthRepositroy();

        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        PrintWriter out = response.getWriter();
//        out.println("Working...");
//        out.println(client.toStrings());

        try {
            int i = authRepositroy.login(email, password);
            if(i == 1){
                HttpSession session = request.getSession(true);
                session.setAttribute("login", true);
                out.println("Working...");
                out.println("Client Login Successfuly...");
                response.sendRedirect("index.jsp");
            }else if (i == 2){
                HttpSession session = request.getSession(true);
                session.setAttribute("login", true);
                out.println("Working...");
                out.println("Seller Login Successfuly....");
            }else{
                out.println("Working...");
                out.println("problem de Login...");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}