package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge,Long> {

    @Query(value = "select * from challenge as ch where " +
            "ch.id  in ( select ac.challenge_id from acceleration as ac where " +
            "ac.id = (select  ca.acceleration_id from candidate as ca where " +
            "ca.acceleration_id = :accelerationId  and ca.user_id = :userId))"
            ,nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId")Long accelerationId, @Param("userId") Long userId);
}
