#include <iostream>
using namespace std;

int reverseNum(int num);

int main()
{
    int num;
    cout<<"Enter the number : ";
    cin>>num;
    int reverse = reverseNum(num);
    if(num==reverse)
    {
        cout<<"Number is pallindrome\n";
    }
    else
    {
        cout<<"Number is NOT a pallindrome\n";
    }
    
    return 0;
}

int reverseNum(int num)
{
    int reversed=0, rem;
    while(num!= 0)
    {
        rem = num% 10;
        reversed = reversed*10+ rem;
        num = num/10; 
    }
    return reversed;
}

