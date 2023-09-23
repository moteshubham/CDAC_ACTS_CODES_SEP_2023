#include <iostream>
using namespace std;

int main()
{
	int matchsticks=21;
	int pick;
	cout<<"Matchsticks count = 21"<<endl;
	while(matchsticks != 1)
	{
		do{
			cout<<"Pick matchsticks between 1 to 4 : ";
			cin>>pick;
		}while(pick<=0 || pick >=5);
		cout<<"Computer picks : "<<5-pick<<endl;
		matchsticks = matchsticks -5;
		cout<<"Matchsticks left : "<<matchsticks<<endl<<endl;
	}
	cout<<"1 matchsticks remaining..."<<endl;
	cout<<"Computer wins.. Wohooo"<<endl<<endl;
	return 0;
}



















