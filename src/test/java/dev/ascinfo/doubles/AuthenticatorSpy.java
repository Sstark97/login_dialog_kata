package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorSpy implements Authenticator {

  private final boolean allowLogin;
  private int calls = 0;
  private String registeredUserName;
  private String registeredPassword;

  public AuthenticatorSpy(boolean allowLogin) {
    this.allowLogin = allowLogin;
  }

  @Override
  public boolean authenticate(String username, String password) {
    calls ++;
    registeredUserName = username;
    registeredPassword = password;
    return allowLogin;
  }

  public int calls() {
    return calls;
  }

  public String registeredUserName() {
    return registeredUserName;
  }

  public String registeredPassword() {
    return registeredPassword;
  }
}
