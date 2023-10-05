#include<iostream>
#include<string>
using namespace std;


class Account
{
    private:
        int accountNumber;
        string accountName;
        string accountType;
        float accountBalance;
       // static int account_number = 1000;
    public:
    static int accountCount ;

    Account()
    {
        int i;
        this->accountName = accountType;
        this->accountType = accountType;
        this->accountNumber = Account::accountCount;
        cout<<"Which account do you want? \n1.Savings \n2.Current \nEnter choice : ";
        cin>>i;
        if(i==1)
            this->accountType="Savings";
        else
            this->accountType="Current";
            cout<<"Enter account holder's name : ";
    }


    Account(string name, string type)
    {
        int i;
        this->accountName = name;
        this->accountType = type;
        this->accountNumber = Account::accountCount;
        cout<<"Which account do you want? \n1.Savings \n2.Current \nEnter choice : ";
        cin>>i;
        if(i==1)
            this->accountType="Savings";
        else
            this->accountType="Current";
            cout<<"Enter account holder's name : ";
    }

    int getAccountCount()
    {
        return Account::accountCount;
    }
    void incAccountCount()
    {
        accountCount += 1;
    }

    int getAccountNumber( )
    {
        return this->accountNumber;
    }
    void setAccountNumber( int )
    {
        this->accountNumber = accountNumber;
        cout<<"Account Successfully Created"<<endl<<"Account No: "<<accountNumber<<endl;
        accountNumber = accountNumber +1;
    }
    void setDefaultAmount()
    {
        if(this->accountType=="Savings")
            this->accountBalance=0;
        if(this->accountType=="Current")
            this->accountBalance=1000;
    }
   


    int getAccountBalance( )
    {
        return this->accountBalance;
    }
    void withdrawAccountBalance(int amount)
    {
        if(amount<=this->accountBalance)
            cout<<"Balance insufficient, paise taak"<<endl;
        else{
        this->accountBalance = this->accountBalance - amount;
        cout<<"Withdraw successful, Balance : "<<this->accountBalance<<endl;
        }
    }
    void depositAccountBalance(int amount)
    {
        this->accountBalance = this->accountBalance + amount;
        cout<<"Deposit successful, Balance : "<<this->accountBalance<<endl;
    }
    void setAccountType()
    {
        int i;
        cout<<"Which account do you want? \n1.Savings \n2.Current \nEnter choice : ";
        cin>>i;
        if(i==1)
            this->accountType="Savings";
        else
            this->accountType="Current";
    }
    void setAccountName()
    {
        cout<<"Enter account holder's name : ";
        cin>>this->accountName;
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
        cout<<"Account No: "<<this->accountNumber<<endl;
        cout<<"Name: "<<this->accountName<<endl;
        cout<<"Type: "<<this->accountType<<endl;
        cout<<"Balance: "<<this->accountBalance<<endl;
    }
    void addAccount();

 
};

int Account::accountCount =1;


void Account :: addAccount()
{
    Account acc;
    int i;
    // cout<<"Which account do you want? \n1.Savings \n2.Current \nEnter choice : ";
    // cin>>i;
    // if(i==1)
    //     this->accountType="Savings";
    // else
    //     this->accountType="Current";
    //     cout<<"Enter account holder's name : ";
    cin>>this->accountName;

}
int main()
{
    int acc_counter=0;
    int choice;
    int temp;
    Account accountList[100];
    
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
                Account acc = addAccount();
                accountList[acc_counter] = acc;
               // account[acc_counter++].setAccountDetails();
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