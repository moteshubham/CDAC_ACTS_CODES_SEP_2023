#include <iostream>
#include <cstring>
using namespace std;


class Person 
{
	private:
		string name;
		int age;
		string address;

	public:
		Person()
		{
			cout<<"Person :: Default Constructor"<<endl;
			this->name = "Shubham";
			this->age = 27; 
			this->address = "Baner_Pune";
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
		// person::string name;
		// person::int age;
		// person::string address;

	public:
		Student()
		{
			cout<<"Student :: Default Constructor"<<endl;
			this->school = "JBVM";
			this->rollNo = 01; 
		}
		Student(int n, string sc)
		{
			cout<<"Student :: Parameterized Constructor"<<endl;
			this->rollNo = n; 
			this->school = sc;
		}
		~Student()
		{
			cout<<"Student :: Destructor"<<endl;
		}
		void displayDetails2()
		{
			cout<<"Student :: displayDetails2() called"<<endl;
			cout<<this->rollNo<<endl;
			cout<<this->school<<endl; 
			displayDetails1();
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
	Student s1(02, "s1_student");
	//Student s2(03, "s2_student");
	//cout<<"Creating Student Object : s1"<<endl;
	Person p1 = s1;

	cout<<"s1 details"<<endl;
	s1.displayDetails2();
	p1.displayDetails1();
	return 0;
}


