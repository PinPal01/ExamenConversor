package conversor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class Conversor extends JFrame{
	
	
	JTextField pantalla;

	double resultado;

	String operacion;

	JPanel panelNumeros, panelOperaciones;

	boolean nuevaOperacion = true;

	Conversor()
	{
		super();
		setSize(600, 800);
		setTitle("Pesos a Dolars");
		
                
                
		setResizable(false);
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());

		pantalla = new JTextField("0", 100);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 50));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		
		panel.add("North", pantalla);

		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

		for (int n = 9; n >= 0; n--) {
			nuevoNumero("" + n);
		}

		nuevoNumero(".");

		panel.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(4, 1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		nuevoBotonOperacion("CE");
                nuevoBotonOperacion("Convertir");
		
                
                
                

		panel.add("East", panelOperaciones);


		
		
		
	}

	private void nuevoNumero(String digito) {
		JButton btn = new JButton();
                
                btn.setFont(new Font("Arial", Font.BOLD, 25));
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				numeroPulsado(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}

	private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

	private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
                
                btn.setFont(new Font("Arial", Font.BOLD, 30));

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}

	private void operacionPulsado(String tecla) {
		if (tecla.equals("Convertir")) {
			calcularResultado();
		} else if (tecla.equals("CE")) {
			resultado = 0;
			pantalla.setText("0");
			nuevaOperacion = true;
		} else {
			operacion = tecla;
			if ((resultado > 0) && !nuevaOperacion) {
				calcularResultado();
			} else {
				resultado = new Double(pantalla.getText());
			}
		}

		nuevaOperacion = true;
	}

	private void calcularResultado() {
		
		resultado= (new Double(pantalla.getText()))/20;
	
		

		pantalla.setText("" + resultado);
		operacion = "";
	}

	
}
