//concrete class implementing DrawAPi
public class RedCircle implements DrawAPI {
  @Override
  public void drawCircle(int radius,int x , int y){
    System.out.println("circle with radius: "+radius+" x: "+x+" y: "+y);
 }	
}