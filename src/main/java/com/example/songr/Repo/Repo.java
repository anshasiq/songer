package com.example.songr.Repo;

import com.example.songr.control.albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<albums,Long> {

}