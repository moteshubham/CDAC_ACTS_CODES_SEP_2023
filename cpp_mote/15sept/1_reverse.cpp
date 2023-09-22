#include <iostream>
using namespace std;

int reverseNum(int num);
void displayRev(int rev);
bool isPrime(int no);
int main()
{
    int num;
    cout<<"Enter the number : ";
    cin>>num;
    int reverse = reverseNum(num);
    displayRev(reverse);
    if(isPrime(num))
    {
        cout<<"Number is prime. \n";
    }
    else
    {
        cout<<"Number is not prime.\n";
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

void displayRev(int rev)
{
    cout<<"Reversed number is : "<<rev<<"\n";
}

bool isPrime(int no)
{
    int flag= 1;
    for(int i=2; i<no; i++)
    {
        if(no%i==0)
        {
            flag = 0;
            break;
        }
    }
    return flag;
}