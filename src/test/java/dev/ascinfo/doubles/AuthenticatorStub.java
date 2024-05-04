package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorStub implements Authenticator {
  private final boolean allowLogin;

  public AuthenticatorStub(boolean allowLogin) {
    this.allowLogin = allowLogin;
  }

  @Override
  public boolean authenticate(String username, String password) {
    return allowLogin;
  }
}
