using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Xml.Serialization;

namespace WindowsFormsApplication1
{
    //[SerializableAttribute]
    [Serializable]
    public class Class1 :ISerializable
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


        public void GetObjectData(SerializationInfo info, StreamingContext context)
        {
            //called during Serialize
            info.AddValue("i", i);
            info.AddValue("mP2", mP2);
        }
        public Class1()
        {

        }
        public Class1(SerializationInfo info, StreamingContext context)
        {
            //called during Deserialize
            i = info.GetInt32("i");
            mP2 = info.GetInt32("mP2");
        }
    }
}
