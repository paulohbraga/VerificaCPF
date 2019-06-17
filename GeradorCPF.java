package VerificaCPF;
public class GeradorCPF {
	
	private String cpf;
		
	public String getCpf() {
		return cpf;
	}

	public String gerarcpf() {
		VerificaCPF verificaCPF = new VerificaCPF();
		long start = 66610000000L;
		start =  start + (long) (Math.random() * (start - 99999999999L));

		String cpf = null;
		for(long i = start; i < 99999999999L; start++ ) {
			verificaCPF.setCpf(Long.toString(start));
			if (verificaCPF.cpfIsValid()) {
				start = Long.parseLong(verificaCPF.getCpf());
				cpf = verificaCPF.getCpf();
				break;
			}
		}
		start = Long.parseLong(verificaCPF.getCpf()) + 1;
		String cpf_part1 = cpf.substring(0,3);
		String cpf_part2 = cpf.substring(3,6);
		String cpf_part3 = cpf.substring(6,9);
		String cpf_digits = cpf.substring(9,11);;
		cpf = cpf_part1 + "." + cpf_part2 + "." + cpf_part3 + "-" + cpf_digits;
		
		return cpf;
	}

}
