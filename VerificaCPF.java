package VerificaCPF;
public class VerificaCPF {
	
	private String cpf;
		
	public String getCpf() {
		return cpf;
	}
	
	public String gerarcpf() {
		VerificaCPF verificaCPF = new VerificaCPF();
		long start = 66610000000L;
		start = (long) (Math.random() * start);

		String cpf = null;
		for(long i = start; i < 99999999999L; start++ ) {
			verificaCPF.setCpf(Long.toString(start));
			if (verificaCPF.cpfIsValid()) {
				start = Long.parseLong(verificaCPF.getCpf());
				System.out.println(verificaCPF.getCpf());
				cpf = verificaCPF.getCpf();
				break;
			}
		}
		start = Long.parseLong(verificaCPF.getCpf()) + 1;
		return cpf;
	}

	public void setCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		this.cpf = cpf;
	}

	private  int primeirodigito() {
		int resultado = 0;
		for (int i = 0, j = 10; i < this.cpf.length() - 2 && j > 0; i++, j--) {
			int num = Character.getNumericValue(cpf.charAt(i));
			resultado += num * j ;
		}
		int resto = resultado % 11;
		resultado = 11 - resto;
		if (resultado > 9) {
			return 0;
		}
		return resultado;
	}
	
	private int segundodigito() {
		int resultado = 0;
		for (int i = 0, j = 11; i < this.cpf.length() - 1 && j > 0; i++, j--) {
			int num = Character.getNumericValue(cpf.charAt(i));
			resultado += num * j ;
		}
		int resto = resultado % 11;
		resultado = 11 - resto;
		if (resultado > 9) {
			return 0;
		}
		return resultado;
	}
	
	public boolean cpfIsValid() {
		if (cpf.equals("00000000000") ||
		    cpf.equals("11111111111") ||
			cpf.equals("22222222222") ||
			cpf.equals("33333333333") ||
			cpf.equals("44444444444") ||
			cpf.equals("55555555555") ||
			cpf.equals("66666666666") ||
			cpf.equals("77777777777") ||
			cpf.equals("88888888888") ||
			cpf.equals("99999999999") 
			){
			System.out.println("Não existe CPF com todos os números iguais válido: " + cpf);
			return false;
		}else {
			
			if  (Character.getNumericValue(cpf.charAt(9)) == primeirodigito() && Character.getNumericValue(cpf.charAt(10))  == segundodigito()) {
				return true;
			}else {
				return false;
			}
		}
	}
}
