namespace AbstractClasses1
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            AbsClass1 o;
            //o = new AbsClass1();  //error

            DerivedClass o2 = new DerivedClass();
            o2.Display();
        }
    }

    public abstract class AbsClass1
    {
        public void Display()
        {
            Console.WriteLine("disp");
        }
    }

    public class DerivedClass : AbsClass1 
    { 
    
    }
}

namespace AbstractClasses2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            AbsClass1 o;
            //o = new AbsClass1();  //error

            DerivedClass o2 = new DerivedClass();
            o2.Display();
        }
    }

    public abstract class AbsClass1
    {
        public abstract void Display();
        public abstract void Show();

    }

    public class DerivedClass : AbsClass1
    {
        public override void Display()
        {
            Console.WriteLine("disp");
        }

        public override void Show()
        {
            Console.WriteLine("show");
        }
    }

    public abstract class Derived2 :AbsClass1
    {

    }
}

/*
                            Can Instantiate     Can be used as a base class
Abstract Class              NO                  YES

Sealed Class                YES                 NO



 
*/