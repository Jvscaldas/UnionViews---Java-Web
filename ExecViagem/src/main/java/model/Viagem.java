package model;

public class Viagem {

	private int codigo;
	private Onibus onibus;
	private Motorista motorista;
	private int hr_saida;
	private int hr_chegada;
	private String partida;
	private String destino;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public int getHr_saida() {
		return hr_saida;
	}

	public void setHr_saida(int hr_saida) {
		this.hr_saida = hr_saida;
	}

	public int getHr_chegada() {
		return hr_chegada;
	}

	public void setHr_chegada(int hr_chegada) {
		this.hr_chegada = hr_chegada;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Viagem [codigo=" + codigo + ", onibus=" + onibus + ", motorista=" + motorista + ", hr_saida=" + hr_saida
				+ ", hr_chegada=" + hr_chegada + ", partida=" + partida + ", destino=" + destino + "]";
	}

}
