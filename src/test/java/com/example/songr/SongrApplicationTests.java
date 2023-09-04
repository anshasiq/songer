package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetTitle() {
		Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
		assertEquals("Album Title", album.getTitle());
	}

	@Test
	public void testGetArtist() {
		Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
		assertEquals("Artist", album.getArtist());
	}

	@Test
	public void testGetSongCount() {
		Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
		assertEquals(10, album.getSongCount());
	}

	@Test
	public void testGetLength() {
		Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
		assertEquals(60, album.getLength());
	}

	@Test
	public void testGetImageUrl() {
		Album album = new Album("Album Title", "Artist", 10, 60, "image.jpg");
		assertEquals("image.jpg", album.getImageUrl());
	}
}
