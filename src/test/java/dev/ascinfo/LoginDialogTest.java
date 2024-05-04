package dev.ascinfo;

import dev.ascinfo.doubles.AuthenticatorDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDialogTest {
  @Test
  void when_closed_login_is_canceled() {
    Authenticator authenticator = new AuthenticatorDummy();
    LoginDialog dialog = new LoginDialog(authenticator);

    dialog.show();
    dialog.close();

    assertFalse(dialog.isOpen());
  }
}