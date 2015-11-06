package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import logic.Game;
import logic.typeOfBets.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import javax.swing.SpinnerNumberModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnRoulette;
	private JMenuItem mntmNewGame;
	private JMenuItem mntmNewPlayer;
	private JMenuItem mntmExit;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JLabel lblPlayerName;
	private Game game;
	private JComboBox cbTypeOfBet;
	private JComboBox cbAuxTypeOfBet;
	private JTextField jtStraightUp;
	private JButton btnBet;
	private JSpinner spAmount;
	private JButton btnNoMoreBets;
	private logic.Number number;
	private JTextField tfNumber;
	private JTextPane txEvenOdd;
	private JTextPane txRedBlack;
	private JScrollPane scrollPane;
	private JTable tbBets;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblMoney;
	private JLabel lblNewLabel;
	private JLabel lblTypeOfBet;
	private JLabel lblOption;
	private JLabel lblAmount;
	private JProgressBar process;
	private JProgressBar processEven;
	private JLabel lblRedblack;
	private JLabel lblEvenodd;
	private JSpinner spCorner1;
	private JSpinner spCorner2;
	private JSpinner spCorner3;
	private JSpinner spCorner4;
	private JTextField tfHotNumbers;
	private JTextField tfColdNumbers;
	private JLabel lblHotNumbers;
	private JLabel lbColdNumbers;
	private JPanel panel_2;
	private JLabel lblColor;
	//private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Roulette");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/icon175x175.png")));

		game=new Game("DefaultPlayer", Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 437);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		//contentPane.setBackground();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPlayerName());
		contentPane.add(getScrollPane());
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getLblMoney());
		contentPane.add(getLblNewLabel());
		contentPane.add(getPanel_2());
		//contentPane.add(getTbBet);
		//contentPane.add(getTbBets());

		representStatus();
	}

	private void newGame() {
		game=new Game("DefaultPlayer", Color.BLUE);
		process.setValue(50);
		processEven.setValue(50);
		tfNumber.setText("");
		representStatus();
		cbTypeOfBet.setSelectedIndex(0);
		cbAuxTypeOfBet.setSelectedIndex(0);
		tfColdNumbers.setText("");
		tfHotNumbers.setText("");

	}

	private void representStatus() {
		representMoney();
		if(this.game.getPlayer().getMoney()<=0){
			JOptionPane.showMessageDialog(null,"Game Over");
		}
		representBets();


	}

	private void representBets() {
		System.err.println(game.getPlayer().getBetsTable().getRowCount());
		tbBets.setModel(game.getPlayer().getBetsTable());
	}

	private void representMoney() {
		lblMoney.setText(String.valueOf(game.getPlayer().getMoney())+"\u20ac");
	}



	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnRoulette());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnRoulette() {
		if (mnRoulette == null) {
			mnRoulette = new JMenu("Roulette");
			mnRoulette.setSelectedIcon(new ImageIcon(MainWindow.class.getResource("/img/icon175x175.png")));
			mnRoulette.add(getMntmNewGame());
			mnRoulette.add(getMntmNewPlayer());
			mnRoulette.add(getMntmExit());
		}
		return mnRoulette;
	}
	private JMenuItem getMntmNewGame() {
		if (mntmNewGame == null) {
			mntmNewGame = new JMenuItem("New Game");
			mntmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNewGame.setMnemonic(KeyEvent.VK_N);
			mntmNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					newGame();
				}
			});
		}
		return mntmNewGame;
	}
	private JMenuItem getMntmNewPlayer() {
		if (mntmNewPlayer == null) {
			mntmNewPlayer = new JMenuItem("New Player");
			mntmNewPlayer.setEnabled(false);
		}
		return mntmNewPlayer;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.setMnemonic(KeyEvent.VK_E);
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setMnemonic(KeyEvent.VK_O);
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(contentPane, "Collaboration Project EII Oviedo - Universit� de Valenciennes", "About Roulette",JOptionPane.INFORMATION_MESSAGE);

				}
			});
		}
		return mntmAbout;
	}
	private JLabel getLblPlayerName() {
		if (lblPlayerName == null) {
			lblPlayerName = new JLabel(game.getPlayer().getName());
			lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPlayerName.setIcon(new ImageIcon(MainWindow.class.getResource("/img/icon_gameMode_single.png")));
			lblPlayerName.setBounds(460, 11, 184, 51);
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setForeground(game.getPlayer().getColor());
		}
		return lblPlayerName;
	}
	private JComboBox getCbTypeOfBet() {
		if (cbTypeOfBet == null) {
			cbTypeOfBet = new JComboBox<TypeOfBet>();
			cbTypeOfBet.setBounds(114, 15, 141, 20);
			cbTypeOfBet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TypeOfBet betSelected = (TypeOfBet) cbTypeOfBet.getSelectedItem();
					//String betSelected = String.valueOf(cbTypeOfBet.getSelectedItem());
					showBetOptions(betSelected);
				}
			});
			cbTypeOfBet.setModel(new DefaultComboBoxModel<TypeOfBet>(game.getBetsAvailable()));
		}
		return cbTypeOfBet;
	}
	protected void showBetOptions(TypeOfBet betSelected) {		
		showCbAux(betSelected);			

	}
	private void showCbAux(TypeOfBet betSelected) {
		if(betSelected instanceof Column){
			String[]cbAuxColumnsArray={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxColumnsArray));
			spCornerBetOff();
			cbAuxTypeOfBet.setVisible(true);	
		}
		else if(betSelected instanceof CornerBet){
			cbAuxTypeOfBet.setVisible(false);
			
			spCorner1.setEnabled(true);
			spCorner2.setEnabled(true);
			spCorner3.setEnabled(true);
			spCorner4.setEnabled(true);
			spCorner1.setVisible(true);
			spCorner2.setVisible(true);
			spCorner3.setVisible(true);
			spCorner4.setVisible(true);


			


		}
		else if(betSelected instanceof EvenOdd){
			String[]cbAuxEvenOddArray={"Even","Odd"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxEvenOddArray));
			spCornerBetOff();
			cbAuxTypeOfBet.setVisible(true);				
		}
		else if(betSelected instanceof RedBlack){
			String[] cbAuxRedBlackArray={"Red","Black"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxRedBlackArray));
			spCornerBetOff();
			cbAuxTypeOfBet.setVisible(true);
		}
		else if(betSelected instanceof StraightUp){
			String[]cbAuxStraightUpArray=new String[37];
			spCornerBetOff();
			for(int i=0;i<=36;i++){
				cbAuxStraightUpArray[i]=String.valueOf(i);
			}
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxStraightUpArray));
			cbAuxTypeOfBet.setVisible(true);
		}
		else if(betSelected instanceof FailedPassed){
			String[]cbAuxFailedPassedArray={"Failed (1-18)","Passed (19-36)"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxFailedPassedArray));
			spCornerBetOff();
			cbAuxTypeOfBet.setVisible(true);
		}
		else if(betSelected instanceof TwoDozen){
			spCornerBetOff();
			String[]cbAuxTwoDozenArray={"}"};///PENSAR COMO ELEGIR 2 COLUMNAS
		}

		else if(betSelected instanceof Dozen){
			spCornerBetOff();
			String[]cbAuxDozenArray={"0","1","3"};
			cbAuxTypeOfBet.setModel(new DefaultComboBoxModel<String>(cbAuxDozenArray));
			cbAuxTypeOfBet.setVisible(true);

		}



	}

	private void spCornerBetOff() {
		spCorner1.setEnabled(false);
		spCorner2.setEnabled(false);
		spCorner3.setEnabled(false);
		spCorner4.setEnabled(false);
		spCorner1.setVisible(false);
		spCorner2.setVisible(false);
		spCorner3.setVisible(false);
		spCorner4.setVisible(false);
		
	}

	private JComboBox getCbAuxTypeOfBet() {
		if (cbAuxTypeOfBet == null) {
			String[]cbAuxColumns={"Column 0","Column 1","Column 2"};
			cbAuxTypeOfBet = new JComboBox(cbAuxColumns);
			cbAuxTypeOfBet.setBounds(114, 56, 141, 20);
			cbAuxTypeOfBet.setVisible(true);
		}
		return cbAuxTypeOfBet;
	}
	private JTextField getJtStraightUp() {
		if (jtStraightUp == null) {
			jtStraightUp = new JTextField();
			jtStraightUp.setVisible(false);
			jtStraightUp.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			jtStraightUp.setBounds(167, 200, 114, 20);
			jtStraightUp.setColumns(10);
		}
		return jtStraightUp;
	}
	private JButton getBtnBet() {
		if (btnBet == null) {
			btnBet = new JButton("Bet");
			btnBet.setMnemonic(KeyEvent.VK_B);
			btnBet.setBounds(33, 131, 89, 23);
			btnBet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TypeOfBet betSelected = (TypeOfBet) cbTypeOfBet.getSelectedItem();
					int amount = Integer.parseInt((String) spAmount.getValue());
					if(betSelected instanceof Column){
						((Column) betSelected).setColomnBeted(cbAuxTypeOfBet.getSelectedIndex());

					}
					else if (betSelected instanceof CornerBet){
						try{
							((CornerBet)betSelected).setBetBoxes((int) spCorner1.getValue(),(int) spCorner2.getValue(),(int)spCorner3.getValue(),(int)spCorner4.getValue());
						}catch(Exception ex){
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
							
						}
					}
					else if(betSelected instanceof EvenOdd){
						((EvenOdd)betSelected).setType(cbAuxTypeOfBet.getSelectedIndex());
					}
					else if(betSelected instanceof RedBlack){
						String color=(String) cbAuxTypeOfBet.getSelectedItem();
						if(color.equals("Red")){
							((RedBlack)betSelected).setColor(Color.RED);
						}
						else if (color.equals("Black")){
							((RedBlack)betSelected).setColor(Color.BLACK);
						}
					}
					else if(betSelected instanceof StraightUp){
						((StraightUp)betSelected).setNumber((int) Integer.parseInt((String) cbAuxTypeOfBet.getSelectedItem()));

					}
					else if(betSelected instanceof FailedPassed){
						((FailedPassed)betSelected).setType((String) cbAuxTypeOfBet.getSelectedItem());
					}
					else if(betSelected instanceof Dozen){
						((Dozen)betSelected).setDozen(cbAuxTypeOfBet.getSelectedIndex());
					}

					if(!game.getPlayer().doABet(amount, betSelected))JOptionPane.showMessageDialog(null, "You don`t have money");;
					representMoney();
					representBets();
					btnNoMoreBets.setEnabled(true);

				}
			});
		}
		return btnBet;
	}
	private JSpinner getSpAmount() {
		if (spAmount == null) {
			spAmount = new JSpinner();
			spAmount.setBounds(114, 100, 141, 20);
			spAmount.setModel(new SpinnerListModel(new String[] {"5", "10", "50", "100", "500", "1000"}));
		}
		return spAmount;
	}

	private JButton getBtnNoMoreBets() {
		if (btnNoMoreBets == null) {
			btnNoMoreBets = new JButton("No more bets!");
			btnNoMoreBets.setMnemonic(KeyEvent.VK_N);
			btnNoMoreBets.setBounds(148, 131, 107, 23);
			btnNoMoreBets.setEnabled(false);
			btnNoMoreBets.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					number=game.turnTheWheel();
					tfNumber.setText(String.valueOf(number.getValue()));
					tfNumber.setForeground(number.getColor());



					btnNoMoreBets.setEnabled(false);
					representMoney();
					tfHotNumbers.setText(String.valueOf(game.getHotColdNumbers().subList(0, 3)));
					tfColdNumbers.setText(String.valueOf(game.getHotColdNumbers().subList(4, 7)));
					process.setValue((int) Math.round(game.getRedBlackStatistics().get(0)*100));
					processEven.setValue((int) Math.round(game.getEvenOddStatistics().get(0)*100));
					
					if(number.getColor().equals(Color.RED)){
						lblColor.setText("The Color is Red");
					}
					else if(number.getColor().equals(Color.BLACK)){
						lblColor.setText("The Color is Black");
					}
				}
			});
		}
		return btnNoMoreBets;
	}
	private JTextField getTfNumber() {
		if (tfNumber == null) {
			tfNumber = new JTextField();
			tfNumber.setBounds(10, 5, 220, 62);
			tfNumber.setHorizontalAlignment(SwingConstants.CENTER);
			tfNumber.setFont(new Font("Tahoma", Font.BOLD, 30));
			tfNumber.setBackground(new Color(153, 204, 255));
			tfNumber.setEditable(false);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
	private JTextPane getTxEvenOdd() {
		if (txEvenOdd == null) {
			txEvenOdd = new JTextPane();
			//txEvenOdd.setBounds(243, 50, 108, 63);
		}
		return txEvenOdd;
	}
	private JTextPane getTxRedBlack() {
		if (txRedBlack == null) {
			txRedBlack = new JTextPane();
			//txRedBlack.setBounds(10, 50, 108, 63);
		}
		return txRedBlack;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(349, 78, 375, 140);
			scrollPane.setViewportView(getTbBets());
		}
		return scrollPane;
	}
	private JTable getTbBets() {
		if (tbBets == null) {
			tbBets = new JTable(game.getPlayer().getBetsTable());
			tbBets.setEnabled(false);
			
		}
		return tbBets;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(102, 153, 204));
			panel.setBounds(10, 200, 285, 165);
			panel.setLayout(null);
			panel.add(getCbTypeOfBet());
			panel.add(getBtnBet());
			panel.add(getBtnNoMoreBets());
			panel.add(getSpAmount());
			panel.add(getLblTypeOfBet());
			panel.add(getLblOption());
			panel.add(getLblAmount());
			panel.add(getCbAuxTypeOfBet());
			panel.add(getSpCorner1());
			panel.add(getSpCorner2());
			panel.add(getSpCorner3());
			panel.add(getSpCorner4());
		}
		return panel;
	}
	private JProgressBar getRedBlackProcess() {
		if(process == null) {
			process = new JProgressBar();
			process.setValue(50);
			process.setForeground(Color.RED);
			process.setBackground(Color.BLACK);
			process.setBounds(21, 34, 150, 30);
			process.setStringPainted(true);
		}
		return process;
	}
	private JProgressBar getEvenOddProcess() {
		if(processEven == null) {
			processEven = new JProgressBar();
			processEven.setValue(50);
			processEven.setForeground(Color.ORANGE);
			processEven.setBackground(Color.CYAN);
			processEven.setBounds(215, 34, 150, 30);
			processEven.setStringPainted(true);
		}
		return processEven;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(349, 229, 375, 136);
			panel_1.setLayout(null);
			//panel_1.add(getTxRedBlack());
			panel_1.add(getEvenOddProcess());
			panel_1.add(getRedBlackProcess());
			panel_1.add(getLblRedblack());
			panel_1.add(getLblEvenodd());
			panel_1.add(getTfHotNumbers());
			panel_1.add(getTfColdNumbers());
			panel_1.add(getLblHotNumbers());
			panel_1.add(getLbColdNumbers());
		}
		return panel_1;
	}
	private JLabel getLblMoney() {
		if (lblMoney == null) {
			lblMoney = new JLabel("");
			lblMoney.setForeground(Color.WHITE);
			lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblMoney.setIcon(new ImageIcon(MainWindow.class.getResource("/img/image-2015-11-06 (1).png")));
			lblMoney.setBounds(349, 25, 120, 33);
		}
		return lblMoney;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Winner Number");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(30, 12, 265, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblTypeOfBet() {
		if (lblTypeOfBet == null) {
			lblTypeOfBet = new JLabel("Type of Bet:");
			lblTypeOfBet.setLabelFor(getCbTypeOfBet());
			lblTypeOfBet.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTypeOfBet.setDisplayedMnemonic('T');
			lblTypeOfBet.setDisplayedMnemonic(KeyEvent.VK_T);
			lblTypeOfBet.setBounds(10, 14, 94, 18);
		}
		return lblTypeOfBet;
	}
	private JLabel getLblOption() {
		if (lblOption == null) {
			lblOption = new JLabel("Option:");
			lblOption.setLabelFor(getCbAuxTypeOfBet());
			lblOption.setDisplayedMnemonic(KeyEvent.VK_O);
			lblOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOption.setBounds(10, 55, 56, 19);
		}
		return lblOption;
	}
	private JLabel getLblAmount() {
		if (lblAmount == null) {
			lblAmount = new JLabel("Amount:");
			lblAmount.setLabelFor(getSpAmount());
			lblAmount.setDisplayedMnemonic('A');
			lblAmount.setDisplayedMnemonic(KeyEvent.VK_A);
			lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAmount.setBounds(10, 103, 78, 14);
		}
		return lblAmount;
	}
	private JLabel getLblRedblack() {
		if (lblRedblack == null) {
			lblRedblack = new JLabel("Red/Black");
			lblRedblack.setHorizontalAlignment(SwingConstants.CENTER);
			lblRedblack.setBounds(21, 9, 150, 14);
		}
		return lblRedblack;
	}
	private JLabel getLblEvenodd() {
		if (lblEvenodd == null) {
			lblEvenodd = new JLabel("Even/Odd");
			lblEvenodd.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvenodd.setBounds(215, 9, 150, 14);
		}
		return lblEvenodd;
	}
	private JSpinner getSpCorner1() {
		if (spCorner1 == null) {
			spCorner1 = new JSpinner();
			spCorner1.setModel(new SpinnerNumberModel(1, 1, 36, 1));
			spCorner1.setEnabled(false);
			spCorner1.setVisible(false);
			spCorner1.setBounds(114, 56, 29, 20);
		}
		return spCorner1;
	}
	private JSpinner getSpCorner2() {
		if (spCorner2 == null) {
			spCorner2 = new JSpinner();
			spCorner2.setModel(new SpinnerNumberModel(1, 1, 36, 1));
			spCorner2.setVisible(false);
			spCorner2.setEnabled(false);
			spCorner2.setBounds(148, 56, 29, 20);
		}
		return spCorner2;
	}
	private JSpinner getSpCorner3() {
		if (spCorner3 == null) {
			spCorner3 = new JSpinner();
			spCorner3.setModel(new SpinnerNumberModel(1, 1, 36, 1));
			spCorner3.setEnabled(false);
			spCorner3.setVisible(false);
			spCorner3.setBounds(187, 56, 29, 20);
		}
		return spCorner3;
	}
	private JSpinner getSpCorner4() {
		if (spCorner4 == null) {
			spCorner4 = new JSpinner();
			spCorner4.setModel(new SpinnerNumberModel(1, 1, 36, 1));
			spCorner4.setVisible(false);
			spCorner4.setEnabled(false);
			spCorner4.setBounds(226, 56, 29, 20);
		}
		return spCorner4;
	}
	private JTextField getTfHotNumbers() {
		if (tfHotNumbers == null) {
			tfHotNumbers = new JTextField();
			tfHotNumbers.setBounds(21, 105, 150, 20);
			tfHotNumbers.setColumns(10);
		}
		return tfHotNumbers;
	}
	private JTextField getTfColdNumbers() {
		if (tfColdNumbers == null) {
			tfColdNumbers = new JTextField();
			tfColdNumbers.setColumns(10);
			tfColdNumbers.setBounds(215, 105, 150, 20);
		}
		return tfColdNumbers;
	}
	private JLabel getLblHotNumbers() {
		if (lblHotNumbers == null) {
			lblHotNumbers = new JLabel("Hot numbers");
			lblHotNumbers.setHorizontalAlignment(SwingConstants.CENTER);
			lblHotNumbers.setBounds(21, 80, 150, 14);
		}
		return lblHotNumbers;
	}
	private JLabel getLbColdNumbers() {
		if (lbColdNumbers == null) {
			lbColdNumbers = new JLabel("Cold numbers");
			lbColdNumbers.setHorizontalAlignment(SwingConstants.CENTER);
			lbColdNumbers.setBounds(215, 80, 150, 14);
		}
		return lbColdNumbers;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(contentPane.getBackground());
			panel_2.setBounds(40, 49, 240, 108);
			panel_2.setLayout(null);
			panel_2.add(getTfNumber());
			panel_2.add(getLblColor());
		}
		return panel_2;
	}
	private JLabel getLblColor() {
		if (lblColor == null) {
			lblColor = new JLabel("");
			lblColor.setHorizontalAlignment(SwingConstants.CENTER);
			lblColor.setForeground(new Color(255, 255, 255));
			lblColor.setBounds(10, 83, 220, 14);
		}
		return lblColor;
	}
}
