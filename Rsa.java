import java.util.*;
import java.math.*;

/* Programme purpose to implement encryyption and decryption of 256 bit number that send to server 
Author:Ajima Master
File Name:Rsa.java
Date:5/3/21
*/

class Rsa
{
	//array of string type accept single argument
	public static void main(String args[]){
		//read 256 plaintext from user
		Scanner sc=new Scanner(System.in);
		//declare variable p and q as prime number
		int p,q,n,e,z,i,d=0;
		
        System.out.println("Enter number to be encryypted and decrypted");
		    int msg=sc.nextInt();
            double c;
            BigInteger msgback;
		
            System.out.println("Enter first prime number p");
		    p=sc.nextInt();
		
        System.out.println("Enter second prime number q");
		    q=sc.nextInt();
        //n is plain text for sending information
		n=p*q;
		z=(p-1)*(q-1);
		    System.out.println("the value of z="+z);
            sc.close();
        
		
        //calculate key e so that e<=1
            for(e=1;e<z;e++)
            {
                if(gcd(e,z)==1)//e for public key exponent
                {
                    break;
                }
                
            }
                System.out.println("The value of e="+e);
                for(i=0;i<9;i++)
                {
                    int x=1+(i*z);//
                    if(x%e==0)//d for private key
                    {
                        d=x/e;
                        break;
                    }
                }
                System.out.println("the value of d="+d);
                c=(Math.pow(msg,e))%n;
                System.out.println("encrypted message is:-");
                System.out.println(c);
                BigInteger N=BigInteger.valueOf(n);//
                BigInteger C=BigDecimal.valueOf(c).toBigInteger();
                msgback=(C.pow(d).mod(N));
                System.out.println("encrypted message is:-");
                System.out.println(msgback);
                
	}
    static int gcd(int e,int z)
    {
        if(e==0)
        return z;
        else
            return gcd(z%e,e);
    }
}