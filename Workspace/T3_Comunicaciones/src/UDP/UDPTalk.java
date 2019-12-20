package UDP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UDPTalk {

	public static final int MAX_LENGTH = 90;

	// atributos: Interfaz
	JTextArea taIn;
	JTextArea taOut;
	JTextField host;
	JButton bt_Enviar;

	// atributos:Comunicaciones
	String recibido;
	int portOut, portIn;

	UDPRecibe udpR;
	UDPEnvia udpE;

	/**
	 * @param recibido
	 * @param portOut
	 * @param portIn
	 */
	public UDPTalk(int portEnvia, int portRecibe) {
		super();
		this.portOut = portEnvia;
		this.portIn = portRecibe;

		this.udpE = new UDPEnvia();
		this.udpR = new UDPRecibe();

		JFrame jf = new JFrame("UDPTalk");
		JPanel panel = new JPanel();
		JLabel jblEnviar = new JLabel("Escribe tu mensaje");
		JLabel jblRecibir = new JLabel("Mensaje recibido");
		JLabel jblHost = new JLabel("Host destino");

		taIn = new JTextArea(3, 24);
		taOut = new JTextArea(3, 24);

		host = new JTextField("127.0.0.1");
		bt_Enviar = new JButton("Enviar");

		jf.setSize(250, 250);
		jf.setLayout(new BorderLayout());
		jf.add("Center", panel);
		panel.add(bt_Enviar);
		panel.add(jblHost);
		panel.add(host);
		panel.add(jblRecibir);
		panel.add(taOut);
		panel.add(jblEnviar);
		panel.add(taIn);
		
		jf.setVisible(true);
		
		
	}// constructor

	public static void main(String[] args) {
		
		if(args.length!= 2) {
			System.out.println("se necesita un puerto de origen");
			System.exit(1);
		}
		

		
		UDPTalk udp0= new UDPTalk(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		
		UDPTalk udp1= new UDPTalk(Integer.parseInt(args[1]), Integer.parseInt(args[0]));

	}

	private class ThreadRecibir extends Thread {
		public void run() {

			try {
				do {
					recibido = udpR.recibe(portIn, MAX_LENGTH);
					taIn.setText(recibido);
					
				} while (recibido.length() != 0);

			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // try
		}// run
	}// ThreadRecibir

	private class ThreadEnviar extends Thread {
		public void run() {
				bt_Enviar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String mssg= taOut.getText();
						
						try {
							udpE.envia(mssg, mssg.length(), host.getText(), portOut);
							taOut.setText("");
							if(mssg.length()==0) System.exit(1);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
			
		}// run
	}// ThreadEnviar

}// class
