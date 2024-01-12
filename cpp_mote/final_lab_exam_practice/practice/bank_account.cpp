#include <iostream>
#include <string>
using namespace std;

class Account{
    private:
    string accountName;
    string accountType;
    int accountBalance;
    int accountNumber;
    
    public:
    static int accountCount;
    Account(){
        this->accountBalance =0;
        this->accountName="";
        this->accountType="";
        this->accountNumber=0;
    }

    int getAccountNumber(){
        return this->accountNumber;
    }
    void setAccountNumber(){
        this->accountNumber=accountCount++;
    }
    int getAccountBalance(){
        return this->accountNumber;
    }
    int getAccountType(){
        return this->accountNumber;
    }
    int getAccountName(){
        return this->accountNumber;
    }
};