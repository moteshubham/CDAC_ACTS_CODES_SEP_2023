namespace Assignment2
{


    public interface IDbFunctions
    {
        public void insert();
        public void delete();
        public void update();
    }


    public abstract class Employee : IDbFunctions
    {
        //property 2 - EMPNO
        //private int empno;
        private int empNo;
        public int Empno//implement auto generate code for this. No setter for read only property
        {
            get { return empNo; }
            private set { empNo = value; }
        }

        //property 1 - NAME
        private string name;
        public string Name
        {
            get { return name; }
            set
            {
                //Console.WriteLine("Entered Name set Perperty");
                if (value =="")
                {
                    Console.WriteLine("Name cannot be blank");
                }
                else
                    this.name = value;
            }
        }

        //propert 3 - DEPTNO 
        private int deptno;
        public int Deptno
        {
            get { return deptno; }
            set
            {
                if (value <= 0)
                {
                    Console.WriteLine("Invalid department number");
                }
                else
                    this.deptno = value;

            }
        }

        protected decimal basic;
        public abstract decimal Basic
        {
            get; set;
        }

        private static int index = 0;
        public Employee(string Name = "default", int Deptno = 1, decimal Basic=10000)
        {
            this.Basic = Basic;
            this.Name = Name;
            this.Deptno = Deptno;
            this.Empno = ++index; //this will auto increment the empNo
        }


        //abstract method
        public abstract decimal CalcNetSalary();

        public void insert()
        {
            Console.WriteLine("insert method - abstract class");
        }

        public void delete()
        {
            Console.WriteLine("delete method - abstract class");
        }

        public void update()
        {
            Console.WriteLine("update method - abstract class");
        }
    }

    public class Manager : Employee, IDbFunctions
    {
        //public new decimal Basic { get; set; }

        //constructor
        public Manager(string Name = "default", int DeptNo = 1, string Designation = "Manager", decimal Basic = 60000) : base(Name, DeptNo, Basic)
        {
            this.Designation = Designation;
        }
       

        private string designation;
        public string Designation
        {
            get { return designation; }
            set
            {
                if (value=="")
                {
                    Console.WriteLine("Designation cannot have a blank space in between");
                }
                else
                    this.designation = value;

            }
        }

    
        public override decimal Basic
        {

            get
            {
                return basic;
            }

            set
            {
                //Console.WriteLine("Enter set property of basic manager");
                //Console.WriteLine(value);
                if (value < 50000 || value > 100000)
                {
                    Console.WriteLine("Manager salary cannot be less than 50000 or more than 100000 ");
                }
                else
                    this.basic = value;

                //Console.WriteLine("Leaving set property of designation");
            }
        }
        public override decimal CalcNetSalary()
        {
            return (this.Basic - 5000);
        }


        public new void insert()
        {
            Console.WriteLine("insert method - Manager class");
        }

        public new void delete()
        {
            Console.WriteLine("delete method - Manager  class");
        }

        public new void update()
        {
            Console.WriteLine("update method - Manager  class");
        }
    }


    public class GeneralManager : Manager, IDbFunctions
    {
        public string Perks { get; set; }

        public GeneralManager(string Name = "deafult", int DeptNo = 1, string Designation = "Manager", string Perks = "GeneralManager", decimal Basic = 60000) : base(Name, DeptNo, Designation, Basic)
        {
            this.Perks = Perks;
        }
        public override decimal Basic
        {
            get
            {
                return basic;
            }

            set
            {

                if (value < 100000 || value > 200000)
                {
                    //Console.WriteLine("Entered the if loop");
                    Console.WriteLine("GeneralManager salary cannot be less than 100000 or more than 200000 ");
                }
                else
                    this.basic = value;


            }
        }
        public override decimal CalcNetSalary()
        {
            return (this.Basic + 10000);
        }

        public new void insert()
        {
            Console.WriteLine("insert method - General Manager class");
        }

        public new void delete()
        {
            Console.WriteLine("delete method - General Manager class");
        }

        public new void update()
        {
            Console.WriteLine("update method - General Manager class");
        }


    }

    public class CEO : Employee, IDbFunctions
    {
        public override decimal Basic
        {
            get
            {
                return this.basic;
            }
            set
            {
                if (value < 500000)
                {
                    Console.WriteLine("Basic of CEO cannot be less than 50000");
                }

                else
                    this.basic = value;
            }
        }

        public CEO(string Name="Arbaaz", int DeptNo=1, decimal Basic= 500000) : base(Name, DeptNo,Basic)
        {

        }

        public sealed override decimal CalcNetSalary()
        {
            return (this.Basic - 20000);
        }

        public new void insert()
        {
            Console.WriteLine("insert method - CEO class");
        }

        public new void delete()
        {
            Console.WriteLine("delete method - CEO class");
        }

        public new void update()
        {
            Console.WriteLine("update method - CEO class");
        }


    }

    public class ImplClass
    {
        public static void Main()
        {
            GeneralManager gm = new GeneralManager("a", 1, "m", "", 110000);
            Console.WriteLine(gm.Basic);
        }
        public static void Main1()
        {
            // Employee emp = new Employee(); <ERROR> CANNOT INSTANTIATE AN ABSTRACT CLASS

            Manager man = new Manager("Arbaaz", 5, "Project-Manager", 60000);

            Console.WriteLine("Name of Manager: " + man.Name);
            Console.WriteLine("DeptNo of Manager: " + man.Deptno);
            Console.WriteLine("Designation of Manager: " + man.Designation);
            Console.WriteLine("Basic Salary of Manager: " + man.Basic);
            Console.WriteLine("Net Salary of Manager: " + man.CalcNetSalary());

            Console.WriteLine();

            GeneralManager gen = new GeneralManager("Adnan", 4, "Regional-Head", "Free House", 180000);
            Console.WriteLine("Name of GM: " + gen.Name);
            Console.WriteLine("DeptNo of GM: " + gen.Deptno);
            Console.WriteLine("Designation of GM: " + gen.Designation);
            Console.WriteLine("Perks for GM: " + gen.Perks);
            Console.WriteLine("Basic Salary of GM: " + gen.Basic);
            Console.WriteLine("Net Salary of GM: " + gen.CalcNetSalary());

            Console.WriteLine();

            CEO ceo = new CEO("Rushi", 1, 600000);
            Console.WriteLine("Name of CEO: " + ceo.Name);
            Console.WriteLine("DeptNo of CEO: " + ceo.Deptno);
            Console.WriteLine("Basic Salary of CEO: " + ceo.Basic);
            Console.WriteLine("Net Salary of CEO: " + ceo.CalcNetSalary());

        }
    }
}