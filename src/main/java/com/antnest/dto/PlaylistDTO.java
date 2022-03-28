package com.antnest.dto;

import com.antnest.entity.Playlist;

public class PlaylistDTO {

    private long id;

    private String name;

    private Playlist.Genre genre;

    private boolean isPublic;

    private long ownerId;

    public PlaylistDTO() {
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Playlist.Genre getGenre() {
        return genre;
    }

    public void setGenre(Playlist.Genre genre) {
        this.genre = genre;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
