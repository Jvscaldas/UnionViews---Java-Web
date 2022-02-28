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
		String sql = ("SELECT * FROM v_descricao_viagem WHERE cod_viagem = ? ");
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Onibus o = new Onibus();
			o.setPlaca(rs.getString("placa_onibus"));

			v.setCodigo(rs.getInt("cod_viagem"));
			v.setOnibus(o);
			v.setHr_saida(rs.getString("hora_saida"));
			v.setHr_chegada(rs.getString("hora_chegada"));
			v.setPartida(rs.getString("partida_viagem"));
			v.setDestino(rs.getString("destino_viagem"));

		}

		rs.close();
		ps.close();
		c.close();

		return v;

	}

	@Override
	public Viagem consultaOnibus(Viagem v) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = ("SELECT * FROM v_descricao_onibus WHERE cod_viagem = ? ");
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Motorista m = new Motorista();
			m.setNome(rs.getString("nome_motorista"));

			Onibus o = new Onibus();
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

		return v;
	}

}