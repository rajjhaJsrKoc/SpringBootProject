package com.interviewPrep.Project.Service.impl;

import com.interviewPrep.Project.NeDetailsDto.ModelMapperNetworkElement;
import com.interviewPrep.Project.NeDetailsDto.NetworkElementsDto;
import com.interviewPrep.Project.NetworkElementNotFoundException;
import com.interviewPrep.Project.Repository.NeRepository;
import com.interviewPrep.Project.entities.NetworkElement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NeElementImpl implements NetworkElementService {

    @Autowired
    private ModelMapperNetworkElement mapper;
    @Autowired
    private NeRepository neRepository;
    @Override
    public List<NetworkElementsDto> getAllNetworkElement() {
        List<NetworkElement> ne = neRepository.findAll();
        return  ne.stream()
                .map(networkElement -> mapper.toDto(networkElement))
                .collect(Collectors.toList());
    }

    @Override
    public List<NetworkElementsDto> getenNetworkElement() {
        List<NetworkElement> ne = neRepository.findTop10();
        return  ne.stream()
                .map(networkElement -> mapper.toDto(networkElement))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNetworkElement(int ip) {
        NetworkElement ne = neRepository.findNetworkElementByIp(ip)
                .orElseThrow(() -> new NetworkElementNotFoundException("Network element not found for IP: " + ip));
        if(ne!= null)
            neRepository.deleteNetworkElementByIp(ip);
    }

    @Override
    public void insertAllNetworkElements(NetworkElementsDto networkElementsDto) {
        NetworkElement entity = new NetworkElement();
        entity.setIp(networkElementsDto.getIp());
        entity.setHostname(networkElementsDto.getHostname());
        entity.setLocation(networkElementsDto.getLocation());
        neRepository.save(entity);
    }

}
