class Box {

 private double width;
 private double depth;
 private double height;
 
  Box(double w,double d,double height)
  {
	   width=w;
	   depth=d;
	   this.height=height;
  }

   Box(double side)
 {
  //  width=depth=height=side;
       this(side,side,side);
 }

  Box()
{
   //width=depth=height=-1;
   this(-1);
}



  String getBoxDetails() {
	  

	  System.out.println("this from instance method "+this);
	  return "Box dims are "+this.width+" "+this.depth+" "+this.height;
  }
  
  double getBoxVolume() {
	  return width*depth*height;
  }

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