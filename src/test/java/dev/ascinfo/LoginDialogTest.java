package dev.ascinfo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginDialogTest {
  @Test
  void correctly_invokes_authenticator() {
    Authenticator authenticatorMock = Mockito.mock(Authenticator.class);
    LoginDialog dialog = new LoginDialog(authenticatorMock);

    when(authenticatorMock.authenticate("user", "pw")).thenReturn(true);
    dialog.show();
    boolean success = dialog.submit("user", "pw");

    assertTrue(success);
    verify(authenticatorMock, times(1)).authenticate("user", "pw");
  }

  @Test
  void fail_invokes_authenticator_with_bad_credentials() {
    Authenticator authenticatorMock = Mockito.mock(Authenticator.class);
    LoginDialog dialog = new LoginDialog(authenticatorMock);

    when(authenticatorMock.authenticate("user", "pw")).thenReturn(false);
    dialog.show();
    boolean success = dialog.submit("user", "pw");

    assertFalse(success);
    verify(authenticatorMock, times(1)).authenticate("user", "pw");
  }

  @Test
  void not_call_authenticator_when_is_closed() {
    Authenticator authenticatorMock = Mockito.mock(Authenticator.class);
    LoginDialog dialog = new LoginDialog(authenticatorMock);

    dialog.show();
    dialog.close();

    assertFalse(dialog.isOpen());
    verify(authenticatorMock, times(0)).authenticate(anyString(), anyString());
  }
}