using System.Reflection.Metadata.Ecma335;

namespace Assignment3
{
   

    abstract class Employee
    {

        private static int currEmpNO = 0;

        private string name;
        public  string Name
        {
            set { 
                if(value != null || value != "")
                {
                    name = value;
                }
                
            }

            get { return name; }
        }

        private int empNo;
        public int EmpNo
        {
            
          get { return empNo; }
        }

        private short deptNo;
        public short DeptNo
        {
            set
            {
                if(value > 0) { 
                deptNo = value;
                }
                else
                {
                    deptNo=1;   
                }
            }

            get { 
                return deptNo;
            }

        }

       public  abstract decimal Basic
        {
            set;get;
        }

        

       public abstract decimal CalcNetSalary();

        public override string ToString()
        {
            return "EmpNo:"+ empNo +" name:"+name+" basic:"+Basic+" deptNo:"+deptNo;
        }
    }

    class Manager : Employee
    {
        
        public Manager(string Name="default",string Designation = "abc"  , short DeptNo = 1 ,decimal Basic = 10000)
        {
            this.Name = Name;
            this.DeptNo = DeptNo;   
            this.Basic = Basic; 
            this.Designation = Designation;
           

        }

        

        private string designation;
       public string Designation
        {
            set
            {
                if(value != null && value!="") { 
                designation = value;
                }
            }
            get { return designation; } 
        }

        private decimal basic;
        public override decimal Basic { 
            get { return basic; }
            set
            {
                basic = value;
            }
        }

        public override decimal CalcNetSalary()
        {

            return basic * 2;
        }


        public override string ToString()
        {
            return base.ToString()+" designation:"+designation;
        }
    }


    class GeneralManager : Manager
    {

        public GeneralManager(string perks , string Name = "default", string Designation = "abc", short DeptNo = 1, decimal Basic = 10000)
            :base(Name, Designation,DeptNo,Basic) 
        {
            this.Perks = perks ;    
        }
        public string Perks { set;get; }

        public override string ToString()
        {
            return base.ToString() + " perks:"+Perks;
        }

    }

    class CEO : Employee
    {

        private decimal basic;
        public override decimal Basic { 
            get { return basic; }
            set {
                basic=value; }
        }

        public sealed  override decimal CalcNetSalary()
        {
            Console.WriteLine("from sealed method..");
            return 5*basic;
        }
    }

    class Tester
    {
        static void Main1()
        {
            Employee employee = new Manager("Raaj", "xyz", 2, 10);
            Employee emp2 = new CEO();
            emp2.Basic = 10000;
            Console.WriteLine(employee.Name);
            Console.WriteLine(employee.CalcNetSalary());//20
            Console.WriteLine(employee.EmpNo);//0
            Console.WriteLine(employee.DeptNo);//2
            Console.WriteLine(((Manager)employee).Designation);//xyz
            Console.WriteLine();
            Console.WriteLine(emp2.EmpNo);
            Console.WriteLine(emp2.CalcNetSalary());

            Console.WriteLine();

            Employee emp3 = new GeneralManager("perks1","RaajTheSweeper","FullTime",10,10);

            Console.WriteLine(emp3.ToString());

        }
    }
}