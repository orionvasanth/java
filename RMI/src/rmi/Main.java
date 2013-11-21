/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

/**
 *
 * @author Orion
 */
import java.rmi.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {
            RemoteInterface service = (RemoteInterface) Naming.lookup("rmi://172.17.9.35/RemoteOwner");
            System.out.println(service.getOwner());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
