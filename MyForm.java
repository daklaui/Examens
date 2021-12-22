import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyForm extends JFrame {
    //les libelles
    JLabel formulaire = new JLabel("Exam Tp");
    JLabel nomL=new JLabel("Nom");
    JLabel genreL=new JLabel("genre");
    // les Inputs
    JTextField nomI = new JTextField();
    // les Buttons
    JButton valider=new JButton("Ajouter");
    JButton annuler=new JButton("Annuler");
    JRadioButton hommeI = new JRadioButton("Homme");
    JRadioButton femmeI = new JRadioButton("Femme");
    ButtonGroup bg = new ButtonGroup();
    public MyForm() {
        super("Exam");
        formulaire.setHorizontalAlignment(SwingConstants.CENTER);
        formulaire.setForeground(Color.black);
        formulaire.setFont(new Font("Time New Roman", Font.BOLD, 15));
        hommeI.setSelected(true);
        bg.add(hommeI);
        bg.add(femmeI);
        // Panel Formulaire
        JPanel panelFormulaire=new JPanel();
        panelFormulaire.setLayout(new GridLayout(5,1));
        panelFormulaire.add(nomL);
        panelFormulaire.add(nomI);
        panelFormulaire.add(genreL);
        panelFormulaire.add(hommeI);
        panelFormulaire.add(femmeI);
        // Panel Buttons
        JPanel panelBouttons=new JPanel();
        panelBouttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBouttons.add(valider);
        panelBouttons.add(annuler);
        // Panel Assemblages
        JPanel panelAssemblage=new JPanel();
        panelAssemblage.setLayout(new BorderLayout());
        panelAssemblage.add("Center",panelFormulaire);
        panelAssemblage.add("South",panelBouttons);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add("North",formulaire);
        c.add("Center",panelAssemblage);
        setSize(200,400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        show();
    }
    public static void main (String[] args)
    {
        new MyForm();
    }
}
