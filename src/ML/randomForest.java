package ML;

//import weka.core.Instances;
//import weka.core.converters.ArffSaver;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;

//import weka.core.converters.ConverterUtils.DataSource;
////
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
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

import javax.swing.JFrame;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.ThresholdCurve;
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
public class randomForest{
	public static  void RF_tech() throws Exception{
		//Train dataset
				DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
				Instances dataset = source.getDataSet();
				System.out.println(dataset.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial Train dataset");

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
				System.out.println("***********************The Train dataset after removing url attribute");

				System.out.println(dataset.toSummaryString());
		//Test dataset
				DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff");
				Instances test = sourceTest.getDataSet();
				System.out.println(test.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial test dataset");

				System.out.println(test.toSummaryString());
				//BufferedReader breader=null;
				//breader= new BufferedReader(new FileReader("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff"));
				//Instances test = new Instances (breader);


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
		//remove 12,13 attribute
				String[] options12 = new String[] { "-R", "12,13" };
				
		//remove 1,11,12,13 attribute
				//String[] options12 = new String[] { "-R", "1,11,12,13" };
				
				
				Remove remove12 = new Remove();
				remove12.setOptions(options12);
				remove12.setInputFormat(dataset);
				//dataset = Filter.useFilter(dataset, remove12); 
				System.out.println("***********************After features selection");

				System.out.println(dataset.toSummaryString());
				//System.out.println(dataset.numAttributes()-1);
				
		//set the target attribute for 
		//*******************************************************train dataset
				
				//for experience
				//dataset.setClassIndex(dataset.numAttributes()-4);
				//for technologies(competences)
				dataset.setClassIndex(dataset.numAttributes()-1);
				
		//****************************************************************The one 
				//for niveau d'etude

				//dataset.setClassIndex(dataset.numAttributes()-5);

				
		//*******************************************************test dataset
				//for experience
			    //with remove
			//test.setClassIndex(test.numAttributes()-2);
		         //without remove
			//test.setClassIndex(test.numAttributes()-4);

			//for niveau d'etude
		        //with remove
			//test.setClassIndex(test.numAttributes()-3);
		        //without remove
			//test.setClassIndex(test.numAttributes()-5);

			//for technologies(competences)
			test.setClassIndex(test.numAttributes()-1);
				
		//************************************************************build the Random Forest classifier
				RandomForest forest=new RandomForest();
				forest.setNumIterations(10);
				/** */
				forest.buildClassifier(dataset);
				System.out.println(forest);
				/**
				 * train the alogorithm with the training data and evaluate the
				 * algorithm with  the training set (Use training set. The classifier is evaluated on how well it predicts the
					class of the instances it was trained on).
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

		
	}
	public static  void RF_ne() throws Exception{
		//Train dataset
		//Train dataset
				DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
				Instances dataset = source.getDataSet();
				System.out.println(dataset.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial Train dataset");

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
				System.out.println("***********************The Train dataset after removing url attribute");

				System.out.println(dataset.toSummaryString());
		//Test dataset
				DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff");
				Instances test = sourceTest.getDataSet();
				System.out.println(test.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial test dataset");

				System.out.println(test.toSummaryString());
				//BufferedReader breader=null;
				//breader= new BufferedReader(new FileReader("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff"));
				//Instances test = new Instances (breader);


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
		//remove 12,13 attribute
				String[] options12 = new String[] { "-R", "12,13" };
				
		//remove 1,11,12,13 attribute
				//String[] options12 = new String[] { "-R", "1,11,12,13" };
				
				
				Remove remove12 = new Remove();
				remove12.setOptions(options12);
				remove12.setInputFormat(dataset);
				//dataset = Filter.useFilter(dataset, remove12); 
				System.out.println("***********************After features selection");

				System.out.println(dataset.toSummaryString());
				//System.out.println(dataset.numAttributes()-1);
				
		//set the target attribute for 
		//*******************************************************train dataset
				
				//for experience
				//dataset.setClassIndex(dataset.numAttributes()-4);
				//for technologies(competences)
				//dataset.setClassIndex(dataset.numAttributes()-1);
				
		//****************************************************************The one 
				//for niveau d'etude

				dataset.setClassIndex(dataset.numAttributes()-5);

				
		//*******************************************************test dataset
				//for experience
			    //with remove
			//test.setClassIndex(test.numAttributes()-2);
		         //without remove
			//test.setClassIndex(test.numAttributes()-4);

			//for niveau d'etude
		        //with remove
			test.setClassIndex(test.numAttributes()-3);
		        //without remove
			//test.setClassIndex(test.numAttributes()-5);

			//for technologies(competences)
			//test.setClassIndex(test.numAttributes()-1);
				
		//************************************************************build the Random Forest classifier
				RandomForest forest=new RandomForest();
				forest.setNumIterations(10);
				/** */
				forest.buildClassifier(dataset);
				System.out.println(forest);
				/**
				 * train the alogorithm with the training data and evaluate the
				 * algorithm with  the training set (Use training set. The classifier is evaluated on how well it predicts the
					class of the instances it was trained on).
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

				
			}
	public static  void RF_exp() throws Exception{
		//Train dataset
				DataSource source = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78/train.arff");
				Instances dataset = source.getDataSet();
				System.out.println(dataset.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial Train dataset");

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
				System.out.println("***********************The Train dataset after removing url attribute");

				System.out.println(dataset.toSummaryString());
		//Test dataset
				DataSource sourceTest = new DataSource("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff");
				Instances test = sourceTest.getDataSet();
				System.out.println(test.numInstances() + " instances loaded.");
				//System.out.println(dataset.toString());
				System.out.println("***********************The initial test dataset");

				System.out.println(test.toSummaryString());
				//BufferedReader breader=null;
				//breader= new BufferedReader(new FileReader("C://Users//ikram//Downloads//JavaProject78//JavaProject78//test.arff"));
				//Instances test = new Instances (breader);


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
		//remove 12,13 attribute
				String[] options12 = new String[] { "-R", "12,13" };
				
		//remove 1,11,12,13 attribute
				//String[] options12 = new String[] { "-R", "1,11,12,13" };
				
				
				Remove remove12 = new Remove();
				remove12.setOptions(options12);
				remove12.setInputFormat(dataset);
				//dataset = Filter.useFilter(dataset, remove12); 
				System.out.println("***********************After features selection");

				System.out.println(dataset.toSummaryString());
				//System.out.println(dataset.numAttributes()-1);
				
		//set the target attribute for 
		//*******************************************************train dataset
				
				//for experience
				dataset.setClassIndex(dataset.numAttributes()-4);
				//for technologies(competences)
				//dataset.setClassIndex(dataset.numAttributes()-1);
				
		//****************************************************************The one 
				//for niveau d'etude

				//dataset.setClassIndex(dataset.numAttributes()-5);

				
		//*******************************************************test dataset
				//for experience
			    //with remove
			//test.setClassIndex(test.numAttributes()-2);
		         //without remove
			test.setClassIndex(test.numAttributes()-4);

			//for niveau d'etude
		        //with remove
			//test.setClassIndex(test.numAttributes()-3);
		        //without remove
			//test.setClassIndex(test.numAttributes()-5);

			//for technologies(competences)
			//test.setClassIndex(test.numAttributes()-1);
				
		//************************************************************build the Random Forest classifier
				RandomForest forest=new RandomForest();
				forest.setNumIterations(10);
				/** */
				forest.buildClassifier(dataset);
				System.out.println(forest);
				/**
				 * train the alogorithm with the training data and evaluate the
				 * algorithm with  the training set (Use training set. The classifier is evaluated on how well it predicts the
					class of the instances it was trained on).
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

				
			}
}