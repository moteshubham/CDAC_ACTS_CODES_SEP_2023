#include <iostream>


int main()
{
    int no1, no2, temp;

    std::cout<<"Enter the two numbers no1 and no2\n";
    std::cin>>no1>>no2;
    std::cout<<"Entered numbers are \nno1= "<<no1<<", no2= "<<no2<<"\n";
    temp = no1;
    no1= no2;
    no2= temp;
    std::cout<<"After swapping numbers are \nno1= "<<no1<<", no2= "<<no2<<"\n";

    return 0;
}