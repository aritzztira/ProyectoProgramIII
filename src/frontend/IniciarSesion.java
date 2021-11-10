package frontend;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepciones.UsuarioNoExiste;
import usuarios.Jugador;
import usuarios.Persona;
import usuarios.Tecnico;
import frontend.Principio;

public class IniciarSesion extends JFrame {

	private JTextField juser;
    private JPasswordField jpassword;
    private String user;
    private String password;
    
    private JPanel iniciosesion;
    ArrayList<Jugador> listaJugadores;
    ArrayList <Tecnico> listaTecnicos;
    
    Persona jugador = new Jugador();
	Persona tecnico = new Tecnico();
	

	/**
	 * Create the frame.
	 * @param listaJugadores la lista de todos los jugadores
	 * @param listaTecnicos la lista de todos los tecnicos 
	 * @param principio la ventana principio
	 */
	public IniciarSesion(ArrayList <Jugador> listaJugadores, ArrayList <Tecnico> listaTecnicos, Principio principio) {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 300);
        iniciosesion=new JPanel();
        iniciosesion.setBorder(new EmptyBorder(5, 5, 5, 5));
        iniciosesion.setLayout(null);

        setContentPane(iniciosesion);

        JLabel lblUsuario = new JLabel("Usuario:" );
        lblUsuario.setBounds(20, 100, 300, 30);
        lblUsuario.setForeground(Color.WHITE);
        iniciosesion.add(lblUsuario);

        juser = new JTextField (20);
        juser.setBounds(100, 100, 300, 30);
        iniciosesion.add(juser);

        JLabel lblContrasena = new JLabel("Contrasena:" );
        lblContrasena.setBounds(20, 140, 300, 30);
        lblContrasena.setForeground(Color.WHITE);
        iniciosesion.add(lblContrasena);

        jpassword = new JPasswordField (20);
        jpassword.setEchoChar('*');
        jpassword.setToolTipText("Contrasena");
        jpassword.setBounds(100, 140, 300, 30);
        iniciosesion.add(jpassword);

        JButton boton1 = new JButton("Entrar");
        boton1.setBounds(213, 186, 200, 30);
        
        boton1.addActionListener(new ActionListener() {
        	
        
			public void actionPerformed(ActionEvent e) {

				user = juser.getText();

				password = jpassword.getText();

				try {

					boolean encontradoPersona = comprobarPersona(user, password, listaJugadores, listaTecnicos);
					
					if(encontradoPersona) {
						
						if(jugador.getTipopersona().equals("jugador")) {
						
						VentanaJugador ventana= new VentanaJugador ();
						ventana.setVisible(true);
						IniciarSesion.this.dispose();
						
						}
						
						else if (jugador.getTipopersona().equals("tecnico")) {
							
							VentanaTecnico ventana = new VentanaTecnico ();
							ventana.setVisible(true);
							IniciarSesion.this.dispose();
							
						} 
						
					}
				

				} catch (UsuarioNoExiste e1) {
					JOptionPane.showMessageDialog(IniciarSesion.this, e1.getMessage());
				}
				
				
			}

		});

        iniciosesion.add(boton1);
        iniciosesion.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        
        
        JLabel foto = new JLabel("New label");
		foto.setIcon(new ImageIcon("entrada/Zubieta.jpg"));
		foto.setBounds(15, 16, 400, 200);
		iniciosesion.add(foto);
		
		JButton btnCancel = new JButton("Atrás");
		btnCancel.setBounds(15, 187, 183, 29);
		

		btnCancel.addActionListener(
				e -> 
				{principio.setVisible(true);
				IniciarSesion.this.setVisible(false); 
				});

		
		iniciosesion.add(btnCancel);

        setVisible(true);
    }
    
 



	/**
     * Sirve para comprobar que el usuario no existe o que la contraseña introducida es incorrecta
     * @param usuario el usuario 
     * @param password la contraseña
     * @param listaJugadores la lista de todos los jugadores
     * @param listaTecnicos la lista de todos los tecnicos
     * @return devuelve si existe o no la persona que hace el login
     * @throws UsuariosNoExiste salta la excepción UsuarioNoExiste en el caso de que no exista o la contraseña sea incorrecta
     */
    
    private boolean comprobarPersona(String usuario, String password, ArrayList<Jugador> listaJugadores, ArrayList<Tecnico> listaTecnicos)
			throws UsuarioNoExiste 
    {

		boolean existe = false;
		long contador1=0;
		contador1= listaJugadores.stream().filter(s -> s.getUser().equals(usuario)).count();
		if (contador1==1) {
			
			Jugador jug= listaJugadores.stream().filter(s -> s.getUser().equals(usuario)).findFirst().get();
			
			if (jug.getUser().equals(usuario)) {
				existe = true;
				if (jug.getPassword().equals(password)) {
					jugador = (Persona) jug;
					tecnico= (Persona) jug;
					existe = true;
					
				} else {
					throw new UsuarioNoExiste("Contraseña incorrecta");
		
				}
			}
		}
		

		long contador2=0;
		contador2= listaTecnicos.stream().filter(s -> s.getUser().equals(usuario)).count();
		if (contador2==1) {
		Tecnico tecni= listaTecnicos.stream().filter(t -> t.getUser().equals(usuario)).findFirst().get();
		
			if (tecni.getUser().equals(usuario)) {
				existe = true;
	
				if (tecni.getPassword().equals(password)) {
					jugador = (Persona) tecni;
					tecnico= (Persona) tecni;
					existe = true;
					
					
				} else {
					throw new UsuarioNoExiste("Contraseña incorrecta");
				}
			}
		}
		
		
		if (!existe) {

			throw new UsuarioNoExiste("Usuario no existente");
		}
		
		return true;

    }
	}


