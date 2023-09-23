#include <iostream>
#include <cstring>
using namespace std;

class Laptop{
	int lid;
	char *make;
	double cost;
	public:
	Laptop();
	Laptop(Laptop &);
	~Laptop();
	Laptop(int, const char*, double);
	void Display();

};

Laptop::Laptop()
{	
	lid=101;
	make= new char[3];
	strcpy(make, "hp");
	cost = 40000;
}

Laptop::Laptop(Laptop &l)
{	
	lid=l.lid;
	make= new char[strlen(l.make)+1];
	strcpy(make, l.make);
	cost = l.cost;
}

Laptop::~Laptop()
{	
	cout<<"destructor"<<endl;
	delete []make;
}

Laptop::Laptop(int id, const char *m, double c)
{
	lid= id;
	make= new char[strlen(m)+1];
	strcpy(make, m);
	cost= c;
}


void Laptop::Display()
{
	cout<<lid<<"   " <<make<<"    "<<cost<<endl<<endl;
}

int main()
{
	Laptop l1;
	Laptop l2(102, "dell", 55000);
	l1.Display();
	l2.Display();
	Laptop l3(l2);
	l2.Display();
	l3.Display();
	
	return 0;
}










