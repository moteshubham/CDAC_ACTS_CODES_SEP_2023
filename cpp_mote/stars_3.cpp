#include <iostream>
using namespace std;

int main()
{

    int n,count=0;
    cout<<"Enter the number for the staaaa****rrr pattern : ";
    cin>>n;
    
    for(int k=n-1; k>=0; k--)
    {
        for(int i=k; i>0; i--)
        {
            cout<<" ";  
        }
        for(int j=2; j<2*(n-k)+1; j++)
        {
            cout<<"*";
        }
        for(int i=k; i>0; i--)
        {
            cout<<" ";
        }
        cout<<"\n";
    }    
    return 0;
}