import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.List;
import javax.xml.transform.Result;
import java.lang.String;
import java.lang.Integer;



public class StarsRUsGUI extends JFrame implements StarsRUsInterface {

	public static final String HOST = "jdbc:mysql://cs174a.engr.ucsb.edu:3306/calvinyoungDB";
	public static final String USER = "calvinyoung";
	public static final String PWD = "644";

	private DefaultComboBoxModel<String> buyStockModel, sellStockModel, showReviewModel;
	private JLabel username, password;
	private JTextField user, depositWithdrawalAmount, balance, stockPrice, stockAmount, tax_idField, nameField, stateField, phoneField, emailField, addressField, stockPriceDebug, dateDebug, lessYear, moreYear;
	private JPasswordField pass;
	private JComboBox<String> signInAsField, depositWithdrawalOptions, stockPriceOptions, buyOrSell, buySellStockOptions, customersOptions1, customersOptions2, stockDebugOptions, showReviewOptions;
	private JButton submit, createAccountButton;
	private JPanel upper;
	private JTable movieTable;
	private DefaultTableModel movieTableModel;
	private JFrame login, createAccount, createMarketAccount, traderInterface, managerInterface, movie, debugInterface, transactionHistoryInterface, movieInterface, actorProfileInterface;

	private SubmitButtonHandler submitHandler;
	private createAccountButtonHandler createAccountHandler;

	Font newFont = new Font("serif", Font.BOLD, 16);
	public void run()
	{
		loginInterface();
		return;
	}
	public void loginInterface()
	{
		login = new JFrame();
		login.setSize(400, 200);

		upper = new JPanel();
		upper.setLayout(new BoxLayout(upper,BoxLayout.Y_AXIS));
		upper.setOpaque(false);

		JPanel lowerRight = new JPanel();
		lowerRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lowerRight.setOpaque(false);

		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		username.setFont(newFont);
		password.setFont(newFont);
		user = new JTextField(3);
		pass = new JPasswordField(3);

		JLabel signInAs = new JLabel("Sign in as");
		signInAs.setFont(newFont);
		String[] signInOptions = {"Trader","Admin"};
		signInAsField = new JComboBox<String>(signInOptions);
		//signInAsField.setSelectedIndex(1);
		//SignInAsHandler signInAsHandler = new SignInAsHandler();
		//signInAsField.addActionListener(signInAsHandler);

		submit = new JButton("Submit");
		submit.setFont(newFont);
		submitHandler = new SubmitButtonHandler();
		submit.addActionListener(submitHandler);

		createAccountButton = new JButton("create account");
		createAccountButton.setFont(newFont);
		createAccountHandler = new createAccountButtonHandler();
		createAccountButton.addActionListener(createAccountHandler);

		login.getRootPane().setDefaultButton(submit);
		login.getContentPane().add(upper,BorderLayout.NORTH);

		lowerRight.add(signInAs);
		lowerRight.add(signInAsField);

		upper.add(username);
		upper.add(user);
		upper.add(password);
		upper.add(pass);
		upper.add(submit);
		upper.add(createAccountButton);
		upper.add(lowerRight,BorderLayout.SOUTH);

		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		pass.setAlignmentX(Component.CENTER_ALIGNMENT);
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		login.setLocationRelativeTo(null); // centers frame on screen
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		login.setTitle("Login");
		login.setVisible(true);
	}
	public void createAccountInterface()
	{
		createAccount = new JFrame();
		createAccount.setSize(400,400);
		JPanel upperCreateAccount = new JPanel();
		upperCreateAccount.setLayout(new BoxLayout(upperCreateAccount,BoxLayout.Y_AXIS));
		upperCreateAccount.setOpaque(false);

		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		JLabel tax_id = new JLabel("Tax Id: ");
		JLabel name = new JLabel("Name: ");
		JLabel state = new JLabel("State: ");
		JLabel phone = new JLabel("Phone number: ");
		JLabel email = new JLabel("Email: ");
		JLabel address = new JLabel("Address: ");
		//user = new JTextField();
		//pass = new JPasswordField();
		username.setFont(newFont);
		password.setFont(newFont);
		tax_id.setFont(newFont);
		name.setFont(newFont);
		state.setFont(newFont);
		phone.setFont(newFont);
		email.setFont(newFont);
		address.setFont(newFont);

		user = new JTextField(3);
		pass = new JPasswordField(3);
		tax_idField = new JTextField();
		nameField = new JTextField();
		stateField = new JTextField();
		phoneField = new JTextField();
		emailField = new JTextField();
		addressField = new JTextField();

		submit = new JButton("submit");
		submit.setFont(newFont);
		submitAccountInformationHandler submitAccountInformation = new submitAccountInformationHandler();
		submit.addActionListener(submitAccountInformation);

		createAccount.getRootPane().setDefaultButton(submit);
		createAccount.getContentPane().add(upperCreateAccount,BorderLayout.NORTH);

		upperCreateAccount.add(username);
		upperCreateAccount.add(user);
		upperCreateAccount.add(password);
		upperCreateAccount.add(pass);
		upperCreateAccount.add(tax_id);
		upperCreateAccount.add(tax_idField);
		upperCreateAccount.add(name);
		upperCreateAccount.add(nameField);
		upperCreateAccount.add(state);
		upperCreateAccount.add(stateField);
		upperCreateAccount.add(phone);
		upperCreateAccount.add(phoneField);
		upperCreateAccount.add(email);
		upperCreateAccount.add(emailField);
		upperCreateAccount.add(address);
		upperCreateAccount.add(addressField);
		upperCreateAccount.add(submit);

		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		pass.setAlignmentX(Component.CENTER_ALIGNMENT);
		tax_id.setAlignmentX(Component.CENTER_ALIGNMENT);
		tax_idField.setAlignmentX(Component.CENTER_ALIGNMENT);
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
		state.setAlignmentX(Component.CENTER_ALIGNMENT);
		stateField.setAlignmentX(Component.CENTER_ALIGNMENT);
		phone.setAlignmentX(Component.CENTER_ALIGNMENT);
		phoneField.setAlignmentX(Component.CENTER_ALIGNMENT);
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
		address.setAlignmentX(Component.CENTER_ALIGNMENT);
		addressField.setAlignmentX(Component.CENTER_ALIGNMENT);
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);

