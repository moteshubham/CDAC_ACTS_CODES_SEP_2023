namespace EventHandling1
{
    internal class Program
    {
        //static void Main()
        //{
        //    Class1 objCls1 = new Class1();
        //    objCls1.InvalidP1 += objCls1_InvalidP1;
        //    objCls1.P1 = 110;
        //}
        //static void objCls1_InvalidP1()
        //{
        //    Console.WriteLine("Event handled");
        //}
        static void Main()
        {
            Class1 objCls1 = new Class1();
            objCls1.InvalidP1 += ObjCls1_InvalidP1;
            objCls1.InvalidP1 += handler2;

            objCls1.P1 = 1234;

            Class1 o2 = new Class1();
            

        }

        private static void ObjCls1_InvalidP1()
        {
            Console.WriteLine("event handled");
        }
        private static void handler2()
        {
            Console.WriteLine("event handled here also");
        }
    }

    //developer
    //step 1 : create a delegate class having the same signature as the event
    public delegate void Del1();

    public class Class1
    {
        //step 2 : declare the event of the delegate type
        public event Del1 InvalidP1;

        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //step 3 : raise the event whenever you want to 
                    if(InvalidP1!=null)
                        InvalidP1();

                }
            }
        }
    }
}
//events with parameters
namespace EventHandling2
{
    internal class Program
    {
        
        static void Main2()
        {
            Class1 objCls1 = new Class1();
            objCls1.InvalidP1 += ObjCls1_InvalidP1;
            objCls1.P1 = 200;
        }

        private static void ObjCls1_InvalidP1(int InvalidValue)
        {
            Console.WriteLine("event handled. invalid value was " + InvalidValue);
        }
    }

    //developer
    //step 1 : create a delegate class having the same signature as the event
    public delegate void Del1(int InvalidValue);

    public class Class1
    {
        //step 2 : declare the event of the delegate type
        public event Del1 InvalidP1;

        private int p1;
        public int P1
        {
            get
            {
                return p1;
            }
            set
            {
                if (value < 100)
                    p1 = value;
                else
                {
                    //step 3 : raise the event whenever you want to 
                    if (InvalidP1 != null)
                        InvalidP1(value);

                }
            }
        }
    }
}