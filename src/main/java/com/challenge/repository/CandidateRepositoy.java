package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepositoy extends CrudRepository<Candidate, Long> {


    Optional<Candidate> findById(CandidateId id);

    @Query( value = "select * from CANDIDATE as ca WHERE " +
            "ca.user_id = %:userId% AND " +
            "ca.company_id = %:companyId% AND " +
            "ca.acceleration_id = :accelerationId",nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userId,
                                 @Param("companyId") Long companyId,
                                 @Param("accelerationId") Long accelerationId);

    @Query(value=  "SELECT * FROM CANDIDATE as ca where ca.company_id = :companyId",nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT * FROM CANDIDATE as ca where ca.acceleration_id = :accelerationId",nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
