#include <iostream>
using namespace std;

int findMax(int nums[], int n);
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
    int maxNo = findMax(nums,n);
    cout<<"Max No : "<<maxNo<<endl;
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
int findMax(int nums[], int n)
{
    int max,temp;
    for(int i=1;i<n;i++)
    {
	if(nums[i]>nums[i-1])
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
    max=nums[n-1];
    return max;
}

