namespace TupleExample1
{
    internal class Program
    {
        static void Main1()
        {
            //Tuple<int, string> t1 = new Tuple<int, string>(1, "Vikram");
            var t1 = new Tuple<int, string>(1, "Vikram");
            Console.WriteLine(t1.Item1);
            Console.WriteLine(t1.Item2);
        

            var t2 = Tuple.Create(1, "Vikram");
            Console.WriteLine(t2.Item1);
            Console.WriteLine(t2.Item2);


            var t3 = Tuple.Create(1, 2, 3, 4, 5, 6, 7);  //max 7
            //var t3a = Tuple.Create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12); //ERROR - max 7
            Console.WriteLine(t3.Item7);


            var nestedTuple = Tuple.Create(1, 2, 3, 4, 5, 6, 7, Tuple.Create(8,9,10,11,12));
            Console.WriteLine(nestedTuple.Item7);
            Console.WriteLine(nestedTuple.Rest.Item1.Item1);  //8
            Console.WriteLine(nestedTuple.Rest.Item1.Item5);  //12


        }

        static void F1(Tuple<int, string> t1)
        {
            Console.WriteLine(t1.Item1);
            Console.WriteLine(t1.Item2);
        }
        static void F2(Tuple<int, int, int, int, int, int, int, Tuple<int,int,int,int,int>> nestedTuple)
        {
            Console.WriteLine(nestedTuple.Item7);
            var t = nestedTuple.Rest;

            Console.WriteLine(t.Item1);  //8
            Console.WriteLine(t.Item5);  //12

        }
    }
}

/*
  Tuple class is that is a reference-type with memory allocation on the heap. 
  Due to allocations and garbage collection pressure, 
   using it can lead to CPU-intensive operations and major performance issues in our system. 
 
 The ValueTuple on the other hand is a lightweight value type object 
     and has its memory stored on the stack.

 ValueTuple is a mutable struct and exposes its elements as fields. .
In terms of performance, flexibility, and reusability the ValueTuple is better.  

 */

namespace ValueTupleExample
{
    internal class Program
    {
        static void Main()
        {
            ValueTuple<int, int> vt0 = new ValueTuple<int, int>(10, 20);
            (int, int) vt1 = (1, 2);

            var vt2 = (1, 2);
            Console.WriteLine(vt2.Item1);
            Console.WriteLine(vt2.Item2);


            //value tuple with named fields
            (int lastYear, int currentYear) namedValueTuple = (2021, 2022);
            Console.WriteLine(namedValueTuple.lastYear);
            Console.WriteLine(namedValueTuple.currentYear);

            var rightHandNamedValueTuple = (language: "C#", tool: "Laptop", occupation: "Developer");
            Console.WriteLine(rightHandNamedValueTuple.language);

            //ValueTuples eight items:

            var valueTuple = ("my", "name", "is", "john", "doe", "and", "I", "am", 1000, "years", "old", true);
        }

        //value tuple as a parameter
        public static string TakeInAValueTuple((int legCount, bool isBlue) organism)
        {
            var hasAtLeastFourLegs = organism.legCount >= 4;
            var isBlue = organism.isBlue;
            return $"hasAtLeastFourLegs : {hasAtLeastFourLegs} and isBlue : {isBlue}";
        }

        //value tuple as a return type
        public static (bool isDay, string greeting) ReturnAValueTuple()
        {
            if (DateTime.Now.Hour < 12)
                return (isDay: true, greeting: "Good Morning");
            return (isDay: false, greeting: "Good Evening");
        }
    }
}

//https://code-maze.com/csharp-tuple/
//https://code-maze.com/csharp-valuetuple-vs-tuple/