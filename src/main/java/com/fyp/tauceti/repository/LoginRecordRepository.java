package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for generating SQL commands to apply to the LOGIN_RECORD database table
 */
public interface LoginRecordRepository extends JpaRepository<LoginRecord, Long> {
}
