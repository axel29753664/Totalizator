package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WelcomeController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        return new MVCModel("/welcome.jsp", "Welcome to Totalizator!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

}
