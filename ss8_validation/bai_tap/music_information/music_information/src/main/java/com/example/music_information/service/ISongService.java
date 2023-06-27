package com.example.music_information.service;

import com.example.music_information.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    Page<Song> getListSong(Pageable pageable);

    void deleteSong(int id);

    void updateSong(Song song);

    void saveSong(Song song);

    Song viewSong(int id);

    Page<Song> searchBySong(String song, Pageable pageable);
}
