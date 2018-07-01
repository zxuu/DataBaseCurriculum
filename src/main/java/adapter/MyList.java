package adapter;

import bean.DocListJpane;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionListener;

public class MyList implements ListModel {
    DocListJpane[] docListJpanes;
    public MyList(DocListJpane[] docListJpanes) {
        this.docListJpanes = docListJpanes;
    }

    @Override
    public int getSize() {
        return docListJpanes.length;
    }

    @Override
    public Object getElementAt(int index) {
        return docListJpanes[index];
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
