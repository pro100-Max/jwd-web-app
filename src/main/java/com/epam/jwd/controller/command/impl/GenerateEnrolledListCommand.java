package com.epam.jwd.controller.command.impl;

import com.epam.jwd.context.AppContext;
import com.epam.jwd.context.PathToPages;
import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.RequestContext;
import com.epam.jwd.controller.command.ResponseContext;
import com.epam.jwd.exception.ValidatorException;
import com.epam.jwd.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Class command that generate {@link java.util.List} enrolled list.
 *
 * @author Maxim Semenko
 * @version 0.0.1
 */

public class GenerateEnrolledListCommand implements Command {

    private static final ResponseContext ADMIN_CABINET_PAGE
            = new ResponseContextImpl(PathToPages.ADMIN_CABINET_PAGE, ResponseContext.ResponseType.FORWARD);

    @Override
    public ResponseContext execute(RequestContext requestContext) {
        if (requestContext.getHttpSession().getAttribute("user") != null) {
            try {
                UserService.getInstance().insertToEnrolledList(UserService.getInstance().selectAll());
                AppContext.isEnrolledList = true;
                requestContext.setAttribute("enrolledList", true);
            } catch (ValidatorException e) {
                e.printStackTrace();
            }
        }
        return ADMIN_CABINET_PAGE;
    }
}
