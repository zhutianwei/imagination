package com.zhu;

import java.util.*;
import java.util.concurrent.*;

public class SongCacheImpl implements SongCache {
    
    ConcurrentHashMap<String, Integer> songs = new ConcurrentHashMap<>();
        
    /** 
     * Record number of plays for a song. 
     * O(1) time complexity
     */ 
    @Override
    public void recordSongPlays(String songId, int numPlays) {
        if (numPlays < 0) {
            throw new IllegalArgumentException("The number of play must be positive.");
        }

        songs.put(songId, songs.getOrDefault(songId, 0) + numPlays);
    }

    /**
     * Fetch the number of plays for a song. 
     * O(1) time complexity
     * @return the number of plays, or -1 if the song ID is unknown.
     */
    @Override
    public int getPlaysForSong(String songId) {
        if (!songs.containsKey(songId)) {
            return -1;
        } else {
            return songs.get(songId);
        }
    }

    /**
     * Return the top N songs played, in descending order of number of plays.
     * O(Nlogk) time complexity
     * O(k) space complexity
     */
    @Override
    public List<String> getTopNSongsPlayed(int n) {
        if (n <= 0) {
            return null;
        }

        PriorityQueue<String> heap = new PriorityQueue<>( 
            (String n1, String n2) -> songs.get(n1) - songs.get(n2));

        for (String key: songs.keySet()) {
            heap.add(key);
            if (heap.size() > n) {
                heap.poll();
            }
        }

        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            result.addFirst(heap.poll());
        }

        return new ArrayList<>(result);
    }
}
