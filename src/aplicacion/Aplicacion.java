package aplicacion;

import java.util.List;
import java.util.Scanner;

import dominio.Mascota;
import dominio.MascotaApta;
import dominio.Veterinaria;

public class Aplicacion {

	public static void main(String[] args) {
		
		Veterinaria veterina = new Veterinaria();
		String menu = "               BIENVENIDO A NUESTRA VETERINARIA                  "
				+ "\n¿Qué desea hacer? (Digite una opción)"
				+ "\n1. Verificar si puedo operar una mascota (Registro)."
				+ "\n2. Consultar los pacientes pendientes de operación."
				+ "\n3. Operar pacientes."
				+ "\n4. Salir.";
		@SuppressWarnings("resource")
		Scanner lector = new Scanner(System.in);
		int opcion = 0;
		
		do {
			
			System.out.println(menu);
			opcion = lector.nextInt();
			
			switch (opcion) {
			case 1:
				
				System.out.println("Ingrese el nombre del paciente: ");
				String nombre = lector.next();
				
				System.out.println("Ingrese el sexo de la mascota (macho o hembra)");
				String sexo = lector.next();
				
				System.out.println("Ingrese la edad del paciente (En meses): ");
				int edad = lector.nextInt();
				
				System.out.println("¿La mascota se encuentra esterilizada? (Si/No)");
				String estaEsterilizado = lector.next();
				boolean esterilizado;
				
				if (estaEsterilizado.equals("Si")) {
					esterilizado = true;
				} else {
					esterilizado = false;
				}
				
				Mascota mascota = veterina.revisarMascota(nombre, sexo, edad, esterilizado);
				
				System.out.println("La mascota fue registrada con éxito");
				break;

			case 2:
				
				List<MascotaApta> mascotasPendientes = veterina.getPacientesAOperar();
				
				for (MascotaApta mascotaApta : mascotasPendientes) {
					System.out.println("Nombre: " + mascotaApta.getNombre()
					+ "\nSexo: " + mascotaApta.getSexo()
					+ "\nEdad: " + mascotaApta.getEdad());
				}
				
				break;
			
			case 3:
				
				veterina.operar();
				
				System.out.println("Los pacientes han sido operados.");
				break;
			}
		} while (opcion != 4);
	}

}
