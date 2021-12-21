import javax.swing.*;
import java.awt.*;

public class MyForm extends JFrame {
    JLabel nomL=new JLabel("Nom");
    JLabel prenomL=new JLabel("Prenom");
    JLabel genreL=new JLabel("genre");
    JTextField nomI = new JTextField();
    JTextField prenomI = new JTextField();
    JButton valider=new JButton("Valider");
    JButton annuler=new JButton("Annuler");
    JRadioButton hommeI = new JRadioButton("Homme");
    JRadioButton femmeI = new JRadioButton("Femme");
    public MyForm() {
        super("Exam");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(nomL);
        c.add(nomI);
        c.add(prenomL);
        c.add(prenomI);
        c.add(genreL);
        c.add(hommeI);
        c.add(femmeI);
        c.add(valider);
        c.add(annuler);
        setSize(500,200);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        show();
    }
    public static void main (String[] args)
    {
        new MyForm();
    }
}
