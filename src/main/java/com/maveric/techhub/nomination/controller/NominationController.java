package com.maveric.techhub.nomination.controller;
import com.maveric.techhub.nomination.model.NominationRequest;
import com.maveric.techhub.nomination.model.ServiceResponse;
import com.maveric.techhub.nomination.service.NominationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * NominationController is the class to manage for employee nominations
 * @author      Kannabiran Shanmugam
 * @version     %I%, %G%
 * @since       1.0
 */
@RestController
@RequestMapping("/nominations")
@RequiredArgsConstructor
class NominationController {

    private final NominationService nominationService;

    @PostMapping
    ResponseEntity<ServiceResponse> createNomination(@Valid @RequestBody NominationRequest nominationRequest) {
        return nominationService.createNomination(nominationRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<ServiceResponse> getNomination(@PathVariable(name = "id") String id) {
        return nominationService.getNomination(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<ServiceResponse> updateNomination(@PathVariable(name = "id") String id,
                                            @RequestBody NominationRequest nominationRequest) {
        return nominationService.updateNomination(id, nominationRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ServiceResponse> deleteNomination(@PathVariable(name = "id") String id) {
        return nominationService.deleteNomination(id);
    }

    @GetMapping
    ResponseEntity<ServiceResponse> getNominations() {
        return nominationService.getNominations();
    }

}