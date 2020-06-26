package com.challenge.repository;

import com.challenge.entity.Challenge;
import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission,Long> {

    @Query( value = "select MAX(sb.score) from SUBMISSION sb where sb.challenge_id = :challengeId",nativeQuery = true)
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "select * from submission as sb where " +
            "sb.challenge_id in " +
            "( select ac.challenge_id from acceleration as ac where ac.id = :accelerationId " +
            "and ac.challenge_id = :challengeId)"
            ,nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                        @Param("accelerationId") Long accelerationId);
}
