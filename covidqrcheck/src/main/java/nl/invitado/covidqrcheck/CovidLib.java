package nl.invitado.covidqrcheck;

import com.sun.jna.Library;

public interface CovidLib extends Library {
    String CheckCode(GoSlice.ByValue code);
}
