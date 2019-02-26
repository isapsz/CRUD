package bd.dbo;

public class Clinica
{
	protected int codClinica;
	protected String nome, complemento;
	protected int cep, numero;

	public Clinica(int c, String n, int ce, int num, String com) throws Exception
	{
		this.setCodClinica(c);
		this.setNome(n);
		this.setCEP(ce);
		this.setNumero(num);
		this.setComplemento(com);
	}

	public int getCodClinica()
	{
		return this.codClinica;
	}

	public String getNome()
	{
		return this.nome;
	}

	public int getCEP()
	{
		return this.cep;
	}
	public String getComplemento()
	{
		return this.complemento;
	}

	public int getNumero()
	{
		return this.numero;
	}


	public void setCodClinica(int cod)	throws Exception
	{
		if(cod < 0)
			throw new Exception("Código de Clinica inválido!");

		this.codClinica = cod;
	}

	public void setNome(String nom)	throws Exception
	{
		if(nome == null || nome.equals(""))
			throw new Exception("Nome de Clinica inválido!");

		this.nome = nom;
	}

	public void setCEP(int cep)	throws Exception
	{
		if(cep < 0)
			throw new Exception("CEP inválido!");

		this.cep = cep;
	}
	
	public void setComplemento(String com)
	{
		this.complemento = com;
	}
	
	public void setNumero(int num) throws Exception
	{
		if(num < 0)
			 throw new Exception("Número inválido");
		
		this.numero = num;
	}

	public String toString()
	{
		String ret = "CodClinica: " + this.codClinica + "\n" +
					 "Nome:"     + this.nome    + "\n" +
					 "CEP:"   + this.cep + "\n" + 
					 "Numero:"   + this.numero + "\n" +
					 ((this.complemento == null || this.complemento.equals("")) ? "" : "Complemento: " + this.complemento);

		return ret;
	}

	public boolean equals(Object other)
	{
		if(this == other)
			return true;

		if(other == null)
			return false;

		if(this.getClass() != other.getClass())
			return false;

		Clinica cl = (Clinica) other;
		if(this.codClinica != cl.codClinica)
			return false;

		if(!this.nome.equals(cl.nome))
			return false;

		if(this.cep != cl.cep)
			return false;
		
		if(!this.complemento.equals(cl.complemento))
			return false;
		
		if(this.numero != cl.numero)
			return false;


		return true;
	}

	public int hashCode()
	{
		int ret = 1;

		ret = ret * 2 + new Integer(this.codClinica).hashCode();
		ret = ret * 2 + new Integer(this.cep).hashCode();
		ret = ret * 2 + new Integer(this.numero).hashCode();
		ret = ret * 2 + this.nome.hashCode();
		ret = ret * 2 + this.complemento.hashCode();

		return ret;
	}

	public Clinica(Clinica modelo)
	{
		this.nome = modelo.nome;
		this.complemento = modelo.complemento;
		this.cep = modelo.cep;
		this.codClinica = modelo.codClinica;
		this.numero = modelo.numero;
	}

	public Object clone()
	{
		Clinica ret = null;
		try
		{
			ret = new Clinica(this);
		}
		catch(Exception erro)
		{}

		return ret;
	}
}