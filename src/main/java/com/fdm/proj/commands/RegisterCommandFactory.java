package com.fdm.proj.commands;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommandFactory implements CommandFactory{

	@Override
	public Command createCommand(ServletContext sc, HttpServletRequest req, HttpServletResponse resp) {
		return new RegisterCommand(sc, req, resp);
	}
}
