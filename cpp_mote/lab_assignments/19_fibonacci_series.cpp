#include <iostream>
#include <cstring>
using namespace std;

void fibonacci(int);

int main()
{
	int n;
	cout<<"Enter the number for series : "<<endl;
	cin>>n;
	fibonacci(n);
	return 0;
}

void fibonacci(int n)
{
	int  sl_term=0, l_term =1, sum;

	for(int i =0; i<n-2; i++)
	{
		if(sl_term == 0)
		{
			cout<<sl_term<<"  ";
			cout<<l_term<<"  ";
		}
	
		sum = l_term + sl_term;
		sl_term = l_term;
		l_term = sum;
		cout<<sum<<"  ";;
	}
	cout<<endl;
}
