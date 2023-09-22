#include <iostream>


int main()
{
    int n,p,r=1;
    std::cout<<"Enter the number and power\n";
    std::cin>>n>>p;
    int i=1;
    while(i<=p)
    {
        r = r*n;
        i++;
    }
    std::cout<<"Result is : "<<r;
    return 0;
}