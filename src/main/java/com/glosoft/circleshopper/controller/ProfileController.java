package com.glosoft.circleshopper.controller;

import com.glosoft.circleshopper.model.Item;
import com.glosoft.circleshopper.model.Profile;
import com.glosoft.circleshopper.model.UserFavorite;
import com.glosoft.circleshopper.repository.ItemRepository;
import com.glosoft.circleshopper.repository.ProfileRepository;
import com.glosoft.circleshopper.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashSet;


@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/profiles")
    public Page<Profile> getAllProfiles(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @PostMapping("/profiles")
    public Profile createProfile(@Valid @RequestBody Profile profile) {
        profile.setFavorites(new HashSet<UserFavorite>());
        return profileRepository.save(profile);
    }

    @PutMapping("/profiles/{profileId}")
    public Profile updateProfile(@PathVariable Long profileId, @Valid @RequestBody Profile profileRequest) {
        return profileRepository.findById(profileId).map(prof -> {
            prof.setName(profileRequest.getName());
            prof.setEmailId(profileRequest.getEmailId());
            prof.setDescription(profileRequest.getDescription());
            return profileRepository.save(prof);
        }).orElseThrow(() -> new ResourceNotFoundException("ProfileId " + profileId + " not found"));
    }

    @DeleteMapping("/profiles/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable Long profileId) {
        return profileRepository.findById(profileId).map(prof -> {
            profileRepository.delete(prof);
            return ResponseEntity.ok().build();
        }).orElseThrow(() ->
                new ResourceNotFoundException("ProfileId " + profileId + " not found"));
    }




}