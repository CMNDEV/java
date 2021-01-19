import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculUn extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// constante

	JLabel question;
	JTextField nombre;
	JLabel resultat;


	// class principal

	public static void main(String[] args) {
		try {
			JFrame fenetre = new JFrame();
			fenetre.setSize(600, 400);
			fenetre.setLocation(600, 300);
			fenetre.setTitle("Calcul valeur de U(n)");
			fenetre.getContentPane().add(new CalculUn());
			fenetre.setVisible(true);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (NumberFormatException e) {
			
			e.printStackTrace();

		}

	}

	// constructeur
	public CalculUn() {
		question = new JLabel("Quel est la valeur de l ENTIER n :");
		nombre = new JTextField(2);
		nombre.addActionListener(this);
		resultat = new JLabel();
		resultat.setFont(new Font(null, 0, 18));
		add(question);
		add(nombre);
		add(resultat);
	}

	// calcul de la recusive U(n)
	public static int u(int n) {

		if (n == 0) {
			return 2;
		}

		if (n == 1) {
			return 5;
		}

		else
			return 2 * u(n - 1) + 3 * u(n - 2);

	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int n = Integer.parseInt(nombre.getText());
		int mResultat = u(n);
		resultat.setText("\nU(" + n+ ") vaut : " + mResultat);
	}

}
