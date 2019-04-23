package economic_project;

class DataException extends Exception {
	private static final long serialVersionUID = 1L;
	private double number;

	public DataException(String message, Double num) {
		
		super(message);//Вызов конструктора класса Exception 
		number = num;
	}

	
	/**
	 * Если в файле исходных данных поменять значение на неверное,то вернется это значение
	 * @return
	 */
	public double getNumber() {
		return number;
	}

	
}
