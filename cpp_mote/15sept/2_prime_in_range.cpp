#include <iostream>
using namespace std;


bool isPrime(int no);
int main()
{
    int N, M;
    cout<<"Enter the range\n";
    cin>>N>>M;

    for(int i=N; i<=M; i++)
    {
        if(isPrime(i))
        {
        cout<<i<<", ";
        }
    }
    return 0;
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
