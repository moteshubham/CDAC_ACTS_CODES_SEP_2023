#include <iostream>
#include <cstring>
using namespace std;

class Complex
{
	int real, img, count;
	static int counter;
	public:
	Complex()
	{
		cout<<"Default const"<<endl;
		this->real = 0;
		this->img = 0;
		count = counter++;
	}
	Complex(int r, int i)
	{
		cout<<"Para const"<<endl;
		this->real = r;
		this->img = i;
		count = counter++;
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
		cout<<"Real part >> ";
		cin>>real;
		cout<<"Imaginary part >> ";
		cin>>img;	
	}
	static void counter2(void)
	{
		cout<<"Objects created : "<<counter<<endl;
	}
	
};

int main()
{
	Complex c1;
	c1.accept();
	c1.display();
	Complex c2(5, 8);
	c2.display();
	c2.counter2();
	return 0;
}







