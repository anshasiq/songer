package com.example.songr ;

import com.example.songr.Repo.Repo;
import com.example.songr.models.Song;
import com.example.songr.models.albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class Allreq {


//    @Override
//    @RequestMapping("homepage")

    @GetMapping("/hello")
    public String renderAPage(Model viewName){
        viewName.addAttribute("name","Ahmad");
        return "hello.html";
    }

    @GetMapping("/capitalize/{cookieName}")
    public String capitalize(Model m , @PathVariable String cookieName) {
        String name=cookieName;
        m.addAttribute("name",name.toUpperCase());
        return "hello.html";
    }
//    @GetMapping("/albums")
//    public String albums(Model albmusModel){
//        Album album1 = new Album("Born to die","Lana del rey",9,180,"https://i.pinimg.com/564x/34/32/93/3432934519d074a56031263185e405a9.jpg");
//        Album album2 = new Album("The Eminem Show" , "Eminem",19 ,4260,"https://i.pinimg.com/564x/07/13/9c/07139c5c7253898b88652e97c3604466.jpg");
//        Album album3 = new Album("This Is Acting" , "Sia" , 18,4230,"https://i.pinimg.com/564x/0a/b9/3a/0ab93a940574edcb06814837533905d2.jpg");
//        albmusModel.addAttribute("albums",new Album[]{album1,album2,album3});
//        return "album.html";
//    }
    @GetMapping("")
    @ResponseBody
    public String albums(){
      return "Home page";
    }

 @Autowired
    Repo Repo;

//    @PutMapping("/updateAlbum")
//    public RedirectView updateAlbumArtist (  @RequestParam String titlee,  @RequestParam String newArtist) {
//        // Find the album by title
//        albums album = Repo.findByTitle(titlee);
//
//        // Check if the album exists
//        if (album != null) {
//            // Update the artist
//            album.setArtist(newArtist);
//            Repo.save(album);
//        }
//
//        // Redirect to a suitable page (e.g., details of the updated album)
//        return new RedirectView("/");
//    }

    @DeleteMapping("/delete/{id}")
    public RedirectView deleteAlbumById(@PathVariable Long id) {
        // Check if the album with the given ID exists
        if (Repo.existsById(id)) {
            // Delete the album by ID
            Repo.deleteById(id);
        }
        // Redirect to a suitable page (e.g., list of albums)
        return new RedirectView("/");
    }
    @PostMapping("/create")
    public RedirectView addsong(String title, String artist, int songCount, int length, String imageUrl )
    {
        albums newStore = new albums(title, artist, songCount, length,  imageUrl);
        Repo.save(newStore);
        return new RedirectView("/");
    }

    @GetMapping("/")
    public String getSalmonCookiesStores(Model m)
    {
        List<albums> songs = Repo.findAll();
        m.addAttribute("albums",songs);
        return "album.html";

    }


}
