package nl.bartnotelaers.service;

import nl.bartnotelaers.hashutil.Hash;
import nl.bartnotelaers.hashutil.SaltMaker;
import nl.bartnotelaers.repository.MapDatabase;

public class RegistrationService {
    private HashService hashService;
    private MapDatabase database;
    private PepperService pepperService;

    public RegistrationService(HashService hashService, MapDatabase database, PepperService pepperService) {
        this.hashService = hashService;
        this.database = database;
        this.pepperService = pepperService;
    }

    public void register(String username, String password) {
        String salt = SaltMaker.generateSalt();
        Hash hash = new Hash(salt, password, pepperService.getPepper());
        if (!database.insertUsernameWithSaltAndHash(username, hash)) {
            // instead of proper exception handling ( not the focus of this project)
            System.err.printf("Username %s is already in use", username);
        } else {
            System.out.printf("%s has been registered", username);
        }
    }
}
