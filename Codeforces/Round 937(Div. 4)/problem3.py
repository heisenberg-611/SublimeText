def min_removals_for_exciting_playlist(n, songs):
    # Create a dictionary to store the count of genres and writers.
    genre_count = {}
    writer_count = {}
    
    # Initialize the total count of songs.
    total_songs = len(songs)
    
    # Iterate through each song and update the counts.
    for genre, writer in songs:
        genre_count[genre] = genre_count.get(genre, 0) + 1
        writer_count[writer] = writer_count.get(writer, 0) + 1
    
    # Initialize the minimum removals needed.
    min_removals = float('inf')
    
    # Iterate through all possible subsets of songs.
    for mask in range(1 << total_songs):
        valid_genres = set()
        valid_writers = set()
        removals = 0
        
        # Check each song in the subset.
        for i in range(total_songs):
            if mask & (1 << i):
                genre, writer = songs[i]
                valid_genres.add(genre)
                valid_writers.add(writer)
            else:
                removals += 1
        
        # Check if the subset is exciting.
        if len(valid_genres) == genre_count and len(valid_writers) == writer_count:
            min_removals = min(min_removals, removals)
    
    return min_removals

# Read the number of test cases.
t = int(input().strip())

# Process each test case.
for _ in range(t):
    n = int(input().strip())
    songs = [input().strip().split() for _ in range(n)]
    result = min_removals_for_exciting_playlist(n, songs)
    print(result)
