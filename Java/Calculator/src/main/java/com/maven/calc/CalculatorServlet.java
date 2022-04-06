package com.maven.calc;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.print("hello ");
        int a = Integer.parseInt(req.getParameter("p"));
        int b = Integer.parseInt(req.getParameter("q"));
        String s = req.getParameter("op");
        if (s.equals("addition")) {
            pw.print(a + b);
        } else if (s.equals("subtraction")) {
            pw.print(a - b);
        } else if (s.equals("multiplication")) {
            pw.print(a * b);
        } else if (s.equals("division")) {
            pw.print(a / b);
        } else if (s.equals("modulus")) {
            pw.print(a % b);
        }

    }
}

