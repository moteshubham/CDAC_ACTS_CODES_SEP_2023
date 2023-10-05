#include <iostream>
#include <cstring>
using namespace std;

class Array
{
	int size;
	int *arr;
	public:
	Array();
	Array(int);
	Array(Array &);
	~Array();
	int & operator[](int);
	int & operator!();
	void Accept();
	void Display();
};

Array::Array()
{
	cout<<"Default contructor called here"<<endl;
	size=5;
	arr= new int[size];
	for(int i=0; i<size; i++)
	{
		arr[i]= 0;
	}
}

Array::Array( int s )
{
	cout<<"Parametrized contructor called here"<<endl;
	size= s;
	arr= new int[size];
	for(int i=0; i<size; i++)
	{
		arr[i]= 0;
	}
}

void Array::Accept()
{
	
	cout<<endl<<"Enter "<<size<<" elements : "<<endl;
	for( int i=0; i<size; i++)
	{
		cin>>arr[i];
	}
}

Array::Array(Array &a)
{
	cout<<"Copy contructor called here"<<endl;
	this->size = a.size;
	this->arr = new int[a.size];
	for( int i=0; i<size; i++)
	{
		this->arr[i] = a.arr[i];
	}
}
int & Array:: operator[](int i)
{
	static int temp;
	if( i<0 || i>=size)
	{
		return temp;
	}
	return arr[i];
}
int & Array:: operator!()
{
	int temp;
	
	for(int i=0, j=size-1; i<j; i++, j--)
	{
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	return arr[0];
}
Array::~Array()
{
	cout<<"Destructor called here"<<endl;
	delete []arr;
}

void Array::Display()
{
	cout<<"Array elements : "<<endl;
	for( int i=0; i<size; i++)
	{
		cout<<arr[i]<<"  ";
	}
	cout<<endl;
}

int main()
{
	//Array a1;  		//Default contructor called here
	//Array a2(7);		//Parametrized contructor called here
	//a2.Display();		//Display function called on a2, Array elements are : 0  0  0  0  0  0  0  
	Array a3(8);
	a3.Accept();
	!a3;
	a3.Display();
	//a2.Accept();		//Accept function called on a2, Enter 7 elements : 
	//Array a4(a2);		//Copy contructor called here on a3 passing a2 as parameter
	//a2.Display();		//Display function called on a3, Array elements are : 7  6  3  5  2  4  1 
	return 0;
}







