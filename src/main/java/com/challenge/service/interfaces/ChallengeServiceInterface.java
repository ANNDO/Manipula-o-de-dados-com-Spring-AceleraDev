package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ChallengeServiceInterface extends ServiceInterface<Challenge> {

    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

    Challenge save(Challenge object);

}
