package main.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AhorcadoGUI extends JFrame implements KeyListener {

	private JPanel cpAhorcado;
	private JTextField txfNuevaLetra;
	private Ahorcado ahorcado;
	private JLabel lblPalabra;		
	private JLabel lblErrores;
	private JLabel lblEstado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AhorcadoGUI frame = new AhorcadoGUI();				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public AhorcadoGUI() {
		setVisible(true);
		setTitle("Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cpAhorcado = new JPanel();
		cpAhorcado.setBackground(Color.WHITE);
		cpAhorcado.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpAhorcado);
		cpAhorcado.setLayout(null);
		
		lblPalabra = new JLabel("");
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabra.setBounds(25, 108, 395, 32);
		cpAhorcado.add(lblPalabra);
		
		txfNuevaLetra = new JTextField();
		txfNuevaLetra.setBounds(25, 201, 52, 22);
		cpAhorcado.add(txfNuevaLetra);
		txfNuevaLetra.setColumns(10);
		
		JLabel lblNuevaLetra = new JLabel("Nueva letra");
		lblNuevaLetra.setBounds(25, 184, 75, 16);
		cpAhorcado.add(lblNuevaLetra);
		
		lblErrores = new JLabel("Intentos: 6");
		lblErrores.setBounds(25, 30, 116, 16);
		cpAhorcado.add(lblErrores);
		
		lblEstado = new JLabel("Estado: Jugando");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setBounds(25, 13, 116, 16);
		cpAhorcado.add(lblEstado);
		
		JLabel lblPalabraActual = new JLabel("Palabra a descubrir");
		lblPalabraActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabraActual.setBounds(25, 79, 395, 16);
		cpAhorcado.add(lblPalabraActual);
		iniciarJuego();
	}
	
	public void iniciarJuego() {
		ahorcado = new Ahorcado();
		Opciones.setDificultad("Intermedio");
		Opciones.setTematica("Animales");
		Opciones.setIdioma("esp");
		ahorcado.comenzarJuego();	
		txfNuevaLetra.addKeyListener(this);
		lblEstado.setText("Estado: " + ahorcado.getResultado());
		lblPalabra.setText(ahorcado.getPalabraActual());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			ahorcado.ingresarLetra(txfNuevaLetra.getText());
			String resultado = ahorcado.getResultado();
			lblPalabra.setText(ahorcado.getPalabraActual());
			lblErrores.setText("Intentos: " + ahorcado.getErrores());
			lblEstado.setText("Estado: " + resultado);
			txfNuevaLetra.setText("");
			if (resultado.equals("Ganaste!") || resultado.equals("Perdiste!")) {
				txfNuevaLetra.setEnabled(false);
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
