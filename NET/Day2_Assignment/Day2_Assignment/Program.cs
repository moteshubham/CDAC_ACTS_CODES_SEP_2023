using MathPerform;
using System.Runtime.Serialization;

namespace Day2_Assignment
{
    internal class Employee
    {
        private string Name;
        private int EmpNo = Idgen++;
        private decimal Basic;
        private short DeptNo;
        private decimal NetSalary;


        private static int Idgen = 1;
        Employee(int EmpNo, String Name, decimal Basic, short DeptNo)
        {
            this.EmpNo = EmpNo;
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }

        public Employee(int EmpNo, String Name, decimal Basic)
        {
            this.EmpNo = EmpNo;
            this.Name = Name;
            this.Basic = Basic;
        }

        public Employee(int EmpNo, String Name)
        {
            this.EmpNo = EmpNo;
            this.Name = Name;
        }

        public Employee(int EmpNo)
        {
            this.EmpNo = EmpNo;

        }

        public Employee()
        {

        }

        public decimal GetNetSalary()
        {
            NetSalary = Basic * 12;
            return NetSalary;
        }

        static void Main(string[] args)
        {
            Employee o1 = new Employee(1, "Amol", 123465, 10);
            Employee o2 = new Employee(1, "Amol", 123465);

            Employee o3 = new Employee(1, "Amol");
            Employee o4 = new Employee(1);
            Employee o5 = new Employee();
            Console.WriteLine("Net salary is " + o1.PerformMath(Basic));

            /*            Employee o1 = new Employee();
                        Employee o2 = new Employee();
                        Employee o3 = new Employee();

                        Console.WriteLine(o1.EmpNo);
                        Console.WriteLine(o2.EmpNo);
                        Console.WriteLine(o3.EmpNo);

                        Console.WriteLine(o3.EmpNo);
                        Console.WriteLine(o2.EmpNo);
                        Console.WriteLine(o1.EmpNo);
            */
        }
    }
}