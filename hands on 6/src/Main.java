import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> datos = new ArrayList<>();
        // Agregar datos al conjunto
        datos.add(8.2);
        datos.add(3.4);
        datos.add(5.6);
        datos.add(2.1);
        datos.add(4.8);
        datos.add(7.9);
        datos.add(4.4);
        datos.add(11.8);


        DataSet conjunto = new DataSet(datos);
        conjunto.mostrarTablaDescriptiva();
    }
}
