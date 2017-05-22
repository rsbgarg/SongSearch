package com.search;

import java.util.Iterator;
import java.util.LinkedList;

public class Dictionary {
	
	TreeNode root;
	
	public Dictionary(){
		root = new TreeNode();
		root.first = null;
		root.sibling = null;
	}

	
	public void search(String g1,String g2, String a1, String a2){
		TreeNode t = root;
		Song s = new Song();
		boolean found = false;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if(root.first == null){
			//System.out.println("Empty");
			return;
		}else if(t.first != null){

			if(t.first.data == g1){
				found = true;
			}
			list.add(t.first);			
			
		}
		
		while(t.sibling != null){
				t = t.sibling;
				if(t.data == g1){
					list.addFirst(t);
					found = true;
					
				}else if(t.data == g2){
					if(!found){
						list.addFirst(t);
					}else{
						TreeNode t2 = list.removeFirst();
						list.addFirst(t);
						list.addFirst(t2);
					}
				}else{
					list.add(t);
				}
				
				
		}
		Iterator<TreeNode> it = list.iterator();
		while(it.hasNext()){
			
			//System.out.println(t.data);
			TreeNode t2 = it.next();
			s.setGenre(t2.getData());
			goToArtist(s,t2,a1,a2);
		}
		
	}
	
	private void goToArtist(Song s,TreeNode t, String a1, String a2) {
//		//System.out.println("inartist");
		// TODO Auto-generated method stub
		boolean found = false;
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if(t.first == null){
			//System.out.println("Empty");
			return;
		}else if(t.first != null){
			
			if(t.first.data == a1){
				found = true;
			}
			list.add(t.first);
			
		}
		while(t.sibling != null){
			t = t.sibling;
			if(t.data == a1){
				list.addFirst(t);
				found = true;
				
			}else if(t.data == a2){
				if(!found){
					list.addFirst(t);
				}else{
					TreeNode t2 = list.removeFirst();
					list.addFirst(t);
					list.addFirst(t2);
				}
			}else{
				list.add(t);
			}
			
			
		}
		Iterator<TreeNode> it = list.iterator();
		while(it.hasNext()){
			
			//System.out.println(t.data);
			TreeNode t2 = it.next();
			s.setArtist(t2.getData());
			goToAlbum(s,t2);
		}
	
		
	}


	private void goToAlbum(Song s, TreeNode t) {
		// TODO Auto-generated method stub
//		//System.out.println("album");
		if(t.first == null){
			//System.out.println("Empty");
			return;
		}else if(t.first != null){
//			
			//System.out.println(t.first.data);
			s.setAlbum(t.first.data);
			goToTitle(s,t.first);
			
		}
			while(t.sibling != null){
				t = t.sibling;
//				//System.out.println(t.data);
				s.setAlbum(t.data);
				goToTitle(s,t);
			}
		
//			
			
			
		
	}


	private void goToTitle(Song s, TreeNode t) {
		// TODO Auto-generated method stub
		if(t.first == null){
			//System.out.println("Empty");
			return;
		}else if(t.first != null){
//			
			//System.out.println(t.first.data);
			s.setTitle(t.first.data);
			s.print();
			
		}
			
		while(t.sibling != null){
				t = t.sibling;
//				//System.out.println(t.data);
				s.setTitle(t.data);
				s.print();
				
		}
//			
			
			
		
	}


	public void addToDictionary(Song song) {
//		//System.out.println("addgenre");
//		song.print();
		boolean found = false;
		TreeNode temp = root;
		if(temp.first == null){
			TreeNode t = new TreeNode();
			t.data = song.genre;
			temp.first = t;
			addArtist(song, t);
			
		}else if(temp.first.data == song.genre){
			addArtist(song,temp.first);
			
		}else{
			while(temp.sibling !=null){
				if(temp.sibling.data == song.genre){
					//System.out.println("yo");
					addArtist(song,temp.sibling);
					found = true;
					break;
				}
				temp = temp.sibling;
				
			}
			if(temp.sibling == null && !found){
				//System.out.println("yo");
				TreeNode t = new TreeNode();
				t.data = song.genre;
				temp.sibling = t;
				addArtist(song, t);
			}
		}
		
		
	}

	private void addArtist(Song song,TreeNode temp) {
		// TODO Auto-generated method stub
//		TreeNode temp = root;
//		//System.out.println("addartist");
		boolean found = false;
		
		if(temp.first == null){
			TreeNode t = new TreeNode();
			t.data = song.artist;
			temp.first = t;
			addAlbum(song, t);
			
		}else if(temp.first.data == song.artist){
			addAlbum(song,temp.first);
			
		}else{
			while(temp.sibling !=null){
				if(temp.sibling.data == song.artist){
					addAlbum(song,temp.sibling);
					found = true;
					break;
				}
				temp = temp.sibling;
				
			}
			if(temp.sibling == null && !found){
				TreeNode t = new TreeNode();
				t.data = song.artist;
				temp.sibling = t;
				addAlbum(song, t);
			}
		}
		
		
		
	}

	private void addAlbum(Song song,TreeNode temp) {
		// TODO Auto-generated method stub
//		//System.out.println("addal");
		boolean found = false;
		if(temp.first == null){
			TreeNode t = new TreeNode();
			t.data = song.album;
			temp.first = t;
			addTitle(song, t);
			
		}else if(temp.first.data == song.album){
			//System.out.println("test");
			addTitle(song,temp.first);
			
		}else{
			while(temp.sibling !=null){
				if(temp.sibling.data == song.album){
					addTitle(song,temp.sibling);
					found = true;
					break;
				}
				temp = temp.sibling;
				
			}
			if(temp.sibling == null && !found){
				TreeNode t = new TreeNode();
				t.data = song.album;
				temp.sibling = t;
				addTitle(song, t);
			}
		}
		
	}

	private void addTitle(Song song, TreeNode temp) {
		// TODO Auto-generated method stub
//		//System.out.println("addtit");
		
		boolean found = false;
		if(temp.first == null){
			TreeNode t = new TreeNode();
			t.data = song.title;
			temp.first = t;
//			song.print();
		}else if(temp.first.data == song.title){
			addTitle(song,temp.first);
			
		}else{
			while(temp.sibling !=null){
				if(temp.sibling.data == song.title){
					found = true;
					break;
				}
				temp = temp.sibling;
				
			}
			if(temp.sibling == null && !found){
				
				TreeNode t = new TreeNode();
				t.data = song.title;
				temp.sibling = t;
			}
		}
		
		
	}
}
