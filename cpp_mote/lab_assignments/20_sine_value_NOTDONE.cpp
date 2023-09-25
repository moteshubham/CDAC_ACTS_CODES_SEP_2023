#include <iostream>
#include <cstring>
using namespace std;
const float PI = 3.142;
const float radians = 180/PI;

double factorial(double);
double power(int, int);
void sin(double);

int main()
{
	double x;
	cout<<"Enter x for Sin(x) : "<<endl;
	cin>>x;
	x = x*PI/180;
	cout<<"x in radians : "<<x<<endl;
	sin(x);
	return 0;
}

void sin( double x)
{
	//sin(x) = x – x^3/3! + x^5/5! – x^7/7! + x^9/9!
	double sin;
	sin = x - (power(x,3)/factorial(3)) + (power(x,5)/factorial(5))  - (power(x,7)/factorial(7)) + (power(x,9)/factorial(9)) ;
	cout<<"Sine value : "<<sin<<endl;
}

double factorial(double n)
{
	if(n<=0)
		return 1;
	return n* factorial(n-1);
}

double power(int b, int i)
{
	double sum=1;
	while(i>0)
	{
		sum = sum * b;
		i--;
	}
	return sum;
}

