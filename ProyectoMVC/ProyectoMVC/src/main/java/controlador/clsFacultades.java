/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoFacultades;
import modelo.daoCarreras;
/**
 *
 * @author visitante
 */
public class clsFacultades {
    private int CodigoFacultad;
    private String NombreFacultad;
    private String EstatusFacultad;

    public int getCodigoFacultad() {
        return CodigoFacultad;
    }

    public void setCodigoFacultad(int CodigoFacultad) {
        this.CodigoFacultad = CodigoFacultad;
    }

    public String getNombreFacultad() {
        return NombreFacultad;
    }

    public void setNombreFacultad(String NombreFacultad) {
        this.NombreFacultad = NombreFacultad;
    }

    public String getEstatusFacultad() {
        return EstatusFacultad;
    }

    public void setEstatusFacultad(String EstatusFacultad) {
        this.EstatusFacultad = EstatusFacultad;
    }

    public clsFacultades(int CodigoFacultad, String NombreFacultad) {
        this.CodigoFacultad = CodigoFacultad;
        this.NombreFacultad = NombreFacultad;
    }

    public clsFacultades(int CodigoFacultad, String NombreFacultad, String EstatusFacultad) {
        this.CodigoFacultad = CodigoFacultad;
        this.NombreFacultad = NombreFacultad;
        this.EstatusFacultad = EstatusFacultad;
    }

    public clsFacultades(int CodigoFacultad) {
        this.CodigoFacultad = CodigoFacultad;
    }

    public clsFacultades() {
    }
    //Metodos de acceso a la capa controlador
    public clsFacultades getBuscarInformacionFacultadesPorNombre(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.consultaFacultadesPorNombre(facultades);
    }
    public clsFacultades getBuscarInformacionFacultadesPorCodigo(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.consultaFacultadesPorCodigo(facultades);
    }    
    public List<clsFacultades> getListadoFacultades()
    {
        daoFacultades daofacultades = new daoFacultades();
        List<clsFacultades> listadoFacultades = daofacultades.consultaFacultades();
        return listadoFacultades;
    }
    public int setBorrarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.borrarFacultades(facultades);
    }          
    public int setIngresarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.ingresaFacultades(facultades);
    }              
    public int setModificarFacultades(clsFacultades facultades)
    {
        daoFacultades daofacultades = new daoFacultades();
        return daofacultades.actualizaFacultades(facultades);
    }              

}
