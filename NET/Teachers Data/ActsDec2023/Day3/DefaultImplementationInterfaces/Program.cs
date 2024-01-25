namespace Interfaces1
{
    internal class Program
    {
        static void Main()
        {
            Class1 o = new Class1();
            o.Insert();

            //2. write a public method in class1 and it calls code from class1
            //o.Select();

            //1. without writing any code for Select in Class1 - it calls def imp code from interface
            (o as IDbFunctions).Select();


        }
    }

    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
        void Select()
        {
            Console.WriteLine("def imp of select");
        }
    }

    public class Class1 : IDbFunctions
    {
        public void Display()
        {
            Console.WriteLine("display from class1");
        }
        public void Delete()
        {
            Console.WriteLine("idb.delete from class1");
        }
        public void Insert()
        {
            Console.WriteLine("idb.Insert from class1");
        }
        public void Update()
        {
            Console.WriteLine("idb.update from class1");
        }
        //public void Select()
        //{
        //    Console.WriteLine("idb.select from class1");
        //}

        //if you are getting multiple copies of Select from different interfaces
        //then insted of public method, use explicit implentation
        void IDbFunctions.Select()
        {
            Console.WriteLine("idb.select from class1 - explicit implementation");
        }
    }

}