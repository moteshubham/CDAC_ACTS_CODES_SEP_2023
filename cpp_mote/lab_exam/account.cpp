#include<iostream>
#include<string>
using namespace std;

static int account_number =1000;

class Account
{
    int acc_no;
    string acc_name;
    string acc_type;
    float acc_balance;
    public:

    Account()
    {

    }
    void setDefaultAmount()
    {
        if(this->acc_type=="Savings")
            this->acc_balance=0;
        if(this->acc_type=="Current")
            this->acc_balance=1000;
    }
   
    void setAccountNumber( )
    {
        this->acc_no = account_number;
        cout<<"Account Successfully Created"<<endl<<"Account No: "<<account_number<<endl;
        account_number = account_number +1;
    }
    int getAccountNumber( )
    {
        return this->acc_no;
    }
    int getAccountBalance( )
    {
        return this->acc_balance;
    }
    void withdrawAccountBalance(int amount)
    {
        if(amount<=this->acc_balance)
            cout<<"Balance insufficient, paise taak"<<endl;
        else{
        this->acc_balance = this->acc_balance - amount;
        cout<<"Withdraw successful, Balance : "<<this->acc_balance<<endl;
        }
    }
    void depositAccountBalance(int amount)
    {
        this->acc_balance = this->acc_balance + amount;
        cout<<"Deposit successful, Balance : "<<this->acc_balance<<endl;
    }
    void setAccountType()
    {
        int i;
        cout<<"Which account do you want? \n1.Savings \n2.Current \nEnter choice : ";
        cin>>i;
        if(i==1)
            this->acc_type="Savings";
        else
            this->acc_type="Current";
    }
    void setAccountName()
    {
        cout<<"Enter account holder's name : ";
        cin>>this->acc_name;
    }
    void setAccountDetails()
    {
        setAccountName();
        setAccountType();
        setDefaultAmount();
        setAccountNumber();
    }
    void displayOne()
    {
        cout<<"Account No: "<<this->acc_no<<endl;
        cout<<"Name: "<<this->acc_name<<endl;
        cout<<"Type: "<<this->acc_type<<endl;
        cout<<"Balance: "<<this->acc_balance<<endl;
    }
    void addAccount();

 
};

int main()
{
    int acc_counter=0;
    int choice;
    int temp;
    Account account[100];
    
    do
    {
        cout<<"\n\n\n";
        cout<<"####### WELCOME TO ACCOUNTS #######"<<endl<<endl;
        cout<<"1. Add account"<<endl;
        cout<<"2. Withdraw"<<endl;
        cout<<"3. Deposit"<<endl;
        cout<<"4. Display your account"<<endl;
        cout<<"5. Display alls accounts"<<endl;
        cout<<"6. Exit"<<endl;
        cin>>choice;
       
        switch (choice)
        {
            case 1:
                account[acc_counter++].setAccountDetails();
                break;

            case 2:
                cout<<"Enter account no: ";
                cin>>temp;\
                cout<<"Enter amount to withdraw : ";
                float withdraw;
                cin>>withdraw;
                account[temp].withdrawAccountBalance(withdraw);
                break;

            case 3:
                cout<<"Enter account no: ";
                cin>>temp;\
                cout<<"Enter amount to deposit : ";
                float deposit;
                cin>>deposit;
                account[temp].depositAccountBalance(deposit);
                break;
            case 4:
                cout<<"Enter account no: ";
                cin>>temp;
                account[temp].displayOne();
                break;

            case 5:
                //account[0].diplayAll();
                break;
        
            default:
                cout<<"Invalid Input"<<endl;
                
        }

    }while (choice!=6) ;
    
}