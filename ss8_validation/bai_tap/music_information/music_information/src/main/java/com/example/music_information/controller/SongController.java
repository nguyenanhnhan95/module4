package com.example.music_information.controller;

import com.example.music_information.dto.SongDto;
import com.example.music_information.model.Song;
import com.example.music_information.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String homeSong(@PageableDefault(size = 2)Pageable pageable, Model model){
        model.addAttribute("songs",songService.getListSong(pageable));
        return "home";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.saveSong(song);
        redirectAttributes.addFlashAttribute("msg","Đã thêm mới thành công: ");
        return "redirect:/song";
    }
    @PostMapping("/delete")
    public String delete(@PathParam("id") int id, RedirectAttributes redirectAttributes){
        songService.deleteSong(id);
        return "redirect:/song";
    }
    @GetMapping("/edit")
    public String editForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute SongDto songDto,Model model,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("songDto",songDto);
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.updateSong(song);
        return "redirect:/song";
    }
}
