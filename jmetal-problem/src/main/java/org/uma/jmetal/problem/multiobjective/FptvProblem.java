
package org.uma.jmetal.problem.multiobjective;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.util.solutionattribute.impl.NumberOfViolatedConstraints;
import org.uma.jmetal.util.solutionattribute.impl.OverallConstraintViolation;


@SuppressWarnings("serial")
public class FptvProblem extends AbstractDoubleProblem /*implements ConstrainedProblem<DoubleSolution> */{
public OverallConstraintViolation<DoubleSolution> overallConstraintViolationDegree ;
public NumberOfViolatedConstraints<DoubleSolution> numberOfViolatedConstraints ;

/**
* Constructor.
*/
public FptvProblem() {
setNumberOfVariables(8);
setNumberOfObjectives(2);
setNumberOfConstraints(1);
setName("FptvProblem") ;

List<Double> lowerLimit = Arrays.asList(100.0, 100.0, 2.0, 3000.0, 1500.0, 20.0, 18.0, 512.0) ;
List<Double> upperLimit = Arrays.asList(300.0, 300.0, 6.0, 4500.0, 2500.0, 50.0, 24.0, 512.0) ;

setLowerLimit(lowerLimit);
setUpperLimit(upperLimit);

overallConstraintViolationDegree = new OverallConstraintViolation<DoubleSolution>() ;
numberOfViolatedConstraints = new NumberOfViolatedConstraints<DoubleSolution>() ;
}

/** Evaluate() method */
@Override
public void evaluate(DoubleSolution solution) {
double NoVC,NoTM,IDQ,DRP,Du,Dr,Dt,Dp;
NoVC = solution.getVariableValue(0);
NoTM = solution.getVariableValue(1);
IDQ = solution.getVariableValue(2);
DRP = solution.getVariableValue(3);
Dp = solution.getVariableValue(4);
Dr = solution.getVariableValue(5);
Dt = solution.getVariableValue(6);
Du = solution.getVariableValue(7);

double f1 = (0.01*(NoVC))+(0.05*NoTM)+(2.75*IDQ);

//double aux = 745.0 * x4 / (x2 * x3);
double f2 = (DRP - (Dp+Du+Dr))/Dt;

solution.setObjective(0,f1);
solution.setObjective(1,f2);
}

/** EvaluateConstraints() method */
/*
@Override
public void evaluateConstraints(DoubleSolution solution)  {
double[] constraint = new double[this.getNumberOfConstraints()];
double x1,x2,x3,x4,x5,x6,x7;

x1 = solution.getVariableValue(0);


constraint[0] = ;


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
}*/
}

