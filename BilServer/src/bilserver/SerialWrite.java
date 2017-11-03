/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

import java.io.IOException;
import java.io.OutputStream;
import gnu.io.SerialPort;

/**
 *
 * @author IB,
 */
public class SerialWrite implements Runnable {

    OutputStream out;
    String msg = "S";

    public SerialWrite(OutputStream out) {
        this.out = out;
    }

    public void run() {
        int msgCounter = 0;
      while (true) {
        String outMsg = msg + " " + msgCounter;
        char[] buffer = outMsg.toCharArray();
        // send text message
        for (int i = 0; i < buffer.length; i++) {
          try {
            this.out.write(buffer[i]);
          }
          catch (IOException e) {
            e.printStackTrace();
          }
        }
        msgCounter++;
        try {
          Thread.sleep(5000);
        }
        catch (InterruptedException e) {
        }
      }
    }
  }
