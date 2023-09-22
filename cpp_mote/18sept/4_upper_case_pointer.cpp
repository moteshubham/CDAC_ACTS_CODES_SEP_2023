#include <iostream>
using namespace std;

void toUpper( char *s );
void display( char *s );

int main()
{
	char str[20];
	cout<<"Enter the string : ";
	cin>>str;
	toUpper(str);
	display(str);
	return 0;
}


void display( char *s )
{
	while(*s != '\0')
	{
		cout<<*s;
		s++;
	}
	cout<<endl;
}


void toUpper( char *s )
{	
	while(*s != '\0')
	{
		*s = *s-32;
		s++;
	}
}
