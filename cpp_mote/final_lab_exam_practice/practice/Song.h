#include <iostream>
class Song
{
private:
    int songId;
    std::string songName;
    std::string lyrics;
    int durSec;
    std::string singer;

public:
    Song(){}
    Song(int songId, std::string songName, std::string singer, std::string lyrics, int durSec);
    void setSongName(std::string songName);
    std::string getSongName();
    void setSinger(std::string singer);
    std::string getSinger();
    void setLyrics(std::string lyrics);
    std::string getLyrics();
    void setDurationSec(int durSec);
    int getDurationSec();
    int getSongId();
};