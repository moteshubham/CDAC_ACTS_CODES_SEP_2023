#include <iostream>
#include <cstring>
using namespace std;
void print ();

class Array 
{
	int *data;
	const int size;  // size is const because we don't want to change size of array
	public:
	Array(int n):size(n)
	{
		//  size =n;  <- size can not be initalized here coz it is const
		data = (int *) malloc( sizeof(int)*n );
	};
	int & operator[](int i)
	{
		static int temp;
		if( i<0 || i>= size )
		{
			return temp;	
		}
		return data[i];
	}
	~Array()
	{
		free (data);
	}
	void print()
	{
		for(int i=0; i<size; i++)
		{
			cout<<data[i]<<"  ";
		}
	}
};

int main()
{
	Array arr1(5);
	arr1[3] = 2;    //acts as arr1.operator[](0)
	//value to above expression is reference to 0th element in array
	arr1.print();

	return 0;
}











