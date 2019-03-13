package bd;

import bd.core.*;
import bd.dao.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://regulus:1433;databasename=BD18194",
            "BD18194", "604020gu");
        }
        catch (Exception erro)
        {
            System.err.println (erro);
            System.exit(0); // aborta o programa
        }

        COMANDO = comando;
    }
}