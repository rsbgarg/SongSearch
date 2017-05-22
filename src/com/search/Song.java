package com.search;

public class Song {
	
	String title;
	String genre;
	String artist;
	String album;
	
	public Song(String title, String genre, String artist, String album) {
		super();
		this.title = title;
		this.genre = genre;
		this.artist = artist;
		this.album = album;
	}
	public Song() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.genre + " " + this.artist + " " + this.album + " " + this.title);
		
	}
	

}
