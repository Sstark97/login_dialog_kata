package dev.ascinfo;

import dev.ascinfo.doubles.AuthenticatorStrictMock;
import org.junit.jupiter.api.Test;

class LoginDialogTest {
  @Test
  void loging_dialog_correctly_invokes_authenticator() {
    AuthenticatorStrictMock authenticatorMock = new AuthenticatorStrictMock("user", "password", true);
    LoginDialog dialog = new LoginDialog(authenticatorMock);

    dialog.show();
    dialog.submit("user", "password");

    authenticatorMock.verify();
  }
}