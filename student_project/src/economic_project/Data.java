package economic_project;

public class Data {
		double []z=new double[3];
		double determ;
		/**
		 * Метод возвращающий коэффициенты уравнения
		 * @param i
		 * @return
		 */
		public double getValueOfZ(int i) {
			double value=0;
		
				value=z[i];
		
				
			return value;
		}
		public double[] getZ() {
			return z;
		}
		public void setZ(double[] z) {
			this.z = z;
		}
		public double getDeterm() {
			return determ;
		}
		public void setDeterm(double determ) {
			this.determ = determ;
		}
}
