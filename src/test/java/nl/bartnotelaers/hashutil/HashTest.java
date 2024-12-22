package nl.bartnotelaers.hashutil;

import nl.bartnotelaers.service.PepperService;
import org.junit.jupiter.api.Test;

public class HashTest {

    @Test
    public void SaltAndHashConstructorTest() {
        Hash hash = new Hash("c9a30dea", "egLi85'x,cZPg%ur", "fakepepper");
        assert (hash.getSalt().equals("c9a30dea"));
        assert (hash.getHash().equals("30a39a6677fac66bf19255c032fc7169fd67cd30355334c083ac3049ca974eb2"));
    }
}