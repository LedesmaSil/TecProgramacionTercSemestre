from Persona import Persona
from conexion import Conexion
from logger_base import log


class personaDAO:
    """"
    DAO significa: Data Access Object
    CRUD significa:
                    Create -> Insertar
                    Read ->Seleccionar
                    Update ->Actualizar
                    Delete -> Eliminar
    """
    _SELECCIONAR = 'SELECT * FROM persona ORDER BY id_Personar'
    _INSERTAR = 'INSERT INTO persona(nombre, apellido, email) VALUES (%s, %s, %S)'
    _ACTUALIZAR = 'UPDATE persona SET nombre=%s, apellido=%s, email=%s WHERE id_persona=%s'
    _ELIMINAR = 'DELETE FROM persona WHERE id_persona=%s'

   