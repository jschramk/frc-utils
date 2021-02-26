// change to your package name
package auto;

/**
 * Class containing a heading and distance to drive
 * autonomously. Combine these sequentially to create a path.
 */
public class DriveSegment {

  private double heading, distance;

  public DriveSegment(double heading, double distance) {
    this.heading = heading;
    this.distance = distance;
  }

  public double getHeadingDegrees() {
    return heading;
  }

  public double getDistanceInches() {
    return distance;
  }

}
