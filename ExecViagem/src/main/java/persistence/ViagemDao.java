package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.Onibus;
import model.Viagem;

public class ViagemDao implements IViagemDao {

	private GenericDao gDao;

	public ViagemDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public Viagem consultaViagem(Viagem v) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM v_descricao_viagem WHERE cod_viagem = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			v.setCodigo(rs.getInt("codigo"));
			v.setDestino(rs.getString("destino"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return v;
	
	}

	

}