package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Motorista;
import model.Onibus;
import model.Viagem;

public class OnibusDao implements IOnibusDao{
	
	private GenericDao gDao;
	
	public OnibusDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public Onibus consultaOnibus(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		Viagem v = new Viagem();
		String sql = ("SELECT * FROM v_descricao_onibus WHERE cod_viagem = ? ");
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Motorista m = new Motorista();
			m.setNome(rs.getString("nome_motorista"));

			o.setPlaca(rs.getString("placa_onibus"));
			o.setMarca(rs.getString("marca_onibus"));
			o.setAno(rs.getInt("ano_onibus"));
			o.setDescricao(rs.getString("descricao_onibus"));

			v.setCodigo(rs.getInt("cod_viagem"));
			v.setMotorista(m);
			v.setOnibus(o);
		}

		rs.close();
		ps.close();
		c.close();

		return o;
	}

}
