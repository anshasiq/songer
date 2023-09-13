package com.example.songr;

import com.example.songr.Repo.Repo;
import com.example.songr.Repo.SongRepo;
import com.example.songr.exception.AlbumNotFoundException;
import com.example.songr.models.Song;
//import com.example.songr.models.albums;
import com.example.songr.models.albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class SongController {
    @Autowired
    Repo alb;
    @Autowired
    SongRepo sp;
//  private int length_in_seconds;
//    private int trackNumber;
    @PostMapping("/addsong/{albumId}")
    public RedirectView addsong(String title, int length_in_seconds, int trackNumber ,@PathVariable Long albumId){
        albums album= alb.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("Could not find album for this song in db!"));
//
        Song newsong= new Song(title,length_in_seconds,trackNumber,album);
        sp.save(newsong);
        return new RedirectView("/allSongs/{albumId}");
    }

//    @GetMapping("/getsongs/{albumsId}")
//    public String getsongs(@PathVariable Long albumsId, Model m)
//    {
//        List<Song> songs = sp.findAllById(albumId);
//        m.addAttribute("songs",songs);
//        return "addSong.html";
//
//    }
@GetMapping("/allSongs/{albumId}")
public String getSongs(Model model, @PathVariable Long albumId) {
    System.out.println("#######^^^^####### " + albumId);
        Optional <albums> one = alb.findById(albumId) ;
    albums two =   one.get();
    List <Song> songs = two.getSongs();
//    List <Song> songs =  sp.findAll();
    model.addAttribute("song", songs);
    model.addAttribute("albums", two);
    return "addSong.html";
}


}
