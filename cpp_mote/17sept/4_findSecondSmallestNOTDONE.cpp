#include <iostream>
using namespace std;

int findSecondSmallest(int nums[], int n);
void display(int nums[], int n);

int main()
{
    int n;
    cout<<"How big array do you want : ";
    cin>>n;
    int nums[n];
    cout<<"\nEnter elements one by one : \n";
    for(int i =0; i<n; i++)
    {
        cin>>nums[i];
    }
    display(nums,n);
    int secondSmallest = findSecondSmallest(nums,n);
    cout<<"Second Smallest No : "<<secondSmallest<<endl;
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

int findSecondSmallest(int nums[], int n)
{
    int min=nums[0],secondSmallest, temp;
    
    for(int i=1; i<n; i++)
    {
	if(<min>nums[i])
	{
		min=nums[i];
	}
    }
    secondSmallest = nums[0];

    for(int i=1; i<n; i++)
    {
	if(secondSmallest>nums[i])
	{
		if(nums[i] != min)
		{
			secondSmallest = nums[i];
		}
	}		
    }
    return secondSmallest;
}

