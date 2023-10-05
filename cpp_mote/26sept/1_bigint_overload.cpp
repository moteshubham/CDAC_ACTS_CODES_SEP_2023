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
		cout<<this->num<<endl;;
	}
	BigInt operator+(BigInt obj2)
	{
        BigInt res;
        res.num = this->num + obj2.num;
        cout << "Addition is : ";
		return res;
	}

	
};

int main()
{
	BigInt obj1(6);
	BigInt obj2(3);
    BigInt res;
    res = obj1+obj2;   //here obj1 is called on obj2
    res.display();
	
	return 0;
}










