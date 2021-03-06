package lv.javaguru.java2.servlet.mvc.controllers.controllerServices;

import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.parsers.ParserStringIdsFromRequestToLong;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
//@Component
public class DeleteButtonProcess implements Process {
//    @Autowired
//    private EventServices eventServices;

    @Override
    public void doAction(HttpServletRequest request, int eventListSize, EventServices eventServices) {
        List<Long> eventIds = ParserStringIdsFromRequestToLong.getIdList(request, eventListSize);
        for (Long id : eventIds) {
            eventServices.delete(id);
        }
    }
}

