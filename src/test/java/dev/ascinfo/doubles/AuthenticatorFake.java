package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorFake implements Authenticator {

  @Override
  public boolean authenticate(String username, String password) {
    return username.equals("username") & password.equals("good password");
  }
}
