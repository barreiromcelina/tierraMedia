package model.nullobjects;

import model.Atraccion;
import model.TipoAtraccion;


public class NullAtr extends Atraccion{
	
	public NullAtr() {
		super(-1, "", 0, TipoAtraccion.valueOf("PAISAJE"), 0, 0);
		
	}

	public static Atraccion build() {
		return new NullAtr();
	}
	
	public boolean isNull() {
		return true;
	}

}
