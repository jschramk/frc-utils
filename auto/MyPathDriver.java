// change to your package name
package auto;

/**
 * Class specific to your robot that contains all drive code to follow a path
 * consisting of segments, each with heading and distance.
 */
public class MyPathDriver extends PathDriver {

  // add any fields needed by this class here

  public MyPathDriver(/* add any constructor arguments here */) {

    // set all fields in your constructor here

  }

  /**
   * This method is called when init() is called on
   * an instance of this class.
   */
  @Override protected void driveInit() {

    // place any initialization code here

  }

  /**
   * This method is called periodically during the autonomous routine.
   *
   * @param segment the current segment in the path that is being driven
   * @param i       the index of the current segment (starts at 0)
   * @return true when this segment has been fully driven, false otherwise
   */
  @Override protected boolean drivePeriodic(DriveSegment segment, int i) {

    // get segment parameters
    // double headingDegrees = segment.getHeadingDegrees();
    // double distanceInches = segment.getDistanceInches();

    // add your drive code here

    // return true when this segment is completed
    return false;

  }

  /**
   * This method is called ONCE when all segments are driven. Place any code
   * needed to stop all motors in this method.
   */
  @Override protected void driveStop() {

    // stop your robot here

  }

}
