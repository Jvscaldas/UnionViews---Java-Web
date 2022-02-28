package model;

public class Viagem {

	private int cod_viagem;
	private Onibus onibus_viagem;
	private Motorista motorista_viagem;
	private String hr_saida_viagem;
	private String hr_chegada_viagem;
	private String partida_viagem;
	private String destino_viagem;

	public int getCodigo() {
		return cod_viagem;
	}

	public void setCodigo(int codigo) {
		this.cod_viagem = codigo;
	}

	public Onibus getOnibus() {
		return onibus_viagem;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus_viagem = onibus;
	}

	public Motorista getMotorista() {
		return motorista_viagem;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista_viagem = motorista;
	}

	public String getHr_saida() {
		return hr_saida_viagem;
	}

	public void setHr_saida(String hr_saida) {
		this.hr_saida_viagem = hr_saida;
	}

	public String getHr_chegada() {
		return hr_chegada_viagem;
	}

	public void setHr_chegada(String hr_chegada) {
		this.hr_chegada_viagem = hr_chegada;
	}

	public String getPartida() {
		return partida_viagem;
	}

	public void setPartida(String partida) {
		this.partida_viagem = partida;
	}

	public String getDestino() {
		return destino_viagem;
	}

	public void setDestino(String destino) {
		this.destino_viagem = destino;
	}

	@Override
	public String toString() {
		return "Viagem [codigo=" + cod_viagem + ", onibus=" + onibus_viagem + ", motorista=" + motorista_viagem
				+ ", hr_saida=" + hr_saida_viagem + ", hr_chegada=" + hr_chegada_viagem + ", partida=" + partida_viagem
				+ ", destino=" + destino_viagem + "]";
	}

}
