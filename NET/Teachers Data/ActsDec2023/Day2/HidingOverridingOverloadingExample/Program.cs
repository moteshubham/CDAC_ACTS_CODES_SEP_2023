namespace HidingOverridingOverloadingExample
{
    internal class Program
    {
        static void Main2()
        {
            DerivedClass o = new DerivedClass();
            o.Display1();
            o.Display1("a");

            o.Display2();
            o.Display3();
        }

        static void Main()
        {
            BaseClass o;
            o = new BaseClass();
            o.Display2();  //dependent on how reference is declared
            o.Display3();  //dependent on which object is the reference pointing to

            Console.WriteLine();
            o = new DerivedClass();
            o.Display2();  //dependent on how reference is declared
            o.Display3();  //dependent on which object is the reference pointing to

            Console.WriteLine();
            o = new SubDerivedClass();
            o.Display2();  //dependent on how reference is declared
            o.Display3();  //dependent on which object is the reference pointing to

            Console.WriteLine();
            o = new SubSubDerivedClass();
            o.Display2();  //dependent on how reference is declared
            o.Display3();  //dependent on which object is the reference pointing to

        }
    }

    public class BaseClass
    {
        public void Display1()
        {
            Console.WriteLine("base display1");
        }
        public void Display2()
        {
            Console.WriteLine("base display2");
        }
        public virtual void Display3()
        {
            Console.WriteLine("base display3");
        }
    }
    public class DerivedClass :BaseClass
    {
        //overloading
        public void Display1(string s)
        {
            Console.WriteLine("derived display1");
        }

        //hiding
        public new void Display2()
        {
            Console.WriteLine("derived display2");
        }
        //overriding
        public override void Display3()
        {
            Console.WriteLine("derived display3");
        }
    }

    public class SubDerivedClass : DerivedClass
    {
       
        //overriding
        public sealed override void Display3()
        {
            Console.WriteLine("subderived display3");
        }
    }
    public class SubSubDerivedClass : SubDerivedClass
    {
        public new void Display3()
        {
            Console.WriteLine("subsubderived display3");
        }
    }
}

/*

Employee
 - EmpNo,Name, Basic, DeptNo
 CalcNetSalary(){}

Manager : Employee
 CalcNetSalary(){}

---------------------------
1. OVERLOADING
Derived  class can overload the base class method
 CalcNetSalary(.......){}
same func name, diff parameters

Manager m = new Manager();
m.CalcNetSalary();         BASE
m.CalcNetSalary(.....);    Derived
---------------------------------------

2. HIDING
1. Derived  class can hide the base class method
 CalcNetSalary(){}
same func name, same parameters

Manager m = new Manager();
m.CalcNetSalary();         Derived

---------------------------------------

3. OVERRIDING
1. Derived  class can override the base class method
 CalcNetSalary(){}
same func name, same parameters

Manager m = new Manager();
m.CalcNetSalary();         Derived


-----------------------------
1. ANY method can be hidden
2. Only a virtual method can be overridden


*/