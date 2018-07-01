package adapter;


import bean.DocJpane;
import bean.DocListJpane;
import model.Doctors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsCellRenderer implements ListCellRenderer{

    DocListJpane docListJpane;

    public DoctorsCellRenderer() {
        docListJpane = new DocListJpane(new Doctors());
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            value.toString();

        }
        return docListJpane;
    }
}
