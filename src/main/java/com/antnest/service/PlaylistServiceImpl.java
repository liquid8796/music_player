package com.antnest.service;

import com.antnest.dto.PlaylistDTO;
import com.antnest.entity.Playlist;
import com.antnest.entity.Track;
import com.antnest.entity.User;
import com.antnest.handler.AntnestException;
import com.antnest.repository.PlaylistRepository;
import com.antnest.repository.TrackRepository;
import com.antnest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public Page<Playlist> findAllPublic(int page, int size) {

        List<Playlist> allPublic = playlistRepository.findAllPublic();
        Page<Playlist> result = new PageImpl<>(allPublic);

        return result;
    }

    @Override
    public List<Playlist> searchPlaylist(String search) {
        return playlistRepository.searchPlaylist(search);
    }

    @Override
    public Playlist getPlaylistById(long id) {
        Optional<Playlist> result = playlistRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("Playlist not found id - " + id, 404);
    }

    @Override
    public Playlist addPlaylist(PlaylistDTO playlist) {
        Playlist result = new Playlist(playlist.getName(), playlist.getGenre(), playlist.isPublic());
        User owner = getUserById(playlist.getOwnerId());
        result.setUser(owner);
        return playlistRepository.save(result);
    }

    @Override
    public Playlist addTrackToPlaylist(long playlistId, long trackId) {

        Playlist result = getPlaylistById(playlistId);
        Track track = getTrackById(trackId);

        if(result.getTracks().contains(track)) throw new AntnestException("Track already added to this playlist!", 409);
        result.getTracks().add(track);

        return playlistRepository.save(result);
    }

    @Override
    public Playlist removeTrackFromPlaylist(long playlistId, long trackId) {

        Playlist result = getPlaylistById(playlistId);
        Track track = getTrackById(trackId);
        result.getTracks().remove(track);

        return playlistRepository.save(result);
    }

    @Override
    public Playlist updatePlaylist(PlaylistDTO playlist) {

        Playlist result = getPlaylistById(playlist.getId());
        result.setName(playlist.getName());
        result.setGenre(playlist.getGenre());
        result.setPublic(playlist.isPublic());
        return playlistRepository.save(result);
    }

    @Override
    public void deletePlaylist(long id) {
        playlistRepository.deleteById(id);
    }

    private User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("User not found id - " + id, 404);
    }

    private Track getTrackById(long id) {
        Optional<Track> result = trackRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("Track not found id - " + id, 404);
    }
}
