package nl.bartnotelaers.repository;

import nl.bartnotelaers.hashutil.Hash;
import nl.bartnotelaers.service.PepperService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class MapDatabaseTest {
    MapDatabase mapDatabase; // object under test
    PepperService pepperService;
    public MapDatabaseTest() {
        this.mapDatabase = new MapDatabase();
        this.pepperService = mock(PepperService.class);
    }

    @Test
    @DisplayName("insert duplicate username fails")
    public void insertUsernameWithSaltAndHashTestDuplicate() {
        // assumes username lcarroll already exists in data
        Hash hash = new Hash("randomSalt", "randomPassword", pepperService.getPepper());
        boolean result = mapDatabase.insertUsernameWithSaltAndHash("lcarroll", hash);
        System.out.println(result);
        assert (!result);
    }
}
