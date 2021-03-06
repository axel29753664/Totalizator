package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class EventManagementController {

    @RequestMapping(value = "eventManagement", method = RequestMethod.GET)
    public ModelAndView processGet() {
        return new ModelAndView("adminPages/eventManagement");
    }

}
