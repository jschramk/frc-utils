// change to your package name
package auto;

/**
 * Abstract superclass for path driving. This class contains all
 * logic to progress through each segment in the drive path.
 */
public abstract class PathDriver {

  private int segmentIndex = 0;
  private LinearSegment[] linearSegments;
  private boolean stopped = false;
  private boolean turning = true;

  // implement this method in your extension of this class
  protected abstract void driveInit();

  // implement this method in your extension of this class
  protected abstract boolean turnPeriodic(double headingDegrees, int i);

  // implement this method in your extension of this class
  protected abstract boolean drivePeriodic(double distanceInches, int i);

  // implement this method in your extension of this class
  protected abstract void driveStop();

  int getPathSegmentCount() {
    return linearSegments == null ? 0 : linearSegments.length;
  }

  public void loadSegments(LinearSegment... linearSegments) {
    this.linearSegments = linearSegments;
  }

  public void init() {
    segmentIndex = 0;
    driveInit();
    if (linearSegments == null || linearSegments.length == 0) {
      System.out.println("No path driver segments loaded!");
    }
  }

  public void periodic() {
    if (linearSegments == null || segmentIndex > linearSegments.length) {
      if (!stopped) {
        driveStop();
        stopped = true;
      }
    } else if(turning) {
      double heading = linearSegments[segmentIndex].getHeadingDegrees();
      if (turnPeriodic(heading, segmentIndex)) {
        turning = false;
      }
    } else {
      double distance = linearSegments[segmentIndex].getDistanceInches();
      if (drivePeriodic(distance, segmentIndex)) {
        segmentIndex++;
      }
    }
  }

}
