package padroesprojeto.integracao.bridge.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroCargosTest {

    @Test
    void deveRetornarSempreAMesmaInstanciaDoRegistro() {
        RegistroCargos instancia1 = RegistroCargos.getInstance();
        RegistroCargos instancia2 = RegistroCargos.getInstance();
        assertSame(instancia1, instancia2);
    }

    @Test
    void deveClonarRecepcionistaPreConfigurado() throws CloneNotSupportedException {
        CargoHospitalar recepcionista = RegistroCargos.getInstance().obterCargo("Recepcionista");
        assertEquals(1000.0f, recepcionista.calcularSalario(), 0.01f);
    }

    @Test
    void deveClonarEnfermeiroPreConfigurado() throws CloneNotSupportedException {
        CargoHospitalar enfermeiro = RegistroCargos.getInstance().obterCargo("Enfermeiro");
        assertEquals(2200.0f, enfermeiro.calcularSalario(), 0.01f);
    }

    @Test
    void deveClonarMedicoPreConfigurado() throws CloneNotSupportedException {
        CargoHospitalar medico = RegistroCargos.getInstance().obterCargo("Medico");
        assertEquals(60.0f, medico.calcularSalario(), 0.01f);
    }

    @Test
    void doisClonesDoMesmoTipoDevemSerObjetosDiferentes() throws CloneNotSupportedException {
        CargoHospitalar clone1 = RegistroCargos.getInstance().obterCargo("Enfermeiro");
        CargoHospitalar clone2 = RegistroCargos.getInstance().obterCargo("Enfermeiro");
        assertNotSame(clone1, clone2);
    }

    @Test
    void alterarSalarioDeUmCloneNaoDeveAfetarOutroClone() throws CloneNotSupportedException {
        CargoHospitalar clone1 = RegistroCargos.getInstance().obterCargo("Enfermeiro");
        CargoHospitalar clone2 = RegistroCargos.getInstance().obterCargo("Enfermeiro");

        clone1.setSalarioBase(5000.0f);

        assertEquals(5500.0f, clone1.calcularSalario(), 0.01f);
        assertEquals(2200.0f, clone2.calcularSalario(), 0.01f);
    }

    @Test
    void clonesDoMesmoTipoCompartilhamAMesmaQualificacao() throws CloneNotSupportedException {
        CargoHospitalar clone1 = RegistroCargos.getInstance().obterCargo("Enfermeiro");
        CargoHospitalar clone2 = RegistroCargos.getInstance().obterCargo("Enfermeiro");

        assertSame(clone1.getQualificacao(), clone2.getQualificacao());
    }

    @Test
    void deveLancarExcecaoParaCargoInexistente() {
        try {
            RegistroCargos.getInstance().obterCargo("Estagiario");
            fail();
        } catch (CloneNotSupportedException e) {
            fail("Não deveria lançar CloneNotSupportedException para cargo inexistente");
        } catch (IllegalArgumentException e) {
            assertEquals("Cargo inexistente", e.getMessage());
        }
    }
}
