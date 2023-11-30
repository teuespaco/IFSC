package main;

public class Produto {
	private int codigo;
	private String nome;
	private float quantidade;
	
	public Produto (int codigo, String nome, float quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		
		public int getCodigo() {
		return this.codigo;
			
	}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public float getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(float quantidade) {
			this.quantidade = quantidade;
		}
		
		public void mostraProduto() {
			System.out.println(""+this.codigo);
			System.out.println(""+this.nome);
			System.out.println(""+this.quantidade);

		}
}