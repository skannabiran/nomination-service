package com.maveric.techhub.nomination.repository;

import com.maveric.techhub.nomination.entity.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NominationRepository extends JpaRepository<Nomination, String> {

    Optional<Nomination> findById(String Id);

    Optional<Nomination> findByNomineeIdAndTypeId(String nomineeId, String typeId);

}