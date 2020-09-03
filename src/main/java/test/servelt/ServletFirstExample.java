package test.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cdi.ControllerMain;

public class ServletFirstExample extends HttpServlet {

    @Inject
    private ControllerMain controller;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String color = request.getParameter("color");
        PrintWriter out = response.getWriter();
        out.println("The choosen color is : " + color);

    }
}
