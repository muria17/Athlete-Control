package Perfomance.web.controller;

import Perfomance.web.Domain.Athlete;
import Perfomance.web.Repository.AthleteRepository;
import Perfomance.web.Repository.AthleteRepositoryCustom;
import Perfomance.web.dto.AthleteDto;
import Perfomance.web.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("athlete")
public class AthleteController {
    @Autowired
    private AthleteRepository repository;
    @Autowired
    private AthleteRepositoryCustom athleteRepositoryCustom;

    private AthleteService service;

    @Autowired
    public AthleteController(AthleteService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public Athlete create(@RequestBody Athlete e) {
        return repository.save(e);
    }

    @GetMapping(value = "/athleteId/{athleteId}")
    public ResponseEntity<List<AthleteDto>> ListAthletesById(@PathVariable("athleteId") Long athleteId) {
        List<AthleteDto> athleteDtoList = athleteRepositoryCustom.findAthletesById(athleteId);
        return new ResponseEntity<List<AthleteDto>>(athleteDtoList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping(value = "/logicalDelete/{id}")
    @Transactional
    public void logicalDelete(@PathVariable Long id) {
        Athlete athlete = repository.getReferenceById(id);
        athlete.delete();
        }

    @PutMapping(value = "/update/{id}")
    public Athlete update (@RequestBody Athlete athlete, @PathVariable long id) {
        return service.update(athlete, id);
    }

    }

