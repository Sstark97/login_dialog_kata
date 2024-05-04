package dev.ascinfo;

import dev.ascinfo.doubles.AuthenticatorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDialogTest {
  @Test
  void loging_dialog_correctly_invokes_authenticator()  {
    AuthenticatorSpy authenticatorSpy = new AuthenticatorSpy(true);
    LoginDialog dialog = new LoginDialog(authenticatorSpy);

    dialog.show();
    boolean success = dialog.submit("user", "pw");

    assertTrue(success);
    assertEquals(1, authenticatorSpy.calls());
    assertEquals("user", authenticatorSpy.registeredUserName());
    assertEquals("pw", authenticatorSpy.registeredPassword());
  }
}