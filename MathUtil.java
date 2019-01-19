/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA_Luke_O_Kane;

import java.math.BigInteger;

/**
 *
 * @author Luke
 */
public class MathUtil
  {

    public static BigInteger modPow(BigInteger num, BigInteger exponent, BigInteger modulo)
      {
        BigInteger result = null;
        if (isLessThanOne(modulo) == true)
          {
            System.out.println("Modulo " + modulo + " cannot be 0 or less.");
          } else if (isRelativelyPrime(exponent, modulo) == false)
          {
            System.out.println(num + "^" + exponent + " mod " + modulo + " are not relatively prime.");
          } else
          {
            try
              {
                result = num.modPow(exponent, modulo);
              } //Catches exception usually caused by a parameter being null or the number and modulo not relatively prime.
            catch (ArithmeticException e)
              {
                System.out.println("ERROR OCCURRED with .modPow method: number is either null, or " + num + "^-1 modulo " + modulo + " are not relatively prime.");
              } catch (NullPointerException e)
              {
                System.out.println("ERROR OCCURRED with .modPow method: one of the inputs is null.");
              } catch (Exception e)
              {
                System.out.println("ERROR OCCURRED with .modPow method: General Error: " + e);
              }
          }
        return result;
      }

    //BigInteger.modInverse with exception handling.
    public static BigInteger modInverse(BigInteger num, BigInteger modulo)
      {
        BigInteger result = null;
        //Checks to see if modulo is greater than 0, if not, then error.
        if (isLessThanOne(modulo) == true)
          {
            System.out.println("Modulo " + modulo + " cannot be 0 or less.");

          } else if (isRelativelyPrime(num, modulo) == false)
          {
            System.out.println(num + "^-1 mod " + modulo + " are not relatively prime.");
          } else
          {
            try
              {
                result = num.modInverse(modulo);
              } //Catches exception usually caused by a parameter being null or the number and modulo not relatively prime.
            catch (ArithmeticException e)
              {
                System.out.println("ERROR OCCURRED with .modInverse method: number is either null, or " + num + "^-1 modulo " + modulo + " are not relatively prime.");
              } catch (NullPointerException e)
              {
                System.out.println("ERROR OCCURRED with .modInverse method: one of the inputs is null.");
              } catch (Exception e)
              {
                System.out.println("ERROR OCCURRED with .modPow method: General Error: " + e);
              }
          }

        return result;
      }

    //Checks if num1 and num2 are relatively prime (using .gcd() method and compareTo), if gcd != 1, then false.
    public static boolean isRelativelyPrime(BigInteger num1, BigInteger num2)
      {
        return num1.gcd(num2).compareTo(new BigInteger("1")) == 0;
      }

    //
    public static boolean isLessThanOne(BigInteger number)
      {
        return number.compareTo(new BigInteger("0")) < 1;

      }
  }
