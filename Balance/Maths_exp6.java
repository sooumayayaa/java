package Balance;
class MathConstants
{
final double PI= 3.14159;

final void displayPI()
{
System.out.println("Value of PI: "+PI);}
}

class Circle extends MathConstants
{
double calculateArea(double radius)
{
double area;
//PI= 3.0;
area= PI* radius* radius;
System.out.println("Area: "+area);
return area;
}



}


class maths
{
	public static void main(String args[])
	{
	Circle cir= new Circle();

	cir.displayPI();
	cir.calculateArea(2.0);
	}
	}