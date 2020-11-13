package ccb.stored.procedure.jobscheduler.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Response implements Serializable {

	private static final long serialVersionUID = -2685687881059631216L;

	private BigDecimal code;
	private String message;
	private BigDecimal totalPages;
	private BigDecimal totalRecords;

	private List<OtrTcliOpergaran> otrTcliOpergaran;

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BigDecimal getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(BigDecimal totalPages) {
		this.totalPages = totalPages;
	}

	public BigDecimal getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(BigDecimal totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<OtrTcliOpergaran> getOtrTcliOpergaran() {
		return otrTcliOpergaran;
	}

	public void setOtrTcliOpergaran(List<OtrTcliOpergaran> otrTcliOpergaran) {
		this.otrTcliOpergaran = otrTcliOpergaran;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + ", totalPages=" + totalPages + ", totalRecords="
				+ totalRecords + ", otrTcliOpergaran=" + otrTcliOpergaran + "]";
	}

}
