#include <iostream>
#include <string.h>
using namespace std;


int main()
{

	char temp[20], *t;
	int i, len, j, n=5;
	char *s[5];

	for(i=0; i<5; i++)
	{
		cout<<"Enter the name : ";
		cin>>temp;
		len = strlen(temp);
		s[i] = (char*) malloc(len*sizeof(char)+1);
		strcpy(s[i], temp);
	}

	for(i=0; i<n-1; i++)
	{
		for(j=i+1; j<n; j++)
		{
			if(strcmp(s[i],s[j]) > 0)
			{
				t= s[i];
				s[i]= s[j];
				s[j]= t;
			}
		}
	}

	cout<<"Strings in aplhabetical order are"<<endl;
	
	for(i=0; i<n; i++)
	{
		cout<<s[i]<<endl;
	}
	for(i=0; i<n; i++)
	{
		free(s[i]);
	}

	return 0;
}
