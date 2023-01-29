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
public class KNNClassification{
	public static void KNN_ne() throws Exception{
		DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
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
				//dataset = Filter.useFilter(dataset, remove1);

		System.out.println("***********************The dataset after removing url attribute");

		System.out.println(dataset.toSummaryString());

		
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
				//dataset.setClassIndex(dataset.numAttributes()-5);
				//for niveau d'etude
				dataset.setClassIndex(dataset.numAttributes()-6);
				//for technologies
				//dataset.setClassIndex(dataset.numAttributes());
				/*
				 * Build a KNN classifier
				 */
		DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff");
		Instances test = sourceTest.getDataSet();
		test = Filter.useFilter(test, remove1);
		
		//for competences
		//test.setClassIndex(test.numAttributes()-1);
		
				//for experience 
		//test.setClassIndex(test.numAttributes()-5);
		//************************************************The one
				//for niveau etude
		test.setClassIndex(test.numAttributes()-6);

		       //for competences
				//dataset.setClassIndex(dataset.numAttributes()-1);
				//k - the number of nearest neighbors to use for prediction
		Classifier ibk = new IBk(1);		
		ibk.buildClassifier(dataset);
	
		System.out.println(ibk);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with  the test set 
		 */
        Evaluation evalK = new Evaluation(dataset);
        evalK.evaluateModel(ibk, test);
		/** Print the algorithm summary */
		System.out.println("** KNN Demo  **");
		System.out.println(evalK.toSummaryString());
	    System.out.println(evalK.toClassDetailsString());
		//System.out.println(evalK.toMatrixString());

		
	}
	public static String KNN_exp() throws Exception{
		DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
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
				//dataset = Filter.useFilter(dataset, remove1);

		System.out.println("***********************The dataset after removing url attribute");

		System.out.println(dataset.toSummaryString());

		
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
				dataset.setClassIndex(dataset.numAttributes()-5);
				//for niveau d'etude
				//dataset.setClassIndex(dataset.numAttributes()-6);
				//for technologies
				//dataset.setClassIndex(dataset.numAttributes());
				/*
				 * Build a KNN classifier
				 */
		DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//train.arff");
		Instances test = sourceTest.getDataSet();
		test = Filter.useFilter(test, remove1);
		
		//for competences
		//test.setClassIndex(test.numAttributes()-1);
				
				//for experience 
		test.setClassIndex(test.numAttributes()-5);
		//************************************************The one
				//for niveau etude
		//test.setClassIndex(test.numAttributes()-6);

		       //for competences
				//dataset.setClassIndex(dataset.numAttributes()-1);
				//k - the number of nearest neighbors to use for prediction


		//dataset.setClassIndex(dataset.numAttributes()-1);
		//k - the number of nearest neighbors to use for prediction
		Classifier ibk = new IBk(1);		
		ibk.buildClassifier(dataset);
	
		System.out.println(ibk);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with  the test set 
		 */
        Evaluation evalK = new Evaluation(dataset);
        evalK.evaluateModel(ibk, test);
		/** Print the algorithm summary */
		System.out.println("** KNN Demo  **");
		System.out.println(evalK.toSummaryString());
	    System.out.println(evalK.toClassDetailsString());
		//System.out.println(evalK.toMatrixString());
		return null;

		
	}
	public static void KNN_tech() throws Exception{
		DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
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
				//dataset = Filter.useFilter(dataset, remove1);

		System.out.println("***********************The dataset after removing url attribute");

		System.out.println(dataset.toSummaryString());

		
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
				//dataset.setClassIndex(dataset.numAttributes()-5);
				//for niveau d'etude
				//dataset.setClassIndex(dataset.numAttributes()-6);
				//for technologies
				dataset.setClassIndex(dataset.numAttributes());
				/*
				 * Build a KNN classifier
				 */
		DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//train.arff");
		Instances test = sourceTest.getDataSet();
		test = Filter.useFilter(test, remove1);
		
		//for competences
		test.setClassIndex(test.numAttributes()-1);
		
				//for experience 
		//test.setClassIndex(test.numAttributes()-5);
		//************************************************The one
				//for niveau etude
		//test.setClassIndex(test.numAttributes()-6);

		       //for competences
				//dataset.setClassIndex(dataset.numAttributes()-1);
				//k - the number of nearest neighbors to use for prediction
		Classifier ibk = new IBk(1);		
		ibk.buildClassifier(dataset);
	
		System.out.println(ibk);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with  the test set 
		 */
        Evaluation evalK = new Evaluation(dataset);
        evalK.evaluateModel(ibk, dataset);
        //evalK.evaluateModel(ibk, test);
		/** Print the algorithm summary */
		System.out.println("** KNN Demo  **");
		System.out.println(evalK.toSummaryString());
	    System.out.println(evalK.toClassDetailsString());
		//System.out.println(evalK.toMatrixString());

		
	}
}