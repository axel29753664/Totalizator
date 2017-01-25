package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;

import java.util.List;

public interface BetManagementService {

    List<UserDTO> prepareUserList ();

    List<BetDTO> managementProcess(UserDTO userDTO);

}
