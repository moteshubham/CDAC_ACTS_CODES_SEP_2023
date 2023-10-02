#include <iostream>
#include <cstring>
using namespace std;


class Person 
{
	private:
		string name;
		int age;
		string address = "null";

	public:
		Person()
		{
			cout<<"Person :: Default Constructor"<<endl;
			this->name = "Shubham";
			this->age = 27; 
			this->address = "Baner, Pune";
		}
		Person(string n, int a, string addr)
		{
			cout<<"Person :: Parameterized Constructor"<<endl;
			this->name = n;
			this->age = a; 
			this->address = addr;
		}
		~Person()
		{
			cout<<"Person :: Destructor"<<endl;
		}

		void displayDetails1()
		{
			cout<<"Person :: displayDetails1() called"<<endl;
			cout<<this->name<<endl;
			cout<<this->age<<endl; 
			cout<<this->address<<endl;
			cout<<endl;
		}
		void personDetails2()
		{
			cout<<"Person :: personDetails2() called"<<endl;
			cout<<this->name<<endl;
			cout<<this->age<<endl; 
		}
	
};

class Student : public Person
{
	private:
		int rollNo;
		string school;

	public:
		Student():Person() 
		{
			cout<<"Student :: Default Constructor"<<endl;
			this->school = "null";
			this->rollNo = 00; 
		}
		Student(int n, string sc):Person("sdh", 12, "fff")
		{
			cout<<"Student :: Parameterized Constructor"<<endl;
			this->rollNo = n; 
			this->school = sc;
		}
		~Student()
		{
			cout<<"Student :: Destructor"<<endl;
		}
		void displayDetails1()
		{
			cout<<"Student :: displayDetails1() called"<<endl;
			cout<<this->rollNo<<endl;
			cout<<this->school<<endl; 
			cout<<endl;
		}
		void studentDetails2()
		{
			cout<<"Student :: studentDetails2() called"<<endl;
		}
};




int main()
{
	//cout<<"Creating Person Object : p1"<<endl;
	Person p1;
	////p1.displayDetails();
	
	cout<<"Creating Student Object : s1"<<endl;
	Student s1;
	Person *pp = &s1;
	pp->Person::name;
	Person *pp2 = &p1;
	pp2->name;

	

	
	return 0;
}



