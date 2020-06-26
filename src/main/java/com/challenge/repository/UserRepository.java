package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    Optional<User> findById(Long userId);

    @Query(value = "select * from users as us where us.id  in " +
            "(select ca.user_id from candidate as ca where " +
            "ca.acceleration_id = (select ac.id from acceleration as ac where ac.name = :accelerationName))"
            , nativeQuery = true)
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);


    @Query(value = "select * from users as us where us.id  in " +
            "(select ca.user_id from candidate as ca where " +
            "ca.company_id = (select co.id from company as co where co.id = :companyId))"
            , nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);



}
