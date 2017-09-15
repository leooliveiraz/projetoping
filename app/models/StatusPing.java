package models;

import java.util.Date;

public class StatusPing {
	private String descricao;
	private Date data;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusPing other = (StatusPing) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Status [descricao=" + descricao + ", data=" + data + "]";
	}
	public StatusPing() {
		setDescricao("OK");
		setData(new Date());
	}
	public StatusPing(String descricao, Date data) {
		super();
		this.descricao = descricao;
		this.data = data;
	}
	
	
}
