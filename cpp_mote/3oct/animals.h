
class Animals   //Animals is abstract due to pure virtual function
{   
    int i;
public:
    const char* getName() const ; 
  //  virtual const char* getName() const = 0 ; //Pure virtual
};

class Lion : public Animals
{
    int j;
public:
    const char* getName() const;
};

class Rat : public Animals
{
    int k;
public:
    const char* getName() const;
};