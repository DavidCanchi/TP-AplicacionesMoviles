package com.tp.tpunla.data;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.tp.tpunla.models.Usuario;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioManager {
    private static UsuarioManager instancia;
    Dao<Usuario, Integer> dao;

    public UsuarioManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try {
            dao = helper.getDao(Usuario.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static UsuarioManager getInstancia(Context context) {
        if(instancia == null) {
            instancia = new UsuarioManager(context);
        }
        return instancia;
    }

    /**
     * Verifica si los datos de usuario y contraseña son correctos
     * @param usuario
     * @param password
     * @return true si los datos son correctos
     * @throws SQLException e
     */
    public boolean isUsuarioCorrecto(String usuario, String password) throws SQLException {
        Map<String, Object> usuarioQuery = new HashMap<>();
        usuarioQuery.put("usuario", usuario);
        usuarioQuery.put("password", password);
        List<Usuario> usuarios = dao.queryForFieldValues(usuarioQuery);
        return usuarios.size() > 0;
    }

    /**
     * Verifica si el nombre de usuario o correo electronico ya setá guardado en la base de datos
     * @param usuario
     * @param email
     * @return true si ni el nombre de usuario ni password estan registrados
     * @throws SQLException e
     */
    public boolean isUsuarioValido(String usuario, String email) throws SQLException {
            QueryBuilder<Usuario, Integer> queryBuilder = dao.queryBuilder();
            Where<Usuario, Integer> where = queryBuilder.where();
            where.or(where.eq("usuario", usuario), where.eq("email", email));
            PreparedQuery<Usuario> preparedQuery = queryBuilder.prepare();
            List<Usuario> usuarios = dao.query(preparedQuery);
            return usuarios.size() == 0;
    }

    public void agregarUsuario(Usuario examen) throws SQLException {
        dao.create(examen);
    }
}
