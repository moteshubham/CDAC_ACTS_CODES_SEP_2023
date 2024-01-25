using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using System.Runtime.Serialization.Formatters.Soap;
using System.Xml.Serialization;

namespace SerializationWithCore
{
    internal class Program
    {
        static void Main()
        {
            BinSer();
            BinDes();
        }

        static void BinSer()
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("C:\\o.dat", FileMode.Create);
#pragma warning disable SYSLIB0011 // Type or member is obsolete
            bf.Serialize(s, o);
#pragma warning restore SYSLIB0011 // Type or member is obsolete
            s.Close();
        }
        static void BinDes()
        {
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("C:\\o.dat", FileMode.Open);
#pragma warning disable SYSLIB0011 // Type or member is obsolete       
            Class1 o = (Class1)bf.Deserialize(s);
#pragma warning restore SYSLIB0011 // Type or member is obsolete
            s.Close();
            Console.WriteLine( o.i.ToString());
            Console.WriteLine(o.P1);
            Console.WriteLine(o.P2.ToString());
        }
        static void SoapSer()
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Create);
            sf.Serialize(s, o);
            s.Close();
        }
        static void SoapDes()
        {
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Open);
            Class1 o = (Class1)sf.Deserialize(s);
            s.Close();
            Console.WriteLine(o.i.ToString());
            Console.WriteLine(o.P1);
            Console.WriteLine(o.P2.ToString());
        }

    }

    [Serializable]
    public class Class1 //: ISerializable
    {
        private int private_data;
        public int i;
        [XmlElement]
        public string P1
        {
            get;
            set;
        }
        private int mP2;
        [XmlAttribute]
        public int P2
        {
            get { return mP2; }
            set { mP2 = value; }
        }


        //    public void GetObjectData(SerializationInfo info, StreamingContext context)
        //    {
        //        //called during Serialize
        //        info.AddValue("i", i);
        //        info.AddValue("mP2", mP2);
        //    }
        //    public Class1()
        //    {

        //    }
        //    public Class1(SerializationInfo info, StreamingContext context)
        //    {
        //        //called during Deserialize
        //        i = info.GetInt32("i");
        //        mP2 = info.GetInt32("mP2");
        //    }
        //}
    }

}