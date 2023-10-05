#include <iostream>
#include <cstring>
using namespace std;

class Complex
{
	int real, img;
	public:
	Complex()
	{
		cout<<"Default const"<<endl;
		this->real = 0;
		this->img = 0;
	}
	Complex(int r, int i)
	{
		cout<<"Para const"<<endl;
		this->real = r;
		this->img = i;
	}
	int getReal(){
		return this-> real;
	}
	int getImg()
	{
		return this-> img;
	}
	void setReal(int re)
	{
		this -> real = re;
	}
	void setImg(int im)
	{
		this-> img = im;
	}
	void display()
	{
		cout<<real<<"  "<<img<<"i"<<endl;
	}
	void accept()
	{
		cout<<"Enter real part : ";
		cin>>real;
		cout<<"Enter imaginary part : ";
		cin>>img;	
	}
	
};

int main()
{
	Complex c1;
	c1.accept();
	c1.display();
	Complex c2(5, 8);
	c2.display();
	return 0;
}







