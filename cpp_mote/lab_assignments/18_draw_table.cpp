#include <iostream>
#include <cstring>
using namespace std;

void charLine(const char *, int);

int main()
{
	const char * pattern = "_";
	charLine(pattern, 40);
	cout<<"Data Type\t\t Size in Bytes"<<endl;
	charLine("_", 40);
	cout<<"Integer\t\t "<<sizeof(int)<<endl;
	charLine("_", 40);
	cout<<"Character\t\t "<<sizeof(char)<<endl;
	charLine("_", 40);
	cout<<"Float\t\t "<<sizeof(float)<<endl;
	charLine("_", 40);
	return 0;
}

void charLine(const char* pattern, int n)
{
	for(int i =0; i<n; i++)
	{
		cout<<pattern;
	}
	cout<<endl;
}
