package com.maveric.techhub.nomination.mapper;

import com.maveric.techhub.nomination.entity.Nomination;
import com.maveric.techhub.nomination.model.NominationDTO;
import com.maveric.techhub.nomination.model.NominationRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NominationMapper {

    Nomination toEntity(NominationRequest request);
    NominationDTO toDTO(Nomination nomination);

    List<NominationDTO> toDTO(List<Nomination> nominations);

}
