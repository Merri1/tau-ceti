package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.LoginRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRecordRepository extends JpaRepository<LoginRecord, Long> {
}
