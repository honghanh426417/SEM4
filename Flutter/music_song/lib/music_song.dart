import 'dart:io';
import 'song.dart';

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
  stdout.write('Enter song title: ');
  String? title = stdin.readLineSync();
  stdout.write('Enter artist name: ');
  String? artist = stdin.readLineSync();
  stdout.write('Enter duration (seconds): ');
  int duration = int.parse(stdin.readLineSync() ?? '0');

  Song song = Song(title: title ?? '', artist: artist ?? '', duration: duration);
  songs.add(song);
  print('Song added successfully!');
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
  listSongs();
  stdout.write('Enter song number to update: ');
  int index = int.parse(stdin.readLineSync() ?? '0') - 1;

  if (index < 0 || index >= songs.length) {
    print('Invalid song number.');
    return;
  }

  stdout.write('Enter new title: ');
  String? title = stdin.readLineSync();
  stdout.write('Enter new artist: ');
  String? artist = stdin.readLineSync();
  stdout.write('Enter new duration (seconds): ');
  int duration = int.parse(stdin.readLineSync() ?? '0');

  songs[index] = Song(title: title ?? songs[index].title, artist: artist ?? songs[index].artist, duration: duration);
  print('Song updated successfully!');
}

void deleteSong() {
  listSongs();
  stdout.write('Enter song number to delete: ');
  int index = int.parse(stdin.readLineSync() ?? '0') - 1;

  if (index < 0 || index >= songs.length) {
    print('Invalid song number.');
    return;
  }

  songs.removeAt(index);
  print('Song deleted successfully!');
}
