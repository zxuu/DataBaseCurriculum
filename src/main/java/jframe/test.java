package jframe;

import adapter.MyList;
import bean.DocListJpane;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends BaseJFrame {

//    MyList myList;

    public test(DocListJpane[] docListJpanes) throws HeadlessException {
        super("表界面",50,50,1000,1000);
//        myList = new MyList(docListJpanes);
        JList<DocListJpane> jList = new JList<>();
        jList.setPreferredSize(new Dimension(1000, 200));
        jList.setListData(docListJpanes);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                DocListJpane docListJpane = jList.getSelectedValue();
                System.out.println(docListJpane.toString());
            }
        });

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.add(jList);
        add(jScrollPane);
    }


}
