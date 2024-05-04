package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorDummy implements Authenticator {
  @Override
  public boolean authenticate(String username, String password) {
    return false;
  }
}
