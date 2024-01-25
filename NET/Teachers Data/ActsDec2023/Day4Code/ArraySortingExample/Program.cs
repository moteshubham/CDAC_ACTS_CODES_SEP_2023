using System.Collections;

namespace ArraySortingExample
{
    internal class Program
    {
        static void Main0()
        {
            Emp[] arr = new Emp[3];
            arr[0] = new Emp { EmpNo = 5, Name = "Ananya", Basic = 12335, DeptNo = 10 };
            arr[1] = new Emp { EmpNo = 1, Name = "Vikram", Basic = 22335, DeptNo = 20 };
            arr[2] = new Emp { EmpNo = 2, Name = "Harsh", Basic = 22335, DeptNo = 20 };

            Array.Sort(arr); //error
            foreach (Emp item in arr)
            {
                Console.WriteLine(item);
            }
        }
        static void Main2()
        {
            Employee1[] arr = new Employee1[5];
            arr[0] = new Employee1 { EmpNo = 5, Name = "Junaid", Basic = 12335, DeptNo = 10 };
            arr[1] = new Employee1 { EmpNo = 2, Name = "Abhi", Basic = 22335, DeptNo = 20 };
            arr[2] = new Employee1 { EmpNo = 1, Name = "Avni", Basic = 52335, DeptNo = 20 };
            arr[3] = new Employee1 { EmpNo = 4, Name = "Shiti", Basic = 32335, DeptNo = 30 };
            arr[4] = new Employee1 { EmpNo = 3, Name = "Suruchi", Basic = 42335, DeptNo = 40 };

            //Array.Sort<Employee1>(arr );

            Array.Sort(arr, new Employee1()); //IComparer


            foreach (Employee1 item in arr)
            {
                Console.WriteLine(item);
            }
        }
        static void Main()
        {
            Employee2[] arr = new Employee2[5];
            arr[0] = new Employee2 { EmpNo = 5, Name = "Junaid", Basic = 12335, DeptNo = 10 };
            arr[1] = new Employee2 { EmpNo = 2, Name = "Abhi", Basic = 22335, DeptNo = 20 };
            arr[2] = new Employee2 { EmpNo = 1, Name = "Avni", Basic = 52335, DeptNo = 20 };
            arr[3] = new Employee2 { EmpNo = 4, Name = "Shiti", Basic = 32335, DeptNo = 30 };
            arr[4] = new Employee2 { EmpNo = 3, Name = "Suruchi", Basic = 42335, DeptNo = 40 };

            Array.Sort<Employee2>(arr );  //IComparable
            //Array.Sort(arr, new Employee1());
            foreach (Employee2 item in arr)
            {
                Console.WriteLine(item);
            }
        }
    }

    public class Emp
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }
        public override string ToString()
        {
            return $"Empno={EmpNo}, Name={Name}, Basic={Basic}, DeptNo={DeptNo}";
        }
    }
   


    public class Employee1 : IComparer<Employee1> //IComparer  //  : 
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }

        //public int Compare(object x, object y)
        //{
        //    Employee1 o1 = (Employee1)x;
        //    Employee1 o2 = (Employee1)y;
        //    //return 0;
        //    //  throw new NotImplementedException();
        //}

        public int Compare(Employee1? x, Employee1? y)
        {
            if (x.EmpNo > y.EmpNo)
                return 1;
            else if (x.EmpNo < y.EmpNo)
                return -1;
            else
                return 0;
        }


        public override string ToString()
        {
            return $"Empno={EmpNo}, Name={Name}, Basic={Basic}, DeptNo={DeptNo}";
        }
    }
    public class Employee2 : IComparable<Employee2>
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public short DeptNo { get; set; }

        public int CompareTo(Employee2? other)
        {
            //return string.Compare(this.Name, other.Name);
            if (this.Basic > other.Basic)
                return 1;
            else if (this.Basic < other.Basic)
                return -1;
            else
                return 0;
        }

        public override string ToString()
        {
            return $"Empno={EmpNo}, Name={Name}, Basic={Basic}, DeptNo={DeptNo}";
        }
    }

}