#include "Song.h"
#include<vector>
int main(){
    std::vector<Song> songs;
    songs.push_back(Song(1,"Instant Crush", "Daft Punk", "...", 300));
    songs.push_back(Song(2,"Lose Yourself To Dance", "Daft Punk", "...", 300));
    songs.push_back(Song(3,"Lose Yourself", "Eminem", "...", 300));
    songs.push_back(Song(4,"Stan", "Eminem", "...", 300));
    songs.push_back(Song(5,"All Star", "Smash Mouth", "...", 300));
    songs.push_back(Song(6,"Bohemian Rhapsody", "Queen", "...", 300));
    songs.push_back(Song(7,"The Show Must Go On", "Queen", "...", 300));
    songs.push_back(Song(8,"March of th eBlack Queen", "Queen", "...", 300));
    songs.push_back(Song(9,"Arurian Dance", "Nujabes", "...", 300));
    songs.push_back(Song(10,"Breaking The Habbit", "Linkin Park", "...", 300));

    std::string singer;
    std::cout<<"Enter the name of the singer: ";
    std::getline(std::cin, singer);
    int durSec = 0;
    for(Song song : songs){
        if(song.getSinger()==singer)
            durSec += song.getDurationSec();
    }
    std::cout << "You have content of " << singer << " of " << durSec << " seconds\n";
}