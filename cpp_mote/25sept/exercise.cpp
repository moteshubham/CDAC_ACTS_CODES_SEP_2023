#include <iostream>
#include <cstring>
using namespace std;
// //void print ();
// void f1(Array );
// int & f2();
// //int * f1();

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
	void f1(Array obj)
	{
		obj[0]=1;
		++obj[1];
	}

int main()
{
	Array arr1(5);
	f1(arr1);
    cout<<arr1[0]<<endl;
  //  Array arr2(arr1);
	arr1[0] = 5;    //acts as arr1.operator[](0)
	//value to above expression is reference to 0th element in array
	// arr1.print();

    cout<<arr1[0]<<endl;
   // cout<<arr2[0];
	
	return 0;
}










