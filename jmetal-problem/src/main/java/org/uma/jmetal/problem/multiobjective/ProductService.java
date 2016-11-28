
package org.uma.jmetal.problem.multiobjective;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.DoubleSolution;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.solutionattribute.impl.NumberOfViolatedConstraints;
import org.uma.jmetal.util.solutionattribute.impl.OverallConstraintViolation;

@SuppressWarnings("serial")
public class ProductService extends AbstractIntegerProblem {
	public OverallConstraintViolation<DoubleSolution> overallConstraintViolationDegree;
	public NumberOfViolatedConstraints<DoubleSolution> numberOfViolatedConstraints;

	double f1min = 15;
	double f1max = 50;
	double f2min = 50;
	double f2max = 150;

	/**
	 * Constructor.
	 */
	public ProductService() {
		setNumberOfVariables(10);
		setNumberOfObjectives(2);
		setNumberOfConstraints(10);
		setName("ProductService");

		List<Integer> lowerLimit = Arrays.asList(100, 100, 2, 50, 1, 3500, 1500, 400, 100, 12);
		List<Integer> upperLimit = Arrays.asList(300, 300, 6, 100, 3, 4000, 2000, 600, 200, 16);

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);

	}

	/** Evaluate() method */
	@Override
	public void evaluate(IntegerSolution solution) {
		double NoVC, NoTM, IDQ, NoVCR, IDQR, DRP, Du, Dr, Dt, Dp;
		double obj1, obj2 = 0;

		NoVC = solution.getVariableValue(0);
		NoTM = solution.getVariableValue(1);
		IDQ = solution.getVariableValue(2);
		NoVCR = solution.getVariableValue(3);
		IDQR = solution.getVariableValue(4);
		DRP = solution.getVariableValue(5);
		Dp = solution.getVariableValue(6);
		Du = solution.getVariableValue(7);
		Dr = solution.getVariableValue(8);
		Dt = solution.getVariableValue(9);

		System.out.println(NoVC + " , " + NoTM + " , " + IDQ + " , " + NoVCR + " , " + IDQR + " , " + DRP + " , " + Du
				+ " , " + Dr + " , " + Dt + " , " + Dp);

		obj1 = (0.02 * (NoVC)) + (0.05 * NoTM) + (2.70 * IDQ) - ((0.01 * NoVCR + 1.75 * IDQR));
		obj2 = (DRP - (Dp + (Du - Dr))) / Dt;

//		if (obj1 <= f1max && obj1 >= f1min && obj2 <= f2max && obj2 >= f2min) {
			solution.setObjective(0, obj1);
			solution.setObjective(1, obj2);
//			System.out.println("object : " + obj1 + " object 2 :" + obj2);
//		}
	}
}
