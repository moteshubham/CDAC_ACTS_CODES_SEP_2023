#include <iostream>
#include <vector>
using namespace std;
class Person{
    protected:
    string name;

    public:
    Person(const string& n):name(n){
        cout << "Person created"<< endl;  // Constructor
    }
    string getName() const{
        return name;
    }
};
class Seller:public Person
{
    protected:
  
    int sellerId;
    public:
    static int generateId;
    Seller(const string &n) : Person(n){
        this->sellerId = getNewId();
    }
    int getNewId()  {
        return generateId++;
    }

};
int Seller::generateId = 1;

class Product{
    protected:
    int productId;
    string productName;
    double price;

    public:
    Product(int id, const string& name, double price ):productId(id), productName(name), price(price)  {

    }
    int getId() const{
        return productId;
    }
    string getProductName(){
        return productName;
    }
    double getPrice() const{
        return price;
    }

};

class ECommerceSystem{
    private:
    vector<Seller> sellers;
    vector<Product> products;
    public:
    void addSeller(const Seller& seller){
        
    }

};

int main(){
    ECommerceSystem ecom;
    int choice;
    do
    {
        cout<< "\nManu:"
        <<"asdadad"
        <<"dsfsf";


        cout<<"enter cho";
        cin>>choice;
        // switch (choice)
        // {
        // case 1:
        //     string n2ame;
        //     break;
        
        // default:
        //     break;
        // }
    } while (choice!=0);
    
}