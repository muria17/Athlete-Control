package Perfomance.web.Service;

import Perfomance.web.Domain.Athlete;
import Perfomance.web.Repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {


    private AthleteRepository repository;

    @Autowired
    public AthleteService(AthleteRepository repository) {
        this.repository = repository;
    }

    public Athlete update(Athlete athlete, Long id) {
        Athlete obj = repository.getReferenceById(id);
        obj.setNome(athlete.getNome() != null ? athlete.getNome() : obj.getNome());
        obj.setPeso(athlete.getPeso() != null ? athlete.getPeso() : obj.getPeso());
        obj.setAltura(athlete.getAltura() != null ? athlete.getAltura() : obj.getAltura());
        obj.setDataInicio(athlete.getDataInicio() != null ? athlete.getDataInicio() : obj.getDataInicio());
        obj.setIdade(athlete.getIdade() != 0 ? athlete.getIdade() : obj.getIdade());

        return repository.save(obj);
        }
}
