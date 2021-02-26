// change to your package name
package auto;

/**
 * Abstract superclass for path driving. This class contains all
 * logic to progress through each segment in the drive path.
 */
public abstract class PathDriver {

  private int segmentIndex = 0;
  private DriveSegment[] driveSegments;
  private boolean stopped = false;

  // implement this method in your extension of this class
  protected abstract void driveInit();

  // implement this method in your extension of this class
  protected abstract boolean drivePeriodic(DriveSegment driveSegment, int i);

  // implement this method in your extension of this class
  protected abstract void driveStop();

  int getPathSegmentCount() {
    return driveSegments == null ? 0 : driveSegments.length;
  }


  public void loadSegments(DriveSegment... driveSegments) {
    this.driveSegments = driveSegments;
  }

  public void init() {
    segmentIndex = 0;
    driveInit();
    if (driveSegments == null || driveSegments.length == 0) {
      System.out.println("No path driver segments loaded!");
    }
  }

  public void periodic() {
    if (driveSegments == null || segmentIndex > driveSegments.length) {
      if (!stopped) {
        driveStop();
        stopped = true;
      }
    } else if (drivePeriodic(driveSegments[segmentIndex], segmentIndex)) {
      segmentIndex++;
    }
  }

}
