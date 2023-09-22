    #include <iostream>
    using namespace std;

    void swapNum(int &num1, int &num2);

    int main()
    {
        int num1, num2;
        cout<<"Enter two numbers :";
        cin>>num1>>num2;
        swapNum(num1, num2);
        cout<<"Swapped numbers by reference are num1= "<<num1<<", num2= "<<num2<<endl;

        return 0;
    }

    void swapNum(int &num1, int &num2)
    {
        int temp;
        temp=num1;
        num1=num2;
        num2=temp;
    }

