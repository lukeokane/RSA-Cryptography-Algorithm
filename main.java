/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA_Luke_O_Kane;

/**
 *
 * @author Luke
 */
public class main
  {

    public static void main(String[] args)
      {      
        Server s1 = new Server();
        Client c1 = new Client(s1);
        c1.sendData();       
      }
  }
