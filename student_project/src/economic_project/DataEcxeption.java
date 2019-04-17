package economic_project;

class DataException extends Exception {
	private static final long serialVersionUID = 1L;
	private double number;

	public DataException(String message, Double num) {
		super(message);
		number = num;
	}

	

	public double getNumber() {
		return number;
	}

	
}
