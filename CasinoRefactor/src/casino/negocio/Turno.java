package casino.negocio;

public class Turno{
    
	public Jugador Jugador1;
	public Jugador Jugador2;
        private Boolean GanadoConOjosDeTigre;
        
	public Turno(Jugador jugador1, Jugador jugador2)
	{
            this.Jugador1 = jugador1;
            this.Jugador2 = jugador2;
            this.GanadoConOjosDeTigre = false;
        }
        
        public void jugar(){
            this.GanadoConOjosDeTigre = false;
            this.Jugador1.juega();
            this.Jugador2.juega();
        }

	public Jugador ganador(){
            
            if(this.Jugador1.resultado().esOjosDeTigre() && 
               this.Jugador2.resultado().esOjosDeTigre())
                return null;
            
            if(this.Jugador1.resultado().esOjosDeTigre()){
                this.GanadoConOjosDeTigre = true;
                return this.Jugador1;
            } 
            
            if(this.Jugador2.resultado().esOjosDeTigre()){
                this.GanadoConOjosDeTigre = true;
                return this.Jugador2;
            }
            
            if(this.Jugador1.resultado().Comparar(this.Jugador2.resultado()) == eResultado.GANAR){
                this.Jugador1.computarVictoria();
                return Jugador1;
            }
            if(this.Jugador1.resultado().Comparar(this.Jugador2.resultado()) == eResultado.PERDER){
                this.Jugador2.computarVictoria();
                return Jugador2;
            }
            return null;
        }
        
        public Boolean GanadoConOjosDeTigre(){
            return this.GanadoConOjosDeTigre;
        }
}
