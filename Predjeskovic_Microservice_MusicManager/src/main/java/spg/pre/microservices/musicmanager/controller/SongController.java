package spg.pre.microservices.musicmanager.controller;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spg.pre.microservices.musicmanager.services.SongDto;
import spg.pre.microservices.musicmanager.services.SongService;

import java.util.List;

@RestController @RequestMapping(SongController.MUSIC_ROUTE)
public class SongController {

    public static final String MUSIC_ROUTE = "/music";

    public final SongService musicService;

    @Autowired
    public SongController(SongService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public List<SongDto> getAllSongs(){
        return  musicService.getAllSongs();
    }

    @GetMapping(path = "/{id}")
    public SongDto getOneSongById(@PathVariable @NonNull String id){
        return musicService.getOneSong(id);
    }

    @PostMapping
    public SongDto addMusic(@RequestBody SongDto musicDto){
        return musicService.addMusic(musicDto);
    }

    @PutMapping("/{id}/{fieldName}/{fieldValue}")
    public void updateSongField(@PathVariable String id, @PathVariable String fieldName, @PathVariable String fieldValue){
        musicService.partialUpdate(id,fieldName,fieldValue);
    }

    @DeleteMapping({"/{id}"})
    public void deleteMusic(@PathVariable String id){
        musicService.deleteMusic(id);
    }




}
