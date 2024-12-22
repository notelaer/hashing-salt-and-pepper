package nl.bartnotelaers.repository;

import nl.bartnotelaers.hashutil.Hash;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
    simulates a database
 */
public class MapDatabase {
    // very simple simulation of database storing username and salt+password
    private Map<String, Hash> database;

    public MapDatabase() {
        database = new ConcurrentHashMap<>();
        // used SHA256
        // janiceDoe password is  egLi85'x,cZPg%ur
        Hash janiceDoeHash = new Hash();
        janiceDoeHash.setSalt("c9a30dea");
        janiceDoeHash.setHash("6591ecac02cfbfd607a8844aef0caeba913a31e074f28877f21ead5e78e0caa1");
        // johnDoe password is  )7nD,><>]~*!dnH=
        Hash johnDoeSaltandHash = new Hash();
        johnDoeSaltandHash.setSalt("14c56847");
        johnDoeSaltandHash.setHash("d6f897c81d711758c77ae4c563f17ea11a6ce9d4c28ec5e3df5882d0ef47193f");
        // lcarroll password is  !DO0N}h=j6"pO<>@
        Hash lcarrollSaltandHash = new Hash();
        lcarrollSaltandHash.setSalt("ede235bb");
        lcarrollSaltandHash.setHash("6f36881dbeaed4079268814cb8d47c5a21ae181c483038f4292ad5baedde954b");
        database.put("janiceDoe", janiceDoeHash);
        database.put("johnDoe", johnDoeSaltandHash);
        database.put("lcarroll", lcarrollSaltandHash);
    }

    public Hash findSaltAndHashByUsername(String username) {
        return database.get(username);
    }

    public boolean insertUsernameWithSaltAndHash(String username, Hash hash) {
        // check if the username exists
        if (!database.containsKey(username)) {
            database.put(username, hash);
            return true;
        }
        // instead of proper exception handling ( not the focus of this project)
        return false;
    }
}