package UTN.datos;

import UTN.dominio.Estudiante;

import static UTN.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class EstudianteDAO {
    //Método listar
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        //Creamos algunos objetos que son necesarios para comunicarnos con la base de datos
        PreparedStatement ps; //Envia la sentencia a la base de datos
        ResultSet rs; //Obtenemos el resultado de la base de datos
        //Creamos un objeto de tipo conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                //Falta agregarlo a la lista
                estudiantes.add(estudiante);
            }
        } catch (Exception e){
            System.out.println("Ocurrió un error al seleccionar datos: "+e.getMessage());
        }
        finally {
            {
                try{
                    con.close();
                }catch (Exception e){
                    System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
                }
            }
        }//Fin finally
        return estudiantes;
    }//Fin método listar

    //Método por id -> fin by id
    public boolean buscarEStudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return  true; //Se encontro un registro
            }//Fin if
        } catch (Exception e){
            System.out.println("Ocurrió un error al buscar estudiante: " +e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexion: " + e.getMessage());
            }//Fin catch
        }//Fin finally
        return  false;
    }

    //Método agregar un nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());
        }//Fin catch
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion:  " + e.getMessage());
            }//Fin catch
        }//Fin finally
        return false;
    }//Fin método agregarEstudiante

    //Método para modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
        } catch (Exception e){
            System.out.println("Error al modificar estudiante: " + e.getMessage());
        }//Fin catch
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexion:  " + e.getMessage());
            }//Fin catch
        }//Fin finally
        return false;
    }// Fin método modificarEstudiante
    public static void main(String[] args){
        var estudianteDao = new  EstudianteDAO();
        //Módificar estudiante
        var estudianteModificado = new Estudiante(1, "Juan Carlos", "Juarez", "6464535165","juan@mail.com");
        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
        if (modificado)
            System.out.println("estudiante modificado: " + estudianteModificado);
        else
            System.out.println("No se modificó el estudiante: " +estudianteModificado);

        //Agregar estudiante
        //var nuevoEstudiante = new Estudiante("Carlos", "Lara", "65465421", "carlosl@mail.com");
        //var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        //if(agregado)
        //    System.out.println("Estudiante agregardo: " +nuevoEstudiante);
        //else
        //    System.out.println("No se ha agregado estudiante: " + nuevoEstudiante);


        //Listar los estudiantes
        System.out.println("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);//Funcion lambda para imprimir


        //Buscar por id
        //var estudiante1 = new Estudiante(1);
        //System.out.println("Estudiantes antes de la busqueda: " + estudiante1);
        //var encontrado = estudianteDao.buscarEStudiantePorId(estudiante1);
        //if(encontrado)
        //    System.out.println("Estudiante encontrado: " + encontrado);
        //else
        //    System.out.println("No se encontró el estudiante: "+estudiante1.getIdEstudiante());
    }
}
