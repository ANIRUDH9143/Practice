package Servlet;
import com.bank.Account;
import com.bank.BankService;
import com.bank.BankServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankServlet extends HttpServlet{
    private static final Gson GSON=new GsonBuilder().create();
    private static BankService bankService=new BankServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            List<Account> accountList=null;
            try {
                accountList = bankService.getAccounts();
//                bankService.sortAccounts(resp,GSON);


            }
            catch (Exception e) {
                e.printStackTrace();
            }
            resp.setStatus(201);
            resp.setHeader("Content-Type","application/json");
            resp.getOutputStream().println(GSON.toJson(accountList));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Account account=GSON.fromJson(req.getReader(),Account.class);
        try {
            bankService.createAccount(account);

        }catch (Exception e){
            e.printStackTrace();
        }


        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println(GSON.toJson(account));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Account account=GSON.fromJson(req.getReader(),Account.class);
        try {
            bankService.putAccount(account);

        }catch (Exception e){
            e.printStackTrace();
        }


        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println(GSON.toJson(account));

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int acc=0;
        try {
            int account_no=Integer.parseInt(req.getPathInfo().replace("/",""));
            acc=account_no;
            bankService.deleteAccountById(account_no);

        }catch (Exception e){
            e.printStackTrace();
        }


        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println("deleted account : "+acc);
    }
}




