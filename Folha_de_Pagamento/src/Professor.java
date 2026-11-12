public class Professor extends FuncionarioPJ {
    
  public Professor(String nome, double valorHoraAula, double horasSemanais) {
        super(nome, valorHoraAula, horasSemanais, false);
    }

    @Override
    public double calcularBruto() {
        double horasMensais = getHorasTrabalhadas() * 4.5;
        double remuneracao = getValorHora() * horasMensais;
        double dsr = remuneracao / 6.0;
        return remuneracao + dsr;
    }
}
 