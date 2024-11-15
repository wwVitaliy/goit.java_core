package module11.homework.task4;

/**
 * Generates random numbers
 */
@FunctionalInterface    //TODO Is this annotation needed?
interface RandomNumberGenerator {
    long next();
}
