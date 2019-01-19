/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA_Luke_O_Kane;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Luke
 */
public class Client
  {

    private BigInteger e;
    private BigInteger N;
    private Server server;

    public Client(Server server)
      {
        System.out.println("Establishing client... connecting to server...");
        this.server = server;
        this.e = server.getE();
        this.N = server.getN();
      }

    public void createNewKeys()
      {
        server.newKeys();
        this.e = server.getE();
        this.N = server.getN();
      }

    private BigInteger encrypt(String Mn, BigInteger e, BigInteger n)
      {
        BigInteger Mn2Bytes = new BigInteger(Mn.getBytes());
        BigInteger encrypt = MathUtil.modPow(Mn2Bytes, e, n);
        return encrypt;
      }

    private BigInteger encrypt(String Mn)
      {
        BigInteger encrypt = encrypt(Mn, e, N);

        return encrypt;
      }

    public void sendData()
      {
        Scanner sc = new Scanner(System.in);
        String message = "";
        boolean exit = false;
        while (exit == false)
          {

            System.out.print("CLIENTSIDE: Enter Message (type 'exit' to exit, 'newkeys' for new keys): ");
            message = sc.nextLine();
             if (message.equals(""))
              {
                 System.out.println("Message cannot be empty.");
              }
           else if (message.equals("exit"))
              {
                exit = true;
                System.out.println("Exiting...");
              } else if (message.equals("newkeys"))
              {
                //Old public and private key will expire, new public key will be generated.
                //If the client continues to use old public key then the decryption will come out as gibberish.
                createNewKeys();
                System.out.println("New keys generated.");
              } else
              {
                //Client is made and gets public key from server.
                //Client uses public key it to encrypt message.
                BigInteger Cn = encrypt(message);
                System.out.println("CLIENTSIDE: Encrypted Message sent to server: " + Cn);
                String M = server.decryptMessage(Cn);
                System.out.println("SERVERSIDE: Message Received from Client: " + M);
                System.out.println("------------");
              }
          }
      }

  }
