#include <iostream>
using namespace std;

void strCpy( char *dest, char *src );

int main()
{
	char s[20];
	char d[20];
	cout<<"Enter src string : ";
	cin>>s;	
	cout<<"Dest string before : "<<d<<"(garbage)"<<endl;
	strCpy(d, s);
	cout<<"Src string : "<<s<<endl;
	cout<<"Dest string : "<<d<<endl;
	return 0;
}

void strCpy( char *dest, char *src )
{
	int i=0; 

	while(*src != '\0')
	{
		*dest = *src;
		src++;
		dest++;
	}
	*dest = '\0';
	//cout<< "dest : "<<dest;
}


