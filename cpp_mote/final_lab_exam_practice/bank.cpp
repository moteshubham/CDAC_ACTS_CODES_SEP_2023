
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
            this->accountNumber = 0;
            this->accountName = "";
            this->accountType = "";
            this->accountBalance = 0;   
        }
        Account(string name, string type){
            this->accountNumber = Account::accountCount;
            this->accountName = name;
            this->accountType = type;
            if(type == "saving"){
                this->accountBalance = 0;
            } else {
                this->accountBalance = 1000;
            }    
        }  

        int getAccountNumber(){
            return this->accountNumber;
        }

        void setAccountNumber( int accountNumber){
            this->accountNumber = accountNumber;    
        }

        int getAccountBalance(){
            return this->accountBalance;
        }

        void setAccountBalance( int accountBalance){
            this->accountBalance = accountBalance;    
        }

        string getAccountName(){
            return this->accountName;
        }

        void setAccountName( string accountName){
            this->accountName = accountName;    
        }

        string getAccountType(){
            return this->accountType;
        }

        void setAccountType( string accountType){
            this->accountType = accountType;    
        }

        int getAccountCount(){
            return Account::accountCount;
        }

        void incAccountCount(){
            accountCount += 1;
            return;
        }

        void display(){
            cout << "****** Account details *****" << endl;
            cout << "Account Name : " << this->accountName << endl;
            cout << "Account Balance : " << this->accountBalance << endl;
            cout << "Account Number : " << this->accountNumber << endl;
            cout << "Account Type : " << this->accountType << endl;
        }

};

int Account::accountCount = 1;

Account addAccount(){
    string name, type;
    char dummy;
    cout << " Enter name " << endl;
    cin >> dummy;
    getline(cin, name);
    cout << " Enter type " << endl;
    cin >> type;
    Account acc(name, type);
    acc.incAccountCount();
    return acc;
}

void display(Account accountList[], int count){
    cout << "Enter Account Number for which you want details" << endl;
    int accountNumber;
    cin >> accountNumber;
    bool found = false;
    for(int i = 0 ; i <= count ; i++){
        if(accountList[i].getAccountNumber() == accountNumber){
            found = true;
            accountList[i].display();
        }
    }
    if(!found){
        cout << "Account NOT FOUND" << endl;
    }
    return;
}

void displayAllAccount(Account accountList[], int count){
    for(int i = 0 ; i <= count ; i++){
        accountList[i].display();
    }
    return;
}

int main(){
    cout << "Lets GO" << endl;
    Account accoutList[30];
    int count = 0;
    int ch = 0;
    do
    {
        cout << "Welcome\n 1. ADD\n 2.Withdraw\n 3.Deposit \n 4. Display\n 5. DisplayAll\n 6.exit" <<endl;
        cin>> ch;

        switch(ch){
        case 1:
            accoutList[count] = addAccount();
            count++;
            break;
        case 2:
            //withdrawAmmount();
            break;
        case 3:
            //depositAmmount();
            break;
        case 4:
            display(accoutList, count);
            break;
        case 5:
            displayAllAccount(accoutList, count);
            break;
        case 6:
            cout << "Thank you" << endl;
            break;
        default:
            cout << "Enter Valid Option" << endl;
            break;
        }
    } while (ch != 6);
    

    //while
    //switch
    // 1. Add
    // 2. withdraw
    // 3. deposit
    // 4. display1
    // 5. displayAll
    // 6. exit
    return 0;
}