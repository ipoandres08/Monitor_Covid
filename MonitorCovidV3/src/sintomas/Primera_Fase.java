package sintomas;

import monitor.Sintoma;

public class Primera_Fase extends Sintoma {

    public Primera_Fase(String n) {
        super(n);
    }

    @Override
    public int peso() {
        return 10;
    }

}
