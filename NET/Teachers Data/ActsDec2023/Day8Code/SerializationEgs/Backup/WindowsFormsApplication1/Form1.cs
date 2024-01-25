using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Runtime.Serialization.Formatters.Binary;
using System.IO;
using System.Runtime.Serialization.Formatters.Soap;
using System.Xml.Serialization;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("C:\\o.dat", FileMode.Create);
            bf.Serialize(s, o);
            s.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            BinaryFormatter bf = new BinaryFormatter();
            Stream s = new FileStream("C:\\o.dat", FileMode.Open);
            Class1 o= (Class1)bf.Deserialize(s);
            s.Close();
            MessageBox.Show(o.i.ToString());
            MessageBox.Show(o.P1);
            MessageBox.Show(o.P2.ToString());
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            SoapFormatter sf= new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Create);
            sf.Serialize(s, o);
            s.Close();

        }

        private void button3_Click(object sender, EventArgs e)
        {
            SoapFormatter sf = new SoapFormatter();
            Stream s = new FileStream("C:\\o.soap", FileMode.Open);
            Class1 o = (Class1)sf.Deserialize(s);
            s.Close();
            MessageBox.Show(o.i.ToString());
            MessageBox.Show(o.P1);
            MessageBox.Show(o.P2.ToString());
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Class1 o = new Class1();
            o.i = 100;
            o.P1 = "aaa";
            o.P2 = 200;
            XmlSerializer xs = new XmlSerializer(typeof(Class1) );
            Stream s = new FileStream("C:\\o.xml", FileMode.Create);
            xs.Serialize(s, o);
            s.Close();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            XmlSerializer xs = new XmlSerializer(typeof(Class1));
            Stream s = new FileStream("C:\\o.xml", FileMode.Open);
            Class1 o = (Class1)xs.Deserialize(s);
            s.Close();
            MessageBox.Show(o.i.ToString());
            MessageBox.Show(o.P1);
            MessageBox.Show(o.P2.ToString());

        }
    }
}
