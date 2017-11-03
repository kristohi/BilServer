/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;




import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author ib
 */
public class Connect {

  private static final int BAUD_RATE = 9600;
  private static final int TIME_OUT = 4000;
  private static final String PORT_NAME = "COM4";
  private final DataOperator dataoperator;
  
  public Connect(DataOperator dataoperator) {
      this.dataoperator = dataoperator;
    try {
      // (new TwoWaySerialComm()).connect(PORT_NAME);
      connect(PORT_NAME);
    }
    catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  void connect(String portName) throws Exception {
    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
    if (portIdentifier.isCurrentlyOwned()) {
      System.out.println("Error: Port is currently in use");
    }
    else {
      CommPort commPort = portIdentifier.open(this.getClass().getName(), TIME_OUT);

      if (commPort instanceof SerialPort) {
        SerialPort serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(
                BAUD_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        InputStream in = serialPort.getInputStream();
        OutputStream out = serialPort.getOutputStream();

        SerialRead sr = new SerialRead(in,dataoperator);
        Thread reader = new Thread(sr);
        reader.start();

        SerialWrite wr = new SerialWrite(out);
        Thread writer = new Thread(wr);
        writer.start();
      }
      else {
        System.out.println("Error: Only serial ports are handled.");
      }
    }
  }
}
