package com.epam.jwd.controller.command.impl;

import com.epam.jwd.context.PathToPages;
import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.RequestContext;
import com.epam.jwd.controller.command.ResponseContext;

public class UserEditPageCommand implements Command {

    private static final ResponseContext USER_EDIT_PAGE = () -> PathToPages.USER_EDIT_PAGE;

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        return USER_EDIT_PAGE;
    }
}