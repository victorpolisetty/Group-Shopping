package com.glosoft.circleshopper.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "profile_favorite")
public class UserFavorite extends AuditModel {

    @EmbeddedId
    UserFavoriteKey id;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("profileId")
    @JoinColumn(name = "profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("profile_id")
    private Profile profile;



    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("itemId")
    @JoinColumn(name = "item_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("item_id")
    private Item item;

    public UserFavorite() {}
    public UserFavorite(UserFavoriteKey key) { this.id= key; }

    public UserFavoriteKey getId() { return id; }
    public void setId(UserFavoriteKey id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }


    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) { this.profile = profile; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserFavorite other = (UserFavorite) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
