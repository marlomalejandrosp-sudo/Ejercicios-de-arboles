public class Torneo {
    public NodoTorneo finalPartido;
    public NodoTorneo qf1, qf2, qf3, qf4;
    public NodoTorneo semi1, semi2;

    public Torneo(String[] equipos) {
        if (equipos.length != 8) {
            throw new IllegalArgumentException("Se necesitan exactamente 8 equipos.");
        }

        // Cuartos de final
        qf1 = new NodoTorneo(equipos[0], equipos[1], "Cuartos");
        qf2 = new NodoTorneo(equipos[2], equipos[3], "Cuartos");
        qf3 = new NodoTorneo(equipos[4], equipos[5], "Cuartos");
        qf4 = new NodoTorneo(equipos[6], equipos[7], "Cuartos");

        // Semifinales
        semi1 = new NodoTorneo(null, null, "Semifinal");
        semi1.izquierda = qf1;
        semi1.derecha = qf2;

        semi2 = new NodoTorneo(null, null, "Semifinal");
        semi2.izquierda = qf3;
        semi2.derecha = qf4;

        // Final
        finalPartido = new NodoTorneo(null, null, "Final");
        finalPartido.izquierda = semi1;
        finalPartido.derecha = semi2;
    }


    public void simularRonda(NodoTorneo nodo) {
        if (nodo == null) return;
        if (nodo.equipo1 != null && nodo.equipo2 != null) {
            nodo.ganador = Math.random() < 0.5 ? nodo.equipo1 : nodo.equipo2;
        } else {
            System.out.println("Este partido aún no tiene equipos asignados.");
        }
    }

    public void recorrerYSimular(NodoTorneo nodo) {
        if (nodo == null) return;

        recorrerYSimular(nodo.izquierda);
        recorrerYSimular(nodo.derecha);

        if (nodo.izquierda == null && nodo.derecha == null) {

            nodo.ganador = Math.random() < 0.5 ? nodo.equipo1 : nodo.equipo2;
        } else {

            nodo.equipo1 = nodo.izquierda.ganador;
            nodo.equipo2 = nodo.derecha.ganador;
            nodo.ganador = Math.random() < 0.5 ? nodo.equipo1 : nodo.equipo2;
        }
    }


    public void simularTorneo() {
        recorrerYSimular(finalPartido);
    }

    public void mostrarBracket(NodoTorneo nodo) {
        if (nodo == null) return;
        mostrarBracket(nodo.izquierda);
        mostrarBracket(nodo.derecha);
        if (nodo.equipo1 != null && nodo.equipo2 != null) {
            System.out.println(nodo.ronda + ": " + nodo.equipo1 + " vs " + nodo.equipo2 + " - Ganador: " + nodo.ganador);
        }
    }

    public String getCampeon() {
        return finalPartido.ganador;
    }

    public NodoTorneo getFinalPartido() {
        return finalPartido;
    }
}
