#include <iostream>
using namespace std;

bool compare( char s1[], char s2[] );

int main()
{
	char str1[20];
	char str2[20];
	cout<<"Enter string 1 : ";
	cin>>str1;
	cout<<"Enter string 2 : ";
	cin>>str2;
	bool same = compare(str1, str2);
	if(same)
		cout<<"Strings are same"<<endl;
	else
		cout<<"String are NOT same"<<endl;
	return 0;
}

bool compare( char s1[], char s2[] )
{
	int i=0;

	while(s1[i] != '\0')
	{
		if(s1[i] == s2[i])
			i++;
		else
			return false;
	}
	return true;
}


