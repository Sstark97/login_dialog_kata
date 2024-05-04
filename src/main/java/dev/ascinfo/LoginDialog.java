package dev.ascinfo;

public class LoginDialog {
  private final Authenticator authenticator;
  private boolean isOpen = false;

  public LoginDialog(Authenticator authenticator) {
    this.authenticator = authenticator;
  }

  public boolean submit(String username, String password) {
    if(isOpen) {
      close();
      return authenticator.authenticate(username, password);
    }

    return false;
  }

  public void show() {
    if(!isOpen) {
      isOpen = true;
    }
  }

  public void close() {
    if(isOpen) {
      isOpen = false;
    }
  }

  public boolean isOpen() {
    return isOpen;
  }
}
