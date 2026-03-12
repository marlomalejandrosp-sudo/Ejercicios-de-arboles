public class Main {
    public static void main(String[] args) {
        String[] equipos = {"EquipoA", "EquipoB", "EquipoC", "EquipoD",
                "EquipoE", "EquipoF", "EquipoG", "EquipoH"};

        Torneo torneo = new Torneo(equipos);

        torneo.simularRonda(torneo.finalPartido);
        System.out.println("Ganador de la ronda: " + torneo.finalPartido.ganador);

        torneo.simularTorneo();

        System.out.println("=== Bracket del Torneo ===");
        torneo.mostrarBracket(torneo.getFinalPartido());

        System.out.println("\nCampeón: " + torneo.getCampeon());
    }
}
