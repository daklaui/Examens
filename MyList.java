import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyList extends JFrame {
    String entete[] = {"id","Nom","Genre"};
    DefaultTableModel model = new DefaultTableModel(entete,3);
    JTable table = new JTable(model);
    JScrollPane sp = new JScrollPane();
    public MyList() {
        super("MyList");
        sp.getViewport().add(table);
        sp.setPreferredSize(new Dimension(600,200));
        JPanel panelTable = new JPanel();
        panelTable.add(sp);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center",panelTable);
        setSize(600,400);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        show();

    }
    public static void main (String[] args) {
        new MyList();
    }
}
