package nl.bartnotelaers.repository;

import nl.bartnotelaers.hashutil.SaltAndHash;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MapDatabaseTest {
    MapDatabase mapDatabase; // object under test

    public MapDatabaseTest() {
        this.mapDatabase = new MapDatabase();
    }

    @BeforeAll
    public void setupDatabaseContent() {
        // janiceDoe password is  egLi85'x,cZPg%ur
        mapDatabase.insertUsernameSaltAndHash("janiceDoe",
                "c9a30dea", "6f36881dbeaed4079268814cb8d47c5a21ae181c483038f4292ad5baedde954b");
        // johnDoe password is  )7nD,><>]~*!dnH=
        mapDatabase.insertUsernameSaltAndHash("johnDoe",
                "14c56847", "d6f897c81d711758c77ae4c563f17ea11a6ce9d4c28ec5e3df5882d0ef47193f");
        // lcarroll password is  !DO0N}h=j6"pO<>@
        mapDatabase.insertUsernameSaltAndHash("lcarroll",
                "ede235bb", "6f36881dbeaed4079268814cb8d47c5a21ae181c483038f4292ad5baedde954b");
    }

    @Test
    @DisplayName("insert duplicate username fails")
    public void insertUsernameSaltAndHashTestDuplicate() {
        boolean result = mapDatabase.insertUsernameSaltAndHash("lcarroll", "someSalt", "someHash");
        assert (!result);
    }

    @Test
    public void findSaltAndHashByUsername() {
        SaltAndHash saltAndHash = mapDatabase.findSaltAndHashByUsername("lcarroll");
        assert (saltAndHash.getSalt().equals("ede235bb"));
        assert (saltAndHash.getHash().equals("6f36881dbeaed4079268814cb8d47c5a21ae181c483038f4292ad5baedde954b"));
    }
}
