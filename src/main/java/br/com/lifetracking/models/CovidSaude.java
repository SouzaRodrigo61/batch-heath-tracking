package br.com.lifetracking.models;

import java.time.LocalDate;

public class CovidSaude {
    
    private String regiao;
    private String estado;
    private String municipio;
    private String coduf;
    private String codmun;
    private String codRegiaoSaude;
    private String nomeRegiaoSaude;
    private LocalDate data;
    private Integer semanaEpi;
    private Long populacaoTCU2019;
    private Long casosNovos;
    private Long obitosAcumulado;
    private Long obitosNovos;
    private Long recuperadosNovos; 
    private String emAcompanhamentoNovos;
    
    /**
	 * 
	 */
	public CovidSaude() {
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((casosNovos == null) ? 0 : casosNovos.hashCode());
		result = prime * result + ((codRegiaoSaude == null) ? 0 : codRegiaoSaude.hashCode());
		result = prime * result + ((codmun == null) ? 0 : codmun.hashCode());
		result = prime * result + ((coduf == null) ? 0 : coduf.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((emAcompanhamentoNovos == null) ? 0 : emAcompanhamentoNovos.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nomeRegiaoSaude == null) ? 0 : nomeRegiaoSaude.hashCode());
		result = prime * result + ((obitosAcumulado == null) ? 0 : obitosAcumulado.hashCode());
		result = prime * result + ((obitosNovos == null) ? 0 : obitosNovos.hashCode());
		result = prime * result + ((populacaoTCU2019 == null) ? 0 : populacaoTCU2019.hashCode());
		result = prime * result + ((recuperadosNovos == null) ? 0 : recuperadosNovos.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		result = prime * result + ((semanaEpi == null) ? 0 : semanaEpi.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CovidSaude)) {
			return false;
		}
		CovidSaude other = (CovidSaude) obj;
		if (casosNovos == null) {
			if (other.casosNovos != null) {
				return false;
			}
		} else if (!casosNovos.equals(other.casosNovos)) {
			return false;
		}
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
		if (emAcompanhamentoNovos == null) {
			if (other.emAcompanhamentoNovos != null) {
				return false;
			}
		} else if (!emAcompanhamentoNovos.equals(other.emAcompanhamentoNovos)) {
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
		if (nomeRegiaoSaude == null) {
			if (other.nomeRegiaoSaude != null) {
				return false;
			}
		} else if (!nomeRegiaoSaude.equals(other.nomeRegiaoSaude)) {
			return false;
		}
		if (obitosAcumulado == null) {
			if (other.obitosAcumulado != null) {
				return false;
			}
		} else if (!obitosAcumulado.equals(other.obitosAcumulado)) {
			return false;
		}
		if (obitosNovos == null) {
			if (other.obitosNovos != null) {
				return false;
			}
		} else if (!obitosNovos.equals(other.obitosNovos)) {
			return false;
		}
		if (populacaoTCU2019 == null) {
			if (other.populacaoTCU2019 != null) {
				return false;
			}
		} else if (!populacaoTCU2019.equals(other.populacaoTCU2019)) {
			return false;
		}
		if (recuperadosNovos == null) {
			if (other.recuperadosNovos != null) {
				return false;
			}
		} else if (!recuperadosNovos.equals(other.recuperadosNovos)) {
			return false;
		}
		if (regiao == null) {
			if (other.regiao != null) {
				return false;
			}
		} else if (!regiao.equals(other.regiao)) {
			return false;
		}
		if (semanaEpi == null) {
			if (other.semanaEpi != null) {
				return false;
			}
		} else if (!semanaEpi.equals(other.semanaEpi)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CovidSaude [");
		if (casosNovos != null) {
			builder.append("casosNovos=").append(casosNovos).append(", ");
		}
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
		if (emAcompanhamentoNovos != null) {
			builder.append("emAcompanhamentoNovos=").append(emAcompanhamentoNovos).append(", ");
		}
		if (estado != null) {
			builder.append("estado=").append(estado).append(", ");
		}
		if (municipio != null) {
			builder.append("municipio=").append(municipio).append(", ");
		}
		if (nomeRegiaoSaude != null) {
			builder.append("nomeRegiaoSaude=").append(nomeRegiaoSaude).append(", ");
		}
		if (obitosAcumulado != null) {
			builder.append("obitosAcumulado=").append(obitosAcumulado).append(", ");
		}
		if (obitosNovos != null) {
			builder.append("obitosNovos=").append(obitosNovos).append(", ");
		}
		if (populacaoTCU2019 != null) {
			builder.append("populacaoTCU2019=").append(populacaoTCU2019).append(", ");
		}
		if (recuperadosNovos != null) {
			builder.append("recuperadosNovos=").append(recuperadosNovos).append(", ");
		}
		if (regiao != null) {
			builder.append("regiao=").append(regiao).append(", ");
		}
		if (semanaEpi != null) {
			builder.append("semanaEpi=").append(semanaEpi);
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the regiao
	 */
	public String getRegiao() {
		return regiao;
	}

	/**
	 * @param regiao the regiao to set
	 */
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the coduf
	 */
	public String getCoduf() {
		return coduf;
	}

	/**
	 * @param coduf the coduf to set
	 */
	public void setCoduf(String coduf) {
		this.coduf = coduf;
	}

	/**
	 * @return the codmun
	 */
	public String getCodmun() {
		return codmun;
	}

	/**
	 * @param codmun the codmun to set
	 */
	public void setCodmun(String codmun) {
		this.codmun = codmun;
	}

	/**
	 * @return the codRegiaoSaude
	 */
	public String getCodRegiaoSaude() {
		return codRegiaoSaude;
	}

	/**
	 * @param codRegiaoSaude the codRegiaoSaude to set
	 */
	public void setCodRegiaoSaude(String codRegiaoSaude) {
		this.codRegiaoSaude = codRegiaoSaude;
	}

	/**
	 * @return the nomeRegiaoSaude
	 */
	public String getNomeRegiaoSaude() {
		return nomeRegiaoSaude;
	}

	/**
	 * @param nomeRegiaoSaude the nomeRegiaoSaude to set
	 */
	public void setNomeRegiaoSaude(String nomeRegiaoSaude) {
		this.nomeRegiaoSaude = nomeRegiaoSaude;
	}

	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * @return the semanaEpi
	 */
	public Integer getSemanaEpi() {
		return semanaEpi;
	}

	/**
	 * @param semanaEpi the semanaEpi to set
	 */
	public void setSemanaEpi(Integer semanaEpi) {
		this.semanaEpi = semanaEpi;
	}

	/**
	 * @return the populacaoTCU2019
	 */
	public Long getPopulacaoTCU2019() {
		return populacaoTCU2019;
	}

	/**
	 * @param populacaoTCU2019 the populacaoTCU2019 to set
	 */
	public void setPopulacaoTCU2019(Long populacaoTCU2019) {
		this.populacaoTCU2019 = populacaoTCU2019;
	}

	/**
	 * @return the casosNovos
	 */
	public Long getCasosNovos() {
		return casosNovos;
	}

	/**
	 * @param casosNovos the casosNovos to set
	 */
	public void setCasosNovos(Long casosNovos) {
		this.casosNovos = casosNovos;
	}

	/**
	 * @return the obitosAcumulado
	 */
	public Long getObitosAcumulado() {
		return obitosAcumulado;
	}

	/**
	 * @param obitosAcumulado the obitosAcumulado to set
	 */
	public void setObitosAcumulado(Long obitosAcumulado) {
		this.obitosAcumulado = obitosAcumulado;
	}

	/**
	 * @return the obitosNovos
	 */
	public Long getObitosNovos() {
		return obitosNovos;
	}

	/**
	 * @param obitosNovos the obitosNovos to set
	 */
	public void setObitosNovos(Long obitosNovos) {
		this.obitosNovos = obitosNovos;
	}

	/**
	 * @return the recuperadosNovos
	 */
	public Long getRecuperadosNovos() {
		return recuperadosNovos;
	}

	/**
	 * @param recuperadosNovos the recuperadosNovos to set
	 */
	public void setRecuperadosNovos(Long recuperadosNovos) {
		this.recuperadosNovos = recuperadosNovos;
	}

	/**
	 * @return the emAcompanhamentoNovos
	 */
	public String getEmAcompanhamentoNovos() {
		return emAcompanhamentoNovos;
	}

	/**
	 * @param emAcompanhamentoNovos the emAcompanhamentoNovos to set
	 */
	public void setEmAcompanhamentoNovos(String emAcompanhamentoNovos) {
		this.emAcompanhamentoNovos = emAcompanhamentoNovos;
	}

	
    
}
