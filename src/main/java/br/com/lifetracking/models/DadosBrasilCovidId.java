package br.com.lifetracking.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class DadosBrasilCovidId implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column
	public String regiao;
	
	@Column
	public String estado;
	
	@Column
	public String municipio;
	
	@Column
	public String coduf;
	
	@Column
	public String codmun;
	
	@Column
	public String codRegiaoSaude;
	
	@Column
	public String data;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codRegiaoSaude == null) ? 0 : codRegiaoSaude.hashCode());
		result = prime * result + ((codmun == null) ? 0 : codmun.hashCode());
		result = prime * result + ((coduf == null) ? 0 : coduf.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DadosBrasilCovidId)) {
			return false;
		}
		final DadosBrasilCovidId other = (DadosBrasilCovidId) obj;
		if (codRegiaoSaude == null) {
			if (other.codRegiaoSaude != null) {
				return false;
			}
		} else if (!codRegiaoSaude.equals(other.codRegiaoSaude)) {
			return false;
		}
		if (codmun == null) {
			if (other.codmun != null) {
				return false;
			}
		} else if (!codmun.equals(other.codmun)) {
			return false;
		}
		if (coduf == null) {
			if (other.coduf != null) {
				return false;
			}
		} else if (!coduf.equals(other.coduf)) {
			return false;
		}
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (estado == null) {
			if (other.estado != null) {
				return false;
			}
		} else if (!estado.equals(other.estado)) {
			return false;
		}
		if (municipio == null) {
			if (other.municipio != null) {
				return false;
			}
		} else if (!municipio.equals(other.municipio)) {
			return false;
		}
		if (regiao == null) {
			if (other.regiao != null) {
				return false;
			}
		} else if (!regiao.equals(other.regiao)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("DadosBrasilCovidId [");
		if (codRegiaoSaude != null) {
			builder.append("codRegiaoSaude=").append(codRegiaoSaude).append(", ");
		}
		if (codmun != null) {
			builder.append("codmun=").append(codmun).append(", ");
		}
		if (coduf != null) {
			builder.append("coduf=").append(coduf).append(", ");
		}
		if (data != null) {
			builder.append("data=").append(data).append(", ");
		}
		if (estado != null) {
			builder.append("estado=").append(estado).append(", ");
		}
		if (municipio != null) {
			builder.append("municipio=").append(municipio).append(", ");
		}
		if (regiao != null) {
			builder.append("regiao=").append(regiao);
		}
		builder.append("]");
		return builder.toString();
	}

	
	    
}
