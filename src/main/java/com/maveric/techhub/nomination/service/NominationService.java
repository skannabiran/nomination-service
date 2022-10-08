package com.maveric.techhub.nomination.service;

import com.maveric.techhub.nomination.exception.EntityNotFoundException;
import com.maveric.techhub.nomination.entity.Nomination;
import com.maveric.techhub.nomination.mapper.NominationMapper;
import com.maveric.techhub.nomination.model.NominationDTO;
import com.maveric.techhub.nomination.model.NominationRequest;
import com.maveric.techhub.nomination.repository.NominationRepository;
import com.maveric.techhub.nomination.model.ServiceResponse;
import com.maveric.techhub.nomination.util.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class NominationService {

    private final NominationRepository nominationRepository;
    private final NominationMapper nominationMapper;

    public ResponseEntity<ServiceResponse> createNomination(NominationRequest nominationRequest) {
        String nomineeId = nominationRequest.getNomineeId();
        String typeId = nominationRequest.getTypeId();
        Optional<Nomination> optionalIdea = nominationRepository.findByNomineeIdAndTypeId(nomineeId, typeId);
        if (!optionalIdea.isPresent()) {
            Nomination nomination = nominationMapper.toEntity(nominationRequest);
            nomination.setId(ServiceConstants._UUID());
            nominationRepository.save(nomination);
            NominationDTO nominationDTO = nominationMapper.toDTO(nomination);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ServiceResponse.builder().response(nominationDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_ALREADY_EXISTS, typeId));
    }

    public ResponseEntity<ServiceResponse> getNomination(String id) {
        Optional<Nomination> optionalUser = nominationRepository.findById(id);
        if (optionalUser.isPresent()) {
            Nomination nomination = optionalUser.get();
            NominationDTO nominationDTO = nominationMapper.toDTO(nomination);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(nominationDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> updateNomination(String id, NominationRequest nominationRequest) {
        Optional<Nomination> optionalUserDB = nominationRepository.findById(id);
        if (optionalUserDB.isPresent()) {
            Nomination nominationDB = optionalUserDB.get();
            Nomination nomination = nominationMapper.toEntity(nominationRequest);
            nomination.setId(nominationDB.getId());
            nominationRepository.save(nomination);
            NominationDTO nominationDTO = nominationMapper.toDTO(nomination);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(nominationDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> deleteNomination(String id) {
        Optional<Nomination> optionalUser = nominationRepository.findById(id);
        if (optionalUser.isPresent()) {
            Nomination nomination = optionalUser.get();
            nominationRepository.delete(nomination);
            ServiceResponse response = ServiceResponse.builder().
                    message(String.format(ServiceConstants.ENTITY_DELETED, id)).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> getNominations() {
        ServiceResponse response = ServiceResponse.builder().build();
        List<Nomination> nominations = nominationRepository.findAll();
        if (!nominations.isEmpty()) {
            List<NominationDTO> nominationDTOS = nominationMapper.toDTO(nominations);
            response.setResponse(nominationDTOS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
