/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCursos;
/**
 *
 * @author visitante
 */
public class clsCursos {
    private String codigo_curso;
    private String nombre_curso;
    private String estatus_curso;

    public clsCursos() {
    }

    public clsCursos(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public clsCursos(String nombre_curso, String estatus_curso) {
        this.nombre_curso = nombre_curso;
        this.estatus_curso = estatus_curso;
    }

    public clsCursos(String codigo_curso, String nombre_curso, String estatus_curso) {
        this.codigo_curso = codigo_curso;
        this.nombre_curso = nombre_curso;
        this.estatus_curso = estatus_curso;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getEstatus_curso() {
        return estatus_curso;
    }

    public void setEstatus_curso(String estatus_curso) {
        this.estatus_curso = estatus_curso;
    }

    
    @Override
    public String toString() {
        return "clsCursos{" + "codigo_curso=" + codigo_curso + ", nombre_curso=" + nombre_curso + ", estatus_curso=" + estatus_curso + '}';
    }
    //Metodos de acceso a la capa controlador
  public clsCursos getBuscarInformacionCursosPorNombre(clsCursos curso)
    {
        daoCursos daocurso= new daoCursos ();
        return daocurso.consultaCursosPorNombre(curso);
    }
    public clsCursos getBuscarInformacionCursosPorId(clsCursos curso)
    {
        daoCursos daocurso= new daoCursos();
        return daocurso.consultaCursosporId(curso);
    }    
    public List<clsCursos> getListadoCursos()
    {
        daoCursos daocurso = new daoCursos();
        List<clsCursos> listadoCursos = daocurso.consultaCursos();
        return listadoCursos;
    }
    public int setBorrarCurso(clsCursos curso)
    {
        daoCursos daocurso = new daoCursos();
        return daocurso.borrarCursos(curso);
    }          
    public int setIngresarCurso(clsCursos curso)
    {
        daoCursos daocurso = new  daoCursos();
        return daocurso.ingresaCursos(curso);
    }              
    public int setModificarCurso(clsCursos curso)
    {
        daoCursos daocurso = new daoCursos();
        return daocurso.actualizaCursos(curso);
    }                           

}



