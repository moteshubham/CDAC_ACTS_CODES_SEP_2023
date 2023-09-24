#include <iostream>
#include <cstring>
using namespace std;

class BigInt
{
	int num;
	public:
	BigInt()
	{
		this->num= 0;
	}
	
	BigInt(int n): num(n)
	{
		this->num=n;
		cout<<n<<endl;
	}
	
	void getNum()
	{
		cout<< this->num <<endl;
	}
	
	void display()
	{
		
	}
	bool operator==(BigInt obj2)
	{
		if(this->num == obj2.num)
			return true;
		return false;
	}
	bool operator!=(BigInt obj2)
	{
		if(this->num != obj2.num)
			return true;
		return false;
	}
	bool operator<(BigInt obj2)
	{
		if(this->num < obj2.num)
			return true;
		return false;
	}
	bool operator>(BigInt obj2)
	{
		if(this->num > obj2.num)
			return true;
		return false;
	}
	bool operator<=(BigInt obj2)
	{
		if(this->num <= obj2.num)
			return true;
		return false;
	}
	bool operator>=(BigInt obj2)
	{
		if(this->num >= obj2.num)
			return true;
		return false;
	}
	
};

int main()
{
	BigInt obj1(6);
	BigInt obj2(6);
	//bool a = obj1==obj2;		//similar to a = obj1.operator==(obj2);
	//cout <<a<<endl;
	//a = obj1.operator==(obj2);
	//cout <<a<<endl;
	//a = obj1.operator<(obj2);
	//cout<<a<<endl;
	int choice;
	
	do
	{
		cout<<"1. =="<<endl;
		cout<<"2. !="<<endl;
		cout<<"3. <"<<endl;
		cout<<"4. >"<<endl;
		cout<<"5. <="<<endl;
		cout<<"6. >="<<endl;
		cout<<"7. Exit"<<endl;
		cin>>choice;
		switch(choice)
		{
			case 1: 
				if(obj1==obj2)
					cout<<"obj1 is equal"<<endl;
				else
					cout<<"obj1 is NOT equal"<<endl;
				break;
			case 2: 
				if(obj1!=obj2)
					cout<<"obj1 NOT equal"<<endl;
				else
					cout<<"obj1 is equal"<<endl;
				break;
			case 3: 
				if(obj1<obj2)
					cout<<"obj1  is less "<<endl;
				else
					cout<<"obj1 is NOT less"<<endl;
				break;
			case 4: 
				if(obj1>obj2)
					cout<<"obj1 is greater"<<endl;
				else
					cout<<"obj1 is NOT greater"<<endl;
				break;
			case 5: 
				if(obj1<=obj2)
					cout<<"obj1 is less than equal"<<endl;
				else
					cout<<"obj1 is NOT less"<<endl;
				break;
			case 6: 
				if(obj1>=obj2)
					cout<<"obj1 is greater equal"<<endl;
				else
					cout<<"obj1 is NOT greater"<<endl;
				break;
		
			default:
				cout<<"Wrong input"<<endl;
				
		}
	}while(choice!=7);
	return 0;
}










