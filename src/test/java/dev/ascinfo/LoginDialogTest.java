package dev.ascinfo;

import dev.ascinfo.doubles.AuthenticatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDialogTest {
  @Test
  public void when_authorizer_allow_login_work_well() throws Exception {
    Authenticator authenticator = new AuthenticatorStub(true);
    LoginDialog dialog = new LoginDialog(authenticator);

    dialog.show();
    boolean success = dialog.submit("username", "password");

    assertTrue(success);
  }

  @Test
  public void when_authorizer_deny_login_work_well() throws Exception {
    Authenticator authenticator = new AuthenticatorStub(false);
    LoginDialog dialog = new LoginDialog(authenticator);

    dialog.show();
    boolean success = dialog.submit("username", "password");

    assertFalse(success);
  }
}