package com.devconnect.microservices.profileservice.repositories;

import com.devconnect.microservices.profileservice.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
}
