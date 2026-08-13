package com.heapsteep.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Encodes plain text into BCrypt hashes for storage (e.g. in {@code data.sql}).
 * Uses {@link BCryptPasswordEncoder} defaults (BCrypt strength 10), matching typical Spring Security setup.
 */
public final class BCryptPasswordEncoderUtil {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private BCryptPasswordEncoderUtil() {}

    /**
     * @param plainText cleartext password; must not be {@code null}
     * @return a new BCrypt hash (includes random salt; output differs on each call)
     */
    public static String encode(String plainText) {
        if (plainText == null) {
            throw new IllegalArgumentException("plainText must not be null");
        }
        return ENCODER.encode(plainText);
    }

    /**
     * Returns whether {@code plainText} matches the given BCrypt-encoded value.
     * Different {@link #encode(String)} outputs for the same password are all valid; this method
     * accepts any of them, including hashes stored in {@code data.sql}.
     *
     * @param plainText   cleartext password to check; must not be {@code null}
     * @param bcryptHash stored BCrypt string (e.g. from DB or {@code data.sql}); must not be {@code null}
     */
    public static boolean matches(String plainText, String bcryptHash) {
        if (plainText == null) {
            throw new IllegalArgumentException("plainText must not be null");
        }
        if (bcryptHash == null) {
            throw new IllegalArgumentException("bcryptHash must not be null");
        }
        return ENCODER.matches(plainText, bcryptHash);
    }

    /**
     * Prints the BCrypt hash for the given password to stdout (for use from the IDE or command line).
     */
    public static void main(String[] args) {
        /*if (args.length != 1) {
            System.err.println("Usage: java ... BCryptPasswordEncoderUtil <plain-password>");
            System.exit(1);
        }*/
        System.out.println(encode("1234")); //Enter password here to be encrypted.
        //System.out.println(matches("1234", "$2a$10$LNmkKjH3rKjzSEu6cigKsu2OBzCjh9rdDYiz/qDegC17UdFW9Wncu")); //To check if the password is correct.
    }
}
