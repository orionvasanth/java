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
public interface RemoteInterface extends Remote
{
    public String getOwner() throws RemoteException;
}
