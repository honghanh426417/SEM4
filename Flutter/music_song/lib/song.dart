class Song {
  String title;
  String artist;
  int duration; 
  Song({required this.title, required this.artist, required this.duration});

  @override
  String toString() {
    return 'Title: $title, Artist: $artist, Duration: $duration seconds';
  }
}
