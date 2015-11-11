

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class prueba extends JPanel 
{
	private boolean band,band1;
	public JTable leftTable;
   
    
    private String deckname;
	
	public int cant;
	//CardGui current;
	
	public JPanel panel;
	private JPanel panel_1;
	private JLabel Count; 
	public static int c;
	private JLabel lblCardsOnDeck;
	private JButton Create;
	 
	public prueba()
	{
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		setBounds(0,0,800,600);	
		setOpaque(false);
		
		
		
	        setLayout(null);
	      
	       

	      

	        JScrollPane scrollPane_1 = new JScrollPane();
	        scrollPane_1.setBounds(new Rectangle(500, 0, 250, 400));
	        scrollPane_1.setBounds(50, 50, 650, 450);
	        add(scrollPane_1);
	        leftTable = new JTable(new SimpleColorTableModel());
	        leftTable.setBackground(new Color(153, 204, 255));
	        scrollPane_1.setViewportView(leftTable);
	        
	        	        setupTable(leftTable);
	        	        
	        	        populate((SimpleColorTableModel) leftTable.getModel());

	        setSize(800, 600);
	        
	   

	        	        
	        	        	       
	        	        
	        	        	       
	       
	       
	        
	        

	        
}

	        



	
	
	
	
	
	
	
	  protected void setupTable(JTable table) {

	        table.setFillsViewportHeight(true);
	        table.getColumnModel().getColumn(2).setMaxWidth(150);
                table.getColumnModel().getColumn(1).setMaxWidth(150);
	        table.getColumnModel().getColumn(0).setMaxWidth(150);
	     //   table.getColumnModel().getColumn(0).setPreferredWidth(10);
	        
	        table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());

	    }
	
	
    public class ColorTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            setText(null);
            if (value instanceof Color) {

                setOpaque(true);
                setBackground((Color)value);

            }

            return this;

        }

    }

    protected void moveSelectedRow(JTable from, JTable to) {

        SimpleColorTableModel fromModel = (SimpleColorTableModel) from.getModel();
        SimpleColorTableModel toModel = (SimpleColorTableModel) to.getModel();

        for (int index : from.getSelectedRows()) {

            Vector rowValue = (Vector) fromModel.getDataVector().get(index);

            toModel.addRow(rowValue);

        }

        int selectedRow = -1;
        while ((selectedRow = from.getSelectedRow()) != -1) {

            fromModel.removeRow(selectedRow);

        }

        from.clearSelection();

    }
	
    protected void populate(SimpleColorTableModel model) {
    	
 
    	
    	
    
    }
	
	public class SimpleColorTableModel extends DefaultTableModel {

	    public SimpleColorTableModel() {
	    	
	    	addColumn("RUT");
	        addColumn("NOMBRE");
	        addColumn("APELLIDO");
                addColumn("SALARIO");
                addColumn("SEXO");
                addColumn("TOTAL_GASTOS");
                addColumn("RESTANTE_GASTOS");
                addColumn("MONTO_AHORRO");
                addColumn("RESULTADO_SA");
                 addColumn("RESULTADO_AHORRO_ANUAL");
	        
	    }

	  
	}
}
