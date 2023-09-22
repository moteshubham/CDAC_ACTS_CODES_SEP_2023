#include <iostream>
using namespace std;

void strCpy( char dest[], char src[] );

int main()
{
	char src[20];
	char dest[20];
	cout<<"Enter src string : ";
	cin>>src;	
	strCpy(dest, src);
	cout<<"Src string : "<<src<<endl;
	cout<<"Dest string : "<<dest<<endl;
	return 0;
}

void strCpy( char dest[], char src[] )
{
	int i=0;

	while(src[i] != '\0')
	{
		dest[i] = src[i];
		i++;
	}
	dest[i] = '\0';
	//cout<< "dest : "<<dest;
}


