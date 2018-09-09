package mesadas;

public class Mesada implements Comparable<Mesada>
{
    private int ancho = 0;
    private int largo = 0;
    private boolean esActiva = true;

    public Mesada(int ancho, int largo)
    {
	this.ancho = ancho;
	this.largo = largo;
    }

    public void rotar90()
    {
	int aux = this.ancho;
	this.ancho = this.largo;
	this.largo = aux;
    }

    public void setearPorAncho()
    {
	if (this.ancho < this.largo)
	{
	    this.rotar90();
	}
    }

    public int getLargo()
    {
	return this.largo;
    }

    public int getAncho()
    {
	return this.ancho;
    }

    public boolean esApilable(Mesada otra)
    {
	if (this.ancho >= otra.ancho && this.largo >= otra.largo)
	{
	    return true;
	}

	return false;
    }

    public boolean esActiva()
    {
	return this.esActiva;
    }

    public void setInactiva()
    {
	this.esActiva = false;
    }
    
    // Comparacion por ancho
    @Override
    public int compareTo(Mesada otra)
    {
	return -(this.ancho - otra.ancho);
    }
}
