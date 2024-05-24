package Presencial.service;

import Presencial.dao.MedicamentoDAOH2;
import Presencial.dao.iDao;
import Presencial.model.Medicamento;

public class MedicamentoService {
    //siempre vamos a asociarnos con el DAO
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService() {
        medicamentoiDao= new MedicamentoDAOH2();
    }
    //aca van todos los metodos del DAO pero manuales.

    public Medicamento guardarMedicamento(Medicamento medicamento){
        return medicamentoiDao.guardar(medicamento);
    }
}
