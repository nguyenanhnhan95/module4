package com.example.music_information.service.impl;

import com.example.music_information.model.Song;
import com.example.music_information.repository.ISongRepository;
import com.example.music_information.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> getListSong(Pageable pageable) {
        return songRepository.findAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void deleteSong(int id) {
        Song song = viewSong(id);
        song.setFlagDelete(true);
        songRepository.save(song);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song viewSong(int id) {
        return songRepository.getSongByIdAndFlagDeleteFalse(id);
    }

    @Override
    public Page<Song> searchBySong(String song, Pageable pageable) {
        return null;
    }
}
