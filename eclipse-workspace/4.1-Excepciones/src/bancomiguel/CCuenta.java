package bancomiguel;

public abstract class CCuenta {
	private String nombre;
	private String cuenta;
	private double interes;
	private double saldo;

	public CCuenta(String nombre, String cuenta, double interes, double saldo) {
		this.interes = interes;
		ingreso(saldo);
		this.nombre = nombre;
		this.cuenta = cuenta;
	}

	//////////////////////////
	public String getNombre() {
		return nombre;
	}

	//////////////////////////
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//////////////////////////
	public String getCuenta() {
		return cuenta;
	}

	//////////////////////////
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	//////////////////////////
	public double getInteres() {
		return interes;
	}

	//////////////////////////
	public void setInteres(double interes) {
		this.interes = interes;
	}

	//////////////////////////
	public double getSaldo() {
		return saldo;
	}

	//////////////////////////
	public void ingreso(double cantidad) {
		try {
			if (cantidad < 0) {
				throw new CantidadNegativo();
			} else
				saldo = saldo + cantidad;
		} catch (CantidadNegativo error) {
			System.out.println("La cantidad es negativa");
		}

	}

	//////////////////////////
	public void reintegro(double cantidad) {
		try {
			if (cantidad < 0) {
				throw new CantidadNegativo();
			} else {
				if (cantidad > saldo) {
					throw new SaldoInsuficiente();
				}
				saldo -= cantidad;
			}
		} catch (SaldoInsuficiente error) {
			System.out.println("La cantidad del reintegro es superior al de la cuenta");
		} catch (CantidadNegativo error) {
			System.out.println("La cantidad es inferior a 0");
		}
	}

	//////////////////////////
	public abstract void comisiones();

	//////////////////////////
	public abstract double intereses();
	//////////////////////////

	public void verDatos() {
		System.out.println("Usuario: " + "'" + nombre + "'" + " con numero de cuenta:" + "'" + cuenta + "'"
				+ " y saldo de: " + "'" + saldo + "'");
	}
}

class SaldoInsuficiente extends Exception {
	public SaldoInsuficiente() {
		super();
	}
}

class CantidadNegativo extends Exception {
	public CantidadNegativo() {
		super();
	}
}
