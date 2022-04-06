package com.studentPack;
import data.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();
        Data obj=new Data();
        pw.println(obj.getDetails());
        pw.println(obj.getStudentById(101));
        pw.println(obj.deleteStudentById(101));
        pw.println(obj.getDetails());
    }

}
