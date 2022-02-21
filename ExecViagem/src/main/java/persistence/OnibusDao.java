package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Onibus;

public class OnibusDao implements IOnibusDao{
	
	private GenericDao gDao;
	
	public OnibusDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public Onibus consultaOnibus(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM onibus WHERE placa_onibus = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getPlaca());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			o.setPlaca(rs.getString("placa"));
		}
		
		rs.close();
		ps.close();
		c.close();
		
		return o;
	}

}
