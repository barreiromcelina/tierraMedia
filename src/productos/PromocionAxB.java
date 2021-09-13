package productos;

public class PromocionAxB extends Promocion {

	private Atraccion gratis;
	public Atraccion getGratis() {
		return this.gratis;
	}
	public PromocionAxB setGratis(Atraccion nuevaGratis) {
		this.gratis = nuevaGratis;
		return this;
	}
	
}
