package mesadas;

import java.util.Arrays;

public class Deposito
{
    private Mesada mesadas[] = null;
    private int pilas = 0;

    public Deposito(int n)
    {
	this.mesadas = new Mesada[n];
    }

    public void cargarMesada(int index, int ancho, int alto)
    {
	this.mesadas[index] = new Mesada(ancho, alto);
    }

    public int apilarMesadas()
    {
	// El lado mas grande de cada mesada sera su "ancho"
	// y luego ordenamos el vector de mayor a menos por "ancho"
	this.ordenarPorAncho();

	// Con el vector ordenado, "apilamos"
	for (int i = 0; i < this.mesadas.length; i++)
	{
	    if (this.mesadas[i].esActiva())
	    {
		recorrer(this.mesadas[i], i + 1);
		pilas++;
	    }
	}

	return this.pilas;
    }

    private void ordenarPorAncho()
    {
	// Acomodo por lado
	for (int i = 0; i < this.mesadas.length; i++)
	{
	    this.mesadas[i].setearPorAncho();
	}

	// Ordeno el vector
	Arrays.sort(this.mesadas);
    }

    private void recorrer(Mesada mesada, int index)
    {
	for (int j = index; j < this.mesadas.length; j++)
	{
	    if (this.mesadas[j].esActiva() && mesada.esApilable(this.mesadas[j]))
	    {
		mesada.setInactiva(); // El padre se vuelve inactivo
		this.mesadas[j].setInactiva(); // Y el hijo tambien

		recorrer(this.mesadas[j], j + 1);
		break;
	    }
	}
    }

}
