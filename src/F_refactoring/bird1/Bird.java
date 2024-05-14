package F_refactoring.bird1;

class Bird {
  private Type type;
  private int numberOfCoconuts;
  boolean isNailed;
  double voltage;

  public enum Type {
    EUROPEAN, AFRICAN, NORWEGIAN_BLUE;
  }

  double getBaseSpeed() {
    return 12.34;
  }

  double getBaseSpeed(double voltage) {
    return voltage * 7;
  }

  double getLoadFactor() {
    return 1.5;
  }

    double getSpeed() {
        switch (type) {
            case EUROPEAN:
                return getBaseSpeed();
            case AFRICAN:
                return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
            case NORWEGIAN_BLUE:
                return (isNailed) ? 0 : getBaseSpeed(voltage);
            default:
                return 0;
        }
    }
}