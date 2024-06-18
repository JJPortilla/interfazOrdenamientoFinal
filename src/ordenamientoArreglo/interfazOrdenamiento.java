package ordenamientoArreglo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class interfazOrdenamiento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTamanoArreglo;
	private JTextField textValoresArreglo;
	private JTextArea textArregloOrdenado;
	private sortMethods sorter;
	private int tamano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazOrdenamiento frame = new interfazOrdenamiento();
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
	public interfazOrdenamiento() {
		sorter = new sortMethods();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTituloPrincipal = new JLabel("Ordenamiento de un arreglo por diferentes metodos ");
		lbTituloPrincipal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbTituloPrincipal.setBounds(63, 10, 400, 79);
		contentPane.add(lbTituloPrincipal);

		JLabel lblTamanoArreglo = new JLabel("Ingrese el tama\u00F1o del arreglo");
		lblTamanoArreglo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTamanoArreglo.setBounds(63, 99, 180, 43);
		contentPane.add(lblTamanoArreglo);

		JLabel lblValoresArreglo = new JLabel("Ingrese los valores del arreglo");
		lblValoresArreglo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblValoresArreglo.setBounds(63, 140, 180, 30);
		contentPane.add(lblValoresArreglo);

		textTamanoArreglo = new JTextField();
		textTamanoArreglo.setBounds(264, 112, 96, 19);
		contentPane.add(textTamanoArreglo);
		textTamanoArreglo.setColumns(10);

		textValoresArreglo = new JTextField();
		textValoresArreglo.setEnabled(false);
		textValoresArreglo.setBounds(264, 147, 96, 19);
		contentPane.add(textValoresArreglo);
		textValoresArreglo.setColumns(10);
		
		textArregloOrdenado = new JTextArea();
		textArregloOrdenado.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArregloOrdenado);
		scrollPane.setBounds(63, 200, 373, 341);
		contentPane.add(scrollPane);

		JButton btnOrdenBurbuja = new JButton("Burbuja");
		btnOrdenBurbuja.setBounds(446, 202, 150, 21);
		contentPane.add(btnOrdenBurbuja);
		btnOrdenBurbuja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ordenarBurbuja();

			}
		});

		JButton btnSeleccion = new JButton("Selecci\u00F3n");
		btnSeleccion.setBounds(446, 233, 150, 21);
		contentPane.add(btnSeleccion);
		btnSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarSeleccion();
			}
		});

		JButton btnInsercion = new JButton("Inserci\u00F3n");
		btnInsercion.setBounds(446, 264, 150, 21);
		contentPane.add(btnInsercion);
		btnInsercion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarInsercion();
			}
		});
		JButton btnBurbujaMejorado = new JButton("BurbujaMejorado");
		btnBurbujaMejorado.setBounds(446, 294, 150, 21);
		contentPane.add(btnBurbujaMejorado);
		btnBurbujaMejorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarBurbujaMejorado();

			}
		});

		JButton btnIngresarTamano = new JButton("Ingresar Tama\u00F1o");

		btnIngresarTamano.setBounds(370, 111, 150, 21);
		contentPane.add(btnIngresarTamano);
		btnIngresarTamano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarTamano();
				
			}
		});

		JButton btnIngresarDatos = new JButton("Ingresar Datos");
		btnIngresarDatos.setBounds(370, 146, 150, 21);
		contentPane.add(btnIngresarDatos);
		btnIngresarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarDatos();
			}
		});

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(445, 520, 150, 21);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
	}

	private void ingresarTamano() {
		try {
			tamano = Integer.parseInt(textTamanoArreglo.getText());
			if (tamano <= 0) {
				throw new NumberFormatException();
			}
			textValoresArreglo.setEnabled(true);
			JOptionPane.showMessageDialog(this, "Tamaño ingresado correctamente");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un tamaño valido (numero entero positivo)");
		}
	}

	private void ingresarDatos() {
		try {
			String[] valoresStr = textValoresArreglo.getText().split(",");
			if (valoresStr.length != tamano) {
				throw new Exception("Numero de valores no coincide con el tamaño del arreglo");
			}
			int[] valores = new int[tamano];
			for (int i = 0; i < tamano; i++) {
				valores[i] = Integer.parseInt(valoresStr[i].trim());
			}
			
			JOptionPane.showMessageDialog(this, "Datos ingresados correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error en los datos ingresados: " + e.getMessage());
		}
	}

	private void ordenarBurbuja() {
		try {
			int logs = JOptionPane.showConfirmDialog(null,"¿Desea arreglar el arreglo con pasos?","Confirmacion", JOptionPane.YES_NO_OPTION);
			int tamano = Integer.parseInt(textTamanoArreglo.getText());
			String[] valoresStr = textValoresArreglo.getText().split(",");
			int[] valores = new int[tamano];
			
			for (int i = 0; i < tamano; i++) {
				valores[i] = Integer.parseInt(valoresStr[i].trim());
			}
			String resultado = sorter.sortByBubbleAscendInterfaz(valores, (logs==0));
			textArregloOrdenado.setText(resultado);
		} catch (Exception e) {
			textArregloOrdenado.setText("Error en los datos ingresados");
		}
	}

	private void ordenarSeleccion() {
		try {
			int logs = JOptionPane.showConfirmDialog(null,"¿Desea arreglar el arreglo con pasos?","Confirmacion", JOptionPane.YES_NO_OPTION);
			int tamano = Integer.parseInt(textTamanoArreglo.getText());
			String[] valoresStr = textValoresArreglo.getText().split(",");
			int[] valores = new int[tamano];
			for (int i = 0; i < tamano; i++) {
				valores[i] = Integer.parseInt(valoresStr[i].trim());
			}
			String resultado = sorter.sortBySelectionAscendInterfaz(valores, (logs==0));
			textArregloOrdenado.setText(resultado);
		} catch (Exception e) {
			textArregloOrdenado.setText("Error en los datos ingresados");
		}
	}

	private void ordenarInsercion() {
		try {
			int tamano = Integer.parseInt(textTamanoArreglo.getText());
			int logs = JOptionPane.showConfirmDialog(null,"¿Desea arreglar el arreglo con pasos?","Confirmacion", JOptionPane.YES_NO_OPTION);
			String[] valoresStr = textValoresArreglo.getText().split(",");
			int[] valores = new int[tamano];
			for (int i = 0; i < tamano; i++) {
				valores[i] = Integer.parseInt(valoresStr[i].trim());
			}
			String resultado = sorter.sortByInsertionAscendInterfaz(valores, (logs==0));
			textArregloOrdenado.setText(resultado);
		} catch (Exception e) {
			textArregloOrdenado.setText("Error en los datos ingresados");
		}

	}

	private void ordenarBurbujaMejorado() {
		try {
			int tamano = Integer.parseInt(textTamanoArreglo.getText());
			int logs = JOptionPane.showConfirmDialog(null,"¿Desea arreglar el arreglo con pasos?","Confirmacion", JOptionPane.YES_NO_OPTION);
			String[] valoresStr = textValoresArreglo.getText().split(",");
			int[] valores = new int[tamano];
			for (int i = 0; i < tamano; i++) {
				valores[i] = Integer.parseInt(valoresStr[i].trim());

				String resultado = sorter.sortByBubbleUpgradeAscendInterfaz(valores, (logs==0));
				textArregloOrdenado.setText(resultado);
			}
		} catch (Exception e) {
			textArregloOrdenado.setText("Error en los datos ingresados");
		}
	}

	private void limpiarCampos() {
		textTamanoArreglo.setText("");
		textValoresArreglo.setText("");
		textArregloOrdenado.setText("");
		tamano = 0;
	}
	
}
