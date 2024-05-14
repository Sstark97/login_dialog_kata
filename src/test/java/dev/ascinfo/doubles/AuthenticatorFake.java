package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorFake implements Authenticator {

  @Override
  public boolean authenticate(String username, String password) {
    return username.length() == 5 & password.length() == 8;
  }
}
