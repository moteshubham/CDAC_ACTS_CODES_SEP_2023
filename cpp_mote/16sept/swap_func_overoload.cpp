#include <iostream>
using namespace std;

void swapNum(int num1, int num2);
void swapNum(float num1, float num2);

int main()
{
    
    swapNum(1.3f, 10.5f);
    swapNum(2, 3);

    return 0;
}

void swapNum(int num1, int num2)
{
    int temp;
    temp=num1;
    num1=num2;
    num2=temp;
    cout<<"Swapped INT numbers are num1= "<<num1<<", num2= "<<num2<<endl;
}

void swapNum(float num1, float num2)
{
    float temp;
    temp=num1;
    num1=num2;
    num2=temp;
    cout<<"Swapped FLOAT numbers are num1= "<<num1<<", num2= "<<num2<<endl;
}
