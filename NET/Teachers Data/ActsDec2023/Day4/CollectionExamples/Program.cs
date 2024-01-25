using System.Collections;

namespace CollectionExamples
{
    internal class Program
    {
        static void Main1()
        {
            ArrayList objArrayList = new ArrayList();
            objArrayList.Add("Vikram");
            objArrayList.Add(100);
            objArrayList.Add(1.1);
            objArrayList.Add(true);

            objArrayList.Remove("Vikram");
            objArrayList.RemoveAt(2);  //index
            ArrayList o2 = new ArrayList();

            objArrayList.AddRange(o2);

            objArrayList.Insert(0, "new");
            objArrayList.InsertRange(0, o2);

            objArrayList.RemoveRange(0, 3); //index, number of items to remove

            //objArrayList.IndexOf
            //objArrayList.LastIndexOf
            //objArrayList.BinarySearch

            //objArrayList.Clear

            //objArrayList.Contains("new");
            object[] arr = new object[objArrayList.Count];
            objArrayList.CopyTo(arr);

            ArrayList o3 = objArrayList.GetRange(0, 3); //returns a subset of the arraylist

            //assumin objArrayList - 10,20 30 ,40
            //o2 - 5 15 25
            objArrayList.SetRange(0, o2);
            //objArrayList - 5 15 25 ,40

            object[] arr2 = objArrayList.ToArray();

            //objArrayList[0] = 10;  //objArrayList.this[0] = 10; -- uses an indexer
            Console.WriteLine( objArrayList.Count );
            foreach (object item in objArrayList)
            {
                Console.WriteLine(item);
            }
        }

        static void Main2()
        {
            ArrayList objArrayList = new ArrayList();

            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");
            objArrayList.Add("Vikram");
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");   

            objArrayList.TrimToSize();  //sets capacity to actual no of elements in list
            Console.WriteLine($"count is {objArrayList.Count}, capacity is {objArrayList.Capacity}");

        }

        static void Main3()
        {
            //Hashtable objDictionary = new Hashtable();
            SortedList objDictionary = new SortedList();
            objDictionary.Add(1, "Vikram");
            objDictionary.Add(2, "Harsh");
            objDictionary.Add(3, "Shweta");
            objDictionary.Add(4, "Ananya");

            objDictionary[5] = "new";
            objDictionary[1] = "update";

            objDictionary.Remove(1);  //key
            objDictionary.RemoveAt(2); //index

            //objDictionary.Contains(key)
            //objDictionary.ContainsKey(key)
            //objDictionary.ContainsValue(value)

            //objDictionary.GetByIndex(0); //returns value at index 0
            //objDictionary.GetKey(index)

            IList keys = objDictionary.GetKeyList();
            //objDictionary.GetValueList

            //objDictionary.IndexOfKey(key);
            //objDictionary.IndexOfValue(value);

            ICollection keys2 = objDictionary.Keys;
            ICollection values = objDictionary.Values;
            objDictionary.SetByIndex(0, "changed");

            foreach (DictionaryEntry item in objDictionary)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine(item.Value);

            }
        }
        static void Main4()
        {
            Stack s = new Stack();
            s.Push("pa");
            Console.WriteLine(s.Peek());
            Console.WriteLine(s.Pop());

            Queue q = new Queue();
            q.Enqueue("a");
            Console.WriteLine(q.Peek());
            Console.WriteLine(q.Dequeue());
        }

        static void Main5()
        {
            List<int> list = new List<int>();
            list.Add(1);
            foreach (int item in list)
            {
                
            }
            List<string> list2 = new List<string>();

            List<Employee> lstEmps = new List<Employee>();
            lstEmps.Add(new Employee { EmpNo = 1, Name = "Vikram" });
            lstEmps.Add(new Employee { EmpNo = 2, Name = "B" });
            lstEmps.Add(new Employee { EmpNo = 3, Name = "C" });
            lstEmps.Add(new Employee { EmpNo = 4, Name = "D" });

            foreach (Employee item in lstEmps)
            {
                Console.WriteLine(item.EmpNo);
                Console.WriteLine(item.Name);
            }
        }
        static void Main6()
        {
            SortedList<int, string> sortedlist1 = new SortedList<int, string>();
            sortedlist1.Add(1, "A");
            sortedlist1.Add(2, "B");
            sortedlist1.Add(3, "C");
            sortedlist1[4] = "D";

            foreach (KeyValuePair<int, string> item in sortedlist1)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine(item.Value);
            }

            SortedList<int, Employee> sortedList2 = new SortedList<int, Employee>();
            sortedList2.Add(1, new Employee { EmpNo = 1, Name = "Vikram" });
            sortedList2.Add(2, new Employee { EmpNo = 2, Name = "B" });

            foreach (KeyValuePair<int,Employee> item in sortedList2)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine(item.Value.EmpNo);
                Console.WriteLine(item.Value.Name);
            }
        }
        static void MAin7()
        {
            Stack<int> stack = new Stack<int>();    
            Queue<int> queue = new Queue<int>();    
        }
    }

    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public override string ToString()
        {
            return "EmpNo=" + EmpNo + ",Name=" + Name;
        }
    }
}