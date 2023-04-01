package interfaces;

import javax.swing.*;
import java.awt.*;

public class WindowSetting {
  public static void setWindowOnTargetMonitor (JFrame frame) {
    //определение монитора с активным приложением
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screenDevices = ge.getScreenDevices();
    PointerInfo pointerInfo = MouseInfo.getPointerInfo();
    Point pointerLocation = pointerInfo.getLocation();
    GraphicsDevice targetScreen = null;

    for (GraphicsDevice screenDevice : screenDevices) {
      Rectangle screenBounds = screenDevice.getDefaultConfiguration().getBounds();
      if (screenBounds.contains(pointerLocation)) {
        targetScreen = screenDevice;
        break;
      }
    }
    if (targetScreen == null) {
      targetScreen = ge.getDefaultScreenDevice();
    }

    Rectangle screenBounds = targetScreen.getDefaultConfiguration().getBounds();

    // установка позиции окна на активном мониторе
    frame.setLocation(screenBounds.x + screenBounds.width / 2 - frame.getWidth() / 2,
            screenBounds.y + screenBounds.height / 2 - frame.getHeight() / 2);
  }
}

