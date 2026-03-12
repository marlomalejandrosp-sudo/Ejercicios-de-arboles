class NodoTorneo {
    String equipo1;
    String equipo2;
    String ganador;
    String ronda;
    NodoTorneo izquierda; // partido previo izquierdo
    NodoTorneo derecha;   // partido previo derecho

    public NodoTorneo(String equipo1, String equipo2, String ronda) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.ronda = ronda;
        this.ganador = null;
        this.izquierda = null;
        this.derecha = null;
    }
}
