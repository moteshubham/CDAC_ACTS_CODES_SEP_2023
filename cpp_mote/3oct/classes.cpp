//definitions
#include <iostream>
#include "classes.h"
using namespace std;



Base::Base(int v) : i(v)
{
	cout<<"Base::Base\n";
}

Derived1::Derived1() : Base(1)
{
	cout<<"Derived1::Derived1\n";
}
Derived2::Derived2() : Base(2)
{
	cout<<"Derived2::Derived2\n";
}
// Derived::Derived() : Base(3)
// {
// 	cout<<"Derived2::Derived2\n";
// }




