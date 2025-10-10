package com.interviewPrep.Project.Service.impl;

import com.interviewPrep.Project.NeDetailsDto.NetworkElementsDto;
import com.interviewPrep.Project.NetworkElementNotFoundException;

import java.util.List;

public interface NetworkElementService {
    List<NetworkElementsDto> getAllNetworkElement();
    List<NetworkElementsDto> getenNetworkElement();
    void deleteNetworkElement(int ip) ;
    void insertAllNetworkElements(NetworkElementsDto networkElementsDto);
}
