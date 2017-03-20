package com.mikalai.cucumber.account.web;

import com.mikalai.cucumber.account.domain.Account;
import com.mikalai.cucumber.account.domain.CashSlot;
import com.mikalai.cucumber.account.web.servlet.AtmServlet;
import com.mikalai.cucumber.account.web.servlet.ValidationServlet;
import com.mikalai.cucumber.account.web.servlet.WithdrawalServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
public class AtmServer
{
    private final Server server;

    public AtmServer(int port, CashSlot cashSlot, Account account) {
        server = new Server(port);

        ContextHandler resourceContext = new ContextHandler();
        resourceContext.setContextPath("/js");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("src/main/webapp/js");
        resourceContext.setHandler(resourceHandler);

        ServletContextHandler servletContext =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath("/");
        servletContext.addServlet(new ServletHolder(
                new WithdrawalServlet(cashSlot, account)),"/withdraw");
        servletContext.addServlet(new ServletHolder(new ValidationServlet(cashSlot)),"/validate");
        servletContext.addServlet(new ServletHolder(new AtmServlet()),"/");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(new Handler[] { resourceContext, servletContext });
        server.setHandler(contexts);

    }
    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }
    public void stop() throws Exception {
        server.stop();
        System.out.println("Server shutdown");
    }
}