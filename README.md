# SongList.java
# Description
This project implements a linked list data structure to manage a collection of Song objects. The Song class is provided by the Bridges API and contains information about a song such as its title, artist, and album.

The SongList class implements the List interface and provides methods for inserting, appending, removing, and iterating over the Song objects in the list. Additionally, it includes a method to retrieve a formatted list of all the songs by a given artist.

# Usage
To use the SongList class, simply create a new instance and call its methods to manipulate the list. Here's an example:
```
SongList myList = new SongList();

// insert a song

Song song1 = new Song("title1", "artist1", "album1", 1);
myList.insert(song1);

// append a song
Song song2 = new Song("title2", "artist2", "album2", 2);
myList.append(song2);

// iterate over the list
myList.moveToStart();
while (!myList.isAtEnd()) {
    Song currentSong = myList.getValue();
    System.out.println(currentSong.getTitle());
    myList.next();
}

// get songs by artist
String formattedList = myList.getSongsByArtist("artist1");
System.out.println(formattedList);
```
# Credits
This project was created by Mohammad Garada 

# Song Comparator 
# Description
This is a Java program that implements the Comparator interface to sort a list of Song objects by their titles in ascending order. This program uses the Bridges API to access the Song class.

# Dependencies
To run this program, you will need the following:

- Java Development Kit (JDK)
- Bridges API

# Usage
To use this program, follow these steps:

1. Clone or download the repository to your local machine.
2. Open the project in your Java IDE.
3. Run the SongComparatorDemo class to see the program in action.
4. Optionally, you can modify the SongComparator class to change the sorting criteria.

# Acknowledgements
This project uses the Bridges API 

