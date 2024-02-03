﻿using Employee_Assignment;

namespace Employee_Assignment
{
    internal class Program
    {
        static void Main()
        {
            Employee o1 = new Employee("Amol", 123465, 10);
            Employee o2 = new Employee("Amol", 123465);
            Employee o3 = new Employee("Amol");

            Console.WriteLine(o1.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o3.EmpNo);
            Console.WriteLine("-----------------------");
            Console.WriteLine(o3.EmpNo);
            Console.WriteLine(o2.EmpNo);
            Console.WriteLine(o1.EmpNo);
        }
    }


    public class Employee
    {
        private string name;
        private int empNo;  // must be readonly and autogenerated
        private decimal basic; //must be between some range
        private short deptNo;
        static int noGenerator = 0;

        static int NoGenerator()
        {
            Console.WriteLine("in static ctor");
            return ++noGenerator;
        }


        public Employee()
        {
            Console.WriteLine("in def ctor");
        }
        public Employee(string name)
        {
            this.name = name;
            this.empNo = NoGenerator();
        }
        public Employee(string name, decimal salary)
        {
            this.name = name;
            this.basic = salary;
            this.empNo = NoGenerator();

        }

        public Employee(string name, decimal salary, short dep)
        {
            this.name = name;
            this.basic = salary;
            this.deptNo = dep;
            this.empNo = NoGenerator();

        }
        public string Name
        {
            set
            {
                if (value != null)
                    name = value;
                else
                    Console.WriteLine("invalid input");
            }
            get
            {
                return name;
            }
        }

        public int EmpNo
        {
            set
            {

            }
            get
            {
                return empNo;
            }
        }

        public decimal Basic
        {
            set
            {
                if (value > 15000 & value < 90000)
                    basic = value;
            }
            get
            {
                return basic;
            }
        }

        public short DeptNo
        {
            set
            {
                if (value > 0)
                    deptNo = value;
            }
            get
            {
                return deptNo;
            }
        }

        public decimal GetNetSalary()
        {
            return basic + 9999;
        }


    }
}

/*Create a Class Employee with the following specifications

Properties
----------
string Name -> no blank names should be allowed
int EmpNo ->  must be readonly and autogenerated
decimal Basic -> must be between some range
short DeptNo -> must be > 0

Methods
-------
decimal GetNetSalary() -> returns calculated net salary (Use any formula to get net salary based on Basic salary)


Create constructors to accept initial values for Employee obj
Employee o1 = new Employee("Amol", 123465, 10);
Employee o2 = new Employee("Amol", 123465);
Employee o3 = new Employee("Amol");
Employee o4 = new Employee();

EmpNo must be autogenerated ... i.e.
first object should automatically get EmpNo 1
second object should automatically get EmpNo 2
third object should automatically get EmpNo 3
...and so on...

Test Cases
Employee o1 = new Employee()
Employee o2 = new Employee()
Employee o3 = new Employee()
cw(o1.EmpNo)
cw(o2.EmpNo)
cw(o3.EmpNo)

cw(o3.EmpNo)
cw(o2.EmpNo)
cw(o1.EmpNo)*/