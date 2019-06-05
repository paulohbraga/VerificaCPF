package VerificaCPF;
public class GeradorCPF {
	
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

}
