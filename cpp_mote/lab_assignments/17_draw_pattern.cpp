#include <iostream>
using namespace std;

int main(){

    int i,j,k,l=-1;
    
    for(i=1; i<=5; i++)
    {
        for(j=1; j<=6-i; j++)
        {
            cout<<j;
        }
        while(i>1 && i<6)
        {
            for(int m=1; m<=2*i-3; m++)
            {
                cout<<" ";
            }
            break;
        }
        for(k=6-i; k>0; k--)
        {
            if(k==5)
            {
                continue;
            }
            cout<<k;
        }
        cout<<"\n";
    }
    return 0;
}