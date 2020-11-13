package ccb.stored.procedure.jobscheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class OtrTcliOpergaran implements Serializable {

	private static final long serialVersionUID = -3170198397532303658L;

	private BigDecimal ogrCliente;
	private BigDecimal ogrCodofi;
	private BigDecimal ogrCodsuc;
	private BigDecimal ogrCodusr;
	private BigDecimal ogrCodusre;
	private Timestamp ogrFecdesde;
	private Timestamp ogrFecha;
	private Timestamp ogrFechasta;
	private Timestamp ogrFecprot;
	private BigDecimal ogrGrado;
	private String ogrHipoteca;
	private BigDecimal ogrMod;
	private BigDecimal ogrMontosol;
	private String ogrNotaria;
	private String ogrNotario;
	private String ogrNtestimonio;
	private BigDecimal ogrNumgaran;
	private BigDecimal ogrNumtra;
	private BigDecimal ogrNumtrae;
	private BigDecimal ogrOperacion;
	private String ogrRelacion;
	private BigDecimal ogrSaldoant;
	private BigDecimal ogrSaldocom;
	private BigDecimal ogrSecuencia;
	private BigDecimal ogrValor;

	public BigDecimal getOgrCliente() {
		return ogrCliente;
	}

	public void setOgrCliente(BigDecimal ogrCliente) {
		this.ogrCliente = ogrCliente;
	}

	public BigDecimal getOgrCodofi() {
		return ogrCodofi;
	}

	public void setOgrCodofi(BigDecimal ogrCodofi) {
		this.ogrCodofi = ogrCodofi;
	}

	public BigDecimal getOgrCodsuc() {
		return ogrCodsuc;
	}

	public void setOgrCodsuc(BigDecimal ogrCodsuc) {
		this.ogrCodsuc = ogrCodsuc;
	}

	public BigDecimal getOgrCodusr() {
		return ogrCodusr;
	}

	public void setOgrCodusr(BigDecimal ogrCodusr) {
		this.ogrCodusr = ogrCodusr;
	}

	public BigDecimal getOgrCodusre() {
		return ogrCodusre;
	}

	public void setOgrCodusre(BigDecimal ogrCodusre) {
		this.ogrCodusre = ogrCodusre;
	}

	public Timestamp getOgrFecdesde() {
		return ogrFecdesde;
	}

	public void setOgrFecdesde(Timestamp ogrFecdesde) {
		this.ogrFecdesde = ogrFecdesde;
	}

	public Timestamp getOgrFecha() {
		return ogrFecha;
	}

	public void setOgrFecha(Timestamp ogrFecha) {
		this.ogrFecha = ogrFecha;
	}

	public Timestamp getOgrFechasta() {
		return ogrFechasta;
	}

	public void setOgrFechasta(Timestamp ogrFechasta) {
		this.ogrFechasta = ogrFechasta;
	}

	public Timestamp getOgrFecprot() {
		return ogrFecprot;
	}

	public void setOgrFecprot(Timestamp ogrFecprot) {
		this.ogrFecprot = ogrFecprot;
	}

	public BigDecimal getOgrGrado() {
		return ogrGrado;
	}

	public void setOgrGrado(BigDecimal ogrGrado) {
		this.ogrGrado = ogrGrado;
	}

	public String getOgrHipoteca() {
		return ogrHipoteca;
	}

	public void setOgrHipoteca(String ogrHipoteca) {
		this.ogrHipoteca = ogrHipoteca;
	}

	public BigDecimal getOgrMod() {
		return ogrMod;
	}

	public void setOgrMod(BigDecimal ogrMod) {
		this.ogrMod = ogrMod;
	}

	public BigDecimal getOgrMontosol() {
		return ogrMontosol;
	}

	public void setOgrMontosol(BigDecimal ogrMontosol) {
		this.ogrMontosol = ogrMontosol;
	}

	public String getOgrNotaria() {
		return ogrNotaria;
	}

	public void setOgrNotaria(String ogrNotaria) {
		this.ogrNotaria = ogrNotaria;
	}

	public String getOgrNotario() {
		return ogrNotario;
	}

	public void setOgrNotario(String ogrNotario) {
		this.ogrNotario = ogrNotario;
	}

	public String getOgrNtestimonio() {
		return ogrNtestimonio;
	}

	public void setOgrNtestimonio(String ogrNtestimonio) {
		this.ogrNtestimonio = ogrNtestimonio;
	}

	public BigDecimal getOgrNumgaran() {
		return ogrNumgaran;
	}

	public void setOgrNumgaran(BigDecimal ogrNumgaran) {
		this.ogrNumgaran = ogrNumgaran;
	}

	public BigDecimal getOgrNumtra() {
		return ogrNumtra;
	}

	public void setOgrNumtra(BigDecimal ogrNumtra) {
		this.ogrNumtra = ogrNumtra;
	}

	public BigDecimal getOgrNumtrae() {
		return ogrNumtrae;
	}

	public void setOgrNumtrae(BigDecimal ogrNumtrae) {
		this.ogrNumtrae = ogrNumtrae;
	}

	public BigDecimal getOgrOperacion() {
		return ogrOperacion;
	}

	public void setOgrOperacion(BigDecimal ogrOperacion) {
		this.ogrOperacion = ogrOperacion;
	}

	public String getOgrRelacion() {
		return ogrRelacion;
	}

	public void setOgrRelacion(String ogrRelacion) {
		this.ogrRelacion = ogrRelacion;
	}

	public BigDecimal getOgrSaldoant() {
		return ogrSaldoant;
	}

	public void setOgrSaldoant(BigDecimal ogrSaldoant) {
		this.ogrSaldoant = ogrSaldoant;
	}

	public BigDecimal getOgrSaldocom() {
		return ogrSaldocom;
	}

	public void setOgrSaldocom(BigDecimal ogrSaldocom) {
		this.ogrSaldocom = ogrSaldocom;
	}

	public BigDecimal getOgrSecuencia() {
		return ogrSecuencia;
	}

	public void setOgrSecuencia(BigDecimal ogrSecuencia) {
		this.ogrSecuencia = ogrSecuencia;
	}

	public BigDecimal getOgrValor() {
		return ogrValor;
	}

	public void setOgrValor(BigDecimal ogrValor) {
		this.ogrValor = ogrValor;
	}

	@Override
	public String toString() {
		return "OtrTcliOpergaran [ogrCliente=" + ogrCliente + ", ogrCodofi=" + ogrCodofi + ", ogrCodsuc=" + ogrCodsuc
				+ ", ogrCodusr=" + ogrCodusr + ", ogrCodusre=" + ogrCodusre + ", ogrFecdesde=" + ogrFecdesde
				+ ", ogrFecha=" + ogrFecha + ", ogrFechasta=" + ogrFechasta + ", ogrFecprot=" + ogrFecprot
				+ ", ogrGrado=" + ogrGrado + ", ogrHipoteca=" + ogrHipoteca + ", ogrMod=" + ogrMod + ", ogrMontosol="
				+ ogrMontosol + ", ogrNotaria=" + ogrNotaria + ", ogrNotario=" + ogrNotario + ", ogrNtestimonio="
				+ ogrNtestimonio + ", ogrNumgaran=" + ogrNumgaran + ", ogrNumtra=" + ogrNumtra + ", ogrNumtrae="
				+ ogrNumtrae + ", ogrOperacion=" + ogrOperacion + ", ogrRelacion=" + ogrRelacion + ", ogrSaldoant="
				+ ogrSaldoant + ", ogrSaldocom=" + ogrSaldocom + ", ogrSecuencia=" + ogrSecuencia + ", ogrValor="
				+ ogrValor + "]";
	}

}
