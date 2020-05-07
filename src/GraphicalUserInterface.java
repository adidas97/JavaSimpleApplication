import java.awt.EventQueue;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font; 

public class GraphicalUserInterface {

	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField ageTextField;
	private JTextField emailTextField;
	private JTextField salaryTextField;
	private JTextField countryTextField;
	private JTextField cityTextField;
	private JTextField streetTextField;
	private JTable table;
	private JTextField textField;
	
	private LinkedList<Manager> managers;
	private LinkedList<Secretary> secretaries;
	private LinkedList<SalesPerson> salesPersons;
	private LinkedList<FactoryWorker> factoryWorkers;
	
	private JPanel showManagersPanel;
	private JPanel showSecretariesPanel;
	private JPanel showSalesPersonsPanel;
	private JPanel showFactoryWorkersPanel;
	
	JLayeredPane layeredPane;
	
	
	private  String header[] = new String[]{"ID","First Name","Last Name","Email","Age","Salary","Country","City","Street"};
    
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalUserInterface window = new GraphicalUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GraphicalUserInterface() {
		layeredPane = new JLayeredPane();
		
        managers = new LinkedList<Manager>();
        secretaries = new LinkedList<Secretary>();
        salesPersons = new LinkedList<SalesPerson>();
        factoryWorkers = new LinkedList<FactoryWorker>();
		
		initialize();
	}
	
	private void CleanTextFields() {
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		ageTextField.setText("");
		emailTextField.setText("");
		countryTextField.setText("");
		cityTextField.setText("");
		streetTextField.setText("");
	}
	
	private void ShowLabels(JPanel panel) {
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(12, 0, 114, 34);
		panel.add(firstName);
		
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(12, 41, 114, 34);
		panel.add(lastName);
		
		JLabel age = new JLabel("Age");
		age.setBounds(12, 88, 114, 34);
		panel.add(age);
		
		JLabel email = new JLabel("Email");
		email.setBounds(12, 149, 114, 34);
		panel.add(email);
		
		JLabel country = new JLabel("Country");
		country.setBounds(12, 211, 114, 34);
		panel.add(country);
		
		JLabel city = new JLabel("City");
		city.setBounds(12, 269, 114, 34);
		panel.add(city);
		
		JLabel street = new JLabel("Street");
		street.setBounds(12, 316, 114, 34);
		panel.add(street);
	}
	
