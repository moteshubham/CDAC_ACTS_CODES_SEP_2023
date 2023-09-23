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
	size= s;
	arr= new int[size];
	for(int i=0; i<size; i++)
	{
		arr[i]= 0;
	}
	cout<<"Parametrized contructor called here"<<endl;
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

Array::~Array()
{
	cout<<"Destructor called here"<<endl;
	delete []arr;
}

void Array::Display()
{
	cout<<"Array elements are : "<<endl;
	for( int i=0; i<size; i++)
	{
		cout<<arr[i]<<"  ";
	}
	cout<<endl;
}

int main()
{
	Array a1;  		//Default contructor called here
	Array a2(7);		//Parametrized contructor called here
	a2.Display();		//Display function called on a2, Array elements are : 0  0  0  0  0  0  0  
	a2.Accept();		//Accept function called on a2, Enter 7 elements : 
	Array a3(a2);		//Copy contructor called hereon a3 passing a2 as parameter
	a3.Display();		//Display function called on a3, Array elements are : 7  6  3  5  2  4  1 
	return 0;
}










