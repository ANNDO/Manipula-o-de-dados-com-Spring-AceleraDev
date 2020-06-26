package com.challenge.service.interfaces;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.Challenge;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    Optional<Candidate> findById(CandidateId id);

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);

    Candidate save(Candidate object);
}
