package persistence;

import java.sql.SQLException;

import model.Viagem;

public interface IViagemDao {

	public Viagem consultaViagem(Viagem v) throws SQLException, ClassNotFoundException;
}