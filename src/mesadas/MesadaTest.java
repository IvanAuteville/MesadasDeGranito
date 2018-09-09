package mesadas;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

public class MesadaTest
{
    @Test
    public void prueba1()
    {
	Deposito deposito = null;

	String path = "E:\\Program Files (x86)\\Programas\\Eclipse\\Workspace\\MesadasDeGranito\\test\\";
	String file = "mesadas";

	int max = 13; // Cantidad de casos de prueba que tengo

	for (int i = 0; i < max; i++)
	{
	    try
	    {
		deposito = ArchivoDeposito.leer(path + file + i + ".in");
	    } catch (FileNotFoundException e)
	    {
		e.getMessage();
	    }

	    try
	    {
		ArchivoDeposito.escribir(path + file + i + ".out", deposito.apilarMesadas());
	    } catch (IOException e)
	    {
		e.getMessage();
	    }
	}
    }
}
