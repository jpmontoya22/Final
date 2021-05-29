package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Veterinaria {
	
	private String nombre;
	private List<Mascota> pacientes = new ArrayList<>();
	
	public boolean esAptoParaOperar(String nombre, String sexo, int edad, boolean esterilizado) {
		boolean apto = false;
		if(!esterilizado) {
			if(sexo == "macho") {
				if(edad >= 12) {
					apto = true;
				}
			} else {
				if(edad >= 18) {
					apto = true;
				}
			}
		}
		return apto;
	}
	
	public Mascota revisarMascota(String nombre, String sexo, int edad, boolean esterilizado) {
		Mascota mascota = null;
		if(esAptoParaOperar(nombre, sexo, edad, esterilizado)) {
			mascota = new MascotaApta(nombre, sexo, edad, esterilizado);
		} else {
			mascota = new MascotaEsterilizada(nombre, sexo, edad, esterilizado);
		}
		return mascota;
	}
	
	public List<MascotaApta> getPacientesAOperar(){
		List<MascotaApta> mascotasAptas = new ArrayList<>();
		for (Mascota mascota : pacientes) {
			if(esAptoParaOperar(mascota.getNombre(), mascota.getSexo(), mascota.getEdad(), mascota.isEsterilizado())) {
				mascotasAptas.add((MascotaApta) mascota);
			}
		}
		return mascotasAptas;
	}
	
	public void operar() {
		List<MascotaApta> mascotasAOperar = this.getPacientesAOperar();
		for (MascotaApta mascotaApta : mascotasAOperar) {
			mascotaApta.operar();
		}
	}
}
