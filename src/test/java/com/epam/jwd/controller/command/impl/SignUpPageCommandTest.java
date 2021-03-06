package com.epam.jwd.controller.command.impl;

import com.epam.jwd.context.PathToPages;
import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.CommandFactory;
import com.epam.jwd.controller.command.ResponseContext;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;

public class SignUpPageCommandTest {

    @Test
    public void testExecute() {
        HttpServletRequest req = mock( HttpServletRequest.class);
        final Command command = CommandFactory.getCommand("sign-up");
        final ResponseContext responseContext = command.execute(new CustomRequestContext(req));
        Assert.assertEquals(responseContext.getPage(), PathToPages.SIGNUP_PAGE);
    }
}