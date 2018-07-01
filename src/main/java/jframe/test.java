package jframe;

import javax.swing.*;
import java.awt.*;

public class test extends BaseJFrame {
    JList jList;
    public test(JList list) throws HeadlessException {
        super("test",50,50,1000,1000);
        JScrollPane s = new JScrollPane();
        s.add(list);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(s);
    }
}
