namespace Employee2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employee3 employee = new Employee3();
            //employee.EmpNo = 10;

            Console.WriteLine(employee.EmpNo);
        }
    }

    public class Employee1
    {
        private static int lastEmpNo;
        string name; //-> no blank names should be allowed
        int empNo; 
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }
        public int EmpNo
        {
            get { return empNo; }
            //set
            //{
            //    if (value > 0)
            //        empNo = value;
            //    else
            //        Console.WriteLine("Invalid EmpNo");
            //}
        }
        public decimal Basic
        {
            get { return basic; }
            set
            {
                if (value < 10000 || value > 100000)
                    Console.WriteLine("Invalid Basic");
                else
                    basic = value;

            }
        }
        public short DeptNo
        {
            get { return deptNo; }
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid EmpNo");
            }
        }
        public decimal GetNetSalary()
        {
            return Basic * 2;
        }
        //public Employee1(int EmpNo = 1, string Name = "default", decimal Basic = 10000, short DeptNo = 1)
        public Employee1( string Name = "default", decimal Basic = 10000, short DeptNo = 1)
        {
            //this.EmpNo = EmpNo;  //property - set
            empNo = ++lastEmpNo;
            
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
    }


    public class Employee2
    {
        private static int lastEmpNo;
        string name; //-> no blank names should be allowed
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }
        public int EmpNo
        {
            get;
        }
        public decimal Basic
        {
            get { return basic; }
            set
            {
                if (value < 10000 || value > 100000)
                    Console.WriteLine("Invalid Basic");
                else
                    basic = value;

            }
        }
        public short DeptNo
        {
            get { return deptNo; }
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid EmpNo");
            }
        }
        public decimal GetNetSalary()
        {
            return Basic * 2;
        }
        public Employee2(int EmpNo = 1, string Name = "default", decimal Basic = 10000, short DeptNo = 1)
        {
            this.EmpNo = ++lastEmpNo;  //this line is only allowed in a constructor for a readonly auto property

            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
        void x()
        {
            //this.EmpNo = ++lastEmpNo;  //error when done outside the constructor
        }
    }


    public class Employee3
    {
        private static int lastEmpNo;
        string name; //-> no blank names should be allowed
        int empNo; //-> must be greater than 0
        decimal basic;// -> must be between some range
        short deptNo;// -> must be > 0

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != "")
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }
        public int EmpNo
        {
            get { return empNo; }

            //only one of the set or the get can have a different access specifier from the property
            //you can only reduce access, not increase it

            private set//property accessor
            {
                if (value > 0)
                    empNo = value;
                else
                    Console.WriteLine("Invalid EmpNo");
            }
        }
        public decimal Basic
        {
            get { return basic; }
            set
            {
                if (value < 10000 || value > 100000)
                    Console.WriteLine("Invalid Basic");
                else
                    basic = value;

            }
        }
        public short DeptNo
        {
            get { return deptNo; }
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid EmpNo");
            }
        }
        public decimal GetNetSalary()
        {
            return Basic * 2;
        }
        public Employee3(int EmpNo = 1, string Name = "default", decimal Basic = 10000, short DeptNo = 1)
        {
            this.EmpNo = EmpNo;  //property - set
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }
    }
}