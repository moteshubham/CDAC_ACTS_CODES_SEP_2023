namespace FieldsAndProperties
{
    internal class Program
    {
        static void Main()
        {
            Class1 o = new Class1();
            o.i = 123;
            Console.WriteLine(o.i);

            o.Prop1 = 1000;  //assign a value -  set
            Console.WriteLine(o.Prop1);  //read a value - get

            //o.Prop3 = ""; //error
            Console.WriteLine(  o.Prop3);

            o.Prop5 = "aa";
            Console.WriteLine(o.Prop5);

            //o.SetJ(200);
            //Console.WriteLine(o.GetJ());

            //o.i = ++o.i + o.i++ - o.i-- - --o.i;
            //o.SetJ(o.GetJ()++);
        }
    }

    public class Class1
    {
        public int i;  //class level variables - fields


        //DONT EVER WRITE A SETTER AND A GETTER
        //private int j;
        //public void SetJ(int VALUE)
        //{
        //    if(VALUE>100)
        //        Console.WriteLine("invalid value");
        //    else
        //        j = VALUE;
        //}
        //public int GetJ() 
        //{ 
        //    return j; 
        //}

        private int prop1;
        public int Prop1
        {
            set 
            { 
                if(value >100)
                    Console.WriteLine("invalid value");
                else
                    prop1 = value;
            }
            get 
            {
                return prop1;
            }
        }
        private string prop2;
        public string Prop2
        {
            get { return prop2; }
            set { prop2 = value; }
        }

        public string Prop4;


        //readonly property
        private string prop3;
        public string Prop3
        {
            get { return prop3; }
        }


        //auto generated property
        //no validations
        //compiler generates te code for get and set.
        //also generates the private variable
        public string Prop5 { get; set; }
    }
}