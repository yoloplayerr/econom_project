package economic_project;

class DataException extends Exception {
	

	public DataException(String message, Double num) {
		super(message);
		number = num;
	}

	private static final long serialVersionUID = 1L;
	private double number;

	public double getNumber() {
		return number;
	}

	
}
