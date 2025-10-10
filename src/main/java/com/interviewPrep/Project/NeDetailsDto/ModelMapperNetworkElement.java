package com.interviewPrep.Project.NeDetailsDto;

import com.interviewPrep.Project.entities.NetworkElement;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperNetworkElement {
    public static NetworkElement toEntity(NetworkElementsDto dto) {
        NetworkElement entity = new NetworkElement();
        entity.setIp(dto.getIp());
        entity.setHostname(dto.getHostname());
        entity.setLocation(dto.getLocation());
        return entity;
    }

    public static NetworkElementsDto toDto(NetworkElement entity) {
        return new NetworkElementsDto(
                entity.getIp(),
                entity.getHostname(),
                entity.getLocation()
        );
    }
}
