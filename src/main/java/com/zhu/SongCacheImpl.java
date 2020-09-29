package com.zhu;

import java.util.*;
import java.util.concurrent.*;

public class SongCacheImpl implements SongCache {
    
    ConcurrentHashMap<String, Integer> songs = new ConcurrentHashMap<>();
        
    /** 
     * Record number of plays for a song. 
     */ 
    @Override
    public void recordSongPlays(String songId, int numPlays) {
        songs.put(songId, songs.getOrDefault(songId, 0) + numPlays);
    }

    /**
     * Fetch the number of plays for a song. 
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

    @Override
    /**
     * Return the top N songs played, in descending order of number of plays.
     */
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
