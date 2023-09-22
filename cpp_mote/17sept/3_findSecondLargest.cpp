#include <iostream>
using namespace std;

int findSecondMax(int nums[], int n);
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
    int secondMax = findSecondMax(nums,n);
    cout<<"Second Largest No : "<<secondMax<<endl;
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

int findSecondMax(int nums[], int n)
{
    int max=nums[0], secondMax, temp;
    for(int i=1;i<n;i++)
    {
	if(max<nums[i])
	{
		max=nums[i];
	}

    }
    secondMax = nums[0];

    for(int i=1;i<n;i++)
    {
	if(secondMax<nums[i])
	{
		if(nums[i] != max)
		{
			secondMax = nums[i];
		}
	}
			
    }

    return secondMax;
}

