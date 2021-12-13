package model.nullobjects;

import model.TipoAtraccion;
import model.Usuario;

public class NullUser extends Usuario {

	public static Usuario build() {
		return new NullUser();
	}
	
	public NullUser() {
		super(0, false, "", "", 0.0, 0.0, TipoAtraccion.valueOf("PAISAJE"));
	}
	
	public boolean isNull() {
		return true;
	}
	
}
