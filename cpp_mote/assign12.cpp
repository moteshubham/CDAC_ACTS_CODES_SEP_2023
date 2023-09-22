#include <iostream>

int main() 
{
	int num,temp,count=0, digit, divisor=1;
	std::cout<<"enter the number: ";
	std::cin>>num;
	temp=num;

	while(temp>0)
	{
		temp=temp/10;
		count++;
	}

	for(int j=1; j<count; j++)
		{
			divisor=10*divisor;
		}
				
	for (int i=0; i<count; i++)
	{
		// while(count>0)
		// {
		// 	divisor=10*divisor;
		// }
		digit=num/divisor;
		num=num%divisor;
		switch(digit)
		{	
			case 1:
			std::cout<<"One ";
			break;

			case 2:
			std::cout<<"Two ";
			break;

			case 3:
			std::cout<<"Three ";
			break;

			case 4:
			std::cout<<"Four ";
			break;

			case 5:
			std::cout<<"Five ";
			break;

			case 6:
			std::cout<<"Six ";
			break;

			case 7:
			std::cout<<"Seven ";
			break;

			case 8:
			std::cout<<"Eight ";
			break;

			case 9:
			std::cout<<"Nine ";
			break;

			case 0:
			std::cout<<"Zero ";
			break;
		}
		divisor=divisor/10;
	}
	
	//std::cout<<count<<"\n";
  
    return 0;
}
