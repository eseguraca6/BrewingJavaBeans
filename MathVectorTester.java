/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

/**
 *
 * @author eseguraca6
 */
public class MathVectorTester {
    public static void main (String [] args)
    {
       MathVector a = new MathVector(3);
       double [] listNumbers = {5,6,7,8,9,10};
       double [] l_2 = {1,2,3,4,11,12};
       MathVector b = new MathVector (listNumbers);
       MathVector c = new MathVector (l_2);
       System.out.println(b.getEl(1));
       System.out.println(c.mag());
       c.neg().printMe();
       b.printMe();
       System.out.println(b.dot(b, c));
       MathVector z = b.plus(b, c);
       MathVector v2 = b.neg();
       MathVector g = b.sp(b, 3);
       double k = b.dot(b, b);
       v2.printMe();
       z.printMe();
       g.printMe();
       System.out.println(k);
       System.out.println(b.mag());
       System.out.println(g.getEl(4));
       double [] h = {3,2,1};
       double [] u = {-1, -3, -2};
       
       MathVector t1 = new MathVector (h);
       MathVector t2 = new MathVector(u);
       
       t1.printMe();
       t2.printMe();
       
       MathVector t3 = t1.plus(t1, t2);
       t3.printMe();
       
      
       
       
       //b.neg();
    }
}
