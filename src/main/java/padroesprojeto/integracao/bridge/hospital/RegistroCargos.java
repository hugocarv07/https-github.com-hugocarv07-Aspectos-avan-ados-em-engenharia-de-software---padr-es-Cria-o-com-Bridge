package padroesprojeto.integracao.bridge.hospital;

import java.util.HashMap;
import java.util.Map;

/**
 * Integra dois padrões criacionais com o Bridge já existente:
 *
 * - Singleton: só existe um RegistroCargos no sistema (getInstance()).
 * - Prototype: em vez de reconstruir um CargoHospitalar do zero (new +
 *   setSalarioBase + setQualificacao) toda vez, o registro guarda
 *   protótipos já configurados e devolve CLONES deles.
 *
 * O CargoHospitalar clonado continua sendo, por baixo, a mesma estrutura
 * de Bridge: a Abstraction (CargoHospitalar) com sua Qualificacao por
 * composição. O clone só evita repetir a configuração inicial.
 */
public class RegistroCargos {

    private RegistroCargos() {
        prototipos.put("Recepcionista", criarRecepcionistaPadrao());
        prototipos.put("Enfermeiro", criarEnfermeiroPadrao());
        prototipos.put("Medico", criarMedicoPadrao());
    }

    private static RegistroCargos instance = new RegistroCargos();
    public static RegistroCargos getInstance() {
        return instance;
    }

    private Map<String, CargoHospitalar> prototipos = new HashMap<>();

    public CargoHospitalar obterCargo(String tipo) throws CloneNotSupportedException {
        CargoHospitalar prototipo = prototipos.get(tipo);
        if (prototipo == null) {
            throw new IllegalArgumentException("Cargo inexistente");
        }
        return prototipo.clone();
    }

    private Recepcionista criarRecepcionistaPadrao() {
        Recepcionista recepcionista = new Recepcionista(1000.0f);
        recepcionista.setQualificacao(new EnsinoTecnico());
        return recepcionista;
    }

    private Enfermeiro criarEnfermeiroPadrao() {
        Enfermeiro enfermeiro = new Enfermeiro(2000.0f);
        enfermeiro.setQualificacao(new Graduacao());
        return enfermeiro;
    }

    private Medico criarMedicoPadrao() {
        Medico medico = new Medico(50.0f);
        medico.setQualificacao(new Mestrado());
        medico.setNumPlantoes(1);
        return medico;
    }
}
