## Securely storing usernames & passwords
**Study project for understanding hashing with salt & pepper.**

A user registers with username and password at a RegistrationService.
The HashService hashes the password with a random **salt** and a fixed **pepper**. 
The username and the resulting digest are stored in a database (simulated here by using a Map). 

Uses Java's MessageDigest with SHA-256 and SecureRandom.

Not for use in production, as this does not conform to best practices - check out [the owasp.org recommendations](https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html).