package com.uxb2b.test.webatm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloTwiceServlet
 */
@WebServlet("/HelloTwiceServlet")
public class HelloTwiceServlet extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7264362215550579331L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloTwiceServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        out.write("hello world, hello world".getBytes());
        out.flush();
        out.close();
    }

}
