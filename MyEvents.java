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
        if(e.getSource()==this.form.valider)
        {
            myDataBase.ajouter(new Personne(this.form.nomI.getText(), this.form.prenomI.getText()));
        }

    }
}
