package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.domain.exception.EventCreationException;
import lv.javaguru.java2.domain.services.factories.CreationFactory;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EventServicesImpl implements EventServices {


    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private BetService betService;

    @Autowired
    private ApplyBetService applyBetService;

    @Autowired
    private CreationFactory<EventDTO> eventCreationFactory;

    @Autowired
    private TransferService transferService;

    @Override
    public void saveToDB(Event event) {
        eventDAO.create(event);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        betService.deleteByEventId(id);
        eventDAO.delete(id);
    }

    @Override
    public Event getByEventName(String name) {
        return eventDAO.getByEventName(name);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.update(event);
    }

    @Override
    public double getCoefficientDependingOnBetState(BetConditionState state, Long eventId) {
        Event event = getEventById(eventId);
        double coefficient = event.getCoefficient();
        if (state.equals(BetConditionState.WIN)) {
            coefficient = 1 / coefficient;
        }
        return coefficient;
    }

    @Override
    public List<Event> getEventsWhereWinnerStatusNotSet() {
        return eventDAO.getEventsWhereWinnerStatusIsNull();
    }

    @Override
    @Transactional
    public void closeEvent(BetConditionState winnerStatus, Long eventId) {
        Event event = getEventById(eventId);
        event.setWinnerStatus(winnerStatus);
        updateEvent(event);
        transferService.transferMoneyToWinners(event);

//        transferService.transferToTotalizatorBank(event.getTotalBank());
//        event.setTotalBank(new BigDecimal(0));
    }

    @Override
    @Transactional
    public void createEvent(Long userId, EventDTO eventDTO, BindingResult eventErrors, BetDTO betDTO, BindingResult betErrors) {
        eventCreationFactory.create(eventDTO, eventErrors);
        if (eventErrors.hasErrors()) {
            throw new EventCreationException("Error create event: " + eventDTO.getEventName());
        }
        initEventFirstBet(betDTO, eventDTO, userId);
        applyBetService.apply(betDTO, betErrors);
        if (betErrors.hasErrors()) {
            throw new EventCreationException("Error create event: " + eventDTO.getEventName() + ". Bet creation Error");
        }
        Event event = getEventById(betDTO.getEventId());
        event.setBetSide(BetConditionState.LOSE);
        updateEvent(event);
    }

    private void initEventFirstBet(BetDTO betDTO, EventDTO eventDTO, Long userId) {
        Event event = getByEventName(eventDTO.getEventName());
        betDTO.setUserId(userId);
        betDTO.setEventId(event.getEventId());
        betDTO.setBetCondition(BetConditionState.WIN);
    }


}

