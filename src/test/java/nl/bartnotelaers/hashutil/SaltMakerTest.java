package nl.bartnotelaers.hashutil;

import org.junit.jupiter.api.Test;

public class SaltMakerTest {
    @Test
    public void generateSaltTestCorrectLength() {
        String resultSaltDefaultLength = SaltMaker.generateSalt();
        String resultSaltSpecificLength = SaltMaker.generateSalt(16);

        assert(resultSaltSpecificLength.length() == 32);
        assert(resultSaltDefaultLength.length() == 16);
    }

    @Test
    public void generateSaltTestDuplicate() {
        String salt1 = SaltMaker.generateSalt();
        String salt2 = SaltMaker.generateSalt();

        assert (!salt1.equals(salt2));
    }
}
