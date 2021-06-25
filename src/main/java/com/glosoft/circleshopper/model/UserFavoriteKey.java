package com.glosoft.circleshopper.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class UserFavoriteKey implements Serializable {

    @Column(name = "profile_id")
    Long profileId;

    @Column(name = "item_id")
    Long itemId;

    public UserFavoriteKey() {}

    public UserFavoriteKey(Long profileId, Long itemId) {
        this.profileId = profileId;
        this.itemId = itemId;
    }

    public Long getProfileId() {
        return profileId;
    }
    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long getItemId) { this.itemId = itemId; }



    @Override
    public int hashCode() {
        int result = profileId.hashCode();
        result = 31 * result + itemId.hashCode();
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
        UserFavoriteKey other = (UserFavoriteKey) obj;
        if (profileId == null) {
            if (other.profileId != null)
                return false;
        } else if (!profileId.equals(other.profileId))
            return false;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        return true;
    }

}



