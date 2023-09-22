#include <iostream>
using namespace std;

bool search(int nums[], int n, int element);
void display(int nums[], int n);

int main()
{
    int n, element;
    cout<<"How big array do you want : ";
    cin>>n;
    int nums[n];
    cout<<"\nEnter elemnts one by one : \n";
    for(int i =0; i<n; i++)
    {
        cin>>nums[i];
    }
    display(nums,n);
    cout<<"Enter element to search : "<<endl;
    cin>>element;
    bool present = search(nums, n, element);
    if(present)
	    cout<<"True"<<endl;
    else
	    cout<<"False"<<endl;

    return 0;
}

void display(int nums[], int n)
{
    cout<<"Entered numbers are : ";
    for(int i =0; i<n; i++)
    {
        cout<<nums[i]<<" ";
    }
    cout<<endl;
}

bool search(int nums[], int n, int element)
{
    for(int i=0;i<n;i++)
    {
	if(element == nums[i])
	{
		return true;
	}
    }

    return false;
}

