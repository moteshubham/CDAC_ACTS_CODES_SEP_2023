#include <iostream>
using namespace std;

int main()
{
    int n,result=1;
    cout<<"Enter the number for its factorial : ";
    cin>>n;
    
    for(int i=n; i>0; i--)
    {
        result = result * i;
    }
    cout<<"Result is : "<<result<<endl;  
    return 0;
}