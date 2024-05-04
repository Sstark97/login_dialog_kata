package dev.ascinfo.doubles;

import dev.ascinfo.Authenticator;

public class AuthenticatorStrictMock implements Authenticator {

  private boolean authenticateCalled = false;
  private final String expectedUsername;
  private final String expectedPassword;
  private final boolean authenticationResult;

  public AuthenticatorStrictMock(String expectedUsername, String expectedPassword,
      boolean authenticationResult) {
    this.expectedUsername = expectedUsername;
    this.expectedPassword = expectedPassword;
    this.authenticationResult = authenticationResult;
  }

  @Override
  public boolean authenticate(String username, String password) {
    if (!expectedUsername.equals(username) || !expectedPassword.equals(password)) {
      throw new AssertionError("Authenticator was called with unexpected arguments");
    }
    if (authenticateCalled) {
      throw new AssertionError("Authenticator authenticate method called more than once");
    }
    authenticateCalled = true;
    return authenticationResult;
  }

  public void verify() {
    if (!authenticateCalled) {
      throw new AssertionError("Expected authenticate method was not called");
    }
  }
}
