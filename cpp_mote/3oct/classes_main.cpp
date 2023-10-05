#include <iostream>
#include "classes.h"
using namespace std;
#include "classes.h"

int main()
{
	cout<<"Create  Derived1 Object\n";
	Derived obj1;
	obj.i=10;
	cout<<"i = "<<obj1.i <<"\n";

	cout<<"Create  Derived Object\n";
	Derived objD;
	objD.i = 100;
	cout<<"i = "<<objD.i<<"\n";

	cout<<"Sizeof Base : "<< sizeof(Base)<<endl;
	cout<<"Sizeof Derived1 : "<< sizeof(Derived1)<<endl;
	cout<<"Sizeof Derived2 : "<< sizeof(Derived2)<<endl;
	cout<<"Sizeof Derived : "<< sizeof(Derived)<<endl;
	
	return 0;
}










