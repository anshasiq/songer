package com.example.songr.Repo;

import com.example.songr.models.albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<albums,Long> {
    albums findByTitle(String titlee);

//    albums findByTitle(String title);
}
