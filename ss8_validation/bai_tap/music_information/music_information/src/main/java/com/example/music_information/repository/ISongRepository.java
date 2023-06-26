package com.example.music_information.repository;

import com.example.music_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {
    Page<Song> findAllByFlagDeleteIsFalse(Pageable pageable);
    Song getSongByIdAndFlagDeleteFalse(int id);
}
