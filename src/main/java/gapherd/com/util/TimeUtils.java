package gapherd.com.util;

public class TimeUtils {

    public static long toNanoSeconds(double seconds) {

        return (long) seconds * 1000000000;

    }

    public static double toSeconds(long nanoSeconds) {

        return (double) nanoSeconds / 1000000000;

    }

}
