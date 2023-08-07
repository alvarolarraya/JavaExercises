package supermercado.presentacion;

public class VistaCuartaEntrega extends VistaTerceraEntrega{
    int cerradas[];
    public VistaCuartaEntrega(int numCajas)
    {
        super(numCajas);
        cerradas = new int[1];
        cerradas[0] = -1;
    }
    public String preguntarSiCerrarCajas()
    {
        System.out.print("¿Quieres cerrar/abrir alguna caja (si/no)?: ");
        return scan.next();
    }
    public int cuantasCajasCerrar()
    {
        int cuantasCerrar,cuantasCajasSinCola;
        cuantasCajasSinCola = cuantasCajasSinCola(tamanioColas);
        System.out.print("¿Cuantas vas a abrir/cerrar (solo puedes cerrar las que no tengan clientes en cola)?: ");
        cuantasCerrar = scan.nextInt();
        while(cuantasCajasSinCola<cuantasCerrar)
        {
            System.out.println("No hay tantas cajas sin cola, piensalo bien");
            System.out.print("¿Cuantas vas a abrir/cerrar (solo puedes cerrar las que no tengan clientes en cola)?: ");
            cuantasCerrar = scan.nextInt();
        }
        return cuantasCerrar;
    }
    public int[] cualesVasACerrar(int[] modificadas)
    {
        System.out.println("¿Cuales vas a abrir/cerrar?: ");
        for(int i = 0;i<modificadas.length;i++)
        {
            System.out.print((i+1)+") ");
            modificadas[i] = scan.nextInt()-1;
            if(tamanioColas[modificadas[i]] != 0)
            {
                System.out.println("Esta caja tiene clientes en cola: no la puedes cerrar");
                System.out.print((i+1)+") ");
                modificadas[i] = scan.nextInt()-1;
            }
        }
        System.out.println("Entendido");
        return modificadas;
    }
    private int cuantasCajasSinCola(int[] tamanioColas)
    {
        int cuantasCajasVacias = 0;
        for(int i = 0;i<tamanioColas.length;i++)
        {
            if(tamanioColas[i] == 0)
                cuantasCajasVacias++;
        }
        return cuantasCajasVacias;
    }
    public boolean estaEnElArray(int numero,int[] array)
    {
        int i = 0;
        while(i < array.length && numero != array[i])
        {
            i++;
        }
        return(i != array.length);
    }
    public void mostrarTamnioColas(int[] tamanioColas)
    {
        this.tamanioColas = tamanioColas;
        System.out.println();
        System.out.println("Ha pasado una hora el tamaño de las colas son:");
        System.out.println();
        for(int i = 0; i<tamanioColas.length;i++)
        {
            if(!estaEnElArray(i,cerradas))
                System.out.println("        CABINA " +(i+1)+ ": "+tamanioColas[i]);
            else
                System.out.println("        CABINA " +(i+1)+ ": CERRADA");
        }
    }
    public void actualizarCajasCerradas(int[] cerradas)
    {
        this.cerradas = new int[cerradas.length];
        this.cerradas = cerradas;
    }
}
