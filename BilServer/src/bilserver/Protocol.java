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
public enum Protocol {
    
    CONTROLS(0),
    LEFT_MOTOR_SPEED(1),
    RIGHT_MOTOR_SPEED(2),
    COMMANDS(3),
    SENSITIVITY(4),
    REQUEST_FEEDBACK(5);
    
    private int value;
    
    private Protocol(int value) {
        this.value = value;
    }
        
    public int getValue() {
        return this.value;
    }

    
    public enum controls {
        STOP("STP"),
        FORWARD("FWD"),
        REVERSE("REV"),
        LEFT("L"),
        RIGHT("R");
        
        private String value;
        
        //private int value;
        
        private controls(String string) {
            this.value = string;
        }
}
}

    
    
