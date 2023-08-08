package br.edu.umfg.tecnologia;

public class Aluno {
    private int ra;
    private String nome;
    private double notaPrimeiraProva ;
    private double notaSegundaProva;
    private double notaTrabalho;

    private static final double PESO_PROVA = 0.35;
    private static final double PESO_TRABALHO = 0.3;
    private static final double MEDIA_APROVADO = 7.0;
    private static final String APROVADO = "APROVADO";
    private static final String EXAME = "EXAME";

    public Aluno(int ra, String nome, double notaPrimeiraProva,
                 double notaSegundaProva, double notaTrabalho)
            throws Exception {
        this.ra = ra;
        this.nome = nome;
        this.notaPrimeiraProva = notaPrimeiraProva;
        this.notaSegundaProva = notaSegundaProva;
        this.notaTrabalho = notaTrabalho;

        validarNota(notaPrimeiraProva);
        validarNota(notaSegundaProva);
        validarNota(notaTrabalho);
    }

    public double media(){
        return ((notaPrimeiraProva + notaSegundaProva ) * PESO_PROVA)
            + (notaTrabalho * PESO_TRABALHO);
    }

    public String situacao(){
        return media() >= MEDIA_APROVADO ? APROVADO : EXAME;
    }

    @Override
    public String toString(){
        return " RA: "+ ra + " Nome: " + nome ;
    }

    private void validarNota(double nota) throws Exception {
        if (nota < 0 || nota > 10)
            throw new Exception("Valor nota " + nota + " inválido!");
    }
}
