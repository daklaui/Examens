import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyEvents implements ActionListener {
    MyForm form ;
    MyDataBase myDataBase;

    public MyEvents(MyForm form) {
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si l'action sur le boutton "Valider"
        if(e.getSource()==this.form.ajouter)
        {

        }

    }
}
