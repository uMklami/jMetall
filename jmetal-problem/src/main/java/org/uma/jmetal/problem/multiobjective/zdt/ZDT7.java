//  ZDT1.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
//
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.uma.jmetal.problem.multiobjective.zdt;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

/** Class representing problem ZDT1 */
@SuppressWarnings("serial")
public class ZDT7 extends AbstractDoubleProblem {

  /** Constructor. Creates default instance of problem ZDT1 (30 decision variables) */
  public ZDT7() {
    this(10);
  }

  /**
   * Creates a new instance of problem ZDT1.
   *
   * @param numberOfVariables Number of variables.
   */
  public ZDT7(Integer numberOfVariables) {
    setNumberOfVariables(numberOfVariables);
    setNumberOfObjectives(2);
    setName("ZDT7");

    List<Double> lowerLimit = Arrays.asList(100.0, 100.0, 2.0, 50.0, 1.0, 3500.0, 1500.0, 400.0, 100.0, 12.0 ) ;
    List<Double> upperLimit = Arrays.asList(300.0, 300.0, 6.0, 100.0, 3.0, 4000.0, 2000.0, 600.0, 200.0, 16.0 ) ;

//    for (int i = 0; i < getNumberOfVariables(); i++) {
//      lowerLimit.add(0.0);
//      upperLimit.add(1.0);
//    }

    setLowerLimit(lowerLimit);
    setUpperLimit(upperLimit);
  }

  /** Evaluate() method */
  public void evaluate(DoubleSolution solution) {
	  
	  double NoVC,NoTM,IDQ,NoVCR,IDQR,DRP,Du,Dr,Dt,Dp;
	  double obj1, obj2 = 0;

	  NoVC = solution.getVariableValue(0);
	  NoTM = solution.getVariableValue(1);
	  IDQ = solution.getVariableValue(2);
	  NoVCR =  solution.getVariableValue(3);
	  IDQR=  solution.getVariableValue(4);
	  DRP = solution.getVariableValue(5);
	  Dp = solution.getVariableValue(6);
	  Du = solution.getVariableValue(7);
	  Dr = solution.getVariableValue(8);
	  Dt = solution.getVariableValue(9);


	   obj1 = (0.02*(NoVC))+(0.05*NoTM)+(2.70*IDQ) - ((0.01*NoVCR + 1.75*IDQR));
	   obj2 = (DRP - (Dp+(Du-Dr)))/Dt;
	  
	    

    solution.setObjective(0, obj1);
    solution.setObjective(1, obj2);
  }

  /**
   * Returns the value of the ZDT1 function G.
   *
   * @param solution Solution
   */
  /*
  private double evalG(DoubleSolution solution) {
    double g = 0.0;
    for (int i = 1; i < solution.getNumberOfVariables(); i++) {
      g += solution.getVariableValue(i);
    }
    double constant = 9.0 / (solution.getNumberOfVariables() - 1);
    g = constant * g;
    g = g + 1.0;
    return g;
  }

  /**
   * Returns the value of the ZDT1 function H.
   *
   * @param f First argument of the function H.
   * @param g Second argument of the function H.
   */
  /*
  public double evalH(double f, double g) {
    double h ;
    h = 1.0 - Math.sqrt(f / g);
    return h;
  }
  */
}
