import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class MyList extends JFrame{
    DefaultTableModel model;
    JTable table ;
    JPanel chart;
    JScrollPane sp ;
    MyDataBase myDataBase;
    MyThread myThread;
    Graphics2D graphe;
    JFrame frame;
    String header[] = {"ID","Nom","Genre"};
    private final double phi = Math.toRadians(40);
    private final int barb = 20;
    private int chartWidth, chartHeight, chartX, chartY;
    public MyList() {
        myDataBase = new MyDataBase();
        model = new DefaultTableModel(header,0);
        table= new JTable(model);
        chart = new JPanel();
        sp = new JScrollPane();
        myThread = new MyThread(this);



    }
    private void drawArrowHead(Graphics2D g2, Point p1, Point p2, Color color)
    {
        g2.setPaint(color);
        double dy = p1.y - p2.y;
        double dx = p1.x - p2.x;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = p1.x - barb * Math.cos(rho);
            y = p1.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(p1.x, p1.y, x, y));
            rho = theta - phi;
        }
    }
    public void axesXY(int nbrPersonneH, int nbrPersonneF, String labelX,String labelY){
        int rightX = chartX + chartWidth;
        int topY = chartY - 150;
        Point southWest= new Point(chartX, chartY);
        Point northEast = new Point(rightX, chartY);
        graphe.draw(new Line2D.Double(southWest, northEast));
        drawArrowHead(graphe, northEast, southWest, Color.green);
        Point southWest1 = new Point(chartX, chartY );
        Point northEast1 = new Point(chartX, topY);
        graphe.draw(new Line2D.Double(southWest1, northEast1));
        drawArrowHead(graphe, northEast1, southWest1, Color.green);
        graphe.setColor(Color.red);
        graphe.drawString(labelX, chartWidth, chartY + 18) ;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        Font original = graphe.getFont();
        Font font = new Font(null, original.getStyle(), original.getSize());
        Font rotatedFont = font.deriveFont(affineTransform);
        graphe.setFont(rotatedFont);
        graphe.drawString(labelY,18, chartY - 25);
    }

    public void histogarmme (int number, Color color, int margin) {
        int barWidth = 50;
        int xLeft = 50 + margin;
        int yTopLeft = chartY - number;
        Rectangle rec = new Rectangle(xLeft, yTopLeft-100, barWidth, number+100);
        graphe.setColor(color);
        graphe.fill(rec);

        graphe.setColor(Color.green);
    }

    public void initScreen(){
        frame =new JFrame("My List");
        frame.setSize(800,400);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        sp.getViewport().add(table);
        sp.setPreferredSize(new Dimension(800,200));

        JPanel panelTable = new JPanel(new GridLayout(2,1));
        chart.setSize(800,400);
        panelTable.add(sp);
        panelTable.add(chart);
        chart.setBackground(Color.BLACK);
        Container c=frame.getContentPane();
        c.setLayout(new BorderLayout());
        c.add("Center",panelTable);
        frame.setVisible(true);
        remplirTab();

        myThread.start();

    }
    public void remplirTab(){
        int width = chart.getWidth();
        int height = chart.getHeight();
        myDataBase.remplirTab(model);
        chartHeight = Integer.parseInt(myDataBase.getPersonnes());
        chartWidth = width - 150;
        chartX = 25;
        chartY = height - 30;
        graphe=(Graphics2D)chart.getGraphics();
        String hommeNumber = myDataBase.getPersonneByGenre("Homme");
        String FemmeNumber = myDataBase.getPersonneByGenre("Femme");
        histogarmme(Integer.parseInt(hommeNumber),Color.blue,0);
        histogarmme(Integer.parseInt(FemmeNumber),Color.pink,60);
        axesXY(Integer.parseInt(hommeNumber), Integer.parseInt(FemmeNumber), "Genre","NbrPersonne");



    }
}
