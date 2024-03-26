package hw3;

import java.util.Objects;

public class TimeSpan implements Comparable<TimeSpan> {
    private final int totalMinutes;

    public static final TimeSpan ZERO = new TimeSpan(0), ONE_MINUTE = new TimeSpan(1), ONE_HOUR = new TimeSpan(60);

    private TimeSpan(int totalMinutes) {
        if (totalMinutes < 0) {
            throw new IllegalArgumentException("negative totalMinutes");
        }

        this.totalMinutes = totalMinutes;
    }

    public static TimeSpan ofHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        }

        return ofMinutes(hours * 60);
    }

    public static TimeSpan ofMinutes(int totalMinutes) {


        // simple: return new TimeSpan(totalMinutes);

        // fancy: do not create a new object when we want zero, one minute, or one hour:
        /*
        switch (totalMinutes) {
            case 0: return ZERO;
            case 1: return ONE_MINUTE;
            case 60: return ONE_HOUR;
            default: return new TimeSpan(totalMinutes);
        }
        */

        // even fancier: using a switch expression:
        return switch (totalMinutes) {
            case 0 -> ZERO;
            case 1 -> ONE_MINUTE;
            case 60 -> ONE_HOUR;
            default -> new TimeSpan(totalMinutes);
        };
    }

    public static TimeSpan ofHoursAndMinutes(int hours, int minutes) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        } else if (minutes < 0) {
            throw new IllegalArgumentException("negative minutes");
        }

        return ofMinutes(hours * 60 + minutes);
    }

    public int getHours() {
        return totalMinutes / 60;
    }

    public int getMinutes() {
        return totalMinutes % 60;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public TimeSpan plusHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("negative hours");
        }

        return ofMinutes(this.totalMinutes + hours * 60);
    }

    public TimeSpan plusMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("negative minutes");
        }

        return ofMinutes(this.totalMinutes + minutes);
    }

    public TimeSpan plus(TimeSpan other) {
        return ofMinutes(this.totalMinutes + other.totalMinutes);
    }

    @Override
    public String toString() {
        return getHours() + "h" + getMinutes() + "m";
    }

    @Override
    public boolean equals(Object o) {
        // simple:
        // return o instanceof TimeSpan && this.totalMinutes == ((TimeSpan) o).totalMinutes;

        // fancy: using a pattern variable:
        return o instanceof TimeSpan other && this.totalMinutes == other.totalMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMinutes);
    }

    @Override
    public int compareTo(TimeSpan other) {
        return Integer.compare(this.totalMinutes, other.totalMinutes);
    }
}
