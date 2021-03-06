package com.epam.jwd.controller;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.CommandFactory;
import com.epam.jwd.controller.command.ResponseContext;
import com.epam.jwd.controller.command.impl.CustomRequestContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main controller that execute all {@link HttpServletRequest} request
 * and {@link HttpServletResponse} response between server-client.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

@WebServlet("/controller")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    /**
     * Method receives {@link HttpServletRequest} requests and {@link HttpServletResponse} responses.
     * Based on {@link HttpServletRequest} the request, he takes {@link Command} a command parameter
     * and receives it from the {@link CommandFactory} commandFactory,
     * then gives the page for output and forward on it.
     *
     * @param req  {@link HttpServletRequest} request
     * @param resp {@link HttpServletResponse} response
     * @throws ServletException exception
     * @throws IOException      exception
     */
    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Command command = CommandFactory.getCommand(req.getParameter("command"));
        final ResponseContext responseContext = command.execute(new CustomRequestContext(req));
        if (responseContext.getResponseType() == ResponseContext.ResponseType.REDIRECT) {
            resp.sendRedirect(responseContext.getPage());
        } else {
            final RequestDispatcher requestDispatcher = req.getRequestDispatcher(responseContext.getPage());
            requestDispatcher.forward(req, resp);
        }
    }
}
