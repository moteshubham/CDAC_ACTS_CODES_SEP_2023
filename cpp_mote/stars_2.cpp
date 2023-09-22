#include <iostream>
using namespace std;

int main()
{

    int n;
    cout<<"Enter the number for the staaaa****rrr pattern : ";
    cin>>n;
    
    for(int k=n-1; k>=0; k--)
    {
        for(int i=k; i>0; i--)
        {
            cout<<" "; 
        }
        for(int j=1; j<=n-k; j++)
        {
                cout<<"*";
        }
        cout<<"\n";
    }
   
    return 0;
}