		createAccount.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
	            loginInterface();
	    }});

		createAccount.setLocationRelativeTo(null); // centers frame on screen
		createAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       	createAccount.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		createAccount.setTitle("Create Account");
		createAccount.setVisible(true);
	}
	public void traderInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}

		Connection connection = null;
		Statement statement = null;

		traderInterface = new JFrame();
		traderInterface.setSize(500, 300);

		JPanel upperTrader = new JPanel();
		upperTrader.setLayout(new BoxLayout(upperTrader,BoxLayout.Y_AXIS));
		upperTrader.setOpaque(false);

		JPanel depositWithdrawalPanel = new JPanel();
		depositWithdrawalPanel.setOpaque(false);

		JPanel buySellPanel = new JPanel();
		buySellPanel.setOpaque(false);

		JPanel showBalancePanel = new JPanel();
		showBalancePanel.setOpaque(false);

		JPanel stockPricePanel = new JPanel();
		stockPricePanel.setOpaque(false);

		JButton depositWithdrawalButton = new JButton("Deposit / Withdrawal");
		depositWithdrawalButton.setFont(newFont);
		DepositWithdrawalHandler depositWithdrawalHandler = new DepositWithdrawalHandler();
		depositWithdrawalButton.addActionListener(depositWithdrawalHandler);

		String[] depositWithdrawalText = {"Deposit","Withdraw"};
		depositWithdrawalOptions = new JComboBox<String>(depositWithdrawalText);
		JLabel dollarSign = new JLabel("$");
		depositWithdrawalAmount = new JTextField(3);

		JButton buySellButton = new JButton("Buy / Sell");
		buySellButton.setFont(newFont);
		BuySellButtonHandler buySellButtonHandler = new BuySellButtonHandler();
		buySellButton.addActionListener(buySellButtonHandler);

		String[] buyOrSellText = {"buy", "sell"};
		buyOrSell = new JComboBox<String>(buyOrSellText);
		BuyOrSellHandler buyOrSellHandler = new BuyOrSellHandler();
		buyOrSell.addActionListener(buyOrSellHandler);

		List<String> stockPriceList = new ArrayList<String>();
		List<String> stockOwnedList = new ArrayList<String>();

		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "Select symbol from stocks";
			String QUERY2 = "Select a.stock_symbol, a.number_of_shares, a.bought_price from customer_profile c, account_stock a where c.taxid = a.taxID and c.username ='" + user.getText() + "'";
			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				stockPriceList.add(result.getString("symbol"));
			}
			ResultSet result2 = statement.executeQuery(QUERY2);
			while(result2.next()){
				String temp = result2.getString("stock_symbol") + " " + result2.getString("number_of_shares") + " @ $" + result2.getString("bought_price");
				stockOwnedList.add(temp);
			}


		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		String[] stockPriceText = stockPriceList.toArray(new String[stockPriceList.size()]);
		String[] sellStockText = stockOwnedList.toArray(new String[stockOwnedList.size()]);


		buyStockModel = new DefaultComboBoxModel<String>(stockPriceText);
		sellStockModel = new DefaultComboBoxModel<String>(sellStockText);
		buySellStockOptions = new JComboBox<String>(buyStockModel);
		stockAmount = new JTextField(5);


		JButton balanceButton = new JButton("Show Balance");
		balanceButton.setFont(newFont);
		BalanceButtonHandler balanceButtonHandler = new BalanceButtonHandler();
		balanceButton.addActionListener(balanceButtonHandler);

		balance = new JTextField(9);
		balance.setEditable(false);
		//balance.setFont(newFont);

		JButton transactionHistoryButton = new JButton("Show Transaction History");
		transactionHistoryButton.setFont(newFont);
		TransactionHistoryButtonHandler transactionHistoryButtonHandler = new TransactionHistoryButtonHandler();
		transactionHistoryButton.addActionListener(transactionHistoryButtonHandler);

		JButton stockPriceButton = new JButton("Show Stock Price");
		stockPriceButton.setFont(newFont);
		StockPriceButtonHandler stockPriceButtonHandler = new StockPriceButtonHandler();
		stockPriceButton.addActionListener(stockPriceButtonHandler);

		stockPriceOptions = new JComboBox<String>(stockPriceText);
		stockPrice = new JTextField(6);
		stockPrice.setEditable(false);

		JButton movieInfoButton = new JButton("Show Movie Information");
		movieInfoButton.setFont(newFont);
		MovieInfoButtonHandler movieInfoButtonHandler = new MovieInfoButtonHandler();
		movieInfoButton.addActionListener(movieInfoButtonHandler);

		traderInterface.getContentPane().add(upperTrader,BorderLayout.NORTH);

		depositWithdrawalPanel.add(depositWithdrawalButton);
		depositWithdrawalPanel.add(depositWithdrawalOptions);
		depositWithdrawalPanel.add(dollarSign);
		depositWithdrawalPanel.add(depositWithdrawalAmount);
		depositWithdrawalOptions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dollarSign.setLayout(new FlowLayout(FlowLayout.RIGHT));
		depositWithdrawalAmount.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperTrader.add(depositWithdrawalPanel);

		buySellPanel.add(buySellButton);
		buySellPanel.add(buyOrSell);
		buySellPanel.add(buySellStockOptions);
		buySellPanel.add(stockAmount);
		upperTrader.add(buySellPanel);

		showBalancePanel.add(balanceButton);
		showBalancePanel.add(balance);
		balance.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperTrader.add(showBalancePanel);
		
		stockPricePanel.add(stockPriceButton);
		stockPricePanel.add(stockPriceOptions);
		stockPricePanel.add(stockPrice);
		stockPriceOptions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		stockPrice.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperTrader.add(stockPricePanel);

		upperTrader.add(transactionHistoryButton);
		upperTrader.add(movieInfoButton);

		transactionHistoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		movieInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		traderInterface.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
	            login.setVisible(true);
	    }});
		traderInterface.setLocationRelativeTo(null); // centers frame on screen
		traderInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        traderInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		traderInterface.setTitle("Trader Interface");
		traderInterface.setVisible(true);
	}
	public void actorProfileInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		actorProfileInterface = new JFrame();
		actorProfileInterface.setSize(500, 100);
		JPanel upperActorProfile = new JPanel();
		upperActorProfile.setLayout(new BoxLayout(upperActorProfile,BoxLayout.Y_AXIS));
		upperActorProfile.setOpaque(false);

		DefaultTableModel actorProfileModel = new DefaultTableModel(new String[]{"actorName", "movie_title", "role", "year", "total_value"}, 0);
		actorProfileModel.addRow(new String[]{"Actor Name","Movie Title","Role","Year", "Total Value"});
		String outputString = "";
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String selectedStock = (String)stockPriceOptions.getSelectedItem();
			//we will also need to do a actor profile popup
			String QUERY = "Select current_price from stocks where symbol='" + selectedStock + "'";
			ResultSet result = statement.executeQuery(QUERY);

			if(result.next())
				stockPrice.setText("$" + result.getDouble("current_price"));
			else
				stockPrice.setText("Error");
			String actorProfile = "SELECT a.actorName, m.movie_title, m.role, m.year, m.total_value FROM actor a, movie_contract m WHERE a.stock = '" + selectedStock + "' AND a.stock = m.stock_id";
			ResultSet resultActorProfile = statement.executeQuery(actorProfile);
			if(resultActorProfile.next())
			{
				String a = resultActorProfile.getString("actorName");
				String b = resultActorProfile.getString("movie_title");
				String c = resultActorProfile.getString("role");
				String d = resultActorProfile.getString("year");
				String f = resultActorProfile.getString("total_value");
				actorProfileModel.addRow(new String[]{a,b,c,d,f});
				//outputString = resultActorProfile.getString("actorName") + "\t" + resultActorProfile.getString("movie_title") + "\t" + resultActorProfile.getString("role") + "\t" + resultActorProfile.getString("year") + "\t" + resultActorProfile.getString("total_value");
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		actorProfileInterface.getContentPane().add(upperActorProfile,BorderLayout.NORTH);
		JTable actorProfileTable = new JTable(actorProfileModel);
		upperActorProfile.add(actorProfileTable);
		//JOptionPane.showMessageDialog(null, outputString);
		actorProfileInterface.setLocationRelativeTo(null); // centers frame on screen
		actorProfileInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        actorProfileInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		actorProfileInterface.setTitle("Actor Profile");
		actorProfileInterface.setVisible(true);
	}
	//}
	public void transactionHistoryInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		transactionHistoryInterface = new JFrame();
		transactionHistoryInterface.setSize(450, 200);
		JPanel upperTransaction = new JPanel();
		upperTransaction.setLayout(new BoxLayout(upperTransaction,BoxLayout.Y_AXIS));
		upperTransaction.setOpaque(false);
		//DefaultTableModel historyTableModel = new DefaultTableModel();
		DefaultTableModel transactionHistoryTableModel = new DefaultTableModel(new String[]{"Tid", "Date", "Stock", "Price", "Amount", "Type"}, 0);

		transactionHistoryInterface.getContentPane().add(upperTransaction,BorderLayout.NORTH);
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "SELECT t.Tid, t.date, b.stock_name, b.price, b.amount, b.type FROM transaction t, buy_sell b, market_stock_account m WHERE t.Tid = b.Tid AND m.username = '" + user.getText() + "' AND m.Aid = t.Aid";			
			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				String a = result.getString("Tid");
				String b = result.getString("date");
				String c = result.getString("stock_name");
				String d = result.getString("price");
				String e = result.getString("amount");
				String f = result.getString("type");
				transactionHistoryTableModel.addRow(new String[]{a, b, f, c, d, e});
			}
			String QUERY2 = "SELECT t.Tid, t.date, w.type, w.money FROM transaction t, withdraw_deposit w, market_stock_account m WHERE t.Tid = w.Tid AND m.username = '" + user.getText() + "' AND m.Aid = t.Aid";			
			ResultSet result2 = statement.executeQuery(QUERY2);
			while(result2.next())
			{
				String a = result2.getString("Tid");
				String b = result2.getString("date");
				String c = result2.getString("type");
				String d = result2.getString("money");
				transactionHistoryTableModel.addRow(new String[]{a, b, c, d, "", ""});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JTable historyTable = new JTable(transactionHistoryTableModel);

		upperTransaction.add(historyTable);


		transactionHistoryInterface.setLocationRelativeTo(null); // centers frame on screen
		transactionHistoryInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        transactionHistoryInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		transactionHistoryInterface.setTitle("Transaction History");
		transactionHistoryInterface.setVisible(true);
	}
	public void movieInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		movieInterface = new JFrame();
		movieInterface.setSize(600, 200);
		JPanel upperMovie = new JPanel();
		upperMovie.setLayout(new BoxLayout(upperMovie,BoxLayout.Y_AXIS));
		upperMovie.setOpaque(false);

		JPanel lowerMovie = new JPanel();
		lowerMovie.setOpaque(false);

		JPanel lowerRight = new JPanel();
		lowerRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		lowerRight.setOpaque(false);

		movieTable = new JTable();
		movieTableModel = new DefaultTableModel(new String[]{"Id", "Title", "Rating", "Production Year"}, 0);

		JButton updateTable = new JButton("Update");
		updateTable.setFont(newFont);
		UpdateTableHandler updateTableHandler = new UpdateTableHandler();
		updateTable.addActionListener(updateTableHandler);

		JLabel yearFrom = new JLabel("Years from ");
		lessYear = new JTextField(4);
		JLabel toYear = new JLabel(" to ");
		moreYear = new JTextField(4);

		JButton showReview = new JButton("Show Review For");
		showReview.setFont(newFont);
		ShowReviewHandler showReviewHandler = new ShowReviewHandler();
		showReview.addActionListener(showReviewHandler);

		showReviewModel = new DefaultComboBoxModel();


		movieInterface.getContentPane().add(upperMovie,BorderLayout.NORTH);

		try{
			connection = DriverManager.getConnection("jdbc:mysql://cs174a.engr.ucsb.edu:3306/moviesDB", USER, PWD);
			statement = connection.createStatement();
			String QUERY = "SELECT id, title, rating, production_year FROM Movies";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				String a = result.getString("id");
				String b = result.getString("title");
				String c = result.getString("rating");
				String d = result.getString("production_year");
				showReviewModel.addElement(a);
				movieTableModel.addRow(new String[]{a, b, c, d});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		showReviewOptions = new JComboBox(showReviewModel);

		movieTable.setModel(movieTableModel);

		lowerRight.add(showReview);
		lowerRight.add(showReviewOptions);
		lowerMovie.add(yearFrom);
		lowerMovie.add(lessYear);
		lowerMovie.add(toYear);
		lowerMovie.add(moreYear);
		lowerMovie.add(updateTable);
		lowerMovie.add(lowerRight);
		upperMovie.add(movieTable);
		upperMovie.add(lowerMovie,BorderLayout.SOUTH);


		movieInterface.addWindowListener(new java.awt.event.WindowAdapter() {
		@Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
	            traderInterface.setVisible(true);
	    }});

		movieInterface.setLocationRelativeTo(null); // centers frame on screen
		movieInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        movieInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		movieInterface.setTitle("Movie Database");
		movieInterface.setVisible(true);

	}
	public void showReviewInterface(String x)
	{
		Connection connection = null;
		Statement statement = null;
		JFrame showReviewInterface = new JFrame();
		showReviewInterface.setSize(400, 300);
		JPanel upperReview = new JPanel();
		upperReview.setLayout(new BoxLayout(upperReview,BoxLayout.Y_AXIS));
		upperReview.setOpaque(false);
		DefaultTableModel reviewTableModel = new DefaultTableModel(new String[]{"Id", "Author", "Review"}, 0);
		try{
			connection = DriverManager.getConnection("jdbc:mysql://cs174a.engr.ucsb.edu:3306/moviesDB", USER, PWD);
			statement = connection.createStatement();
			String QUERY = "SELECT id, author, review FROM Reviews WHERE movie_id = '" + x + "'";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				String a = result.getString("id");
				String c = result.getString("author");
				String d = result.getString("review");
				reviewTableModel.addRow(new String[]{a, c, d});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JTable reviewTable = new JTable(reviewTableModel);
		showReviewInterface.getContentPane().add(upperReview,BorderLayout.NORTH);
		upperReview.add(reviewTable);
		showReviewInterface.setLocationRelativeTo(null); // centers frame on screen
		showReviewInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showReviewInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		showReviewInterface.setTitle("Reviews");
		showReviewInterface.setVisible(true);

	}
	public void managerInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		managerInterface = new JFrame();
		managerInterface.setSize(400, 300);

		JPanel upperManager = new JPanel();
		upperManager.setLayout(new BoxLayout(upperManager,BoxLayout.Y_AXIS));
		upperManager.setOpaque(false);

		JPanel genMonthlyStatementPanel = new JPanel();
		//genMonthlyStatementPanel.setLayout(new BoxLayout(genMonthlyStatementPanel,BoxLayout.Y_AXIS));
		genMonthlyStatementPanel.setOpaque(false);

		JPanel customerReportPanel = new JPanel();
		customerReportPanel.setOpaque(false);

		List<String> customerList = new ArrayList<String>();
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "Select username from customer_profile";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				customerList.add(result.getString("username"));
			}

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		String[] customersText = customerList.toArray(new String[customerList.size()]);;
		customersOptions1 = new JComboBox<String>(customersText);
		customersOptions2 = new JComboBox<String>(customersText);


		JButton  addInterestButton = new JButton("Add Interest");
		addInterestButton.setFont(newFont);
		AddInterestHandler addInterestHandler = new AddInterestHandler();
		addInterestButton.addActionListener(addInterestHandler);

		JButton  genMonthlyStatementButton = new JButton("Generate Monthly Statement");
		genMonthlyStatementButton.setFont(newFont);
		GenMonthlyStatementHandler genMonthlyStatementHandler = new GenMonthlyStatementHandler();
		genMonthlyStatementButton.addActionListener(genMonthlyStatementHandler);

		JButton  listActiveCustomersButton = new JButton("List Active Customers");
		listActiveCustomersButton.setFont(newFont);
		ListActiveCustomersHandler listActiveCustomersHandler = new ListActiveCustomersHandler();
		listActiveCustomersButton.addActionListener(listActiveCustomersHandler);

		JButton  genDTERButton = new JButton("Generate Government DTER");
		genDTERButton.setFont(newFont);
		GenDTERHandler genDTERHandler = new GenDTERHandler();
		genDTERButton.addActionListener(genDTERHandler);

		JButton  customerReportButton = new JButton("Customer Report");
		customerReportButton.setFont(newFont);
		CustomerReportHandler customerReportHandler = new CustomerReportHandler();
		customerReportButton.addActionListener(customerReportHandler);

		JButton  deleteTransactionsButton = new JButton("Delete Transactions");
		deleteTransactionsButton.setFont(newFont);
		DeleteTransactionsHandler deleteTransactionsHandler = new DeleteTransactionsHandler();
		deleteTransactionsButton.addActionListener(deleteTransactionsHandler);

		JButton  debugInterfaceButton = new JButton("Debug Interface");
		debugInterfaceButton.setFont(newFont);
		DebugInterfaceHandler debugInterfaceHandler = new DebugInterfaceHandler();
		debugInterfaceButton.addActionListener(debugInterfaceHandler);

		managerInterface.getContentPane().add(upperManager,BorderLayout.NORTH);

		upperManager.add(addInterestButton);
		genMonthlyStatementPanel.add(genMonthlyStatementButton);
		genMonthlyStatementPanel.add(customersOptions1);
		customersOptions1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperManager.add(genMonthlyStatementPanel);
		upperManager.add(listActiveCustomersButton);
		upperManager.add(genDTERButton);
		customerReportPanel.add(customerReportButton);
		customerReportPanel.add(customersOptions2);
		customersOptions2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperManager.add(customerReportPanel);
		upperManager.add(deleteTransactionsButton);
		upperManager.add(debugInterfaceButton);

		addInterestButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		listActiveCustomersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		genDTERButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteTransactionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		debugInterfaceButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		managerInterface.addWindowListener(new java.awt.event.WindowAdapter() {
		@Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent)
	    {
	            login.setVisible(true);
	    }});
		managerInterface.setLocationRelativeTo(null); // centers frame on screen
		managerInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        managerInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		managerInterface.setTitle("Manager Interface");
		managerInterface.setVisible(true);

	}
	public void genMonthlyStatementInterface()
	{
		Connection connection = null;
		Statement statement = null;

		JFrame genMonthlyStatementInterface = new JFrame();
		genMonthlyStatementInterface.setSize(450, 200);
		JPanel upperMonthlyStatement = new JPanel();
		upperMonthlyStatement.setLayout(new BoxLayout(upperMonthlyStatement,BoxLayout.Y_AXIS));
		upperMonthlyStatement.setOpaque(false);
		DefaultTableModel genMonthlyStatementModel = new DefaultTableModel(new String[]{"Spacing", "Tid", "Date", "Stock", "Price", "Amount", "Type"}, 0);

		genMonthlyStatementInterface.getContentPane().add(upperMonthlyStatement,BorderLayout.NORTH);
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			genMonthlyStatementModel.addRow(new String[]{"Name", "Email", "Initial balance", "Final balance" , "Earnings" , "Commissions Paid", ""});
			String getCustInfo = "SELECT c.email, c.name, m.initial_balance, m.balance, m.earnings, count(b.Tid) as numBS FROM customer_profile c, market_stock_account m, transaction t, buy_sell b WHERE c.username = '" + ((String)customersOptions1.getSelectedItem()) + "' AND c.username = m.username AND m.aid = t.Aid AND t.Tid = b.Tid";
			ResultSet getCustInfoResult = statement.executeQuery(getCustInfo);
			if(getCustInfoResult.next())
			{
				//int x = Integer.parseInt(getCustInfoResult.getString("numBS"));
				genMonthlyStatementModel.addRow(new String[]{getCustInfoResult.getString("name"), getCustInfoResult.getString("email"), getCustInfoResult.getString("initial_balance"), getCustInfoResult.getString("balance") , getCustInfoResult.getString("earnings") , "$" + String.valueOf(Integer.parseInt(getCustInfoResult.getString("numBS")) * 20) , ""});
			}
			String QUERY = "SELECT t.Tid, t.date, b.stock_name, b.price, b.amount, b.type FROM transaction t, buy_sell b, market_stock_account m WHERE t.Tid = b.Tid AND m.username = '" + ((String)customersOptions1.getSelectedItem()) + "' AND m.Aid = t.Aid";			
			ResultSet result = statement.executeQuery(QUERY);
			genMonthlyStatementModel.addRow(new String[]{"Stock Accounts", "", "", "" , "" , "", ""});
			while(result.next()){
				String a = result.getString("Tid");
				String b = result.getString("date");
				String c = result.getString("stock_name");
				String d = result.getString("price");
				String e = result.getString("amount");
				String f = result.getString("type");
				genMonthlyStatementModel.addRow(new String[]{"", a, b, f, c, d, e});
			}
			genMonthlyStatementModel.addRow(new String[]{"Market Account", "", "", "" , "" , "", ""});
			String QUERY2 = "SELECT t.Tid, t.date, w.type, w.money FROM transaction t, withdraw_deposit w, market_stock_account m WHERE t.Tid = w.Tid AND m.username = '" + ((String)customersOptions1.getSelectedItem()) + "' AND m.Aid = t.Aid";			
			ResultSet result2 = statement.executeQuery(QUERY2);
			while(result2.next())
			{
				String a = result2.getString("Tid");
				String b = result2.getString("date");
				String c = result2.getString("type");
				String d = result2.getString("money");
				genMonthlyStatementModel.addRow(new String[]{"", a, b, c, d, "", ""});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JTable monthlyStatementTable = new JTable(genMonthlyStatementModel);

		upperMonthlyStatement.add(monthlyStatementTable);


		genMonthlyStatementInterface.setLocationRelativeTo(null); // centers frame on screen
		genMonthlyStatementInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        genMonthlyStatementInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		genMonthlyStatementInterface.setTitle("Monthly Statement");
		genMonthlyStatementInterface.setVisible(true);
	}
	public void customerReportInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		JFrame customerReportInterface = new JFrame();
		customerReportInterface.setSize(400, 300);
		JPanel upperCustomerReport = new JPanel();
		upperCustomerReport.setLayout(new BoxLayout(upperCustomerReport,BoxLayout.Y_AXIS));
		upperCustomerReport.setOpaque(false);
		DefaultTableModel customerReportModel = new DefaultTableModel(new String[]{"Aid", "Balance", "Stock", "Quantity", "bought_price"}, 0);
		customerReportModel.addRow(new String[]{"Aid", "Balance", "Stock", "Quantity", "Bought Price"});
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String userReportName = (String)customersOptions2.getSelectedItem();
			String QUERY = "SELECT aid, balance FROM market_stock_account WHERE username='" + userReportName + "'";
			ResultSet result = statement.executeQuery(QUERY);

			while(result.next())
			{
				customerReportModel.addRow(new String[]{result.getString("aid"), result.getString("balance"), "", "", ""});
			}
			String getUserStocks = "SELECT a.stock_symbol, a.bought_price, a.number_of_shares FROM customer_profile c, account_stock a WHERE c.username='" + userReportName + "' AND c.taxid = a.taxID";
			ResultSet getUserStocksResults = statement.executeQuery(getUserStocks);
			while(getUserStocksResults.next())
			{
				customerReportModel.addRow(new String[]{"", "", getUserStocksResults.getString("stock_symbol"), getUserStocksResults.getString("number_of_shares"), getUserStocksResults.getString("bought_price")});
			}

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JTable customReportTable = new JTable(customerReportModel);
		customerReportInterface.getContentPane().add(upperCustomerReport,BorderLayout.NORTH);
		upperCustomerReport.add(customReportTable);
		customerReportInterface.setLocationRelativeTo(null); // centers frame on screen
		customerReportInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        customerReportInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		customerReportInterface.setTitle("Customer Report");
		customerReportInterface.setVisible(true);
	}
	public void debugInterface()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;

		debugInterface = new JFrame();
		debugInterface.setSize(350, 300);

		JPanel upperDebug = new JPanel();
		upperDebug.setLayout(new BoxLayout(upperDebug,BoxLayout.Y_AXIS));
		upperDebug.setOpaque(false);

		JPanel setStockPricePanel = new JPanel();
		setStockPricePanel.setOpaque(false);

		JPanel setDatePanel = new JPanel();
		setDatePanel.setOpaque(false);

		JButton  openMarketButton = new JButton("Open Market");
		openMarketButton.setFont(newFont);
		OpenMarketHandler openMarketHandler = new OpenMarketHandler();
		openMarketButton.addActionListener(openMarketHandler);

		JButton  closeMarketButton = new JButton("Close Market");
		closeMarketButton.setFont(newFont);
		CloseMarketHandler closeMarketHandler = new CloseMarketHandler();
		closeMarketButton.addActionListener(closeMarketHandler);

		JButton  setStockPriceButton = new JButton("Set Stock Price");
		setStockPriceButton.setFont(newFont);
		SetStockPriceHandler setStockPriceHandler = new SetStockPriceHandler();
		setStockPriceButton.addActionListener(setStockPriceHandler);

		List<String> stockNameList = new ArrayList<String>();
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "Select symbol from stocks";
			String QUERY2 = "Select stock_symbol, number_of_shares, bought_price from customer_profile c, account_stock a where c.taxid = a.taxID and c.username ='" + user.getText() + "'";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				stockNameList.add(result.getString("symbol"));
			}

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		String[] stockNameText = stockNameList.toArray(new String[stockNameList.size()]);
		stockDebugOptions = new JComboBox<String>(stockNameText);
		JLabel dollarSign = new JLabel("$");
		stockPriceDebug = new JTextField(4);

		JButton  setDateButton = new JButton("Set Date");
		setDateButton.setFont(newFont);
		SetDateHandler setDateHandler = new SetDateHandler();
		setDateButton.addActionListener(setDateHandler);

		dateDebug = new JTextField(6);

		debugInterface.getContentPane().add(upperDebug,BorderLayout.NORTH);

		upperDebug.add(openMarketButton);
		upperDebug.add(closeMarketButton);
		setStockPricePanel.add(setStockPriceButton);
		setStockPricePanel.add(stockDebugOptions);
		setStockPricePanel.add(dollarSign);
		setStockPricePanel.add(stockPriceDebug);
		stockDebugOptions.setLayout(new FlowLayout(FlowLayout.RIGHT));
		dollarSign.setLayout(new FlowLayout(FlowLayout.RIGHT));
		stockPriceDebug.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperDebug.add(setStockPricePanel);
		setDatePanel.add(setDateButton);
		setDatePanel.add(dateDebug);
		dateDebug.setLayout(new FlowLayout(FlowLayout.RIGHT));
		upperDebug.add(setDatePanel);

		openMarketButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		closeMarketButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		debugInterface.setLocationRelativeTo(null); // centers frame on screen
		debugInterface.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        debugInterface.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		debugInterface.setTitle("Debug Interface");
		debugInterface.setVisible(true);
	}
	public class SubmitButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}catch (ClassNotFoundException ev) {
					ev.printStackTrace();
				}
				Connection connection = null;
				Statement statement = null;
				String user_input = user.getText();
				try{
					connection = DriverManager.getConnection(HOST, USER, PWD);
					statement = connection.createStatement();
					String input_pass = new String(pass.getPassword());
					String QUERY;
					Boolean traderOrAdmin = "Trader".equals((String)signInAsField.getSelectedItem());
					if(traderOrAdmin)
					{
						QUERY = "SELECT username, password from customer_profile where username ='" + user_input + "' and password='" + input_pass + "'" ;
					}
					else
					{
						QUERY = "SELECT username, password from admin where username ='" + user_input + "' and password='" + input_pass + "'" ;
					}
					ResultSet result = statement.executeQuery(QUERY);

					if(result.next()) {
						repaint();
						login.setVisible(false);
						if(traderOrAdmin)
							traderInterface();
						else
							managerInterface();
						user.requestFocusInWindow();
					}
					else
						JOptionPane.showMessageDialog(null, "incorrect password and/or username");


				}catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
						try {
							statement.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if (connection != null){
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			return;
		}
    }
    public class createAccountButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		 login.dispose();
		 createAccountInterface();
		return;
		}
    }
    public class BuyOrSellHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {  
		if(("buy".equals((String)buyOrSell.getSelectedItem())))
		{
			buySellStockOptions.setModel(buyStockModel);
		}
		else
		{
			buySellStockOptions.setModel(sellStockModel);
		}
		return;
		}
    }
    public class submitAccountInformationHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		JOptionPane.showMessageDialog(null, "submitting...");

			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch (ClassNotFoundException ev) {
				ev.printStackTrace();
			}
			Connection connection = null;
			Statement statement = null;
			try{
				connection = DriverManager.getConnection(HOST, USER, PWD);
				statement = connection.createStatement();
				String input_pass = new String(pass.getPassword());
				String QUERY = "insert into customer_profile values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String QUERY2 = "select taxid from customer_profile where taxid='" + tax_idField.getText() + "'";
				ResultSet result = statement.executeQuery(QUERY2);
				PreparedStatement prep = connection.prepareStatement(QUERY);
				prep.setString(1, nameField.getText());
				prep.setString(2, user.getText());
				prep.setString(3, input_pass);
				prep.setString(4, addressField.getText());
				prep.setString(5, stateField.getText());
				prep.setString(6, phoneField.getText());
				prep.setString(7, emailField.getText());
				prep.setString(8, tax_idField.getText());
				prep.setString(9, "filler"); //fix this so we can have unique ssns

				if(result.next())
					System.out.println("taxid has already been used");
				else
					prep.execute();

			}catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
					try {
						statement.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (connection != null){
					try {
						connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			return;
		}
    }
    public class DepositWithdrawalHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String QUERY = "Select balance from market_stock_account where username ='" + user.getText() + "' and account_type = 'market'";
			String QUERY2;
			ResultSet result = statement.executeQuery(QUERY);


			if(result.next()){
				String selectedOption = (String) depositWithdrawalOptions.getSelectedItem();
				double sum;
				if(selectedOption == "Deposit") //need to ask what the string is here
					sum = result.getDouble("balance") + Double.parseDouble(depositWithdrawalAmount.getText());
				else
					sum = result.getDouble("balance") - Double.parseDouble(depositWithdrawalAmount.getText());
				QUERY2 = "update market_stock_account set balance =" + sum + " where username ='" + user.getText() +"' and account_type='market'";
				//this will update all market accounts with the same username to the same balance. probably not intended
				//especially if they have more than one market account, but might not matter
				PreparedStatement prep = connection.prepareStatement(QUERY2);
				prep.executeUpdate(); //hopefully this works

				String QUERY7 = "insert into transaction(date, aid) select c.date, m.aid from currentTime c, market_stock_account m, customer_profile cp where cp.username = m.username and cp.username ='" + user.getText() + "'";
				PreparedStatement prep3 = connection.prepareStatement(QUERY7);
				prep3.executeUpdate(); //hopefully this works

				String QUERY5 = "select tid from transaction where tid not in (select tid from buy_sell) and tid not in (select tid from withdraw_deposit) and tid not in(select tid from accrue_interest)";
				ResultSet result3 = statement.executeQuery(QUERY5);

				while(result3.next()){
					String QUERY6 = "insert into withdraw_deposit(Tid, date, money, type) select " + result3.getInt("tid") + ", c.date, " + Double.parseDouble(depositWithdrawalAmount.getText()) + ", '" + selectedOption + "' from currentTime c";
					PreparedStatement prep2 = connection.prepareStatement(QUERY6);
					prep2.execute(); //hopefully this works
				}
				JOptionPane.showMessageDialog(null, "balance updated");
			}
			else
				System.out.println("this account has no balance");


		}catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Invalid Withdraw");
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		depositWithdrawalAmount.setText("");
		return;
		}
    }
    public class BuySellButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY8 = "select OpenOrClose from OpenCloseMarket";
			ResultSet result8 = statement.executeQuery(QUERY8);
			String openTime = "";
			if(result8.next())
				openTime = result8.getString("OpenOrClose");
			System.out.println(openTime);
			if(openTime.compareTo("open") == 0){
			String buyOrSellOption = (String)buyOrSell.getSelectedItem();
			if(buyOrSellOption == "buy") {
				String buyOption = (String) buySellStockOptions.getSelectedItem();
				double stockQT = Double.parseDouble(stockAmount.getText());
				String QUERY = "select c.taxid, s.symbol, s.current_price from customer_profile c, stocks s, account_stock a where c.username ='" + user.getText() + "' and c.taxid = a.taxID and a.stock_symbol='" + buyOption + "' and a.stock_symbol = s.symbol and a.bought_price = s.current_price";
				ResultSet result = statement.executeQuery(QUERY);
				//also need to generate a transaction id for the new buy or sell (probably use a trigger for this)
				if (result.next()) {
					//update shares if all the info matches
					//System.out.println("update");

					String QUERY2 = "update account_stock set number_of_shares = number_of_shares + " + stockQT + " where stock_symbol ='" + buyOption + "' and taxID ='" + result.getString("taxid") + "' and bought_price = '" + result.getString("current_price") + "'";
					PreparedStatement prep = connection.prepareStatement(QUERY2);
					prep.executeUpdate(); //hopefully this works
				} else {
					//System.out.println("insert");
					//insert if no matches are found
					String QUERY3 = "select c.taxid, s.current_price from customer_profile c, stocks s where c.username ='" + user.getText() + "' and s.symbol ='" + buyOption + "'";
					ResultSet result2 = statement.executeQuery(QUERY3);
					String QUERY4;
					if (result2.next()) {
						Double temp = Double.parseDouble(stockAmount.getText());
						QUERY4 = "insert into account_stock values('" + result2.getString("taxid") + "','" + result2.getDouble("current_price") + "','" + buyOption + "','" + temp + "')";
						PreparedStatement prep2 = connection.prepareStatement(QUERY4);
						prep2.execute(); //hopefully this works
					}
				}
				String QUERY5 = "select tid from transaction where tid not in (select tid from buy_sell) and tid not in (select tid from withdraw_deposit) and tid not in(select tid from accrue_interest)";
				ResultSet result3 = statement.executeQuery(QUERY5);

				while(result3.next()){
					String QUERY6 = "insert into buy_sell(Tid, stock_name, date, price, amount, type) select " + result3.getInt("tid") +",'" + buyOption + "', c.date, s.current_price, " + stockQT + ", 'buy' from stocks s, currentTime c where s.symbol='" + buyOption +"'";
					PreparedStatement prep2 = connection.prepareStatement(QUERY6);
					prep2.execute(); //hopefully this works
				}

			}
			else { //sell
				String stockToSell = ((String) buySellStockOptions.getSelectedItem()).substring(0, 3);
				String buyOption = (String) buySellStockOptions.getSelectedItem();
				//System.out.println(stockToSell);
				String taxId = "";
				double stockQT = Double.parseDouble(stockAmount.getText());
				String QUERY34 = "SELECT c.taxid FROM customer_profile c WHERE c.username ='" + user.getText() + "'";
				ResultSet result34 = statement.executeQuery(QUERY34);
				if (result34.next()) {
					taxId = result34.getString("taxID");
					//String getSharesAmount = "SELECT number_of_shares FROM account_stock WHERE taxID = '" + taxId + "' AND stock_symbol = '" + stockToSell + "'";
					//ResultSet resultShareAmount = statement.executeQuery(getSharesAmount);
					String currentStockPrice = "SELECT current_price FROM stocks WHERE symbol = '" + stockToSell + "'";
					ResultSet result2 = statement.executeQuery(currentStockPrice);
					double currentPrice = 0;
					String stocksBoughtPrice = buyOption.substring(buyOption.indexOf("$") + 1,buyOption.length());
					double numVer = Double.parseDouble(stocksBoughtPrice);
					System.out.println(stocksBoughtPrice);
					if (result2.next())
						currentPrice = result2.getDouble("current_price");
					String QUERY24 = "UPDATE account_stock SET number_of_shares = number_of_shares - " + stockQT + " WHERE stock_symbol ='" + stockToSell + "' and taxID ='" + taxId + "' and bought_price=" + numVer;
					//String QUERY3 = "UPDATE market_stock_account SET balance = balance +'" + (currentPrice * stockQT - 20) + "' WHERE username = '" + user.getText() + "'";
					PreparedStatement prep = connection.prepareStatement(QUERY24);
					prep.executeUpdate();

					//earnings
					double totalCost = numVer * stockQT;
					String QUERYEarning = "update market_stock_account set earnings = earnings + (" + currentPrice + "*" + stockQT + ") - " + totalCost + "where username='" + user.getText() + "'";
					PreparedStatement prep3 = connection.prepareStatement(QUERYEarning);
					prep3.executeUpdate();

					String QUERY5 = "select tid from transaction where tid not in (select tid from buy_sell) and tid not in (select tid from withdraw_deposit) and tid not in(select tid from accrue_interest)";
					ResultSet result3 = statement.executeQuery(QUERY5);

					while (result3.next()) {
						String QUERY7 = "insert into buy_sell(Tid, stock_name, date, price, amount, type) select " + result3.getInt("tid") + ",'" + stockToSell + "', c.date, s.current_price, " + stockQT + ", 'sell' from stocks s, currentTime c where s.symbol='" + stockToSell + "'";
						PreparedStatement prep7 = connection.prepareStatement(QUERY7);
						prep7.execute(); //hopefully this works
					}


				} else {
					System.out.println("Error");
				}
			}


			}
			else
				JOptionPane.showMessageDialog(null, "market is closed");


		}
		catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error could not complete transaction");
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		List<String> stockPriceList = new ArrayList<String>();
		List<String> stockOwnedList = new ArrayList<String>();

		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "Select symbol from stocks";
			String QUERY2 = "Select a.stock_symbol, a.number_of_shares, a.bought_price from customer_profile c, account_stock a where c.taxid = a.taxID and c.username ='" + user.getText() + "'";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				stockPriceList.add(result.getString("symbol"));
			}
			ResultSet result2 = statement.executeQuery(QUERY2);
			while(result2.next()){
				String temp = result2.getString("stock_symbol") + " " + result2.getString("number_of_shares") + " @ $" + result2.getString("bought_price");
				stockOwnedList.add(temp);
			}


		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		String[] stockPriceText = stockPriceList.toArray(new String[stockPriceList.size()]);
		String[] sellStockText = stockOwnedList.toArray(new String[stockOwnedList.size()]);

		sellStockModel = new DefaultComboBoxModel<String>(sellStockText);
		JOptionPane.showMessageDialog(null, "Transaction Complete");
		return;
		}
    }
    public class BalanceButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String QUERY = "Select balance from market_stock_account where username ='" + user.getText() + "' and account_type = 'market'";
			ResultSet result = statement.executeQuery(QUERY);
			if(result.next())
				balance.setText("$" + result.getString("balance"));
			else
				System.out.println("no market account found");

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return;
		}
    }
    public class TransactionHistoryButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		transactionHistoryInterface();
		return;
		}
    }
    public class StockPriceButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		actorProfileInterface();
		return;
		}
    }
    public class MovieInfoButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		traderInterface.setVisible(false);
		movieInterface();
		return;
		}
    }
    public class AddInterestHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		Statement statement2 = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			statement2 = connection.createStatement();

			String QUERY = "select aid, average_balance from market_stock_account";
			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				double interestRate = ((result.getDouble("average_balance")/31) * .03);
				//calculate interest
				String QUERY7 = "insert into transaction(date, aid) select date, " + result.getInt("aid") + "  from currentTime";
				PreparedStatement prep7 = connection.prepareStatement(QUERY7);
				prep7.execute(); //hopefully this works


				String QUERY5 = "select tid from transaction where tid not in (select tid from buy_sell) and tid not in (select tid from withdraw_deposit) and tid not in(select tid from accrue_interest)";
				ResultSet result3 = statement2.executeQuery(QUERY5);


				while(result3.next()){
					String QUERY6 = "insert into accrue_interest(Tid, date, interest) select " + result3.getInt("tid") + ", c.date, " + interestRate + "from currentTime c";
					PreparedStatement prep2 = connection.prepareStatement(QUERY6);
					prep2.execute(); //hopefully this works
				}

				//add into balance and earnings
				String updateBalance = "update market_stock_account set balance = balance + " + interestRate + ", earnings = earnings + " + interestRate + "where aid=" + result.getInt("aid");
				PreparedStatement prep5 = connection.prepareStatement(updateBalance);
				prep5.execute(); //hopefully this works
			}




		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (statement2 != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return;
		}
    }
    public class GenMonthlyStatementHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		genMonthlyStatementInterface();
		return;
		}
    }
    public class ListActiveCustomersHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		Connection connection = null;
		Statement statement = null;
		String resultstring = "";
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "SELECT t.Aid FROM transaction t, buy_sell b WHERE t.Tid = b.Tid GROUP BY t.Aid HAVING sum(b.amount) > 1000";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				resultstring += result.getString("Aid") + "\n";
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null, resultstring);
		return;
		}
    }
    public class GenDTERHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		Connection connection = null;
		Statement statement = null;
		String resultstring = "";
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
			String QUERY = "SELECT c.username, c.state FROM customer_profile c, market_stock_account m WHERE c.username = m.username AND m.earnings > 10000";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				resultstring += result.getString("username") + "      " +result.getString("state") + "\n";
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null, resultstring);
		return;
		}
    }
    public class CustomerReportHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		customerReportInterface();
		return;
		}
    }
    public class DeleteTransactionsHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
			Connection connection = null;
			Statement statement = null;
			try{
				connection = DriverManager.getConnection(HOST, USER, PWD);
				statement = connection.createStatement();
				String input_pass = new String(pass.getPassword());
				String QUERY = "DELETE FROM transaction";
				PreparedStatement prep = connection.prepareStatement(QUERY);
				prep.execute();

				}catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
						try {
							statement.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					if (connection != null){
						try {
							connection.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			JOptionPane.showMessageDialog(null, "Transaction Deleted");
		return;
		}
    }
    public class DebugInterfaceHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		debugInterface();
		return;
		}
    }
    public class OpenMarketHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String QUERY = "update OpenCloseMarket set OpenOrClose ='open'";
			PreparedStatement prep = connection.prepareStatement(QUERY);
			prep.executeUpdate();


		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return;
		}
    }
    public class CloseMarketHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			//should update the date?
			String QUERY = "update OpenCloseMarket set OpenOrClose ='close'";
			PreparedStatement prep = connection.prepareStatement(QUERY);
			prep.executeUpdate();
			String QUERY2 = "update stocks set closing_price = current_price";
			PreparedStatement prep2 = connection.prepareStatement(QUERY2);
			prep2.executeUpdate();

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return;
		}
    }
    public class SetStockPriceHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String selectedStock = (String)stockDebugOptions.getSelectedItem();
			Double temp = Double.parseDouble(stockPriceDebug.getText());
			String QUERY = "update stocks set current_price='" + temp + "' where symbol ='" + selectedStock +"'"; //~change the values inside
			PreparedStatement prep = connection.prepareStatement(QUERY);
			prep.executeUpdate();


		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Stock price set");
		return;
		}
    }
    public class SetDateHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ev) {
			ev.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try{
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();

			String oldDate = "select date from currentTime";
			ResultSet dateResult = statement.executeQuery(oldDate);

			Integer dateOld = 0;
			if(dateResult.next()){
				dateOld = Integer.parseInt(dateResult.getString("date").substring(3, 5));
			}
			Integer dateNew = Integer.parseInt(dateDebug.getText().substring(3,5));

			Integer timeDiff = dateNew - dateOld;
			String QUERY = "update currentTime set date='" + dateDebug.getText() + "'";
			PreparedStatement prep = connection.prepareStatement(QUERY);
			prep.executeUpdate();

			System.out.println(timeDiff);
			//update average balance
			String avgBalance = "update market_stock_account set average_balance = average_balance + (balance * " + timeDiff + ")";
			PreparedStatement prep4 = connection.prepareStatement(avgBalance);
			prep4.executeUpdate();

		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Date Set");
		return;
		}
    }
    public class UpdateTableHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) { 
		Connection connection = null;
		Statement statement = null;
		movieTableModel = new DefaultTableModel(new String[]{"Id", "Title", "Rating", "Production Year"}, 0); 
		try{
			connection = DriverManager.getConnection("jdbc:mysql://cs174a.engr.ucsb.edu:3306/moviesDB", USER, PWD);
			statement = connection.createStatement();

			String QUERY = "SELECT id, title, rating, production_year FROM Movies WHERE production_year >= '" + lessYear.getText() + "' AND  production_year <= '" + moreYear.getText() + "' AND rating = 5";

			ResultSet result = statement.executeQuery(QUERY);

			while(result.next()){
				String a = result.getString("id");
				String b = result.getString("title");
				String c = result.getString("rating");
				String d = result.getString("production_year");
				showReviewModel.addElement(a);
				movieTableModel.addRow(new String[]{a, b, c, d});
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if (statement != null) {		//shouldnt be necessary if i could find the right place to throw exceptions
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		movieTable.setModel(movieTableModel);
		return;
		}
    }
    public class ShowReviewHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {  
		showReviewInterface((String)showReviewOptions.getSelectedItem());
		return;
		}
    }
}