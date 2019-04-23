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
			
		
				
			return z[i];
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
