package ML;

//import weka.core.Instances;
//import weka.core.converters.ArffSaver;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;

//import weka.core.converters.ConverterUtils.DataSource;
////
import java.util.Random;

import javax.swing.JFrame;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
public class LoadSaveData{
	public static void main(String args[]) throws Exception{
		DataSource source = new DataSource("C://Users//Admin//Documents//s7//java//pour projet//myProject/dataEmploi.arff");
		Instances dataset = source.getDataSet();
		System.out.println(dataset.numInstances() + " instances loaded.");
		//System.out.println(dataset.toString());
		//Instances dataset = new Instances(new BufferedReader(new FileReader("/home/likewise-open/ACADEMIC/csstnns/test/house.arff")));		
		System.out.println("***********************The initial dataset");

		System.out.println(dataset.toSummaryString());
		// remove experience attribute
				//String[] opts = new String[] { "-R", "11" };
				//Remove remove = new Remove();
				//remove.setOptions(opts);
				//remove.setInputFormat(dataset);
				//dataset = Filter.useFilter(dataset, remove);
		// remove url attribute
				String[] options = new String[] { "-R", "2" };
				Remove remove1 = new Remove();
				remove1.setOptions(options);
				remove1.setInputFormat(dataset);
				dataset = Filter.useFilter(dataset, remove1);

		System.out.println("***********************The dataset after removing url attribute");

		System.out.println(dataset.toSummaryString());

		//ArffSaver saver = new ArffSaver();
		//saver.setInstances(dataset);
		//saver.setFile(new File("C://Users//Admin//Documents//s7//java//pour projet//myProject/new.arff"));
		//saver.writeBatch();
		/*
		 * Feature selection
		 */
		AttributeSelection attSelect = new AttributeSelection();
		InfoGainAttributeEval eval = new InfoGainAttributeEval();
		Ranker search = new Ranker();
		attSelect.setEvaluator(eval);
		attSelect.setSearch(search);
		attSelect.SelectAttributes(dataset);
		int[] indices = attSelect.selectedAttributes();
		System.out.println("Selected attributes: "+Utils.arrayToString(indices));
// remove 12,13 attribute
		String[] options12 = new String[] { "-R", "12,13" };
		Remove remove12 = new Remove();
		remove12.setOptions(options12);
		remove12.setInputFormat(dataset);
		//dataset = Filter.useFilter(dataset, remove12);
		System.out.println("***********************After features selection");

		System.out.println(dataset.toSummaryString());
		System.out.println(dataset.numAttributes()-1);
		
//set the target attribute 
		//for experience
		//dataset.setClassIndex(dataset.numAttributes()-2);
		//for niveau d'etude
		//dataset.setClassIndex(dataset.numAttributes()-3);
		//for technologies
		//dataset.setClassIndex(dataset.numAttributes());
		/*
		 * Build a decision tree
		 */
		String[] Options = new String[1];
		Options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(Options);
		tree.buildClassifier(dataset);
		//System.out.println(tree);
		/*
		 * Evaluation
		 */

		Classifier cl = new J48();
		Evaluation eval_roc = new Evaluation(dataset);
		eval_roc.crossValidateModel(cl, dataset, 10, new Random(1), new Object[] {});
		System.out.println(eval_roc.toSummaryString("\n **********************J48*****************************",true));
		// Confusion matrix
		double[][] confusionMatrix = eval_roc.confusionMatrix();
		System.out.println(eval_roc.toMatrixString());
//print other performance measures
		System.out.println("Precision ="+eval_roc.precision(1));
		System.out.println("Recall ="+eval_roc.recall(1));
		System.out.println("F1 Measure ="+eval_roc.fMeasure(1));
		System.out.println("TPR ="+eval_roc.truePositiveRate(1));
		System.out.println("TNR ="+eval_roc.trueNegativeRate(1));
		System.out.println("FPR ="+eval_roc.falsePositiveRate(1));
		System.out.println("FNR ="+eval_roc.falseNegativeRate(1));
//print the tree Graph		
		System.out.println("\n\n"+tree.graph());
///////////////////////
		RandomForest forest=new RandomForest();
		forest.setNumIterations(10);
		/** */
		forest.buildClassifier(dataset);
		System.out.println(forest);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with testing data
		 */
		Evaluation evalu = new Evaluation(dataset);
		evalu.evaluateModel(forest, dataset);
		
		
		/** Print the algorithm summary */
		System.out.println("** Decision Tress Evaluation with Datasets **");
		System.out.println(evalu.toSummaryString());
		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(forest);
		//System.out.println(evalu.toMatrixString());
		//System.out.println(evalu.toClassDetailsString());
//*************************************************************
		DataSource sourceTest = new DataSource("C://Users//Admin//Documents//s7//java//pour projet//myProject/test.arff");
		Instances test = sourceTest.getDataSet();
		test = Filter.useFilter(test, remove1);
		test.setClassIndex(test.numAttributes()-1);

		dataset.setClassIndex(dataset.numAttributes()-1);
		//k - the number of nearest neighbors to use for prediction
		Classifier ibk = new IBk(1);		
		ibk.buildClassifier(dataset);
	
		System.out.println(ibk);
       
        Evaluation evalK = new Evaluation(dataset);
        evalK.evaluateModel(ibk, test);
		/** Print the algorithm summary */
		System.out.println("** KNN Demo  **");
		System.out.println(evalK.toSummaryString());
	    System.out.println(evalK.toClassDetailsString());
		//System.out.println(evalK.toMatrixString());

		
	}
}