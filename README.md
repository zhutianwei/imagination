# imagination

As the program could be run by multiple threads, so I have chosen ConcurrentHashMap to store song names and times they have been played. Because it's a thread-safe
data structre and would not get into dead cycle when augmenting its size. 
