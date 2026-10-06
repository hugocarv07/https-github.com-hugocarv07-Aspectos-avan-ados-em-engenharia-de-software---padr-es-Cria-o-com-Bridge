package padroesprojeto.integracao.bridge.hospital;

/**
 * Abstraction do Bridge (guarda uma Qualificacao por composição) que
 * também é um Prototype: pode ser clonada em vez de reconstruída do
 * zero a cada novo funcionário com o mesmo perfil de cargo.
 *
 * A Qualificacao não tem estado próprio (suas implementações são
 * imutáveis), então o clone compartilha a mesma referência em vez de
 * cloná-la também — diferente de um atributo mutável, que precisaria de
 * cópia profunda para não ser compartilhado entre os clones.
 */
public abstract class CargoHospitalar implements Cloneable {

    protected Qualificacao qualificacao;

    protected float salarioBase;

    public CargoHospitalar(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setQualificacao(Qualificacao qualificacao) {
        this.qualificacao = qualificacao;
    }

    public Qualificacao getQualificacao() {
        return qualificacao;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract float calcularSalario();

    @Override
    public CargoHospitalar clone() throws CloneNotSupportedException {
        return (CargoHospitalar) super.clone();
    }
}
