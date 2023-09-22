#include <iostream>
using namespace std;

int main()
{
    int length, breadth;
    do
    {
        cout<<"Enter length and breadth : ";
        cin>>length>>breadth;
        for(int i=1;i<=breadth; i++)
    {
        if(i==1 || i==breadth)
        {
            for(int j=1; j<=length; j++)
            {
                cout<<"#";
            }
        }
                            
        {
            cout<<"#";
            for(int k=1; k<length-1; k++)
            {
                cout<<" ";
            }
            cout<<"#";
        }
        cout<<"\n";
    }

    }while(length>0 && breadth>0);

    return 0;
}
