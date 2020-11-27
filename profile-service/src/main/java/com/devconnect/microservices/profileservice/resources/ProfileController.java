package com.devconnect.microservices.profileservice.resources;

import com.devconnect.microservices.profileservice.domain.UserProfile;
import com.devconnect.microservices.profileservice.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/createProfile")
    public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfile userProfile) {
        UserProfile newUserProfile = profileService.saveProfile(userProfile);
        return new ResponseEntity<>(newUserProfile, HttpStatus.CREATED);
    }

    @GetMapping("/getProfiles")
    public ResponseEntity<List<UserProfile>> getProfiles() {
        List<UserProfile> userProfiles = profileService.getAllProfiles();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/getProfile")
    public ResponseEntity<UserProfile> getProfile(Long id) {
        UserProfile userProfile = profileService.getProfileById(id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<UserProfile> updateProfile(@RequestBody UserProfile userProfile) {
        UserProfile updatedUserProfile = profileService.updateProfile(userProfile.getId(), userProfile);
        return new ResponseEntity<>(updatedUserProfile, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProfile")
    public ResponseEntity<Boolean> deleteProfile(Long id) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
