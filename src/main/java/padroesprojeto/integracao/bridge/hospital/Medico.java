package padroesprojeto.integracao.bridge.hospital;

public class Medico extends CargoHospitalar {

    private int numPlantoes;

    public Medico(float salarioBase) {
        super(salarioBase);
    }

    public void setNumPlantoes(int numPlantoes) {
        this.numPlantoes = numPlantoes;
    }

    public int getNumPlantoes() {
        return numPlantoes;
    }

    public float calcularSalario() {
        return this.salarioBase * this.numPlantoes * (1 + this.qualificacao.percentualAumento());
    }
}
