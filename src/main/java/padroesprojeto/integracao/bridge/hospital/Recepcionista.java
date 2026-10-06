package padroesprojeto.integracao.bridge.hospital;

public class Recepcionista extends CargoHospitalar {

    public Recepcionista(float salarioBase) {
        super(salarioBase);
    }

    public float calcularSalario() {
        return this.salarioBase;
    }
}
