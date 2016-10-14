/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;
import java.lang.*;
/**
 *
 * @author eseguraca6
 */
public class MathVector 
{
        /* You should know the dimension of a vector merely by inspection. 
         Thus, equivalently you would publicly access the dimension
         This is equivalent of saying there is a vector on R^3, you know
         by definition that the vector has a dimensionality of 3, but
         you not necessarily know the components for each coordinate,
         hence why the vector components would be private. 
        */
        
        private int dimensionVector;
        
        //However, the components should be private. 
        private double [] vectorComponents;
        MathVector(int givenDimension)
        {
            //sets the dimension given to the private 
            //variable to build this vector
           this.dimensionVector = givenDimension;
           this.vectorComponents = new double [this.dimensionVector];
           
           for(int i = 0; i < this.dimensionVector; i++)
           {
               this.vectorComponents[i] = 0;
               //System.out.println(this.vectorComponents[i]);
               //This line was for testing, it worked.
           }
        }
        /* The decision for this constructor the way it is designed is the following:
          On the homework it hints at N-dimensional vectors 
          Thus, for generalizing I have to assume I can get 
          a) more than 3, and b) in the right order correspondence of coordinates
        */ 
        MathVector(double [] components)
        {
            //for this, the dimension is 3.
            this.dimensionVector = components.length;
            this.vectorComponents = new double [this.dimensionVector];
            
            for(int i = 0; i < this.dimensionVector; i++)
            {
                this.vectorComponents[i] = components[i];
                //System.out.println(this.vectorComponents[i]);
            }
        }
        
        double getEl(int iComponent)
        {
            return vectorComponents[iComponent-1];
        }
        
        double mag()
        {
            double totalMagnitude = 0.0;
            for(int i = 0 ; i < vectorComponents.length;i++)
            {
                double tmpValue = vectorComponents[i] * vectorComponents[i];
                totalMagnitude += tmpValue;
            } 
            return Math.sqrt(totalMagnitude);
        }
        
        MathVector neg()
        {
            /*you need a MathVector object to hold the negative values.
            You also need to enter the vector you want to extract values
            from, copy the values to the new vector, and adjust the values
            accordignly 
            */
            
            MathVector negVector = new MathVector(this.dimensionVector);
            
            for(int i = 0; i < this.dimensionVector; i++)
            {
                negVector.vectorComponents[i] = - (vectorComponents[i]);
                //System.out.println(negVector.vectorComponents[i]);
            }
            return negVector;
        }
        
        MathVector plus(MathVector aVector, MathVector bVector)
        {
            MathVector sumVector = new MathVector(aVector.dimensionVector);
            for(int i = 0; i < this.dimensionVector; i++)
            {
                double tmpSumValue = aVector.vectorComponents[i] + bVector.vectorComponents[i];
                sumVector.vectorComponents[i] = tmpSumValue; 
                
            }
            return sumVector;
        }
        
        void printMe()
        {
            // this is make the right format.
            System.out.print("[");
            for(int i = 0; i < this.dimensionVector; i++)
            {
                //this line extract the individual number at location i.
                System.out.print(this.vectorComponents[i]);
                //due to formating in bracket form [1,....,5], you have to extract
                //until the n-1 element, if your list is 1,2,3, you stop at two
                if( i < this.dimensionVector-1)
                {
                    //editing for format
                    System.out.print(", ");   
                }
            }
            //closing the line with the right editing
            System.out.println("]");
        }
        
        MathVector sp (MathVector cVector, int scalarAdjuster)
        {
            //this function takes two vectors as arguments and 
            //returns a new vector corresponding to the scalar product
            
            //this line below creates the vector taking the dimension of the vector's argument.
            MathVector adjustedVector = new MathVector(cVector.dimensionVector);
            
            //you loop through the vector
            for(int i = 0; i < cVector.dimensionVector; i++)
            {
                //you adjust component by component  
                adjustedVector.vectorComponents[i] = scalarAdjuster * cVector.vectorComponents[i];
            }
            //you return the appropiate result
            return adjustedVector;
        }
        
        
        //this is the equivalent of the dot product
        double dot(MathVector fVector, MathVector gVector)
        {
            double dotResult = 0;
            for(int i = 0; i < fVector.dimensionVector; i++)
            {
                double tmpValue = fVector.vectorComponents[i] * gVector.vectorComponents[i];
                dotResult += tmpValue;
            }
            return dotResult;
        }
}

