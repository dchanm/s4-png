import com.sec.android.app.sbrowser.common.TabData;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Main {
  public static void main(String[] args) throws IOException {
    if (args.length < 1) {
      System.err.println("Please pass in name of file to convert");
      System.exit(1);
    }

    ObjectInputStream ois = null;

    try {
      String file = args[0].trim();
      ois = new ObjectInputStream(new FileInputStream(file));
      TabData t = (TabData) ois.readObject();

      int height = t.getHeight();
      int width = t.getWidth();
      byte[] arr = t.getBitmap();

      BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_565_RGB);

      DataBuffer db = b.getRaster().getDataBuffer();

      for (int i = 0; i < arr.length; i += 2) {
        int rgb16 = ((arr[i + 1] & 0xFF) << 8) | (arr[i] & 0xFF);
        db.setElem(i / 2, rgb16);
      }

      ImageIO.write(b, "png", new File(file.split("\\.")[0] + "-out.png"));
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      if (ois != null) ois.close();
    }
  }
}
