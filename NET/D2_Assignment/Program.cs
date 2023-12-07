using Math;

namespace D2_Assignment


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

        public decimal getNetSalary()
        {
            Math.Program program = new Math.Program();
            return NetSalary;
        }

        public void setNetSalary(Employee e)
        {
            Math.Program program = new Math.Program();
            NetSalary = program.PerformMath(e.Basic);
        }

        static void Main(string[] args)
        {
            Employee o1 = new Employee(1, "Amol", 123, 10);
            Employee o2 = new Employee(1, "Amol", 12);

            Employee o3 = new Employee(1, "Amol");
            Employee o4 = new Employee(1);
            Employee o5 = new Employee();
            
            Math.Program program = new Math.Program();
            decimal netSalary=program.PerformMath(o1.Basic);
            // Console.WriteLine("Net salary is " +netSalary);

            o2.setNetSalary(o2);
            Console.WriteLine("Net salary is " + o2.getNetSalary());
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

