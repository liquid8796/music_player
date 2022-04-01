package com.antnest.controller;

import com.antnest.dto.PlaylistDTO;
import com.antnest.entity.Playlist;
import com.antnest.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaylistController {

    private static final int size = 2;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public List<Playlist> getPlaylists(@RequestParam(defaultValue="0") int page){

        Pageable paging = PageRequest.of(page, size);

        Page<Playlist> pagePlaylists = playlistService.findAllPublic(paging);
        List<Playlist> playlists = pagePlaylists.getContent();

        return playlists;
    }

    @GetMapping("/playlist/{id}")
    public Playlist getPlaylistsById(@PathVariable long id){
        return playlistService.getPlaylistById(id);
    }

    @GetMapping("/playlist/search")
    public List<Playlist> searchPlaylist(@RequestParam String word){
        return playlistService.searchPlaylist(word);
    }

    @PostMapping("/playlist")
    public Playlist addPlaylist(@RequestBody PlaylistDTO playlist){
        Playlist result = playlistService.addPlaylist(playlist);
        return result;
    }

    @GetMapping("/playlist/{pId}/add/{tId}")
    public Playlist addTrackToPlaylist(@PathVariable long pId, @PathVariable long tId){
        Playlist result = playlistService.addTrackToPlaylist(pId, tId);
        return result;
    }

    @PutMapping("/playlist")
    public Playlist updatePlaylist(@RequestBody PlaylistDTO playlist){
        Playlist result = playlistService.updatePlaylist(playlist);
        return result;
    }

    @GetMapping("/playlist/{pId}/remove/{tId}")
    public Playlist deletePlaylist(@PathVariable long pId, @PathVariable long tId){
        Playlist result = playlistService.removeTrackFromPlaylist(pId, tId);
        return result;
    }

    @DeleteMapping("/playlist/delete/{id}")
    public String deletePlaylist(@PathVariable long id){
        playlistService.deletePlaylist(id);
        return "Deleted playlist - " + id;
    }
}
