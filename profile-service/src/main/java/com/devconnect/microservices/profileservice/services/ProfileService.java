package com.devconnect.microservices.profileservice.services;

import com.devconnect.microservices.profileservice.domain.UserProfile;
import com.devconnect.microservices.profileservice.exceptions.ProfileException;
import com.devconnect.microservices.profileservice.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public List<UserProfile> getAllProfiles() {
        return repository.findAll();
    }

    public UserProfile getProfileById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ProfileException("UserProfile with ID: "+id+" Not found"));
    }

    public UserProfile saveProfile(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    public UserProfile updateProfile(Long id, UserProfile userProfile) {
        return repository.findById(id).map(
                temp -> {
                        temp.setDateOfBirth(userProfile.getDateOfBirth());
                        temp.setEmail(userProfile.getEmail());
                        temp.setName(userProfile.getName());
                        return repository.save(temp);
                    }).
                orElseThrow(()-> new ProfileException("UserProfile with ID: "+id+" Not found"));
    }

    public void deleteProfile(Long id) {
        repository.delete(
                repository.findById(id)
                .orElseThrow(()-> new ProfileException("UserProfile with ID: "+id+" Not found"))
        );
    }

}
