#include <iostream>
using namespace std;

int strlen( char s[] );

int main()
{
	char s[20];
	cout<<"Enter the string : ";
	cin>>s;	
	int len = strlen(s);
	cout<<"Length of string : "<<len<<endl;
	return 0;
}

int strlen( char s[] )
{
	int i=1;

	while(s[i] != '\0')
	{
		i++;
	}
	return i;
}


