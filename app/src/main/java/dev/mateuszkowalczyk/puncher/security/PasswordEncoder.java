package dev.mateuszkowalczyk.puncher.security;

public interface PasswordEncoder {
    String encode(String plainPassword);

    boolean matches(String plainPassword, String encodedPassword);
}
