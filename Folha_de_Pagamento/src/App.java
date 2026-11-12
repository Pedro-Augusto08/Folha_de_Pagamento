import java.util.Locale;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));

        // Funcionarios CLT
        Funcionario ana = new Funcionario("Ana", 3000.00);
        Funcionario bruno = new Funcionario("Bruno", 6000.00);

        // Funcionario PJ
        FuncionarioPJ carla = new FuncionarioPJ("Carla", 50, 120);

        // Professores CLT
        Professor daniel = new Professor("Daniel", 50, 20);
        Professor elisa = new Professor("Elisa", 100, 20);

        System.out.println("===== FOLHA DE PAGAMENTO =====");

        mostrarFuncionario(ana);
        mostrarFuncionario(bruno);
        mostrarFuncionario(carla);
        mostrarFuncionario(daniel);
        mostrarFuncionario(elisa);

        System.out.println("\n===== TESTES OBRIGATORIOS =====");

        // Teste 1: entradas negativas
        testarInvalido("Salario negativo", () ->
            new Funcionario("Teste", -100));

        testarInvalido("Valor da hora negativo", () ->
            new FuncionarioPJ("Teste", -50, 10));

        testarInvalido("Horas negativas", () ->
            new FuncionarioPJ("Teste", 50, -10));

        // Teste 2: CLT com salario zero
        Funcionario zero = new Funcionario("Salario Zero", 0);
        mostrarFuncionario(zero);

        // Teste 3: PJ com zero horas
        FuncionarioPJ pjZero = new FuncionarioPJ("PJ Zero", 50, 0);
        mostrarFuncionario(pjZero);

        // Teste 4: teto do INSS
        Funcionario f8000 = new Funcionario("CLT 8000", 8000);
        Funcionario f10500 = new Funcionario("CLT 10500", 10500);
        Funcionario f12000 = new Funcionario("CLT 12000", 12000);

        System.out.printf("INSS 8000: R$ %.2f%n", f8000.calcularINSS());
        System.out.printf("INSS 10500: R$ %.2f%n", f10500.calcularINSS());
        System.out.printf("INSS 12000: R$ %.2f%n", f12000.calcularINSS());

        // Teste 5: isencao e reducao do IRRF
        Funcionario f5000 = new Funcionario("CLT 5000", 5000);

        System.out.printf("IRRF 5000: R$ %.2f%n", f5000.calcularIRRF());
        System.out.printf("IRRF 6000: R$ %.2f%n", bruno.calcularIRRF());

        // Teste 6: calcular duas vezes
        double primeiro = ana.calcularLiquido();
        double segundo = ana.calcularLiquido();

        System.out.println("Liquido igual nas duas chamadas? "
                + (primeiro == segundo));

        // Teste 7: independencia dos objetos
        System.out.printf("Liquido da Ana novamente: R$ %.2f%n",
                ana.calcularLiquido());
    }

    public static void mostrarFuncionario(Funcionario f) {

        System.out.println("\n-----------------------------");

        System.out.println("Nome: " + f.getNome());
        System.out.println("Regime: " + (f.isPJ() ? "PJ" : "CLT"));

        System.out.printf("Bruto: R$ %.2f%n", f.calcularBruto());
        System.out.printf("INSS: R$ %.2f%n", f.calcularINSS());
        System.out.printf("IRRF: R$ %.2f%n", f.calcularIRRF());
        System.out.printf("FGTS: R$ %.2f%n", f.calcularFGTS());
        System.out.printf("DAS: R$ %.2f%n", f.calcularMEI());
        System.out.printf("Liquido: R$ %.2f%n", f.calcularLiquido());
    }

    public static void testarInvalido(String descricao, Runnable teste) {

        try {
            teste.run();
            System.out.println(descricao + ": FALHOU");
        } catch (IllegalArgumentException e) {
            System.out.println(descricao + ": PASSOU - " + e.getMessage());
        }
    }
}