	private void ShowInput(JPanel panel) {
        textField = new JTextField();
		textField.setBounds(484, 461, 39, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(105, 6, 165, 22);
		panel.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(105, 47, 165, 22);
		panel.add(lastNameTextField);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(105, 94, 165, 22);
		panel.add(ageTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(105, 155, 165, 22);
		panel.add(emailTextField);
		
		countryTextField = new JTextField();
		countryTextField.setColumns(10);
		countryTextField.setBounds(105, 217, 165, 22);
		panel.add(countryTextField);
		
		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(105, 275, 165, 22);
		panel.add(cityTextField);
		
		streetTextField = new JTextField();
		streetTextField.setColumns(10);
		streetTextField.setBounds(105, 322, 165, 22);
		panel.add(streetTextField);
	}
	
	private void TableInitialize(DefaultTableModel dtm,JTable table,JPanel panel) {
		
		table.setModel(dtm);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 34, 741, 497);
		panel.add(sp);
		OpenPanel(panel);
	}
	
	private void OpenPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private JPanel SecretaryPanel() {
		JPanel secretaryPanel = new JPanel();
		layeredPane.add(secretaryPanel, "name_681604646307100");
		secretaryPanel.setLayout(null);
		
		JLabel input = new JLabel("Input Form for Secretary");
		input.setBounds(400, 8, 341, 49);
		secretaryPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(secretaryPanel);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(12, 370, 114, 34);
		secretaryPanel.add(salary);
		
		ShowInput(secretaryPanel);
		
		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		salaryTextField.setBounds(105, 370, 165, 22);
		secretaryPanel.add(salaryTextField);
		
		int countSecretaries = secretaries.size();
		String convertedCountSecretaries = Integer.toString(countSecretaries);
		textField.setText(convertedCountSecretaries);
		
		JButton addSecretaryBtn = new JButton("Add");
		addSecretaryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				int age = Integer.parseInt(ageTextField.getText());
				String email = emailTextField.getText();
				String country = countryTextField.getText();
				String city = cityTextField.getText();
				String street = streetTextField.getText();
				double salary = Double.parseDouble(salaryTextField.getText());
				
				CleanTextFields();
				salaryTextField.setText("");
				
				Address address = new Address(country,city,street);
				Secretary secretary = new Secretary(age,firstName,lastName,email,address,salary);
				secretaries.add(secretary);
				
				showSecretariesPanel = new JPanel();
				layeredPane.add(showSecretariesPanel, "name_681415529124300");
				showSecretariesPanel.setLayout(null);
				
				JLabel secretariesLabel = new JLabel("Secretaries");
				secretariesLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				secretariesLabel.setBounds(163, 0, 112, 25);
				showSecretariesPanel.add(secretariesLabel);
				
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<secretaries.size();i++) {
					Object[] objs = {secretaries.get(i).getId(),secretaries.get(i).getFirstName(),secretaries.get(i).getLastName(),secretaries.get(i).getEmail()
							,secretaries.get(i).getAge(),secretaries.get(i).getSalary(),secretaries.get(i).getAddress().getCountry()
							,secretaries.get(i).getAddress().getCity(),secretaries.get(i).getAddress().getStreet()}; 
					dtm.addRow(objs);
				}
				TableInitialize(dtm,table,showSecretariesPanel);
			}
		});
		addSecretaryBtn.setBounds(138, 466, 97, 25);
		secretaryPanel.add(addSecretaryBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Secretaries");
		lblNewLabel_1.setBounds(328, 466, 114, 25);
		secretaryPanel.add(lblNewLabel_1);
		
		JButton showSecretariesBtn = new JButton("Show");
		showSecretariesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showSecretariesPanel);
			}
		});
		showSecretariesBtn.setBounds(12, 466, 97, 25);
		secretaryPanel.add(showSecretariesBtn);
		
	  return secretaryPanel;
	}
	
	private JPanel SalesPersonPanel() {
		JPanel salesPersonPanel = new JPanel();
		layeredPane.add(salesPersonPanel, "name_680604646307100");
		salesPersonPanel.setLayout(null);
		
		JLabel input = new JLabel("Input Form for Sales Person");
		input.setBounds(400, 8, 341, 49);
		salesPersonPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(salesPersonPanel);
		
	    JLabel comission = new JLabel("Comission");
	    comission.setBounds(12, 356, 114, 34);
	    salesPersonPanel.add(comission);
	    
	    JLabel priceOfDeal = new JLabel("Average price per deal");
	    priceOfDeal.setBounds(12, 396, 144, 34);
	    salesPersonPanel.add(priceOfDeal);
	    
	    JLabel numberOfDeals = new JLabel("Number of deals");
	    numberOfDeals.setBounds(12, 430, 114, 34);
	    salesPersonPanel.add(numberOfDeals);
		
		ShowInput(salesPersonPanel);
		
		JTextField comissionTextField = new JTextField();
		comissionTextField.setColumns(10);
		comissionTextField.setBounds(105, 362, 165, 22);
		salesPersonPanel.add(comissionTextField);
		
		JTextField pricePerDealTextField = new JTextField();
		pricePerDealTextField.setColumns(10);
		pricePerDealTextField.setBounds(150, 400, 165, 22);
		salesPersonPanel.add(pricePerDealTextField);
		
		JTextField numberOfDealsTextField = new JTextField();
		numberOfDealsTextField.setColumns(10);
		numberOfDealsTextField.setBounds(115, 440, 175, 18);
		salesPersonPanel.add(numberOfDealsTextField);
		
		int countSalesPersons = salesPersons.size();
		String convertedCountSalesPersons = Integer.toString(countSalesPersons);
		textField.setText(convertedCountSalesPersons);
		
		JButton addSalesPersonBtn = new JButton("Add");
		addSalesPersonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				int age = Integer.parseInt(ageTextField.getText());
				String email = emailTextField.getText();
				String country = countryTextField.getText();
				String city = cityTextField.getText();
				String street = streetTextField.getText();
				int comission = Integer.parseInt(comissionTextField.getText());
				double pricePerDeals = Double.parseDouble(pricePerDealTextField.getText());
				int numberOfDeals = Integer.parseInt(numberOfDealsTextField.getText());
				
				CleanTextFields();
				
				Address address = new Address(country,city,street);
				SalesPerson salesPerson = new SalesPerson(age,firstName,lastName,email,address,comission,pricePerDeals,numberOfDeals);
				salesPersons.add(salesPerson);
				
				showSalesPersonsPanel = new JPanel();
				layeredPane.add(showSalesPersonsPanel, "name_682415529124300");
				showSalesPersonsPanel.setLayout(null);
				
				JLabel salesPersonLabel = new JLabel("Sales Persons");
				salesPersonLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				salesPersonLabel.setBounds(163, 0, 112, 25);
				showSalesPersonsPanel.add(salesPersonLabel);
				
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<salesPersons.size();i++) {
					Object[] objs = {salesPersons.get(i).getId(),salesPersons.get(i).getFirstName(),salesPersons.get(i).getLastName(),salesPersons.get(i).getEmail()
							,salesPersons.get(i).getAge(),salesPersons.get(i).getSalary(),salesPersons.get(i).getAddress().getCountry()
							,salesPersons.get(i).getAddress().getCity(),salesPersons.get(i).getAddress().getStreet()}; 
					dtm.addRow(objs);
				}
				TableInitialize(dtm,table,showSalesPersonsPanel);
			}
		});
		addSalesPersonBtn.setBounds(138, 466, 97, 25);
		salesPersonPanel.add(addSalesPersonBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Sales Persons");
		lblNewLabel_1.setBounds(328, 466, 144, 25);
		salesPersonPanel.add(lblNewLabel_1);
		
		JButton showSalesPersonBtn = new JButton("Show");
		showSalesPersonBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showSalesPersonsPanel);
			}
		});
		showSalesPersonBtn.setBounds(12, 466, 97, 25);
		salesPersonPanel.add(showSalesPersonBtn);
		
	  return salesPersonPanel;
	}
	
	private JPanel FactoryWorkerPanel() {
		JPanel factoryWorkerPanel = new JPanel();
		layeredPane.add(factoryWorkerPanel, "name_671604646307100");
		factoryWorkerPanel.setLayout(null);
        
		JLabel input = new JLabel("Input Form for Factory Worker");
		input.setBounds(400, 8, 341, 49);
		factoryWorkerPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(factoryWorkerPanel);
		
		JLabel pricePerHour = new JLabel("Price per hour");
		pricePerHour.setBounds(12, 396, 114, 34);
		factoryWorkerPanel.add(pricePerHour);
	    
	    JLabel hoursPerMonth = new JLabel("Hours per month");
	    hoursPerMonth.setBounds(12, 355, 114, 34);
	    factoryWorkerPanel.add(hoursPerMonth);
		
        ShowInput(factoryWorkerPanel);
		
        JTextField pricePerHourTextField = new JTextField();
        pricePerHourTextField.setColumns(10);
        pricePerHourTextField.setBounds(115, 362, 165, 22);
        factoryWorkerPanel.add(pricePerHourTextField);
		
		JTextField hoursPerMonthTextField = new JTextField();
		hoursPerMonthTextField.setColumns(10);
		hoursPerMonthTextField.setBounds(105, 400, 165, 22);
		factoryWorkerPanel.add(hoursPerMonthTextField);
		
		int countFactoryWorkers = factoryWorkers.size();
		String convertedCountManagers = Integer.toString(countFactoryWorkers);
		textField.setText(convertedCountManagers);
		
		JButton addFactoryWorkerBtn = new JButton("Add");
		addFactoryWorkerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				int age = Integer.parseInt(ageTextField.getText());
				String email = emailTextField.getText();
				String country = countryTextField.getText();
				String city = cityTextField.getText();
				String street = streetTextField.getText();
				int pricePerHour = Integer.parseInt(pricePerHourTextField.getText());
				int hoursPerMonth = Integer.parseInt(hoursPerMonthTextField.getText());
			
				CleanTextFields();
				pricePerHourTextField.setText("");
				hoursPerMonthTextField.setText("");
				
				Address address = new Address(country,city,street);
				FactoryWorker factoryWorker = new FactoryWorker(age,firstName,lastName,email,address,pricePerHour,hoursPerMonth);
				factoryWorkers.add(factoryWorker);
				
				showFactoryWorkersPanel = new JPanel();
				layeredPane.add(showFactoryWorkersPanel, "name_621415529124300");
				showFactoryWorkersPanel.setLayout(null);
				
				JLabel factoryWorkersLabel = new JLabel("Factory workers");
				factoryWorkersLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				factoryWorkersLabel.setBounds(163, 0, 142, 25);
				showFactoryWorkersPanel.add(factoryWorkersLabel);
				
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<factoryWorkers.size();i++) {
					Object[] objs = {factoryWorkers.get(i).getId(),factoryWorkers.get(i).getFirstName(),factoryWorkers.get(i).getLastName(),factoryWorkers.get(i).getEmail()
							,factoryWorkers.get(i).getAge(),factoryWorkers.get(i).getSalary(),factoryWorkers.get(i).getAddress().getCountry()
							,factoryWorkers.get(i).getAddress().getCity(),factoryWorkers.get(i).getAddress().getStreet()}; 
					dtm.addRow(objs);
				}
				TableInitialize(dtm,table,showFactoryWorkersPanel);
			}
		});
		addFactoryWorkerBtn.setBounds(138, 466, 97, 25);
		factoryWorkerPanel.add(addFactoryWorkerBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Factory Workers");
		lblNewLabel_1.setBounds(328, 466, 142, 25);
		factoryWorkerPanel.add(lblNewLabel_1);
		
		JButton showFactoryWorkersBtn = new JButton("Show");
		showFactoryWorkersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showFactoryWorkersPanel);
			}
		});
		showFactoryWorkersBtn.setBounds(12, 466, 97, 25);
		factoryWorkerPanel.add(showFactoryWorkersBtn);
	  return factoryWorkerPanel;
	}
	
	private JPanel ManagerPanel() {
		JPanel managerPanel = new JPanel();
		layeredPane.add(managerPanel, "name_671604646307100");
		managerPanel.setLayout(null);
        
		JLabel input = new JLabel("Input Form for Manager");
		input.setBounds(400, 8, 341, 49);
		managerPanel.add(input);
		input.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		ShowLabels(managerPanel);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(12, 370, 114, 34);
		managerPanel.add(salary);
		
        ShowInput(managerPanel);
		
		salaryTextField = new JTextField();
		salaryTextField.setColumns(10);
		salaryTextField.setBounds(105, 370, 165, 22);
		managerPanel.add(salaryTextField);
		
		int countManagers = managers.size();
		String convertedCountManagers = Integer.toString(countManagers);
		textField.setText(convertedCountManagers);
		
		JButton addManagerBtn = new JButton("Add");
		addManagerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				int age = Integer.parseInt(ageTextField.getText());
				String email = emailTextField.getText();
				double salary = Double.parseDouble(salaryTextField.getText());
				String country = countryTextField.getText();
				String city = cityTextField.getText();
				String street = streetTextField.getText();
				
				CleanTextFields();
				salaryTextField.setText("");
				
				Address address = new Address(country,city,street);
				Manager manager = new Manager(age,firstName,lastName,email,address,salary);
				managers.add(manager);
				
				showManagersPanel = new JPanel();
				layeredPane.add(showManagersPanel, "name_681415529124300");
				showManagersPanel.setLayout(null);
				
				JLabel managersLabel = new JLabel("Managers");
				managersLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				managersLabel.setBounds(163, 0, 112, 25);
				showManagersPanel.add(managersLabel);
				
				table = new JTable();
			    DefaultTableModel dtm = new DefaultTableModel(header,0);
				 
				for(int i=0;i<managers.size();i++) {
					Object[] objs = {managers.get(i).getId(),managers.get(i).getFirstName(),managers.get(i).getLastName(),managers.get(i).getEmail()
							,managers.get(i).getAge(),managers.get(i).getSalary(),managers.get(i).getAddress().getCountry()
							,managers.get(i).getAddress().getCity(),managers.get(i).getAddress().getStreet()}; 
					dtm.addRow(objs);
				}
				TableInitialize(dtm,table,showManagersPanel);
			}
		});
		addManagerBtn.setBounds(138, 466, 97, 25);
		managerPanel.add(addManagerBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Current Managers");
		lblNewLabel_1.setBounds(328, 466, 114, 25);
		managerPanel.add(lblNewLabel_1);
		
		JButton showManagersBtn = new JButton("Show");
		showManagersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpenPanel(showManagersPanel);
			}
		});
		showManagersBtn.setBounds(12, 466, 97, 25);
		managerPanel.add(showManagersBtn);
	  return managerPanel;
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		layeredPane.setBounds(366, 13, 741, 531);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel welcomePanel = new JPanel();
		layeredPane.add(welcomePanel, "name_671430906635100");
		welcomePanel.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 41, 43, -31);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel introLabel = new JLabel("Choose for which object you want to fill the data");
		introLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		introLabel.setBounds(12, 13, 344, 96);
		frame.getContentPane().add(introLabel);
		
		JButton managerInputBtn = new JButton("Manager");
		managerInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OpenPanel(ManagerPanel());
			
			}
		});
		managerInputBtn.setBounds(46, 122, 141, 43);
		frame.getContentPane().add(managerInputBtn);
		
		JButton secretaryInputBtn = new JButton("Secretary");
		secretaryInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(SecretaryPanel());
			}
		});
		secretaryInputBtn.setBounds(46, 190, 141, 43);
		frame.getContentPane().add(secretaryInputBtn);
		
		JButton salesPersonInputBtn = new JButton("SalesPerson");
		salesPersonInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(SalesPersonPanel());
			}
		});
		salesPersonInputBtn.setBounds(46, 269, 141, 49);
		frame.getContentPane().add(salesPersonInputBtn);
		
		JButton factoryWorkerInputBtn = new JButton("FactoryWorker");
		factoryWorkerInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenPanel(FactoryWorkerPanel());
			}
		});
		factoryWorkerInputBtn.setBounds(46, 350, 141, 49);
		frame.getContentPane().add(factoryWorkerInputBtn);
		frame.setBounds(100, 100, 1144, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
