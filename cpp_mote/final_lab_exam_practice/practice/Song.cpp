#include "Song.h"

Song::Song(int songId, std::string songName, std::string singer, std::string lyrics, int durSec)
{
    this->songId = songId;
    this->songName = songName;
    this->singer = singer;
    this->lyrics = lyrics;
    this->durSec = durSec;
}

void Song::setSongName(std::string songName)
{
    this->songName = songName;
}

std::string Song::getSongName()
{
    return this->songName;
}

void Song::setSinger(std::string singer)
{
    this->singer = singer;
}

std::string Song::getSinger()
{
    return this->singer;
}

void Song::setLyrics(std::string lyrics)
{
    this->lyrics = lyrics;
}

std::string Song::getLyrics()
{
    return this->lyrics;
}
void Song::setDurationSec(int durSec)
{
    this->durSec = durSec;
}
int Song::getDurationSec()
{
    return this->durSec;
}

int Song::getSongId(){
    return this->songId;
}