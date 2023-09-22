import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "ANA", "MARCOS", "DANIELA", "AFONSO"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;


        String[] candidatosSelecionadosArray = new String[5];


        String[] contatadosArray = new String[5];

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionadosArray[candidatosSelecionados] = candidato;
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }


        System.out.println("\nOs cinco candidatos selecionados são:");
        for (String candidatoSelecionado : candidatosSelecionadosArray) {
            if (candidatoSelecionado != null) {
                System.out.println(candidatoSelecionado);
            }
        }


        ligarParaCandidatosSelecionados(candidatosSelecionadosArray, contatadosArray);

        // Informa quem conseguiu contato e com quem não conseguiu contato
        System.out.println("\nConseguimos contato com:");
        for (String contatado : contatadosArray) {
            if (contatado != null) {
                System.out.println(contatado);
            }
        }

        System.out.println("\nNão conseguimos  contato com:");
        for (String candidatoSelecionado : candidatosSelecionadosArray) {
            boolean foiContatado = false;
            for (String contatado : contatadosArray) {
                if (contatado != null && contatado.equals(candidatoSelecionado)) {
                    foiContatado = true;
                    break;
                }
            }
            if (!foiContatado) {
                System.out.println(candidatoSelecionado);
            }
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void ligarParaCandidatosSelecionados(String[] candidatosSelecionados, String[] contatadosArray) {
        System.out.println("\nRealizando ligações para os candidatos selecionados:");

        for (String candidato : candidatosSelecionados) {
            if (candidato != null) {
                System.out.println("Ligando para " + candidato + "...");
                int tentativas = 0;
                boolean atendeu = false;
                while (tentativas < 3 && !atendeu) { // 3 tentativas máximas
                    tentativas++;
                    atendeu = atendeuLigacao();
                    if (atendeu) {
                        System.out.println(candidato + " atendeu à ligação na tentativa " + tentativas);
                        contatadosArray[tentativas - 1] = candidato;
                    } else {
                        System.out.println(candidato + " não atendeu à ligação na tentativa " + tentativas);
                    }
                }
            }
        }
    }

    static boolean atendeuLigacao() {

        return ThreadLocalRandom.current().nextBoolean();
    }
}
