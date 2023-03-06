/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCarreras;
/**
 *
 * @author visitante
 */
public class clsCarreras {
    private int CodigoCarrera;
    private String NombreCarrera;
    private int CodigoFacultad;
    private String EstatusCarrera;

    public int getCodigoCarrera() {
        return CodigoCarrera;
    }

    public void setCodigoCarrera(int CodigoCarrera) {
        this.CodigoCarrera = CodigoCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public int getCodigoFacultad() {
        return CodigoFacultad;
    }

    public void setCodigoFacultad(int CodigoFacultad) {
        this.CodigoFacultad = CodigoFacultad;
    }

    public String getEstatusCarrera() {
        return EstatusCarrera;
    }

    public void setEstatusCarrera(String EstatusCarrera) {
        this.EstatusCarrera = EstatusCarrera;
    }

    /**
     *
     * @param CodigoFacultad
     */
    public clsCarreras(int CodigoFacultad) {
        this.CodigoFacultad = CodigoFacultad;
    }

    public clsCarreras(int CodigoCarrera, String NombreCarrera) {
        this.CodigoCarrera = CodigoCarrera;
        this.NombreCarrera = NombreCarrera;
    }

    public clsCarreras(int CodigoCarrera, String NombreCarrera, int CodigoFacultad, String EstatusCarrera) {
        this.CodigoCarrera = CodigoCarrera;
        this.NombreCarrera = NombreCarrera;
        this.CodigoFacultad = CodigoFacultad;
        this.EstatusCarrera = EstatusCarrera;
    }


    public clsCarreras() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsCarreras getBuscarInformacionCarrerasPorNombre(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorNombre(carreras);
    }
    public clsCarreras getBuscarInformacionCarrerasPorCodigo(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorCodigo(carreras);
    }    
    public List<clsCarreras> getListadoCarreras()
    {
        daoCarreras daocarreras = new daoCarreras();
        List<clsCarreras> listadoCarreras = daocarreras.consultaCarreras();
        return listadoCarreras;
    }
    public int setBorrarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.borrarCarreras(carreras);
    }          
    public int setIngresarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.ingresaCarreras(carreras);
    }              
    public int setModificarCarreras(clsCarreras carreras)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.actualizaCarreras(carreras);
    }              

}
