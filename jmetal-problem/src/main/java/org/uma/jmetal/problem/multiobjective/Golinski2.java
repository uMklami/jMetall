//  Golinski.java
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

package org.uma.jmetal.problem.multiobjective;

import org.uma.jmetal.problem.ConstrainedProblem;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.solutionattribute.impl.NumberOfViolatedConstraints;
import org.uma.jmetal.util.solutionattribute.impl.OverallConstraintViolation;

import java.util.Arrays;
import java.util.List;


/**
 * Class representing problem Golinski.
 */
@SuppressWarnings("serial")
public class Golinski2 extends AbstractDoubleProblem implements ConstrainedProblem<DoubleSolution> {
  public OverallConstraintViolation<DoubleSolution> overallConstraintViolationDegree ;
  public NumberOfViolatedConstraints<DoubleSolution> numberOfViolatedConstraints ;

  /**
   * Constructor.
   * Creates a default instance of the Golinski problem.
   */
  public Golinski2() {
    setNumberOfVariables(10);
    setNumberOfObjectives(2);
    setNumberOfConstraints(2);
    setName("Golinski2") ;

    List<Double> lowerLimit = Arrays.asList(100.0, 100.0, 2.0, 50.0, 1.0, 3500.0, 1500.0, 400.0, 100.0, 12.0 ) ;
    List<Double> upperLimit = Arrays.asList(300.0, 300.0, 6.0, 100.0, 3.0, 4000.0, 2000.0, 600.0, 200.0, 16.0 ) ;

    setLowerLimit(lowerLimit);
    setUpperLimit(upperLimit);

    overallConstraintViolationDegree = new OverallConstraintViolation<DoubleSolution>() ;
    numberOfViolatedConstraints = new NumberOfViolatedConstraints<DoubleSolution>() ;
  }

  /** Evaluate() method */
  @Override
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

	  System.out.println(NoVC+" , "+NoTM+" , "+IDQ+" , "+NoVCR+" , "+IDQR+" , "+DRP+" , "+Du+" , "+Dr+" , "+Dt+" , "+Dp);
	   obj1 = (0.02*(NoVC))+(0.05*NoTM)+(2.70*IDQ) - ((0.01*NoVCR + 1.75*IDQR));
	   obj2 = (DRP - (Dp+(Du-Dr)))/Dt;
	   
	   solution.setObjective(0, obj1);
	   solution.setObjective(1, obj2);
  }

  /** EvaluateConstraints() method */
  @Override
  public void evaluateConstraints(DoubleSolution solution)  {
    double[] constraint = new double[this.getNumberOfConstraints()];


    constraint[0] = 50;
    constraint[1] = 20;


    double overallConstraintViolation = 0.0;
    int violatedConstraints = 0;
    for (int i = 0; i < getNumberOfConstraints(); i++) {
      if (constraint[i]<0.0){
        overallConstraintViolation+=constraint[i];
        violatedConstraints++;
      }
    }

    overallConstraintViolationDegree.setAttribute(solution, overallConstraintViolation);
    numberOfViolatedConstraints.setAttribute(solution, violatedConstraints);
  }
}

