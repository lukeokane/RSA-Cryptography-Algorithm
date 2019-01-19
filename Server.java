/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA_Luke_O_Kane;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Luke
 */
public final class Server
  {

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phiNum;
    private BigInteger e;
    private BigInteger d;
    private int BIT_LENGTH = 2046;
    //Allows 256 characters to be inputted e.g BIT_LENGTH = 2048 / 8 = 256

    public Server()
      {
        System.out.println("Establishing server...");
        createKeys();
      }

    private void createKeys()
      {
        try
          {
            Random rand = new SecureRandom();

            this.p = BigInteger.probablePrime(BIT_LENGTH / 2, rand);

            this.q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);

            while (p.equals(q))
              {
                q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
              }

            this.N = p.multiply(q);

            this.phiNum = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));

            //Destroy p and q.
            p = BigInteger.ZERO;
            q = BigInteger.ZERO;

            this.e = BigInteger.probablePrime(phiNum.bitLength() / 2, rand);

            this.d = MathUtil.modInverse(e, phiNum);
          } catch (ArithmeticException e)
          {
            System.out.println("ERROR: ArithmeticException called in Server Class");
          } catch (Exception e)
          {
            System.out.println("General exception caught: " + e);
          }
      }
    
    public void newKeys(){
        createKeys();
    }

    private String decrypt(BigInteger Cn)
      {
        BigInteger decrypted = MathUtil.modPow(Cn, d, N);
        String decryptedText = new String(decrypted.toByteArray());
        return decryptedText;
      }

    public String decryptMessage(BigInteger Cn)
      {
        return decrypt(Cn);
      }

    public BigInteger getN()
      {
        return N;
      }

    public BigInteger getE()
      {
        return e;
      }

  }
