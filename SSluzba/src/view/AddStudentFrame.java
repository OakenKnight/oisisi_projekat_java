package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FocusStudenti;
import controller.StudentiController;
import model.BazaStudenata;
import model.StatusStudent;
import model.Student;

public class AddStudentFrame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6074145523826069140L;
	private static JTextField imePolje;
	private static JTextField prezimePolje;
	private static JTextField datumRodjenjaPolje;
	private static JTextField datumUpisaPolje;
	private static JTextField emailPolje;
	private static JTextField adresaPolje ;
	private static JTextField telefonPolje;
	private static JTextField indexPolje;
	private static JTextField prosekPolje;
	private static String godina;
	public static JButton potvrda;
	private int god;
	private StatusStudent stats;
	
	public AddStudentFrame(){
	   // setUndecorated(true);
		setModal(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		if(3*screenHeight/7 < 460 || 2*screenWidth/10 < 350){
			setSize(400, 460);
		}else {
			setSize(2*screenWidth/10,3*screenHeight/7);
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje studenta");
		
		
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		FocusStudenti fokus=new FocusStudenti();
		
		JPanel imeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeLabela = new JLabel("Ime* ");
		imePolje = new JTextField();
		imePolje.setPreferredSize(new Dimension(200,25));
		imePolje.setName("txt");
		imePolje.addFocusListener(fokus);
		imePolje.setToolTipText("npr. Ivan");
		imeStudenta.add(imeLabela);
		imeStudenta.add(imePolje);
		
		JPanel prezimeStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeLabela = new JLabel("Prezime* ");
		prezimePolje = new JTextField();
		prezimePolje.setPreferredSize(new Dimension(200,25));
		prezimePolje.setName("txt");
		prezimePolje.addFocusListener(fokus);
		prezimePolje.setToolTipText("npr. Ivanović");

		prezimeStudenta.add(prezimeLabela);
		prezimeStudenta.add(prezimePolje);
		
		JPanel datumRodjenjaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumRodjenjaLabela = new JLabel("Datum rodjenja* ");
		datumRodjenjaPolje = new JTextField();
		datumRodjenjaPolje.setPreferredSize(new Dimension(200,25));
		datumRodjenjaPolje.setName("txt");
		datumRodjenjaPolje.addFocusListener(fokus);
		datumRodjenjaPolje.setToolTipText("npr. 19.09.1999.");

		datumRodjenjaStudenta.add(datumRodjenjaLabela);
		datumRodjenjaStudenta.add(datumRodjenjaPolje);
		
		
		
		JPanel adresaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaLabela = new JLabel("Adresa stanovanja* ");
		adresaPolje= new JTextField();
		adresaPolje.setPreferredSize(new Dimension(200,25));
		adresaPolje.setName("txt");
		adresaPolje.addFocusListener(fokus);
		adresaPolje.setToolTipText("npr. Karađorđeva 83, Novi Sad");

		adresaStudenta.add(adresaLabela);
		adresaStudenta.add(adresaPolje);
		
		JPanel telefonStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonLabela = new JLabel("Broj telefona* ");
		telefonPolje = new JTextField();
		telefonPolje.setPreferredSize(new Dimension(200,25));
		telefonPolje.setName("txt");
		telefonPolje.addFocusListener(fokus);
		telefonPolje.setToolTipText("npr. 024/333-559");
		telefonStudenta.add(telefonLabela);
		telefonStudenta.add(telefonPolje);
		
		JPanel indexStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel indexLabela = new JLabel("Broj indeksa* ");
		indexPolje = new JTextField();
		indexPolje.setPreferredSize(new Dimension(200,25));
		indexPolje.setName("txt");
		indexPolje.addFocusListener(fokus);
		indexPolje.setToolTipText("npr. RA201/2017");
		indexStudenta.add(indexLabela);
		indexStudenta.add(indexPolje);
		
		JPanel emailStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailLabela = new JLabel("Email* ");
		emailPolje = new JTextField();
		emailPolje.setPreferredSize(new Dimension(200,25));
		emailPolje.setName("txt");
		emailPolje.addFocusListener(fokus);
		emailPolje.setToolTipText("npr. ivan.ivanovic@aol.com");
		
		emailStudenta.add(emailLabela);
		emailStudenta.add(emailPolje);
		
		JPanel datumUpisaStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumUpisaStudentaLabela = new JLabel("Datum upisa* ");
		datumUpisaPolje = new JTextField();
		datumUpisaPolje.setPreferredSize(new Dimension(200,25));
		datumUpisaPolje.setName("txt");
		datumUpisaPolje.addFocusListener(fokus);
		datumUpisaPolje.setToolTipText("npr. 12.07.2017");

		datumUpisaStudenta.add(datumUpisaStudentaLabela);
		datumUpisaStudenta.add(datumUpisaPolje);
		
		
		JPanel prosekStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prosekLabela = new JLabel("Prosek* ");
		prosekPolje = new JTextField();
		prosekPolje.setPreferredSize(new Dimension(200,25));
		prosekPolje.setName("txt");
		prosekPolje.addFocusListener(fokus);
		prosekPolje.setToolTipText("npr. 6.66");
		
		prosekStudenta.add(prosekLabela);
		prosekStudenta.add(prosekPolje);
		
		JPanel trenutnaGodStudenta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel trenutnaGodLabela = new JLabel("Trenutna godina studija* ");
		String [] lista = {"I (prva)","II (druga)","III (treca)","IV (cetvrta)"};
		JComboBox<Object> godine = new JComboBox<Object>(lista);
		
		trenutnaGodStudenta.add(trenutnaGodLabela);
		trenutnaGodStudenta.add(godine);
		
		
		JPanel prvoDugem = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel drugoDugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JRadioButton budzet = new JRadioButton("Budzet",true);
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
		
		ButtonGroup nacinFinansiranja = new ButtonGroup();
		
		nacinFinansiranja.add(budzet);
		nacinFinansiranja.add(samofinansiranje);
		prvoDugem.add(budzet);
		drugoDugme.add(samofinansiranje);
		
		
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("Odustanak");
		potvrda = new JButton("Potvrda");
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		
		
		potvrda.addActionListener(new ActionListener() {
			String imeReg="[A-Ž][a-ž]+";
			String adresaReg="[a-žA-Ž0-9 ]*[,][ a-žA-Ž]+";
			String telReg="[0-9]+/[0-9]+[-][0-9]+";
			String emailReg="[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+";
			String idxReg="[A-Z]+[0-9]+/[0-9]+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean postoji = false;
				for(Student std : BazaStudenata.getInstance().getStudenti()) {
					if(std.getBrIndex().equals(indexPolje.getText().trim())) {
						postoji = true;
					}
				}
				String [] datum1 = datumRodjenjaPolje.getText().split("\\.");
				String [] datum2 = datumUpisaPolje.getText().split("\\.");
				LocalDate lc1 = LocalDate.of(Integer.parseInt(datum1[2]), Integer.parseInt(datum1[1]), Integer.parseInt(datum1[0]));
				LocalDate lc2 = LocalDate.of(Integer.parseInt(datum2[2]), Integer.parseInt(datum2[1]), Integer.parseInt(datum2[0]));
				
				if(imePolje.getText().equals("") || prezimePolje.getText().equals("") || datumRodjenjaPolje.getText().equals("") || adresaPolje.getText().equals("") || telefonPolje.getText().equals("")
						|| indexPolje.getText().equals("")  || datumUpisaPolje.getText().equals("") || emailPolje.getText().equals("") || prosekPolje.getText().equals("") ) {
					
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
				}else if(!imePolje.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Ime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!prezimePolje.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumRodjenjaPolje.getText())){
					JOptionPane.showMessageDialog(null, "Datum rodjenja nije unesen kako treba!(dd.MM.yyyy)","",JOptionPane.ERROR_MESSAGE);
				}else if(!adresaPolje.getText().trim().matches(adresaReg)) {
					JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!telefonPolje.getText().matches(telReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailPolje.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!indexPolje.getText().matches(idxReg)) {
					JOptionPane.showMessageDialog(null, "Indeks nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumUpisaPolje.getText())){
					JOptionPane.showMessageDialog(null, "Datum upisa nije unesen kako treba!(dd.MM.yyyy)","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriProsek(prosekPolje.getText())){
					JOptionPane.showMessageDialog(null, "Prosek nije unesen kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(postoji){
					JOptionPane.showMessageDialog(null, "Vec postoji Student sa unetim brojem indeksa!!!","",JOptionPane.ERROR_MESSAGE);
				}else if(lc1.isAfter(lc2)) {
					JOptionPane.showMessageDialog(null, "Datum upisa je pre datuma rodjenja!!!","",JOptionPane.ERROR_MESSAGE);
				}else {
					//potvrda.setEnabled(true);
					if(budzet.isSelected()) {
						stats=StatusStudent.B;
					}else {
						stats=StatusStudent.S;
					}
					
					godina = godine.getSelectedItem().toString();
					if(godina.equals("I (prva)")) {
						god=1;
					}else if(godina.equals("II (druga)")){
						god=2;
					}else if(godina.equals("III (treca)")){
						god=3;
					}else {
						god=4;
					}

					StudentiController.getInstance().addStudent(imePolje.getText(), prezimePolje.getText(),lc1, adresaPolje.getText(), telefonPolje.getText(), emailPolje.getText(),indexPolje.getText(),lc2,god, stats, Double.parseDouble(prosekPolje.getText()));
					
					setVisible(false);
					dispose();
				}
				
			}
			/*
			 * ne radi mi ovaj proveriProsek pa cu staviti da vraca true
			*/
			private boolean proveriProsek( String text ) {
				// TODO Auto-generated method stub
				String prosekReg="[0-9]*[0-9][.][0-9][0-9]";
				if(text.matches(prosekReg)) {
					if(text.isEmpty()==false) {
						Double ocena=Double.parseDouble(text);
						if(ocena<=10.0) {
							if(ocena>=6.0) {
								return true;
							}
						}else {
							return false;
						}
					}
				}
				return false;
			}
			
			private boolean proveriDatum(String text) {
				// TODO Auto-generated method stub
				if(!text.isEmpty()) {
					


					String regexdatum="^\\d{2,2}\\.\\d{2,2}\\.\\d{4}$";

					
					if(!text.matches(regexdatum)) {
						return false;
					}else {
						String[] datumi=text.split("\\.");
						int dan=Integer.parseInt(datumi[0]);
						int mesec=Integer.parseInt(datumi[1]);

						if(dan<1) {
							return false;
						}else if(mesec>12) {
							return false;
						}else if(mesec<1) {
							return false;
						}else if(mesec==2) {
							if(dan>29 ) {
								return false;
							}
						}else if(mesec==1 || mesec==3 || mesec==5 || mesec==7 ||mesec==8 || mesec==10 || mesec==12) {
							if(dan>31) {
								return false;
							}
						}else if(mesec==4 || mesec==6 || mesec==9 || mesec==11) {
							if(dan>30) {
								return false;
							}
						}
						return true;
						}
					}
				return false;
				}
		});
		
		
		odustanakPotvrda.add(odustanak);
		odustanakPotvrda.add(potvrda);

		Box obrazac = Box.createVerticalBox();
		obrazac.add(Box.createVerticalStrut(14));
		obrazac.add(imeStudenta);
		obrazac.add(prezimeStudenta);
		obrazac.add(datumRodjenjaStudenta);
		obrazac.add(adresaStudenta);
		obrazac.add(telefonStudenta);
		obrazac.add(datumUpisaStudenta);
		obrazac.add(emailStudenta);
		obrazac.add(indexStudenta);
		obrazac.add(trenutnaGodStudenta);
		obrazac.add(prosekStudenta);
		obrazac.add(prvoDugem);
		obrazac.add(drugoDugme);
		obrazac.add(odustanakPotvrda);
		obrazac.add(Box.createGlue());
		
		
		
		this.add(obrazac,BorderLayout.CENTER);
		
		this.add(donjiPanel,BorderLayout.SOUTH);

		
		setVisible(true);
		
	}
	
	
}
