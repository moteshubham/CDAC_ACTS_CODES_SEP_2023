using System.Xml.Linq;

namespace InheritanceAssign
{
    internal class Program
    {
        static void Main()
        {

          //  Manager m = new Manager();
            GeneralManager g = new GeneralManager();
          //  CEO c = new CEO();
          //  Console.WriteLine("manager : " + m.CalcNetSalary());
            //Console.WriteLine("genmgr : " + g.CalcNetSalary());
            //Console.WriteLine("ceo : " + c.CalcNetSalary());
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();
            Console.WriteLine();
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------------
        public abstract class Employee
        {
            private string name;
            protected string Name
            {
                set
                {
                    if (value != null)
                        name = value;
                    else
                    {
                        Console.WriteLine("enter valid name");
                    }
                }
                get
                {
                    return name;
                }

            }
            static int empNoGenerator = 0;
            private int empNo;
            public int EmpNo
            {
                get
                {
                    return empNo;
                }
            }

            private short deptNo;
            public short DeptNo
            {
                get
                {
                    return deptNo;
                }
                set
                {
                    if (value < 1)
                        Console.WriteLine("enter valid dept no");
                    else
                        deptNo = value;
                }
            }

            protected abstract decimal Basic
            {
                get; set;
            }

            public abstract decimal CalcNetSalary();


            public Employee(string name = "default", short DeptNo = 1)
            {
                this.name = name;
                this.DeptNo = DeptNo;
                this.empNo = ++empNoGenerator;
            }
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------------

        public class Manager : Employee
        {
            private string? designation;
            private string Designation
            {
                set
                {
                    if (value != null)
                        this.designation = value;
                    else
                        Console.WriteLine("invalid designation");
                }
                get
                {
                    return designation!;
                }
            }

            private decimal basic;
            protected override decimal Basic
            {
                set
                {
                    if (value < 49000)
                        Console.WriteLine("enter valid basic 50k is basic for manager");
                    else
                        basic = value;
                }
                get
                {
                    return basic;
                }
            }
            public override decimal CalcNetSalary()
            {
                return Basic + 5555;
            }


            public Manager(string Designation = "default designation mgr", string name = "default name mgr", short DeptNo = 2) : base(name, DeptNo)
            {
                 this.Basic = 50000;
                this.Designation = Designation;

            }

        }
        //---------------------------------------------------------------------------------------------------------------------------------------------------
        public class GeneralManager : Manager
        {
            private string? perks;
            protected string? Perks
            {
                set; get;
            }
            private decimal basic;
            protected override decimal Basic
            {
                set
                {
                    if (value < 69000)
                        Console.WriteLine("enter valid basic 70k is basic for Genreal manager");
                    else
                        basic = value;
                }
                get
                {
                    return basic;
                }
            }
            public GeneralManager(string Designation = "default designation gen mgr", string name = "default genmgr", short deptNo = 3, string Perks = "def perks") : base(Designation, name, deptNo)
            {
                this.Perks = Perks;
                this.Basic = 70000;

            }
            public override decimal CalcNetSalary()
            {
                return Basic + 8888;
            }
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------------
        public class CEO : Employee
        {


            private decimal basic;
            protected override decimal Basic
            {
                set
                {
                    if (value < 89000)
                        Console.WriteLine("enter valid basic 90k is basic for CEO");
                    else
                        basic = value;
                }
                get
                {
                    return basic;
                }
            }
            public CEO(string name = "default ceo", short DeptNo = 4) : base(name, DeptNo)
            {
                Basic = 90000;
            }
            public override sealed decimal CalcNetSalary()
            {
                return Basic + 9999;
            }
        }

    }
}
/*




NOTE : Overloaded constructors in all classes calling their base class constructor
All classes must implement IDbFunctions interface
All classes to override the abstract members defined in the base class(Employee). Basic property to have different validation in different classes.
CalcNetSalary() to have different validation in different classes.*/