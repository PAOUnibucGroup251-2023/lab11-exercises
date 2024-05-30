package com.unibuc.random;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/random")
public class RandomNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Generate a random number
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1; // Random number between 1 and 100

        // Set the random number as a request attribute
        request.setAttribute("randomNumber", randomNumber);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/randomNumber.jsp").forward(request, response);

    }
}

