package com.antnest.service;


import com.antnest.dto.PlaylistDTO;
import com.antnest.entity.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaylistService {

    public Page<Playlist> findAllPublic(Pageable pageable);

    public List<Playlist> searchPlaylist(String search);

    public Playlist getPlaylistById(long id);

    public Playlist addPlaylist(PlaylistDTO playlist);

    public Playlist addTrackToPlaylist(long playlistId, long trackId);
    public Playlist removeTrackFromPlaylist(long playlistId, long trackId);

    public Playlist updatePlaylist(PlaylistDTO playlist);

    public void deletePlaylist(long id);
}
