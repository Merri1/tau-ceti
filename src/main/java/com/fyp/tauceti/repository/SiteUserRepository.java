package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for generating SQL commands to apply to the SITE_USER database table
 */
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    // Find a SiteUser by the passed email
    SiteUser findSiteUserByEmail(String str);
}
