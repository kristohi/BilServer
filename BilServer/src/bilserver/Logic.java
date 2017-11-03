/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilserver;

/**
 *
 * @author JKK
 */
public class Logic {

    protected enum STATES {
        STOP(0),
        GOFWD(1),
        GOREV(-1),
        GOLEFT(10),
        GORIGHT(20),
        GOFWDANDLEFT(11),
        GOFWDANDRIGHT(21),
        GOREVANDLEFT(9),
        GOREVANDRIGHT(19),
        DEFAULT(-99);

        private int value;

        private STATES(int value) {
            this.value = value;
        }

    }

    private final DataOperator dataoperator;
    private STATES state;

    public Logic(DataOperator dataoperator) {
        this.dataoperator = dataoperator;
    }

    /**
     * Run this command to get manual mode.
     */
    protected void manualModeFromGui() {
        this.handleButtonPressedState();

    }

    /**
     * Selects the corresponding state from the GUI.
     */
    protected void handleButtonPressedState();

    {
        int buttonState = 0;
        if (0 != dataoperator.FUNCTION)
          
    

) 
    }
}
