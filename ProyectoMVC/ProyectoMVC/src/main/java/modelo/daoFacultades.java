/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsFacultades;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoFacultades {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM siu.facultades";
    private static final String SQL_INSERT = "INSERT INTO siu.facultades(nombre_facultad, estatus_facultad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE siu.facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM siu.facultades WHERE codigo_facultad=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM siu.facultades WHERE nombre_facultad = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM siu.facultades WHERE codigo_facultad = ?";    

    public List<clsFacultades> consultaFacultades() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsFacultades> facultad = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");
                clsFacultades facultades = new clsFacultades();
                facultades.setCodigoFacultad(codigo);
                facultades.setNombreFacultad(nombre);
                facultades.setEstatusFacultad(estatus);
                facultad.add(facultades);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return facultad;
    }

    public int ingresaFacultades(clsFacultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, facultades.getNombreFacultad());
            stmt.setString(2, facultades.getEstatusFacultad());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaFacultades(clsFacultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, facultades.getNombreFacultad());
            stmt.setString(2, facultades.getEstatusFacultad());
            stmt.setInt(3, facultades.getCodigoFacultad());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarFacultades(clsFacultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, facultades.getCodigoFacultad());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsFacultades consultaFacultadesPorNombre(clsFacultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultades);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, facultades.getCodigoFacultad());            
            stmt.setString(1, facultades.getNombreFacultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                //facultades = new clsFacultades();
                facultades.setCodigoFacultad(codigo);
                facultades.setNombreFacultad(nombre);
                facultades.setEstatusFacultad(estatus);
                System.out.println(" registro consultado: " + facultades);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return facultades;
    }
    public clsFacultades consultaFacultadesPorCodigo(clsFacultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultades);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, facultades.getCodigoFacultad());            
            //stmt.setString(1, facultades.getNombreFacultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_facultad");
                String nombre = rs.getString("nombre_facultad");
                String estatus = rs.getString("estatus_facultad");

                //facultades = new clsFacultades();
                facultades.setCodigoFacultad(codigo);
                facultades.setNombreFacultad(nombre);
                facultades.setEstatusFacultad(estatus);
                System.out.println(" registro consultado: " + estatus);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return facultades;
    }    
}
