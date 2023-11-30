package main;

public class Computador {

		private String processador;
		private int ram;
		private String GPU;
		private String placaMae;
		
		public Computador (String processador, int ram) {
			this.processador = processador;
			this.ram = ram;
}	

		public String getProcessador() {
			return this.processador;
		}

		public void setProcessador(String processador) {
			this.processador = processador;
		}
		
		public boolean ligar() {
		return true;
		}
		
		public boolean desligar() {
		return true;
		}
		
		protected String tipoProcessador() {
			return this.processador;
}
		
		String tipoGPU() {
			return this.GPU;
		}
		
		public void finalize() {
			System.out.println("Tchau");
		}
}
