package cmsc256;

/*
File Name: SongList.java
Programmer Name: Mohammad Garada
File Description: Searching and sorting data related to bridges.data_src_dependent.Song objects
 */



import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

import java.util.ArrayList;


//implementation of linked lists
public class SongList implements cmsc256.List<bridges.data_src_dependent.Song> {

    //main method for testing
    public static void main(String[] args) {
        SongList test = new SongList();
        System.out.println(test.getValue().getArtist());
        test.next();
    }


    //instance variables
    private SLelement<Song> headValue;
    private SLelement<Song> tailValue;
    private SLelement<Song> currentValue;
    private int listSizeValue;

    //constructors
    public SongList() {
        clear();
        connectToBridges();
    }

    SongList(int size) {
        this();
    }


    @Override
    //clears all elements
    public void clear() {
        //creates trail value
        currentValue = tailValue = new SLelement<>(null);

        //creates header value
        headValue = new SLelement<>(tailValue);
        listSizeValue = 0;
    }

    @Override
    //inserts the parameter of "it" into the currentValue position
    public boolean insert(Song it) {
        currentValue.setNext(new SLelement<>(currentValue.getValue(), currentValue.getNext()));
        currentValue.setValue(it);
        if (tailValue == currentValue) {
            //creates a new tail
            tailValue = currentValue.getNext();
        }
        //increases element count
        listSizeValue++;
        return true;
    }

    @Override
    //appends the parameter of "it" to the list
    public boolean append(Song it) {
        tailValue.setNext(new SLelement<>(null));
        tailValue.setValue(it);
        tailValue = tailValue.getNext();
        //increase element count
        listSizeValue++;
        return true;
    }


    @Override
    //this method removes and returns whatever is stored into the current value
    public Song remove() {
        //if there is nothing to remove, return null
        if (currentValue == tailValue) {
            return null;
        }
        //stores and remembers the elements
        Song it = currentValue.getValue();
        currentValue.setValue(currentValue.getNext().getValue());
        if (currentValue.getNext() == tailValue) {
            tailValue = currentValue;
        }
        currentValue.setNext(currentValue.getNext().getNext());
        listSizeValue--; //decreases element count
        //returns it
        return it;
    }

    @Override
    public void moveToStart() {
        //sets the current value at the start of the list
        currentValue = headValue.getNext();
    }

    @Override
    public void moveToEnd() {
        //sets the current value at the end of the list
        currentValue = tailValue;
    }

    @Override
    public void prev() {
        //shifts the current value once to the left
        if (headValue.getNext() == currentValue) {
            //there is no previous element
            return;
        }
        SLelement<Song> temp = headValue;

        //look for the previous element in the list
        while (temp.getNext() != currentValue) {
            temp = temp.getNext();
        }
        currentValue = temp;
    }

    @Override
    //shifts the current value once to the right
    public void next() {
        if (currentValue != currentValue.getNext()) {
            currentValue = currentValue.getNext();
        }
    }

    @Override
    public int length() {
        //returns the length of the list
        return listSizeValue;
    }

    @Override
    //method returns the position of the current element value
    public int currPos() {
        SLelement<Song> temp = headValue.getNext();
        int i;
        for (i = 0; currentValue != temp; i++) {
            temp = temp.getNext();
        }
        return i;
    }

    @Override
    // moves down in the list to "pos" parameter position
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSizeValue)) {
            return false;
        }
        currentValue = headValue.getNext();
        for (int i = 0; i < pos; i++) {
            currentValue = currentValue.getNext();
        }
        return true;
    }

    @Override
    //This method is to see if current position is at end of the list, if so return true
    public boolean isAtEnd() {
        return currentValue == tailValue;
    }

    @Override
    //method to return current element value
    public Song getValue() {
        //if there is no current element
        if (currentValue == tailValue) {
            // null is returned if current value is at the tail
            return null;
        }
        return currentValue.getValue();
    }

    //returns a formatted list of all the songs by an artist to the method that appear on the linked list
    public String getSongsByArtist(String artist) {
        ArrayList<Song> newSongList = new ArrayList<>();
        for (int i = 0; i < listSizeValue; i++) {
            if (currentValue.getValue().getArtist().equals(artist)) {
                //  newSongList.add(curr);
            }
        }


        return null;
        // return null;
    }


    //method in order to connect to bridges
    protected void connectToBridges() {
        Bridges bridges = new Bridges(3, "moeg", "1635461342501");
        DataSource ds = bridges.getDataSource();

        try {
            java.util.List<Song> allSongs = ds.getSongData();


            for (int i = 0; i < allSongs.size(); i++) {
                this.append(allSongs.get(i));
            }
        } catch (Exception e) {
            System.out.println("Unable to connect to bridges" + e.getMessage());
            e.printStackTrace();
        }
    }

}











