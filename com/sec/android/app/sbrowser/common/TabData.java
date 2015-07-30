package com.sec.android.app.sbrowser.common;

import java.io.Serializable;
import android.graphics.Bitmap.Config;

public class TabData implements Serializable {
  private static final long serialVersionUID = -4581405572611034185L;
  private byte[] bitmapByteArray;
  private Config mConfig;
  private int height;
  private int width;

  public TabData(byte[] arr, int width, int height, Config c) {
    this.bitmapByteArray = arr;
    this.width = width;
    this.height = height;
    this.mConfig = c;
  }

  public Config getBitConfig() {
    return mConfig;
  }

  public byte[] getBitmap() {
    return bitmapByteArray;
  }

  public int getHeight() {
    return height;
  }
  public int getWidth() {
    return width;
  }
}
