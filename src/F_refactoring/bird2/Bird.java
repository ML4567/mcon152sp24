package F_refactoring.bird2;

abstract class Bird {
  int numberOfCoconuts;
  boolean isNailed;
  double voltage;

  double getBaseSpeed() {
    return 12.34;
  }
  
  double getBaseSpeed(double voltage) {
    return voltage * 7;
  }
  
  double getLoadFactor() {
    return 1.5;
  }
  
  abstract double getSpeed();
}

class EuropeanBird extends Bird {
    @Override
    double getSpeed() {
        return getBaseSpeed();
    }
}

class AfricanBird extends Bird {
    @Override
    double getSpeed() {
        return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
    }
}

class NorwegianBlueBird extends Bird {
    @Override
    double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }
}

// class NewBird extends Bird {} // compiler error, which is good because it forces us to decide the speed
