/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

import java.io.IOException;
import java.io.InputStream;
import gnu.io.SerialPort;

/**
 *
 * @author ib
 */
  public class SerialRead implements Runnable {

    InputStream in;
    private final DataOperator dataoperator;

    public SerialRead(InputStream in, DataOperator dataoperator) {
      this.in = in;
      this.dataoperator = dataoperator;
    }

    public void run() {  // original
      String[] dataToArduino = new String[10];
      byte[] buffer = new byte[1024];
      int len = -1;
      String msg;
      String msgComplete = "";  // appending msg from buffer
      try {
        while ((len = this.in.read(buffer)) > -1) {
          msg = new String(buffer, 0, len);
          msgComplete += msg;
          if ((!msgComplete.isEmpty())) {
            //System.out.print(msg);
            if (msgComplete.endsWith("\n")) {
              System.out.println("Complete text string from Arduino:");
              System.out.print(msgComplete);
              //dataToArduino[0] = msgComplete;
              dataoperator.handleStringsFromArduino(msgComplete, 0);

               // split into substrings, each containing one integer number
              /*String[] subString = msgComplete.split("/");
              int[] intValues = new int[subString.length - 1]; // to avoid \r\n
              Integer[] integerValues = new Integer[subString.length - 1]; // wrapper
              System.out.println("Decoded integer values from Arduino:");
              for (int i = 0; i < (subString.length - 1); i++) {
                try {
                  intValues[i] = Integer.parseInt(subString[i]); // get the integer number
                }
                catch (NumberFormatException e) {
                  System.out.println("Parse integer exception);");
                }
                System.out.println(subString[i]);
              }*/
              System.out.println();
              msgComplete = "";  // reset, ready for next message
            }
          }
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
    
   