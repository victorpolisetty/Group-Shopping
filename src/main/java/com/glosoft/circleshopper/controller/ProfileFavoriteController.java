package com.glosoft.circleshopper.controller;

import com.glosoft.circleshopper.exception.ResourceNotFoundException;
import com.glosoft.circleshopper.model.Item;
import com.glosoft.circleshopper.model.UserFavorite;
import com.glosoft.circleshopper.model.UserFavoriteKey;
import com.glosoft.circleshopper.repository.ItemRepository;
import com.glosoft.circleshopper.repository.UserFavoriteRepository;
import com.glosoft.circleshopper.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
public class ProfileFavoriteController {

    @Autowired
    private UserFavoriteRepository userFavoriteRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles/{profileId}/favorites")
    public List<Item> getAllFavoritesByProfileId(@PathVariable (value = "profileId") Long profileId,
                                                 Pageable pageable) {
        Page<UserFavorite> userFavorites = userFavoriteRepository.findByProfileId(profileId, pageable);
        List<Item> ip =  (userFavorites.stream().map(UserFavorite::getItem).collect(Collectors.toList()));
        return ip;
    }

    @PostMapping("/profiles/{profileId}/favorites/{itemId}")
    public UserFavorite createFavorite(@PathVariable (value = "profileId") long profileId,
                                       @PathVariable (value = "itemId") Long itemId
    ) {
        UserFavorite fav = new UserFavorite(new UserFavoriteKey(profileId, itemId));
        fav.setProfile(profileRepository.findById(profileId).get());
        fav.setItem(itemRepository.findById(itemId).get());
        return userFavoriteRepository.save(fav);
    }


    @PutMapping("/profiles/{profileId}/favorites/{favoriteId}")
    public UserFavorite updateFavorite(@PathVariable (value = "profileId") Long profileId,
                                       @PathVariable (value = "favoriteId") Long favoriteId,
                                       @Valid @RequestBody UserFavorite userFavoriteRequest) {
        if(!profileRepository.existsById(profileId)) {
            throw new ResourceNotFoundException("ProfileId " + profileId + " not found");
        }

        return userFavoriteRepository.findById(favoriteId).map(fav -> {
            fav.setItem(userFavoriteRequest.getItem());
            return userFavoriteRepository.save(fav);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + favoriteId + "not found"));
    }

    @DeleteMapping("/profiles/{profileId}/favorites/{itemId}")
    public ResponseEntity<?> deleteFavorite(@PathVariable (value = "profileId") Long profileId,
                                           @PathVariable (value = "itemId") Long itemId) {

            userFavoriteRepository.deleteById(new UserFavoriteKey(profileId, itemId));
            return ResponseEntity.ok().build();
      //  }).orElseThrow(() -> new ResourceNotFoundException("Favorite not found with item id " + itemId + " and profileId " + profileId));
    }
}
