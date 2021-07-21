package com.fdm.proj.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdm.proj.commands.RegisterCommand;
import com.fdm.proj.commands.RegisterCommandFactory;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final Logger ERROR = LogManager.getLogger("com.fdm.proj.servlets.Error");
	private static final Logger INFO = LogManager.getLogger("com.fdm.proj.servlets.Info");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RegisterCommandFactory cf = (RegisterCommandFactory) req.getServletContext().getAttribute("rcf");
		RegisterCommand command = (RegisterCommand) cf.createCommand(req.getServletContext(), req, resp);
		String page = command.execute();
		
		if (page.equals(req.getServletPath().substring(1))) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/" + page + ".jsp");
			rd.forward(req, resp);
			
		} else {
			resp.sendRedirect(req.getContextPath() + "/" + page);			
		}
	}
}
