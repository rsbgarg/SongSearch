package com.search;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Song s1 = new Song("Arriving","Rock","porcupine","insomnia");
		Song s2 = new Song("Trains","Metal","porcupine","insomnia");
		Song s3 = new Song("Stairway","Rock","Led Zep","led zep album");
		Song s4 = new Song("Whole Lotta","Metal","Led Zep","grafiti");
		
		Dictionary d = new Dictionary();
		d.addToDictionary(s1);
		d.addToDictionary(s2);
		d.addToDictionary(s3);
		d.addToDictionary(s4);
		
		d.search("Rock", "Metal", "porcupine", "Led Zep");

	}

}
