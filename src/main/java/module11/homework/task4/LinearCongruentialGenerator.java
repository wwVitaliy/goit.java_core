package module11.homework.task4;

/**
 *  Generates a pseudo-random numbers based on next sequence:
 *  * x[0] = seed
 *  * x[n + 1] = (a * x[n] + c) % m
 *  * where a, c and m are long-type numbers
  */
class LinearCongruentialGenerator
        implements RandomNumberGenerator {
    // sequence parameters
    private final long a;
    private final long c;
    private final long m;
    //  element of the sequence
    private long x;

    public LinearCongruentialGenerator(long a, long c, long m, long seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.x = seed;
    }

    /**
     * Calculates next pseudo-random number
     *
     * @return long - next pseudo-random number
     */
    public long next() {
        this.x = (this.a * this.x + this.c) % this.m;
        return x;
    }
}
