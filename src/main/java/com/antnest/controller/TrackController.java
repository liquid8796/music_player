package com.antnest.controller;

import com.antnest.dto.TrackDTO;
import com.antnest.entity.Track;
import com.antnest.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TrackController {

    private static final int size = 2;

    @Autowired
    private TrackService trackService;

    @GetMapping("/tracks")
    public List<Track> getTracks(@RequestParam(defaultValue="0") int page){

        List<Track> tracks = new ArrayList<>();
        Pageable paging = PageRequest.of(page, size);

        Page<Track> pageTracks = trackService.findAll(paging);
        tracks = pageTracks.getContent();

        return tracks;
    }

    @GetMapping("/track/{id}")
    public Track getTrackById(@PathVariable long id){
        return trackService.getTrackById(id);
    }

    @GetMapping("/track/search")
    public List<Track> findTrackByName(@RequestParam String word){
        return trackService.findTrackByName(word);
    }

    @PostMapping("/track")
    public Track addTrack(@RequestBody TrackDTO track){
        Track result = trackService.addTrack(track);
        return result;
    }

    @PutMapping("/track")
    public Track updateTrack(@RequestBody TrackDTO track){
        Track result = trackService.updateTrack(track);
        return result;
    }

    @DeleteMapping("/track/delete/{id}")
    public String deleteTrack(@PathVariable long id){
        trackService.deleteTrack(id);
        return "Deleted track - " + id;
    }
}
