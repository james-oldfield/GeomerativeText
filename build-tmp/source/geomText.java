import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import geomerative.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class geomText extends PApplet {

// This sketch is an experiment using the Geomerative library to manipulate text. 

// Create bubbles around the string myText.

// Sketch built with help from Geomerative tutorial: http://freeartbureau.org/
// USING GEOMERATIVE LIBRARY. Thanks due.

//////////////////////////////////////////////////////
/////// --------- james-oldfield.co ---------- ///////
//////////////////////////////////////////////////////

 // require geomerative library

int fontSize = 400;
String myText = "James";

public void setup() {
  size(displayWidth, displayHeight);
  smooth();
  frameRate(5);

  RG.init(this); // initalise the library 
}
  
  public void draw() {
  background(0);
  RFont font = new RFont("Vollkorn.ttf", fontSize, RFont.CENTER);
  translate(width/2, height/2);
  fill(0);
  font.draw(myText);

// Here, I am setting a distance of 10px between every ellipse drawn.
RCommand.setSegmentLength(10);
 
RGroup textGroup = font.toGroup(myText); 
textGroup = textGroup.toPolygonGroup();
 
// Initialises a new variable, textPoints, as an array and stores the points of the text inside.
RPoint[] textPoints = textGroup.getPoints();
 
	// If i is smaller than the number of points in the image (length of array), increment by 1, and draw an ellipse at each point.
	// For-Loop contains concepts discovered at http://freeartbureau.org/ 
for (int i=0; i<textPoints.length; i++) {
	noStroke();
	fill(255, 255, 255, 70);
	ellipse(textPoints[i].x, textPoints[i].y, mouseX/random(20,50), mouseY/random(20,50));
}

}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "geomText" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
