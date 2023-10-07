class Box {
//data members : state of the object(instance vars) / fields /props/attributes
 private double width;
 private double depth;
 private double height;
  //add a parameterized ctor to init COMPLETE state of the Box
  Box(double w,double d,double height)
  {
	   width=w;
	   depth=d;
	   this.height=height;
  }
//add overloaded ctor to init a cube (using ctor chaining)
   Box(double side)
 {
  //  width=depth=height=side;
       this(side,side,side);//matching ctor of the SAME class will be invoked.
 }
 //add overloaded ctor to init a dummy box
  Box()
{
   //width=depth=height=-1;
   this(-1);
}


  //add an instance method to ret box details(all dims) in a string
  String getBoxDetails() {
	  
	  //impl arg : this
	  //using "this" keyword : OPTIONAL
	  System.out.println("this from instance method "+this);
	  return "Box dims are "+this.width+" "+this.depth+" "+this.height;
  }
  //add an instance method to ret  computed vol of the Box
  double getBoxVolume() {
	  return width*depth*height;
  }
//add a non static method to chk equality of 2 boxes
  boolean isEqual(Box anotherBox)
  {
    //b1.isEqual(b2) => this=b1,     anotherBox=b2
    System.out.println("this from method "+this +" arg "+anotherBox);
    return this.width==anotherBox.width && this.depth==anotherBox.depth && this.height==anotherBox.height;
 }
  
  Box createNewBox(double w, double d, double h){
	Box myBox = new Box(this.width+w, this.depth+d, this.height+h);
	return myBox;
}

}