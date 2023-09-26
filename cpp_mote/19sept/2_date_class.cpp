#include <iostream>
#include <cstring>
using namespace std;

class Date 
{
	int day;
	int month;
	int year;
	public:
	Date(){}
	Date(int d, int m, int y) : day(d), month(m), year(y){}
	void Read()
	{
		    int dd,mm,yy;
		    cout<<"Enter Day:";
		    cin>>dd;
		    cout<<"Enter Month:";
		    cin>>mm;
		    cout<<"Enter Year:";
		    cin>>yy;
		    this->day=dd;
		    this->month=mm;
		    this->year=yy;
	}
	void Write()
	{
		    cout<<day<<" ";
		    cout<<month<<" ";
		    cout<<year<<endl;
	}
	bool operator==(Date obj2)
	{
		if( day == obj2.day && month == obj2.month && year == obj2.year )
			return true;
		return false;
	}
	bool operator<=(Date obj2)
	{
		if( day <= obj2.day && month <= obj2.month && year <= obj2.year )
			return true;
		return false;
	}
};

int main()
{
	Date d3;
	d3.Read();
	Date d1 (22,7,1996);
	Date d2(22,7,1995);
		if (d1 <= d2)
			cout<<" d1 = d2"<<endl;
		else
			cout<< "d1 != d2"<<endl;
	
	return 0;
}


