package ordenamientoArreglo;

public class sortMethods {
	// Estos metodos son para imprimir en cadena para la interfaz grafica
	public String sortByBubbleAscendInterfaz(int[] arr, boolean logs) {
		StringBuilder log = new StringBuilder();
		int[] arreglo = arr.clone();

		log.append("Arreglo inicio " + imprimeInterfaz(arreglo)).append("\n");
		int tamano = arreglo.length;
		int pasadas = 0;
		for (int i = 0; i < tamano; i++) {
			if (logs) {
				log.append("\nPass num ").append(i).append("\n");
			}
			for (int j = i + 1; j < tamano; j++) {
				if (logs) {
					log.append("i= ").append(arreglo[i]).append(" j= ").append(arreglo[j]).append("\n");
				}
				if (arreglo[i] > arreglo[j]) {
					if (logs) {
						log.append("-Si es mayor se realiza el cambio\n");
					}
					int temporal = arreglo[i];
					arreglo[i] = arreglo[j];
					arreglo[j] = temporal;
					pasadas++;
					if (logs) {
						log.append(imprimeInterfaz(arreglo)).append("\n");
					}
				}
			}
		}
		log.append("Total de pasadas: ").append(pasadas).append("\n");
		log.append(imprimeInterfaz(arreglo)).append("\n");
		return log.toString();
	}

	public String sortBySelectionAscendInterfaz(int[] arr, boolean logs) {
		StringBuilder log = new StringBuilder();
		int[] arreglo = arr.clone();
		log.append("Arreglo inicio " + imprimeInterfaz(arreglo)).append("\n");

		int tamano = arreglo.length;
		int pasadas = 0;
		for (int i = 0; i < tamano - 1; i++) {

			int num = i;
			for (int j = i + 1; j < tamano; j++) {
				if (logs) {
					log.append("\nValor index menor: " + arreglo[num]);
					log.append(" Comparacion: " + arreglo[j]);
				}
				if (arreglo[j] < arreglo[num]) {
					if (logs) {
						log.append("\nintercambio");
					}
					num = j;
				}
			}
			if (logs) {
				log.append("\nSe intercambia el valor de index menor: " + arreglo[num] + " con el valor actual: "
						+ arreglo[i]);
			}
			int temporal = arreglo[num];
			arreglo[num] = arreglo[i];
			arreglo[i] = temporal;
			pasadas++;
			if (logs) {
				log.append("\nPass num ").append(pasadas).append("\n");
				log.append(imprimeInterfaz(arreglo)).append("\n");
			}
		}
		log.append("Total de pasadas: ").append(pasadas).append("\n");
		log.append(imprimeInterfaz(arreglo)).append("\n");
		return log.toString();
	}

	public String sortByInsertionAscendInterfaz(int[] arr, boolean logs) {
		StringBuilder log = new StringBuilder();
		int[] arreglo = arr.clone();
		log.append("Arreglo inicio " + imprimeInterfaz(arreglo)).append("\n");

		int tamano = arreglo.length;
		int pasadas = 0;
		for (int i = 1; i < tamano; ++i) {
			int key = arreglo[i];
			int j = i - 1;
			if (logs) {
				log.append("\nValor Actual: " + key);
			}
			while (j >= 0 && arreglo[j] > key) {

				if (logs) {
					log.append("\nValor Actual: " + key);
					log.append(" Valor Comparar: " + arreglo[j]);
					log.append("\nIntercambio");
				}
				arreglo[j + 1] = arreglo[j];
				j = j - 1;
			}

			arreglo[j + 1] = key;
			pasadas++;
			if (logs) {
				log.append("\nPass num ").append(pasadas).append("\n");
				log.append(imprimeInterfaz(arreglo)).append("\n");
			}
		}
		log.append("Total de pasadas: ").append(pasadas).append("\n");
		log.append(imprimeInterfaz(arreglo)).append("\n");
		return log.toString();
	}

	public String sortByBubbleUpgradeAscendInterfaz(int[] arr, boolean logs) {
		StringBuilder log = new StringBuilder();
		int[] arreglo = arr.clone();
		log.append("Arreglo inicial " + imprimeInterfaz(arreglo)).append("\n");

		int tamano = arreglo.length - 1;
		int pasadas = 0;
		boolean flag = true;
		while (tamano > 0 && flag) {
			flag = false;
			if (logs) {
				log.append("\nPass num ").append(pasadas + 1).append("\n");
			}
			for (int i = 0; i < tamano; i++) {
				if (logs) {
					log.append("\nComparación ").append(i+1).append("\n");
					log.append("i= ").append(arreglo[i]).append(" j= ").append(arreglo[i + 1]).append("\n");
				}
				if (arreglo[i] > arreglo[i + 1]) {
					if (logs) {
						log.append("-Se realiza el cambio ya que i=").append(arreglo[i]).append(" es mayor que j=").append(arreglo[i+1]).append("\n");
					}
					int temporal = arreglo[i];
					arreglo[i] = arreglo[i + 1];
					arreglo[i + 1] = temporal;
					flag = true;
				}
				if (logs) {
					log.append("\nTras la comparación ").append(i + 1).append(" el arreglo queda de esta manera:").append("\n");
					log.append(imprimeInterfaz(arreglo)).append("\n");
				}
			}
			if (logs) {
				log.append("\nTras la pasada ").append(pasadas + 1).append(" el arreglo queda de esta manera:").append("\n");
				log.append(imprimeInterfaz(arreglo)).append("\n");
			}
			pasadas++;
		}
		log.append("Total de pasadas: ").append(pasadas).append("\n");
		log.append("Arreglo final tras las pasadas: ").append("\n");
		log.append(imprimeInterfaz(arreglo)).append("\n");
		return log.toString();
	}

	public String imprimeInterfaz(int[] arreglo) {
		StringBuilder result = new StringBuilder();
		for (int i : arreglo) {
			result.append(i).append(" ");
		}
		return result.toString();
	}
}
