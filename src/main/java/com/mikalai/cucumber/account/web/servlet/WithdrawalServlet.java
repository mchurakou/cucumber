package com.mikalai.cucumber.account.web.servlet;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.CashSlot;
import com.mikalai.cucumber.account.domain.teller.AutomatedTeller;
import com.mikalai.cucumber.account.domain.teller.Teller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class WithdrawalServlet extends HttpServlet
{

    private CashSlot cashSlot;
    private Account account;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Teller teller = new AutomatedTeller(cashSlot);
        int amount = Integer.parseInt(request.getParameter("amount"));
        try {
            teller.withdrawFrom(account, amount);
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(
                    "<html><head><title>ATM</title></head>" +
                            "<body>Please take your $" + amount + "</body></html>");
        } catch (RuntimeException e) {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(
                    "<html><head><title>ATM</title></head>" +
                            "<body>" + e.getMessage() + "</body></html>");

        }
    }
}
