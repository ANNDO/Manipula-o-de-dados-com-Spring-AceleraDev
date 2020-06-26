package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    @Query(value ="select * from acceleration as ac where ac.id in " +
            "(select ca.acceleration_id from candidate ca where " +
            "ca.company_id = :companyId)"
            ,nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
