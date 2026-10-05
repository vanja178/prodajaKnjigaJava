package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ApstraktniDomenskiObjekat;

public class ModelTabele<T extends ApstraktniDomenskiObjekat> extends AbstractTableModel {

    private List<T> lista;
    private String[] kolone;

    public ModelTabele(List<T> lista) {
        this.lista = lista;
        if (lista != null && !lista.isEmpty()) {
            kolone = lista.get(0).getNazivKolone();
        }
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        }
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        if (kolone == null) {
            return 0;
        }
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] o = lista.get(rowIndex).getNizObjekta();
        return o[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ApstraktniDomenskiObjekat getSelektovanaStavka(int i) {
        return lista.get(i);
    }
}
