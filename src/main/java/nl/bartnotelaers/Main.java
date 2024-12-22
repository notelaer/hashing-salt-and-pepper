package nl.bartnotelaers;

import nl.bartnotelaers.repository.MapDatabase;
import nl.bartnotelaers.service.HashService;
import nl.bartnotelaers.service.PepperService;
import nl.bartnotelaers.service.RegistrationService;

public class Main {
    public static void main(String[] args) {
        MapDatabase mapDatabase = new MapDatabase();
        PepperService pepperService = new PepperService();
        HashService hashService = new HashService(pepperService);
        RegistrationService registrationService = new RegistrationService(hashService, mapDatabase);
        registrationService.register("username", "mypassword");
        registrationService.register("username", "otherpassword");
    }
}