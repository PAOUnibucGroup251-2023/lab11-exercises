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

        // Set the response content type
        response.setContentType("text/html");

        // Get the response writer
        PrintWriter out = response.getWriter();

        // Write the HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Random Number</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }");
        out.println(".number { font-size: 48px; color: #333; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Random Number Generator</h1>");
        out.println("<p class='number'>" + randomNumber + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

