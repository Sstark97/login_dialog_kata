package dev.ascinfo;

public interface Authenticator {
  boolean authenticate(String username, String password);
}
