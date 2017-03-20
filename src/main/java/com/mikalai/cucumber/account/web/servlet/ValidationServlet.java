package com.mikalai.cucumber.account.web.servlet;

import com.mikalai.cucumber.account.domain.CashSlot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ValidationServlet extends HttpServlet
{
    private CashSlot cashSlot;
    public ValidationServlet(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {


        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        int amount = Integer.parseInt(request.getParameter("amount"));
        if (cashSlot.canDispense(amount)) {
            response.getWriter().println("{\"content\":\"\"}");
        } else {
            response.getWriter().println(
                    "{\"content\":\"Insufficient ATM funds\"}");
        }
    }
}

