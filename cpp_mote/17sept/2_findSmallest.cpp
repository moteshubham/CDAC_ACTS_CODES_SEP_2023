#include <iostream>
using namespace std;

int findSmallest(int nums[], int n);
void display(int nums[], int n);

int main()
{
    int n;
    cout<<"How big array do you want : ";
    cin>>n;
    int nums[n];
    cout<<"\nEnter elemnts one by one : \n";
    for(int i =0; i<n; i++)
    {
        cin>>nums[i];
    }
    display(nums,n);
    int smallestNo = findSmallest(nums,n);
    cout<<"Smallest No : "<<smallestNo<<endl;
    return 0;
}

void display(int nums[], int n)
{
    cout<<"Entered numbers are : ";
    for(int i =0; i<n; i++)
    {
        cout<<nums[i]<<" "<<endl;
    }
}
int findSmallest(int nums[], int n)
{
    int smallest,temp;
    for(int i=1;i<n;i++)
    {
	if(nums[i]<nums[i-1])
	{
		continue;
	}
	else
	{	//swap
		temp= nums[i];
		nums[i]= nums[i-1];
		nums[i-1]= temp;
	}
    }
    smallest=nums[n-1];
    return smallest;
}

