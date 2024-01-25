using System.Reflection;
namespace ReflectionExample
{
    internal class Program
    {

        //asm1 -> asm2 ->asm3 ->asm4
        static void Main()
        {
            //Assembly asm = Assembly.GetAssembly(type);
            //Assembly asm = Assembly.GetAssembly(typeof(string));
            //Assembly asm = Assembly.GetEntryAssembly();  //asm1
            //Assembly asm = Assembly.GetCallingAssembly();  //asm3
            //Assembly asm = Assembly.GetExecutingAssembly(); //asm4

            Assembly asm = Assembly.LoadFrom(@"D:\Trainings\ActsDec2023\Day2\Functions\bin\Debug\net7.0\Functions.dll");

            //Console.WriteLine(asm.FullName);
            Console.WriteLine(asm.GetName().Name);

            //asm.GetType("classname");
            Type[] arrTypes = asm.GetTypes();
            foreach (Type t in arrTypes)
            {
                Console.WriteLine("   "+ t.Name);
                MethodInfo[] arrMethods = t.GetMethods();
                foreach (MethodInfo m in arrMethods)
                {
                    Console.WriteLine(m.Name);
                    //...
                }
            }
        }
    }
}