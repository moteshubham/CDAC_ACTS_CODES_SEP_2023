namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
        Mutex m;
        public Form1()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                m = Mutex.OpenExisting("Mutex1");
                label2.Text = "opened existing";
                label1.Text = "waiting";
                m.WaitOne();
            }
            catch (WaitHandleCannotBeOpenedException)
            {
                m = new Mutex(true, "Mutex1");
                label2.Text = "created new";
                this.Refresh();
            }
            label1.Text = "Running 2";
            this.Refresh();
            for (long i = 0; i < 9999999999; i++)  
            { }
            label1.Text = "Ended 2";
            m.ReleaseMutex();

        }
    }
}