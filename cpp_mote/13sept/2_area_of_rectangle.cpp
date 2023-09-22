#include <iostream>


int main()
{
    int length, breadth, area;

    std::cout<<"Enter the length and breadth\n";
    std::cin>>length>>breadth;
    area= length * breadth;
    std::cout<<"Area = "<<area;
    return 0;
}