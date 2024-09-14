import 'dart:io';
import 'package:music_song/song.dart';

List<Song> songs = [];

void main() {
  while (true) {
    print('--- Music Manager ---');
    print('1. Add Song');
    print('2. List Songs');
    print('3. Update Song');
    print('4. Delete Song');
    print('5. Exit');
    stdout.write('Choose an option: ');
    String? choice = stdin.readLineSync();

    switch (choice) {
      case '1':
        addSong();
        break;
      case '2':
        listSongs();
        break;
      case '3':
        updateSong();
        break;
      case '4':
        deleteSong();
        break;
      case '5':
        print('Exiting...');
        return;
      default:
        print('Invalid option, please try again.');
    }
  }
}

void addSong() {
  try {
    stdout.write('Enter song title: ');
    String? title = stdin.readLineSync();
    stdout.write('Enter artist name: ');
    String? artist = stdin.readLineSync();
    stdout.write('Enter duration (seconds): ');
    int duration = int.parse(stdin.readLineSync() ?? '0');

    if (title == null || artist == null || duration <= 0) {
      throw FormatException('Invalid input. Please provide valid song details.');
    }

    Song song = Song(title: title, artist: artist, duration: duration);
    songs.add(song);
    print('Song added successfully!');
  } catch (e) {
    print('Error: ${e.toString()}');
  }
}

void listSongs() {
  if (songs.isEmpty) {
    print('No songs available.');
    return;
  }
  for (int i = 0; i < songs.length; i++) {
    print('Song ${i + 1}: ${songs[i]}');
  }
}

void updateSong() {
  try {
    listSongs();
    stdout.write('Enter song number to update: ');
    int index = int.parse(stdin.readLineSync() ?? '0') - 1;

    if (index < 0 || index >= songs.length) {
      throw FormatException('Invalid song number.');
    }

    stdout.write('Enter new title (press enter to keep current): ');
    String? title = stdin.readLineSync();
    stdout.write('Enter new artist (press enter to keep current): ');
    String? artist = stdin.readLineSync();
    stdout.write('Enter new duration (seconds, press enter to keep current): ');
    String? durationInput = stdin.readLineSync();
    int duration = durationInput != null && durationInput.isNotEmpty
        ? int.parse(durationInput)
        : songs[index].duration;

    Song updatedSong = Song(
      title: title?.isEmpty ?? true ? songs[index].title : title!,
      artist: artist?.isEmpty ?? true ? songs[index].artist : artist!,
      duration: duration,
    );
    songs[index] = updatedSong;
    print('Song updated successfully!');
  } catch (e) {
    print('Error: ${e.toString()}');
  }
}

void deleteSong() {
  try {
    listSongs();
    stdout.write('Enter song number to delete: ');
    int index = int.parse(stdin.readLineSync() ?? '0') - 1;

    if (index < 0 || index >= songs.length) {
      throw FormatException('Invalid song number.');
    }

    songs.removeAt(index);
    print('Song deleted successfully!');
  } catch (e) {
    print('Error: ${e.toString()}');
  }
}
