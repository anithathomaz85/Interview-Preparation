package gts;

/*
* 
*  Given a set of songs, say 10 songs. Play the songs such that 
1. All the songs in a set will get played 
2. songs will get played in random order. 
(Write pseudo code for the logic applied and explain the time and space complexity. 
Answer should have only Big O(n) time and space complexity) "
*/

/**
* 
* Pseudocode
* 
* function playSongsRandomly(songList):
    n = length of songList
 
    // Step 1: Shuffle songs
    for i from n - 1 down to 1:
        j = random number between 0 and i
        swap songList[i] with songList[j]
 
    // Step 2: Play each song
     * 
    for song in songList:
        play(song)
 
*
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
 
public class Q032_ShuffleSongs {
 
	public static void main(String[] args) {
 
		List<String> songs = Arrays.asList("Song1", "Song2", "Song3", "Song4", "Song5",
											"Song6", "Song7", "Song8","Song9", "Song10");
 
		// Step 2: Shuffle the list using Fisher-Yates algorithm 
		List<String> shuffledSongs = new ArrayList<>(songs);  
		shuffleSongs(shuffledSongs);
 
		// Step 3: Play the songs
		for (String song : shuffledSongs) {
			play(song);
		}
	}
 
	// Fisher-Yates Shuffle (O(n) time, O(n) space if using a copied list)
 	public static void shuffleSongs(List<String> list) {
 		
		Random rand = new Random();
 		// for (int i = list.size() - 1; i > 0; i--) {
		for (int i = 0; i < list.size(); i++) {
 			int j = rand.nextInt(i + 1); // random index from 0 to i
 			// Swap list[i] with list[j]
 			Collections.swap(list, i, j);
		}
	}
 
	public static void play(String song) {
		System.out.println("Playing: " + song);
	}
}
