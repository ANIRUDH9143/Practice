package Servlet;
import model.Account;
import com.bank.AccountService;
import com.bank.AccountServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static Database.ToConnection.getTransactions;

public class BankServlet extends HttpServlet{
    private static final Gson GSON=new GsonBuilder().create();
    private static final AccountService bankService=new AccountServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Account> accountList=null;
        List<Account> sortedList=new ArrayList<>();
        try {
            accountList = bankService.getAccounts();
            sortedList = bankService.sortAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println("Before sorting accounts with cu");
        resp.getOutputStream().println(GSON.toJson(accountList));
        resp.getOutputStream().println("After sorting");
        resp.getOutputStream().println(GSON.toJson(sortedList));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Transaction> transactionList=null;
        transactionList = getTransactions();
        resp.setStatus(201);
        resp.setHeader("Content-Type","application/json");
        resp.getOutputStream().println("Transaction details:==================");
        resp.getOutputStream().println(GSON.toJson(transactionList));
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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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




