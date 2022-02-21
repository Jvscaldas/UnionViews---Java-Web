package persistence;

import java.sql.SQLException;

import model.Onibus;

public interface IOnibusDao {
	
	public Onibus consultaOnibus (Onibus o) throws SQLException, ClassNotFoundException;

}
