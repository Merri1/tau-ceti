package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    SiteUser findSiteUserByEmail(String str);
}
