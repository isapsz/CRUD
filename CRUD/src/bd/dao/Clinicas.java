 package bd.dao;

 import java.sql.*;
 import bd.*;
 import bd.core.*;
 import bd.dbo.*;

 public class Clinicas
 {
	 public static Clinica getClinica (int codClinica) throws Exception
	     {
	         Clinica clinica = null;

	         try
	         {
	             String sql;

	             sql = "SELECT * FROM CLINICAS WHERE CODCLINICA = ?";

	             BDSQLServer.COMANDO.prepareStatement (sql);

	             BDSQLServer.COMANDO.setInt (1, codClinica);

	             MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	             if (!resultado.first())
	                 throw new Exception ("Clinica nao cadastrada");

	             clinica = new Clinica (resultado.getInt   ("CODCLINICA"),
	                              resultado.getString("NOME"),
	                              resultado.getInt	 ("CEP"),
	                              resultado.getInt("NUMERO"),
	                              resultado.getString("COMPLEMENTO"));
	         }
	         catch (SQLException erro)
	         {
	             throw new Exception ("Erro ao procurar clinica");
	         }

	    return clinica;
    }
	 
	 public static boolean cadastrado (int codigo) throws Exception
	 {
	        boolean retorno = false;

	        try
	        {
	            String sql;

	            sql = "SELECT * " +
	                  "FROM CLINICA " +
	                  "WHERE CODCLINICA = ?";

	            BDSQLServer.COMANDO.prepareStatement (sql);

	            BDSQLServer.COMANDO.setInt (1, codigo);

	            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)

	            /* // ou, se preferirmos,

	            String sql;

	            sql = "SELECT COUNT(*) AS QUANTOS " +
	                  "FROM LIVROS " +
	                  "WHERE CODIGO = ?";

	            BDSQLServer.COMANDO.prepareStatement (sql);

	            BDSQLServer.COMANDO.setInt (1, codigo);

	            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

	            resultado.first();

	            retorno = resultado.getInt("QUANTOS") != 0;

	            */
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao procurar clinica");
	        }

	        return retorno;
	  }
	 
	 public static void incluir (Clinica clinica) throws Exception
	    {
	        if (clinica ==null)
	            throw new Exception ("Cíinica nao fornecido");

	        try
	        {
	            String sql;

	            sql = "INSERT INTO CLINICAS " +
	                  "(CODCLINICA,NOME,CEP,NUMERO,COMPLEMENTO) " +
	                  "VALUES " +
	                  "(?,?,?,?,?)";

	            BDSQLServer.COMANDO.prepareStatement (sql);

	            BDSQLServer.COMANDO.setInt    (1, clinica.getCodClinica ());
	            BDSQLServer.COMANDO.setString (2, clinica.getNome ());
	            BDSQLServer.COMANDO.setInt  (3, clinica.getCEP ());
	            BDSQLServer.COMANDO.setInt  (4, clinica.getNumero ());
	            BDSQLServer.COMANDO.setString  (5, clinica.getComplemento ());

	            BDSQLServer.COMANDO.executeUpdate ();
	            BDSQLServer.COMANDO.commit        ();
	        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao inserir livro");
	        }
	    }

	    public static void excluir (int codigo) throws Exception
	    {
	        if (!cadastrado (codigo))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;

	            sql = "DELETE FROM CLINICA " +
	                  "WHERE CODCLINICA=?";

	            BDSQLServer.COMANDO.prepareStatement (sql);

	            BDSQLServer.COMANDO.setInt (1, codigo);

	            BDSQLServer.COMANDO.executeUpdate ();
	            BDSQLServer.COMANDO.commit        ();        }
	        catch (SQLException erro)
	        {
	            throw new Exception ("Erro ao excluir clinica");
	        }
	    }

	    public static void alterar (Clinica clinica) throws Exception
	    {
	        if (clinica==null)
	            throw new Exception ("Livro nao fornecido");

	        if (!cadastrado (clinica.getCodClinica()))
	            throw new Exception ("Nao cadastrado");

	        try
	        {
	            String sql;

	            sql = "UPDATE CLINICAS " +
	                  "SET NOME=?, " +
	                  "CEP=? " + "NUMERO = ?"+
	                  "COMPLEMENTO = ?"+
	                  "WHERE CODCLINICA=?";

	            BDSQLServer.COMANDO.prepareStatement (sql);

	            BDSQLServer.COMANDO.setString (1, clinica.getNome ());
	            BDSQLServer.COMANDO.setInt  (2, clinica.getCEP ());
	            BDSQLServer.COMANDO.setInt  (3, clinica.getNumero ());
	            BDSQLServer.COMANDO.setString (4, clinica.getComplemento ());
	            BDSQLServer.COMANDO.setInt    (5, clinica.getCodClinica ());

	            BDSQLServer.COMANDO.executeUpdate ();
	            BDSQLServer.COMANDO.commit        ();
	        }
	        catch (SQLException erro)
	        {
	        	
	            throw new Exception ("Erro ao atualizar dados de clinica");
	        }
	    }

    public static MeuResultSet getClinicas() throws Exception
    {
		MeuResultSet resultado = null;

		try
		{
			String sql;

			sql = "SELECT * FROM CLINICAS";

		    BDSQLServer.COMANDO.prepareStatement(sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
		}

		catch(SQLException erro)
		{
			throw new Exception ("Erro ao recuperar as clinicas.");
		}

		return resultado;
	}
 }