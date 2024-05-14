package dev.ascinfo;

import dev.ascinfo.doubles.AuthenticatorFake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDialogTest {
  @Test
  void bad_password_attempt_login_fail() {
    AuthenticatorFake authenticatorFake = new AuthenticatorFake();
    LoginDialog dialog = new LoginDialog(authenticatorFake);

    dialog.show();
    boolean success = dialog.submit("user", "pw");

    assertFalse(success);
  }

  @Test
  void goods_password_attempt_login_success() {
    AuthenticatorFake authenticatorFake = new AuthenticatorFake();
    LoginDialog dialog = new LoginDialog(authenticatorFake);

    dialog.show();
    boolean success = dialog.submit("username", "good password");

    assertFalse(success);
  }
}