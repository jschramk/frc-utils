// change to your package name
package utils;

/**
 * Class for taking a rolling average over a specified number of values
 */
public class RollingAverage {

  private final double[] values;
  boolean wrapped = false;
  private double sum = 0;
  private int i = 0;

  public RollingAverage(int size) {
    this.values = new double[size];
  }

  public void feed(double value) {
    if (Double.isNaN(value) || !Double.isFinite(value))
      return;
    sum += value - values[i];
    values[i] = value;
    if (i == values.length - 1) {
      wrapped = true;
    }
    i = (i + 1) % values.length;
  }

  public double avg() {
    if (wrapped) {
      return sum / values.length;
    } else {
      return sum / i;
    }
  }


}
