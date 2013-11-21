/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Orion
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SMSClient toMobile = new SMSClient(1);
        toMobile.sendMessage("9983372290", "Hi Ashu");
    }

}
