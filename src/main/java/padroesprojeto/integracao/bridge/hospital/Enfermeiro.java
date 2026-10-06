package padroesprojeto.integracao.bridge.hospital;

public class Enfermeiro extends CargoHospitalar {

    public Enfermeiro(float salarioBase) {
        super(salarioBase);
    }

    public float calcularSalario() {
        return this.salarioBase * (1 + this.qualificacao.percentualAumento());
    }
}
