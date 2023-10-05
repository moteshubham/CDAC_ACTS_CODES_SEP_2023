#include <iostream>
#include "animals.h"
using namespace std;

void printAnimalName(const Animals& obj)
{
	cout<<"Hello "<<obj.getName() <<"\n";
}
int main()
{
// 	Animals obj;
	Lion obj1;
	Rat obj2;

	cout<<"Sizeof Animals : "<< sizeof(Animals)<<endl;
	cout<<"Sizeof Lion : "<< sizeof(Lion)<<endl;
	cout<<"Sizeof Rat : "<< sizeof(Rat)<<endl;
	printAnimalName(obj1);
	printAnimalName(obj2);
	//Animals ob3;  //canot create object of abstract class

	return 0;
}










