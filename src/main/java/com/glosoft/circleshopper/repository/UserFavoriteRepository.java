package com.glosoft.circleshopper.repository;

import com.glosoft.circleshopper.model.Item;
import com.glosoft.circleshopper.model.UserFavorite;
import com.glosoft.circleshopper.model.UserFavoriteKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {
    Page<UserFavorite> findByProfileId(Long profileId, Pageable pageable);
 //   Optional<Item> findByProfileFavoriteKey(ProfileFavoriteKey profileItemKey);
    void deleteById (UserFavoriteKey profileItemKey);
}

