package mesadas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoDeposito
{
    public static Deposito leer(String path) throws FileNotFoundException
    {
	// Archivo
	Scanner sc = new Scanner(new File(path));

	// Cantidad de mesadas a leer
	int n = sc.nextInt();

	// Creo un deposito con n mesadas
	Deposito deposito = new Deposito(n);

	// Cargo las n mesadas
	for (int i = 0; i < n; i++)
	{
	    deposito.cargarMesada(i, sc.nextInt(), sc.nextInt());
	}

	sc.close();
	return deposito;
    }

    public static void escribir(String path, int salida) throws IOException
    {
	PrintWriter out = new PrintWriter(new FileWriter(path));

	out.print(salida);
	out.close();
    }

    /*
     * // int salida public static void escribir(String path, Mesada[] mesadas)
     * throws IOException { PrintWriter out = new PrintWriter(new FileWriter(path));
     * 
     * for (int i = 0; i < mesadas.length; i++) { out.println(mesadas[i].getAncho()
     * + " " + mesadas[i].getLargo()); }
     * 
     * // out.print(salida); out.close(); }
     */
}
