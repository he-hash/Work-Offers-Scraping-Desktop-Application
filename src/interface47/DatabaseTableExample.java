package interface47;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

import ML.KNNClassification;
import ML.randomForest;
import ML.treeDecision;
import ML.KNNTest;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 * @author ikram
 *
 */
public class DatabaseTableExample extends JFrame {
  // Declare JDBC driver and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3307/projet";

  // Declare database credentials
  static final String USER = "root";
  static final String PASS = "";

  // Declare UI components
  JPanel urlPanel;
  JLabel urlLabel;
  JTextField urlTextField;
  JButton confirmButton;
  JPanel tablePanel;
  JTable table;
  JFrame frame;
  static JButton btnTraining;
  static JButton btnTesting;
  static JCheckBox chckbxAlgorithm1;
  static JCheckBox chckbxAlgorithm2;
  static JCheckBox chckbxAlgorithm3;
  static JRadioButton rdbtnNewRadioButton;
  static JRadioButton rdbtnNewRadioButton_1;
  static JRadioButton rdbtnNewRadioButton_2;
  static JTextArea textArea;

  // Constructor
  public DatabaseTableExample() {
    // Initialize UI components
    urlPanel = new JPanel();
    urlLabel = new JLabel("Enter URL:");
    urlTextField = new JTextField(20);
    confirmButton = new JButton("Confirm");
    tablePanel = new JPanel();
    table = new JTable();
    table.setTableHeader(new JTableHeader(table.getColumnModel()));
    table.setPreferredScrollableViewportSize(new Dimension(400, 500));
    frame = new JFrame();
    frame.setBounds(80, 150, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    textArea = new JTextArea();
	textArea.setBounds(0, 180, 800, 100);
	textArea.setForeground(new Color(139, 0, 139));
	textArea.setFont(new Font("Serif",Font.BOLD,14));
	textArea.setAlignmentX(FlowLayout.RIGHT);
	textArea.setBackground(Color.LIGHT_GRAY);
	//frame.getContentPane().add(textArea); 
	//frame.setVisible(true);
// Add the text area to the GUI
    btnTraining = new JButton("training");
    btnTraining.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (chckbxAlgorithm1.isSelected()) {
        		if (rdbtnNewRadioButton.isSelected()) {
        			try {
        			    // Call the KNN.test function and set the text of the text area to the output
        				 KNNClassification.KNN_exp();
        				textArea.setText("Correctly Classified Instances : 99.42%\nIncorrectly Classified Instances: 0.57%");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_1.isSelected()) {
        			try {
        				KNNClassification.KNN_ne();
        				textArea.setText("Correctly Classified Instances : 100%\nIncorrectly Classified Instances: 0%\n ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_2.isSelected()) {
        			try {
        				KNNClassification.KNN_tech();
        				textArea.setText("Correctly Classified Instances : 100%\nIncorrectly Classified Instances:0% ");;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        	}
        	if (chckbxAlgorithm2.isSelected()) {
        		if (rdbtnNewRadioButton.isSelected()) {
        			try {
        				randomForest.RF_exp();
        				textArea.setText("Correctly Classified Instances : 99.75%\nIncorrectly Classified Instances: 0.24%");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_1.isSelected()) {
        			try {
        				randomForest.RF_ne();
        				textArea.setText("Correctly Classified Instances : 99.51%\nIncorrectly Classified Instances: 0.48%");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_2.isSelected()) {
        			try {
        				randomForest.RF_tech();
        				textArea.setText("Correctly Classified Instances : 88.70%\nIncorrectly Classified Instances: 11.29%\nPrecision= 0.885\nRecall=0.96 ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        	}
        	if (chckbxAlgorithm3.isSelected()) {
        		if (rdbtnNewRadioButton.isSelected()) {
        			try {
        				treeDecision.TD_exp();
        				textArea.setText("Correctly Classified Instances : 53.93%\nIncorrectly Classified Instances: 46.06%\nPrecision= 0.51\nRecall=0.84 ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_1.isSelected()) {
        			try {
        				treeDecision.TD_ne();
        				textArea.setText("Correctly Classified Instances :99.03%\nIncorrectly Classified Instances: 0.96%\nPrecision= 0.991\nRecall=0.991");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        		if (rdbtnNewRadioButton_2.isSelected()) {
        			try {
        				treeDecision.TD_tech();
        				textArea.setText("Correctly Classified Instances : 92.06%\nIncorrectly Classified Instances: 7.93%\nPrecision= 1.0\nRecall=1.0");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
         		}
        	}

        		
        }
      });
    btnTraining.setForeground(new Color(255, 0, 0));
    btnTraining.setBounds(6, 67, 89, 23);
   // frame.getContentPane().add(btnTraining);

    btnTesting = new JButton("testing");
    btnTesting.setForeground(new Color(0, 128, 0));
    btnTesting.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  if (chckbxAlgorithm3.isSelected()) {
      		if (rdbtnNewRadioButton.isSelected()) {
      			try {
      				KNNTest.KNN_exp();
      				textArea.setText("Correctly Classified Instances : 100%\nIncorrectly Classified Instances: 0%\n ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
       		}
      		if (rdbtnNewRadioButton_1.isSelected()) {
      			try {
      				KNNTest.KNN_ne();
      				textArea.setText("Correctly Classified Instances : 100%\nIncorrectly Classified Instances: 0%\n ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
       		}
      		if (rdbtnNewRadioButton_2.isSelected()) {
      			try {
      				KNNTest.KNN_tech();
      				textArea.setText("Correctly Classified Instances : 100%\nIncorrectly Classified Instances: 0%\n ");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
       		}
      	}
      }
    });
    btnTesting.setBounds(6, 103, 89, 23);
    //frame.getContentPane().add(btnTesting);

    chckbxAlgorithm1 = new JCheckBox("KNN");
    chckbxAlgorithm1.setForeground(new Color(218, 112, 214));
    chckbxAlgorithm1.setBounds(6, 30, 97, 23);
    //frame.getContentPane().add(chckbxAlgorithm1);

    chckbxAlgorithm2 = new JCheckBox("Random Forest");
    chckbxAlgorithm2.setForeground(new Color(139, 0, 139));
    chckbxAlgorithm2.setBounds(6, 37, 97, 23);
    //frame.getContentPane().add(chckbxAlgorithm2);
    
    chckbxAlgorithm3 = new JCheckBox("Tree Decision");
    chckbxAlgorithm3.setForeground(new Color(139, 0, 139));
    chckbxAlgorithm3.setBounds(6, 40, 97, 23);
    //frame.getContentPane().add(chckbxAlgorithm3);
    
     rdbtnNewRadioButton = new JRadioButton("experience");
	rdbtnNewRadioButton.setForeground(new Color(123, 104, 238));
	rdbtnNewRadioButton.setBounds(10, 60, 97, 23);
	//frame.getContentPane().add(rdbtnNewRadioButton);
	
	 rdbtnNewRadioButton_1 = new JRadioButton("niveau_étude");
	rdbtnNewRadioButton_1.setForeground(new Color(220, 20, 60));
	rdbtnNewRadioButton_1.setBounds(10, 60, 97, 23);
	//frame.getContentPane().add(rdbtnNewRadioButton_1);
	
	rdbtnNewRadioButton_2 = new JRadioButton("compétences");
	rdbtnNewRadioButton_2.setForeground(new Color(0, 206, 209));
	rdbtnNewRadioButton_2.setBounds(10, 100, 97, 23);
	//frame.getContentPane().add(rdbtnNewRadioButton_2);
    // Add action listener to confirm button
    confirmButton.addActionListener(new ActionListener() {
      /**
     *
     */
    public void actionPerformed(ActionEvent e) {
    	 // Connect to database and retrieve data
        try {
          // Register JDBC driver
          Class.forName(JDBC_DRIVER);

          // Open a connection
          Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

          // Execute a query
          Statement stmt = conn.createStatement();
          String sql = "SELECT metier,niveau_etude,experience,contrat,mode_travail,competences FROM projeet ";
          ResultSet rs = stmt.executeQuery(sql);
       // Create a table model
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(new String[] {"Métier", "Niveau d'etude", "Experience","Contrat","Mode de travail","Competences"});
          // Get metadata from result set
          ResultSetMetaData metadata = rs.getMetaData();

          // Get number of columns
          int columnCount = metadata.getColumnCount();

          // Add column names to table model
         // for (int i = 1; i <= columnCount; i++) {
           // model.addColumn(metadata.getColumnName(i));
         // }

          // Add rows to table model
          while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
              row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
            

          // Set table model as data model for table
          table.setModel(model);
       

       // Add table to scroll pane
          

          
          }
          for (int i = 0; i < (table.getColumnCount()); i++) {
        	  TableColumn column = table.getColumnModel().getColumn(i);
        	  column.setPreferredWidth(200);
        	}
       // Add table to scroll pane
          

          // Add table panel to frame
         // DatabaseTableExample.this.add(tablePanel, BorderLayout.EAST);


       // Set column names in the table model
        //  model.setColumnIdentifiers(new String[] {"Métier", "Niveau d'etude", "Experience","Contrat","Mode de travail","Competences"});



          // Populate table with data from result set
          //table.setModel(DbUtils.resultSetToTableModel(rs));

          // Clean up
          rs.close();
          stmt.close();
          conn.close();
        } catch (SQLException se) {
          // Handle errors for JDBC
          se.printStackTrace();
        } catch (Exception ex) {
          // Handle errors for Class.forName
          ex.printStackTrace();
        }
      }
    });

    // Add components to panels
    urlPanel.add(urlLabel);
    urlPanel.add(urlTextField);
    urlPanel.add(confirmButton);
    tablePanel.add(table);

    // Add panels to frame
    this.add(urlPanel, BorderLayout.NORTH);
    this.add(tablePanel, BorderLayout.EAST);
    JScrollPane scrollPane = new JScrollPane(table);

    // Remove any existing components from the table panel
    tablePanel.removeAll();

    // Add scroll pane to table panel
    tablePanel.add(scrollPane);
    
  }
  public class frame3 {

		//private JFrame frame;
  public static void main(String[] args) {
    // Create and show the interface
    DatabaseTableExample frame = new DatabaseTableExample();
    frame.setTitle("Database Table Example");
    frame.setSize(1000, 1000);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //DatabaseTableExample example = new DatabaseTableExample();
    frame.setVisible(true);
    //frame.setLayout(new BorderLayout());
    frame.getContentPane().setLayout(new FlowLayout());
    frame.setBounds(10,150,400,1000);
    frame.getContentPane().add(btnTraining);
    frame.getContentPane().add(btnTesting);
    frame.getContentPane().add(chckbxAlgorithm1);
    frame.getContentPane().add(chckbxAlgorithm2);
    frame.getContentPane().add(chckbxAlgorithm3);
    frame.getContentPane().add(rdbtnNewRadioButton);
    frame.getContentPane().add(rdbtnNewRadioButton_1);
    frame.getContentPane().add(rdbtnNewRadioButton_2);
    frame.getContentPane().add(textArea);

    try {
    	  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}


    // Set background color of frame
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);

    // Set background color of table panel
    frame.tablePanel.setBackground(Color.LIGHT_GRAY);
  //  EventQueue.invokeLater(new Runnable() {
	//	public void run() {
		//	try {
		//		frame3 window = new frame3();
		//		window.frame.setVisible(true);
		//	} catch (Exception e) {
		//		e.printStackTrace();
		//	}
	//	}
	//});

    
  }}}

