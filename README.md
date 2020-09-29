# imagination
The two files SongCache.java and SongCacheImpl.java can be found at **imagination/src/main/java/com/zhu**

As the program could be run by multiple threads, so I have chosen ConcurrentHashMap to store song names and times played. Because it's a thread-safe data structure so it would not get into dead cycle when augmenting its size. 

For the `void recordSongPlays(String songId, int numPlays)` method, it requires the number of play to be a positive number or it would throw an exception. The time complexity is O(1) for put() method.

For the `int getPlaysForSong(String songId)` method, the time complexity is also O(1).

For the `List<String> getTopNSongsPlayed(int n)` method, I have created a PriorityQueue as a minimum heap to store the top n songs played, it would only need O(k) space complexity where k is equal to the parameter n. As each insertion requires O(logk) time complexity so for n elements in the ConcurrentHashmap it would require O(nlogk). 