import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument.Content;

import com.mysql.jdbc.Statement;
import java.awt.Color;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Taller extends JFrame implements ActionListener {
	
	private Container contentPane,actual;
	private JButton insertar,eliminar,modificar,consulta,consultageneral,volver;
	 private JButton jButton1, jButton2;
	 private   JCheckBox jCheckBox1;
	  private JCheckBox jCheckBox2;
	 private JCheckBox jCheckBox3;
	 private int error,sexo,mensual,indefinido,cuenta;//estas son banderas
	 private int ingresomen,porcentaje;
	       JButton boton,boton2;
	   JComboBox jComboBox1;
	   JLabel jLabel1;
	JLabel jLabel10,changed;
	  JLabel jLabel11;
	   JLabel jLabel12;
	    JLabel jLabel13;
	    JLabel jLabel14;
javax.swing.JLabel jLabel2;
	    javax.swing.JLabel jLabel3;
	    javax.swing.JLabel jLabel4;
	    javax.swing.JLabel jLabel5;
	     javax.swing.JLabel jLabel6;
	     javax.swing.JLabel jLabel7;
	    javax.swing.JLabel jLabel8;
	     javax.swing.JLabel jLabel9;
	   javax.swing.JRadioButton jRadioButton1;
	     javax.swing.JRadioButton jRadioButton2;
	     javax.swing.JTextField jTextField1;
	    javax.swing.JTextField jTextField2;
	   javax.swing.JTextField jTextField3;
	     javax.swing.JTextField jTextField4;
	    javax.swing.JTextField jTextField5;
	     javax.swing.JTextField jTextField6;
	     javax.swing.JTextField jTextField7;
	   javax.swing.JTextField jTextField8;
	     javax.swing.JTextField jTextField9;
	 public static MySql db;
	   boolean exito; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 db=new MySql();
					Taller frame = new Taller();
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
	public Taller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800,600);
		setTitle("Taller");
		setResizable(false);
	
		
		
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		insertar = new JButton("INGRESAR");
		insertar.setBounds(298, 112, 281, 39);
		contentPane.add(insertar);
		insertar.addActionListener(this);
		
		modificar = new JButton("MODIFICAR");
		modificar.setBounds(298, 191, 281, 39);
		contentPane.add(modificar);
		modificar.addActionListener(this);
		
		eliminar = new JButton("ELIMINAR");
	
		eliminar.setBounds(298, 259, 281, 39);
		contentPane.add(eliminar);
		eliminar.addActionListener(this);
		
		consultageneral = new JButton("CONSULTA GENERAL");
		consultageneral.setBounds(298, 344, 281, 39);
		contentPane.add(consultageneral);
		consultageneral.addActionListener(this);
		consulta = new JButton("UBICAR RUT");
		
		consulta.setBounds(298, 414, 281, 39);
		contentPane.add(consulta);
		consulta.addActionListener(this);
		
		volver=new JButton("VOLVER");
		volver.setBounds(650,520,100,30);
		contentPane.add(volver);
		volver.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==insertar)
		{
			opcion1();
		
		}
                if(e.getSource()==jButton1)
                {
                db.insertData(jTextField1.getText(),jTextField2.getText(),jTextField3.getText(),jTextField4.getText());//hace el query a la base de datos
                jButton1.setEnabled(false);
                }
                if(e.getSource()==consultageneral)
                {
                    consultageneral();
                }
                 if(e.getSource()==consulta)
                {
                    consulta();
                }
                
                
                
                if(e.getSource()==eliminar)
		{
			eliminar();
		
		}
		if(e.getSource()==boton)
                {
                    if(!db.existe(jTextField1.getText()) && !jTextField1.getText().isEmpty())
	        		{
	        			
	        			jTextField2.setVisible(true);
                                        jLabel3.setVisible(true);
	        			jTextField3.setVisible(true);
                                        jLabel4.setVisible(true);
                                       jTextField1.setEditable(false);
                                        boton2.setVisible(true);
	        		}else
	        		{
	        		jLabel2.setVisible(true);
	        		jTextField1.setText("");
                                
	        		}
                
                
                }
                if(e.getSource()==boton2)
                {
                   // aca se modifica el valor
                   if(!jTextField2.getText().isEmpty()&& !jTextField3.getText().isEmpty())
                   {
                   
                   jTextField2.setEditable(false);
                   jTextField3.setEditable(false);
                   exito=this.db.modificar(jTextField1.getText(),jTextField2.getText(),jTextField3.getText());
                   
                 changed.setVisible(true);
                   }
                
                }
		if(e.getSource()==jComboBox1)
		{
			
			porcentaje=jComboBox1.getSelectedIndex()+1;
			porcentaje = porcentaje*10;
			
			jTextField7.setText(""+(Integer.parseInt(jTextField5.getText())*porcentaje/100));
			jTextField9.setText(""+(Integer.parseInt(jTextField7.getText())*12));
		} 
		if(e.getSource()==volver)
		{
			
			setContentPane(contentPane);
			 setBounds(100,100,800,600);
                         db.SelectData();
		}
		if(e.getSource()==modificar)
		{
			
			modificar();
		
		}
		if(e.getSource()==jCheckBox3)
		{
			if(jCheckBox3.isSelected())
			{
			
				jTextField8.setText(""+ingresomen*12);
				jButton1.setEnabled(true);
			}
			else{
				
			
				
			}
		}
		
		if(e.getSource()==jCheckBox2)
		{
			if(jCheckBox2.isSelected())
			{
				
				jTextField6.setEnabled(true);
				
			}
			else{
				System.out.println("false");
				
				jTextField6.setEnabled(false);
				
				
			}
		}
		
		if(e.getSource()==jCheckBox1)
		{
			if(jCheckBox1.isSelected())
			{
				
				jComboBox1.setEnabled(true);
				
			}
			else{
				System.out.println("false");
				
				jComboBox1.setEnabled(false);
				
				
			}
		}
	
		if(e.getSource()==jRadioButton1)//si presiona el radio buton masculino
		{
			if(jRadioButton2.isSelected())
			{
				jRadioButton2.setSelected(false);;
				
				
			}
			if(jRadioButton1.isSelected())
			{
			
				sexo=0;
				
			}else
			{
				sexo=1;
				
				
			}
		}
	
		
		if(e.getSource()==jRadioButton2)//si presiona el radio buton masculino
		{
			if(jRadioButton1.isSelected())
			{
				jRadioButton1.setSelected(false);
			
			}
			if(jRadioButton2.isSelected())
			{
				sexo=0;
				
			}else
			{
				sexo=1;
				
			}
			
		}
	
	
	}
	public void opcion1()
	{
	
		actual=new JPanel();
		
		setContentPane(actual);
	
		
		 jTextField1 = new javax.swing.JTextField();
		  JButton btnCheck = new JButton("Validate fields");
		  btnCheck.setBounds(400,150,50,30);
	        btnCheck.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0)
                        
                        {
                            System.out.println("entro el evento");
                        if(!jTextField4.getText().isEmpty() && !jTextField3.getText().isEmpty() && !jTextField2.getText().isEmpty())
	        	{
	        		System.out.println("no son vacios");
	        		if(!db.existe(jTextField1.getText()))
                                {
	        		
	        		if(jRadioButton2.isSelected()||jRadioButton1.isSelected())
                                {
                                    ingresomen=Integer.parseInt(jTextField4.getText());
	        		jCheckBox1.setEnabled(true);
					jCheckBox2.setEnabled(true);
					jCheckBox3.setEnabled(true);
	        		}
                                }
	        	}	        
	        	}
	        });

		 actual.add(btnCheck);
			  
			  
	        jTextField1.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		
	        		if(!db.existe(jTextField1.getText()) && !jTextField1.getText().isEmpty())
	        		{
	        	
	        		
	        		jTextField2.setEditable(true);
	        		jTextField1.setEditable(false);
	        	
	        		}else
                                {
                                jTextField2.setEditable(false);
                                
                                }
                                     
	        	}
	        });		
	 
	        jTextField2 = new javax.swing.JTextField();
	       
	  	
	      
	        jTextField3 = new JTextField();
	      
	       
      jTextField4 = new JTextField();

	
	        

	        jCheckBox1 = new JCheckBox();
	        
	        jCheckBox2 = new JCheckBox();
	        jCheckBox2.addActionListener(this);
	        jCheckBox1.setEnabled(false);
	        jCheckBox3 = new javax.swing.JCheckBox();
	        jCheckBox3.addActionListener(this);
	        jRadioButton1 = new javax.swing.JRadioButton();
	        jRadioButton2 = new javax.swing.JRadioButton();
	        jComboBox1 = new javax.swing.JComboBox();
	        jCheckBox2.setEnabled(false);
	        jCheckBox3.setEnabled(false);
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jButton1 = new javax.swing.JButton();
	        jLabel6 = new javax.swing.JLabel();
	        jLabel7 = new javax.swing.JLabel();
	        jLabel8 = new javax.swing.JLabel();
	        jLabel10 = new javax.swing.JLabel();
	        jLabel11 = new javax.swing.JLabel();
	        jLabel12 = new javax.swing.JLabel();
	        
	        jTextField6 = new javax.swing.JTextField();
	        jTextField6.setEnabled(false);
	        jTextField6.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusLost(FocusEvent e) 
	        	{
	        	if(!jTextField6.getText().isEmpty())
	        	{
	        		
	        		if(!jTextField4.getText().isEmpty())
		        	{
	        			int aux= Integer.parseInt(jTextField6.getText());
		        		
		        		jTextField5.setText(""+(ingresomen - aux ) );
		        		
		        		
		        	}
	        		
	        		
	        		
	        	}	
	        		
	        	}
	        });
	        jTextField8 = new javax.swing.JTextField();
	        
	        jTextField8.setEditable(false);
	        jLabel9 = new javax.swing.JLabel();
	        jTextField5 = new javax.swing.JTextField();
	        jLabel13 = new javax.swing.JLabel();
	        jTextField7 = new javax.swing.JTextField();
	        jButton1.addActionListener(this);
	        jTextField7.setEditable(false);
	        jLabel14 = new javax.swing.JLabel();
	        jTextField9 = new javax.swing.JTextField();
	        jTextField9.setEditable(false);
	        jCheckBox1.setText("QUIERO AHORRAR EL MONTO RESTANTE");
	        jCheckBox1.addActionListener(this);
	        jCheckBox2.setText("TENGO GASTOS CONSTANTES TODOS LOS MESES");
	        jCheckBox2.addActionListener(this);
	        
	        jCheckBox3.setText("TENGO CONTRATO INDEFINIDO");
	        
	        
	        jRadioButton1.setText("MASCULINO");
	         jRadioButton2.addActionListener(this);
	         jRadioButton2.setText("FEMENINO");
	         jRadioButton1.addActionListener(this);
	         jTextField5.setEditable(false);
	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%", "100%" }));
	        jComboBox1.setEnabled(false);
	        jComboBox1.addActionListener(this);;
	        jLabel1.setText("RUT");

	        jLabel2.setText("NOMBRE");

	        jLabel3.setText("APELLIDOS");

	        jLabel4.setText("CON ESTE PROGRAMA, PODRIAS SABER DE FORMA GENERAL COMO SE DISTRIBUYE TU SUELDO");

	        jLabel5.setText("BIENVENIDO A TU CALCULADOR DE INGRESOS");
	        jButton1.setText("GUARDAR");
	        jLabel6.setText("SEXO");

	        jLabel7.setText("INGRESO MENSUAL");

	        jLabel8.setText("\u00BFCUALES SON MIS RESULTADOS FINALES DE INGRESOS?");

	        jButton1.setEnabled(false);

	        jLabel10.setText("ANUALMENTE GANARIAS:");

	        jLabel11.setText("\u00BFCUANTO  DEL RESTANTE?");

	        jLabel12.setText("\u00BFCUANTO ES EL TOTAL DE ESOS GASTOS?");

	        jLabel9.setText("EL RESTANTE ES");

	        jLabel13.setText("CORRESPONDE A");

	        jLabel14.setText("MIS AHORROS ANUALES SERIAN DE:");
	        jTextField1.addActionListener(this);
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(272)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        							.addGroup(layout.createSequentialGroup()
	        								.addComponent(jLabel5)
	        								.addGap(385))
	        							.addGroup(layout.createSequentialGroup()
	        								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        									.addGroup(layout.createSequentialGroup()
	        										.addComponent(jLabel7)
	        										.addPreferredGap(ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
	        										.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
	        									.addGroup(layout.createSequentialGroup()
	        										.addComponent(jLabel3)
	        										.addPreferredGap(ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
	        										.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
	        									.addGroup(layout.createSequentialGroup()
	        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        											.addComponent(jLabel1)
	        											.addComponent(jLabel2))
	        										.addPreferredGap(ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
	        										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        											.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
	        											.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
	        								.addGap(28)
	        								.addComponent(btnCheck)
	        								.addGap(136))
	        							.addGroup(layout.createSequentialGroup()
	        								.addComponent(jLabel4)
	        								.addGap(251))
	        							.addGroup(layout.createSequentialGroup()
	        								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        									.addGroup(layout.createSequentialGroup()
	        										.addPreferredGap(ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
	        										.addComponent(jRadioButton1))
	        									.addGroup(layout.createSequentialGroup()
	        										.addGap(106)
	        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        											.addComponent(jLabel12)
	        											.addComponent(jLabel11))
	        										.addPreferredGap(ComponentPlacement.RELATED)
	        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        											.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
	        											.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        										.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
	        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        											.addComponent(jLabel13)
	        											.addComponent(jLabel9))))
	        								.addGap(18)
	        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        									.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
	        									.addComponent(jRadioButton2)
	        									.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
	        								.addGap(81)))
	        						.addGroup(layout.createSequentialGroup()
	        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
	        								.addGroup(layout.createSequentialGroup()
	        									.addGap(60)
	        									.addComponent(jLabel14))
	        								.addGroup(layout.createSequentialGroup()
	        									.addGap(22)
	        									.addComponent(jCheckBox3)
	        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        									.addComponent(jLabel10)
	        									.addGap(18)))
	        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        								.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
	        								.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(layout.createSequentialGroup()
	        							.addContainerGap(611, Short.MAX_VALUE)
	        							.addComponent(jLabel6)
	        							.addGap(368))
	        						.addGroup(layout.createSequentialGroup()
	        							.addGap(460)
	        							.addComponent(jButton1)
	        							.addGap(175)
	        							.addGap(218)))
	        					.addGap(71))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(56)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(jCheckBox1)
	        						.addComponent(jCheckBox2))
	        					.addGap(314)))
	        			.addContainerGap(276, Short.MAX_VALUE))
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(403)
	        			.addComponent(jLabel8)
	        			.addContainerGap(674, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addComponent(jLabel4)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(jLabel1)
	        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(btnCheck))
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(jLabel2)
	        						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        					.addGap(9)
	        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	        						.addGroup(layout.createSequentialGroup()
	        							.addComponent(jLabel3)
	        							.addGap(18))
	        						.addGroup(layout.createSequentialGroup()
	        							.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.UNRELATED)))
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(jLabel7)
	        						.addGroup(layout.createSequentialGroup()
	        							.addPreferredGap(ComponentPlacement.UNRELATED)
	        							.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	        					.addGap(29)
	        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(jLabel6)
	        						.addComponent(jRadioButton2)
	        						.addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
	        					.addGap(18)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(jCheckBox2)
	        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        							.addComponent(jLabel9)
	        							.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        					.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addComponent(jLabel12)))
	        			.addGap(18)
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        					.addComponent(jCheckBox1)
	        					.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addComponent(jLabel11))
	        				.addComponent(jLabel13)
	        				.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
	        			.addComponent(jLabel8)
	        			.addGap(36)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(jLabel10)
	        				.addComponent(jCheckBox3))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jLabel14)
	        				.addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(21)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jButton1)
	        			)
	        			.addGap(18))
	        );
	       actual.setLayout(layout);
	       actual.add(volver);
	        pack();
	        
	       
	}
	
	public void modificar()
	{
              exito = false;
		repaint();
		actual=new JPanel();
		setContentPane(actual);
		actual.setLayout(null);
		jTextField1=new JTextField();
		jTextField1.setBounds(420+50,100,100,25);
		actual.add(jTextField1);
		actual.add(volver);
		jLabel1=new JLabel("ingrese el RUT para la modificacion");
		jLabel1.setBounds(180+50,100,200,25);
                jLabel2=new JLabel("el campo a modificar no existe");
                jLabel2.setForeground(Color.RED);
		jLabel2.setBounds(180+120,50,200,25);
		actual.add(jLabel2);
                actual.add(jLabel1);
                boton=new JButton("verificar");
                boton.addActionListener(this);
                boton.setBounds(350,150,100,20);
                actual.add(boton);
                boton2=new JButton("aplicar cambios");
                boton2.addActionListener(this);
                boton2.setBounds(350,450,150,30);
                boton2.setVisible(false);
                actual.add(boton2);
                jLabel2.setVisible(false);
                jTextField1.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) { /*********************aca se hace el delete******************************/
	        		jLabel2.setVisible(false);
	        		
	        	}
	        });
                jLabel3=new JLabel("ingrese el campo a modificar");
                jLabel3.setBounds(150,400,200,25);
                actual.add(jLabel3);
                jTextField2=new JTextField();
                 jTextField2.setBounds(320,400,100,25);
                jTextField2.setVisible(false);
                jLabel3.setVisible(false);
                actual.add( jTextField2);
                jLabel4=new JLabel("ingrese el nuevo valor");
               jLabel4.setBounds(450,400,200,25);
                actual.add(jLabel4);
                jTextField3=new JTextField();
                 jTextField3.setBounds(600,400,100,25);
                jTextField3.setVisible(false);
                actual.add( jTextField3);
                jLabel4.setVisible(false);
                 changed= new JLabel("cambios efectuados");
                   changed.setBounds(350,500,200,30);
                   changed.setVisible(false);
                   actual.add(changed);
		setVisible(true);
	
		
	}
        
        void eliminar()
        {
                repaint();
		actual=new JPanel();
		setContentPane(actual);
		actual.setLayout(null);
		jTextField1=new JTextField();
		jTextField1.setBounds(420+50,100,100,25);
		actual.add(jTextField1);
		actual.add(volver);
		jLabel1=new JLabel("ingrese el RUT para la eliminacion");
		jLabel1.setBounds(180+50,100,200,25);
                jLabel2=new JLabel("el campo a eliminar no existe");
                jLabel2.setForeground(Color.RED);
		jLabel2.setBounds(180+120,50,200,25);
		actual.add(jLabel2);
                actual.add(jLabel1);
                boton=new JButton("eliminar");
             
                boton.setBounds(350,150,100,20);
                actual.add(boton);
                
              
                jLabel2.setVisible(false);
                boton.addActionListener(new ActionListener() {
	        	
	        	

            @Override
            public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==boton)
                {
                if(!jTextField1.getText().isEmpty())
                    jTextField1.setEditable(false);
                System.out.println( jTextField1.getText());
                db.deleteRecord(jTextField1.getText());
                }
            
            }
	        });
                
		setVisible(true);
	
        
        
        
        }
        
        
        void consultageneral( )
        {
        actual=new JPanel();
	setContentPane(actual);
        actual.setLayout(null);
        boton=new JButton("consultar");
             
                boton.setBounds(350,150,100,20);
                actual.add(boton);
                
              
          
                boton.addActionListener(new ActionListener() {
	        	
	        	

            @Override
            public void actionPerformed(ActionEvent e) 
            {
            
            if(e.getSource()==boton)
                {
                actual.remove(boton);
              
                JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(30, 50, 700, 500);
                actual.add(scrollPane);
                JTable  rightTable = new JTable();
	        rightTable.setBackground(new Color(0, 204, 204));
                scrollPane.setColumnHeaderView(rightTable);
	        setupTable(rightTable);
                populate(rightTable);
                
                
                
                
                
                repaint();
                
                
                
                
                
                
                
                
                
                }
            }}
                );
        actual.add(volver);
        setVisible(true);
        }
        
      protected void setupTable(JTable table) {
        
               
	        //table.setFillsViewportHeight(true);
	       // table.getColumnModel().getColumn(2).setMaxWidth(10);
	       // table.getColumnModel().getColumn(0).setMaxWidth(18);
	     //   table.getColumnModel().getColumn(0).setPreferredWidth(10);
	     
	        

	    }  
          public void consulta()
          {
          
              repaint();
		actual=new JPanel();
		setContentPane(actual);
		actual.setLayout(null);
		jTextField1=new JTextField();
		jTextField1.setBounds(420+50,100,100,25);
		actual.add(jTextField1);
		actual.add(volver);
		jLabel1=new JLabel("ingrese el nombre del campo a consultar");
		jLabel1.setBounds(180,100,250,25);
                
                jLabel3=new JLabel("¿en donde el campo  insertado sea igual a ?");
		jLabel3.setBounds(180,180,250,25);
                actual.add(jLabel3);
                
                jLabel2=new JLabel("el campo a consultar no existe");
                jTextField3=new JTextField();
                 jTextField3.setBounds(470,180,100,25);
                
                actual.add( jTextField3);
                
                jLabel2.setForeground(Color.RED);
		jLabel2.setBounds(180+120,50,200,25);
		actual.add(jLabel2);
                actual.add(jLabel1);
                boton=new JButton("consultar");
             
                boton.setBounds(360,250,100,20);
                actual.add(boton);
                
              
                jLabel2.setVisible(false);
                boton.addActionListener(new ActionListener() {
	        	
	        	

            @Override
            public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==boton)
                {
                if(!jTextField1.getText().isEmpty() && !jTextField3.getText().isEmpty())// aca se hace el query
                {
                    jTextField1.setEditable(false);
                     jTextField3.setEditable(false);
                     
                }
                }
            
            }
	        });
                
		setVisible(true);
	
        
          
          
          }
      
      
          protected void populate(JTable model)//aca se hace el query de select*
         {
    	
    
			//model.addRow(new Object[]{id,Nombre, color});
	}
    	
}
	
