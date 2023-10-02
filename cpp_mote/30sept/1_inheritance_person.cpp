#include <iostream>
#include <cstring>
using namespace std;


class Person 
{
	private:
		string name;
		int age;
		char bloodGroup;
		string address = "null";

	public:
		Person()
		{
			cout<<"Person :: Default Constructor"<<endl;
			this->name = "null";
			this->age = 00; 
			this->bloodGroup = 'A+';
			this->address = "null";
			cout<<endl;
		}
		Person(string n, int a, char b, string addr)
		{
			cout<<"Person :: Parameterized Constructor"<<endl;
			this->name = n;
			this->age = a; 
			this->bloodGroup = b;
			this->address = addr;
			cout<<endl;
		}
		~Person()
		{
			cout<<"Person :: Destructor"<<endl;
		}

		//setters
		void setName(string n)
		{
			this->name = n;
		};
		void setAge(int a)
		{
			this->age = a;
		};
		void setBloodGroup(char b)
		{
			this->bloodGroup = b;
		};
		void setAddress(string addr)
		{
			this->address = addr;
		};
		//getters
		string getName()
		{
			return this->name;
		};
		int getAge()
		{
			return this->age;
		}
		char getBloodGroup()
		{
			return this->bloodGroup;
		}
		string getAddress()
		{
			return this->address;
		}
		void displayDetails()
		{
			cout<<"Person :: Display() called"<<endl;
			cout<<this->name<<endl;
			cout<<this->age<<endl; 
			cout<<this->bloodGroup<<endl;
			cout<<this->address<<endl;
			cout<<endl;
		}
		void personDetails()
		{
			cout<<"Person :: personDisplay() called"<<endl;
		}
	
};

class Student : public Person
{
	private:
		int rollNo;
		string school;

	public:
		Student() : Person()
		{
			cout<<"Student :: Default Constructor"<<endl;
			this->school = "null";
			this->rollNo = 00; 
			cout<<endl;
		}
		Student(int n, string sc)
		{
			cout<<"Student :: Parameterized Constructor"<<endl;
			this->rollNo = n; 
			this->school = sc;
			cout<<endl;
		}
		~Student()
		{
			cout<<"Student :: Destructor"<<endl;
		}
		void displayDetails()
		{
			cout<<"Student :: Display() called"<<endl;
			cout<<this->rollNo<<endl;
			cout<<this->school<<endl; 
			cout<<endl;
		}
		void studentDetails()
		{
			cout<<"Student :: studentDisplay() called"<<endl;
		}
};




int main()
{
	//cout<<"Creating Person Object : p1"<<endl;
	//Person p1;
	//p1.displayDetails();
	cout<<endl<<endl<<"Creating Student Object : s1"<<endl;
	Student s1;
	s1.displayDetails();
	s1.personDetails();
	return 0;
}
