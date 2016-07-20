package as.tomatoapp.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumericUtil {
    /**
     * generate random integer from min to max
     * @param min int minimum value (included)
     * @param max int maximum value (included)
     * @return int
     */
    public int randomInt(int min, int max) {
        Random random = new Random();

        int up_excluded = (max - min) + 1;

        return random.nextInt(up_excluded) + min;
    }

    public long randomLong(long min, long max) {
        Random random = new Random();

        long up_excluded = (max - min) - 1L;

        return (long)(random.nextDouble()*up_excluded + min);
    }
}
