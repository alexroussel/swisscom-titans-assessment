package com.swisscom.backend.dao;

import com.swisscom.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT DISTINCT user FROM UserEntity user WHERE user.firstName IN :filter " +
            "OR user.lastName IN :filter OR user.department IN :filter OR user.costCenter IN :filter")
    List<UserEntity> findAll(List<String> filter);

}
