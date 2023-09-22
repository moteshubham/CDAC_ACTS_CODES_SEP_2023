#include <iostream>
using namespace std;

int main()
{

    int n;
    cout<<"Enter the number for the staaaa****rrr pattern : ";
    cin>>n;
    cout<<"\n";

    for(int i=0; i<n; i++)
    {
        for(int j=0; j<=i; j++)
        {
            cout<<"*";
        }
        cout<<"\n";
    }
    return 0;
}