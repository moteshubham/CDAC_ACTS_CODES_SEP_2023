#include <iostream>
#include <cstring>
using namespace std;

class Employee{
	int emp_id;
	char emp_name[20];
	double salary;
	public:
	Employee();
	Employee(int, char*, double);
	int getId();
	void Accept();
	void Display();
	void Update();
};

Employee::Employee()
{	
}

Employee::Employee(int id, char* n, double s)
{
	emp_id= id;
	strcpy(emp_name, n);
	salary= s;
}

int Employee::getId()
{	
	return emp_id;
}

void Employee::Accept()
{
	cout<<"Enter ID : ";
	cin>>emp_id;
	cout<<"Enter Name : ";
	cin>>emp_name;
	cout<<"Enter Salary : ";
	cin>>salary;	
}

void Employee::Display()
{
	cout<<"ID         : "<<emp_id<<endl;
	cout<<"Name   : "<<emp_name<<endl;
	cout<<"Salary  : "<<salary<<endl<<endl;
}
void Employee::Update()
{
	Accept();
}
int main()
{
	Employee e[10];
	int choice, cnt=0, id;
	while(true)
	{
		cout<<"\n";
		cout<<"1. Insert new employee data"<<endl;
		cout<<"2. Update employee data"<<endl;
		cout<<"3. Display employee data"<<endl;
		cout<<"4. Exit"<<endl;
		cin>>choice;
		switch(choice)
		{	
			case 1:
				e[cnt++].Accept();
				break;
				
			case 2:
				cout<<"Enter ID to update : ";
				cin>>id;
				for(int i=0; i<cnt; i++)
				{	
					if(id==e[i].getId())
					{
						e[i].Update();
					}
				}
				break;
			
			case 3:
				for(int i=0; i<cnt; i++)
				{
					e[i].Display();
				}
				break;
				
			case 4:
				exit(0);
				
			default :
				cout<<"Wrong input"<<endl;
		}	
	}
	return 0;
}



















