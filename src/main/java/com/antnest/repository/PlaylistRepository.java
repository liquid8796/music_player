package com.antnest.repository;

import com.antnest.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query(value = "select * from Playlist p where p.is_public = True", nativeQuery = true)
    List<Playlist> findAllPublic();

    @Query(value = "select p.* " +
            "from Playlist as p " +
            "join User as u on p.owner_id=u.id " +
            "where p.name LIKE %:search% or p.genre LIKE %:search% or u.first_name LIKE %:search% or u.last_name LIKE %:search%", nativeQuery = true)
    List<Playlist> searchPlaylist(@Param("search") String search);
}
