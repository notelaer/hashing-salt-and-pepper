package nl.bartnotelaers.service;

import nl.bartnotelaers.hashutil.HashHelper;
import nl.bartnotelaers.hashutil.SaltMaker;

public class HashService {

    private PepperService pepperService;

    public HashService(PepperService pepperService) {
        this.pepperService = pepperService;
    }

    public String hash(String password) {
        return HashHelper.hash(SaltMaker.generateSalt(), password, pepperService.getPepper());
    }

}
