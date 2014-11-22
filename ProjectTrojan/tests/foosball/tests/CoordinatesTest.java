package foosball.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import foosball.math.Coordinates;



@Test
public class CoordinatesTest {
 
  public void checkDistanceBetweenReturnsADoubleValueBasicTest() {
	  Coordinates testCoordinates1 = new Coordinates(0,5);
	  Coordinates testCoordinates2 = new Coordinates(10,10);
	  assertEquals(Math.sqrt((10 - 0) * (10 - 0) + (5 - 10) * (5 - 10)),testCoordinates1.distanceBetween(testCoordinates2));
	  
  }
}
