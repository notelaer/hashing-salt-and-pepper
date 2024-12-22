package nl.bartnotelaers.service;

import nl.bartnotelaers.hashutil.SaltMaker;
import nl.bartnotelaers.repository.MapDatabase;

public class RegistrationService {
    private HashService hashService;
    private MapDatabase database;

    public RegistrationService(HashService hashService, MapDatabase database) {
        this.hashService = hashService;
        this.database = database;
    }

    public void register(String username, String password) {
        String salt = SaltMaker.generateSalt();
        String hashedPassword = hashService.hash(password);
        if (!database.insertUsernameSaltAndHash(username, salt, hashedPassword)) {
            // instead of proper exception handling ( not the focus of this project)
            System.err.printf("%n Username \"%s\" is already in use", username);
        } else {
            System.out.printf("%n Username \"%s\" has been registered", username);
        }
    }
}
