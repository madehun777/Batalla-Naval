package com.mycompany.batallanaval.controlador;
import com.mycompany.batallanaval.modelo.Reporte;
import java.util.ArrayList;
import java.util.List;

public class ControladorReporte {
    private List<Reporte> reportes;

    public ControladorReporte() {
        this.reportes = new ArrayList<>();
    }

    public void guardarReporte(Reporte reporte) {
        reportes.add(reporte);
    }

    public List<Reporte> getReportes() {
        return reportes;
    }
}
