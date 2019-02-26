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