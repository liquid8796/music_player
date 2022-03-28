package com.antnest.service;

import com.antnest.dto.TrackDTO;
import com.antnest.entity.Track;
import com.antnest.entity.User;
import com.antnest.handler.AntnestException;
import com.antnest.repository.TrackRepository;
import com.antnest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Track> findAll(Pageable pageable) {
        return trackRepository.findAll(pageable);
    }

    @Override
    public Track getTrackById(long id) {
        Optional<Track> result = trackRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("Track not found id - " + id, 404);
    }

    @Override
    public Track addTrack(TrackDTO track) {
        Track result = new Track(track.getName(), track.getLengthInSec());
        User singer = getUserById(track.getSingerId());
        result.setUser(singer);
        return trackRepository.save(result);
    }

    @Override
    public Track updateTrack(TrackDTO track) {
        Track result = getTrackById(track.getId());
        User user = getUserById(track.getSingerId());
        result.setName(track.getName());
        result.setUser(user);
        return trackRepository.save(result);
    }

    @Override
    public void deleteTrack(long id) {
        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> findTrackByName(String name){
        return trackRepository.findTrackByName(name);
    }

    private User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);

        if(result.isPresent()) return result.get();
        else throw new AntnestException("User not found id - " + id, 404);
    }

}
