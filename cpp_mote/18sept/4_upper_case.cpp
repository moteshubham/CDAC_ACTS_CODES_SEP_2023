#include <iostream>
using namespace std;

void toUpper( char s[] );
void display( char s[] );

int main()
{
	char str[20];
	cout<<"Enter the string : ";
	cin>>str;
	toUpper(str);
	display(str);
	return 0;
}


void display( char s[] )
{
	int i=0;
	while(s[i] != '\0')
	{
		cout<<s[i];
		i++;
	}
	cout<<endl;
}


void toUpper( char s[] )
{
	int i=0;	
	while(s[i] != '\0')
	{
		s[i] = s[i]-32;
		i++;
	}
}
