#include <iostream>
#include <cstring>
using namespace std;

class Date 
{
	int day;
	int month;
	int year;
	public:
	Date();
	Date(int d, int m, int y) : day(d), month(m), year(y){};
	void Read()
	{
		    int dd,mm,yy;
		    cout<<"Enter Day:";
		    cin>>dd;
		    cout<<"Enter Month:";
		    cin>>mm;
		    cout<<"Enter Year:";
		    cin>>yy;
	}
	void Write()
	{

	}
	bool operator==(Date obj2)
	{
		if( day == obj2.day && month == obj2.month && year == obj2.year )
			return true;
		return false;
	}
};

int main()
{
	//Date d3.read();
	Date d1(22,7,1996);
	Date d2(22,7,1997);
			if (d1 == d2)
			cout<<" d1 = d2"<<endl;
		else
			cout<< "d1 != d2"<<endl;
	
	return 0;
}










