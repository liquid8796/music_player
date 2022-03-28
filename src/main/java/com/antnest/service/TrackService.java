package com.antnest.service;

import com.antnest.dto.TrackDTO;
import com.antnest.entity.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackService {

    public Page<Track> findAll(Pageable pageable);

    public Track getTrackById(long id);

    public List<Track> findTrackByName(String name);

    public Track addTrack(TrackDTO track);

    public Track updateTrack(TrackDTO track);

    public void deleteTrack(long id);
}
