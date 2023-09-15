package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
//import
//import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.songr.models.albums;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@AutoConfi
@SpringBootTest
@AutoConfigureMockMvc
public class SongTest {
    @Autowired
    MockMvc mockMvc;
    ///addsong/2
    @Test
    public void givenPostRequest_toCreateAn_Album_ShouldCreateARecordInDB() throws Exception {
        mockMvc.perform(
                post("/create")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("title", "The asd")
                        .param("artist", "anshasu")
                        .param("songCount", String.valueOf(4))
                        .param("length", String.valueOf(45))
                        .param("imageUrl", "image.jpg")
        ).andExpect(redirectedUrl("/")).andExpect(status().isFound());
    }
    @Test
    public void testGetTitle() {
        albums album = new albums("Album Title", "Artist", 10, 60, "image.jpg");
        assertEquals("Album Title", album.getTitle());
    }


    @Test
    public void homePageRender() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("<h1>Add An Album</h1>")));
    }

}
