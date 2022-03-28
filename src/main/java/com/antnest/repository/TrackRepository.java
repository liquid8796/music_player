package com.antnest.repository;

import com.antnest.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "select * from Track t where t.name LIKE %:name%", nativeQuery = true)
    List<Track> findTrackByName(@Param("name") String name);
}
