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
  

}