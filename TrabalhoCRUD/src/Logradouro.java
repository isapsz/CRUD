

public class Logradouro
{
    private String logradouro;
    public  String getLogradouro ()
    {
        return this.logradouro;
    }
    public void setLogradouro (String logradouro)
    {
        this.logradouro = logradouro;
    }

    private String bairro;

    public  String getBairro ()
    {
        return this.bairro;
    }
    public void setBairro (String bairro)
    {
        this.bairro = bairro;
    }

    private String cidade;
    public  String getCidade ()
    {
        return this.cidade;
    }
    public void setCidade (String cidade) throws Exception
    {
        if (cidade==null || cidade.length()==0)
            throw new Exception ("Cidade ausente");

        this.cidade = cidade;
    }

    private InfoCidade cidade_info;
    public InfoCidade getCidade_info ()
    {
        return (InfoCidade)this.cidade_info.clone();
    }
    public void setCidade_info (InfoCidade infoCidade) throws Exception
    {
        if (infoCidade==null)
            throw new Exception ("Informacao de cidade ausente");

        this.cidade_info = (InfoCidade)infoCidade.clone();
    }

    private String estado;
    public  String getEstado ()
    {
        return this.estado;
    }
    public void setEstado (String estado) throws Exception
    {
        if (estado==null || estado.length()==0)
            throw new Exception ("Estado ausente");

        this.estado = estado;
    }

    private InfoEstado estado_info;
    public  InfoEstado getEstado_info ()
    {
        return (InfoEstado)this.estado_info.clone();
    }
    public void setEstado_info (InfoEstado infoEstado) throws Exception
    {
        if (infoEstado==null)
            throw new Exception ("Informacao de estado ausente");

         this.estado_info = (InfoEstado)infoEstado.clone();
    }

    private String cep;
    public  String getCep ()
    {
         return this.cep;
    }
    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.length()==0)
            throw new Exception ("Logradouro ausente");

         this.cep = cep;
    }
    
    private String complemento;
    
    public String getComplemento()
    {
    	return this.complemento;
    }
    
    public void setComplemento(String complemento)
    {
    	this.complemento = complemento;
    }
    

    public Logradouro (String logradouro, String bairro,
                       String cidade, InfoCidade cidade_info,
                       String estado, InfoEstado estado_info,
                       String cep, String complemento) throws Exception
    {
        this.setLogradouro  (logradouro);
        this.setBairro      (bairro);
        this.setCidade      (cidade);
        this.setCidade_info (cidade_info);
        this.setEstado      (estado);
        this.setEstado_info (estado_info);
        this.setCep         (cep); 
        this.setComplemento(complemento);
    }

    // exigencia do mapeador de JSon
    public Logradouro () {}

    public String toString ()
    {
        return ((this.logradouro == null)? "" : "\nLogradouro:" + this.logradouro)"+
               "\nCidade....: "+
               this.cidade+
               " / "+
               this.cidade_info+
               "\nEstado....: "+
               this.estado+
               " / "+
               this.estado_info+
               "\nC.E.P.....: "+
               this.cep + ((this.complemento == null)? "" : "\nComplemento:" + this.complemento);
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

      //if (!(this.getClass() != obj.getClass())
      //if (!(obj.getClass != Logradouro.class))
        if (!(obj instanceof Logradouro))
            return false;

        Logradouro cep = (Logradouro)obj;

        if (!this.logradouro.equals(cep.logradouro))
            return false;

        if (!this.cidade.equals(cep.cidade))
            return false;

        if (!this.cidade_info.equals(cep.cidade_info))
            return false;

        if (!this.estado.equals(cep.estado))
            return false;

        if (!this.estado_info.equals(cep.estado_info))
            return false;

        if (!this.cep.equals(cep.cep))
            return false;
        
        if(!this.complemento.equals(cep.complemento))
        	return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.logradouro .hashCode();
        ret = 2*ret + this.cidade     .hashCode();
        ret = 2*ret + this.cidade_info.hashCode();
        ret = 2*ret + this.estado     .hashCode();
        ret = 2*ret + this.estado_info.hashCode();
        ret = 2*ret + this.cep        .hashCode();
        ret = 2*ret+ this.complemento.hashCode();

        return ret;
    }

    public Logradouro (Logradouro modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.logradouro  = modelo.logradouro;
        this.cidade      = modelo.cidade;
        this.cidade_info = (InfoCidade)modelo.cidade_info.clone();
        this.estado      = modelo.estado;
        this.estado_info = (InfoEstado)modelo.estado_info.clone();
        this.cep         = modelo.cep;
        this.complemento = modelo.complemento;
    }

    public Object clone ()
    {
        Logradouro ret=null;

        try
        {
            ret = new Logradouro (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}