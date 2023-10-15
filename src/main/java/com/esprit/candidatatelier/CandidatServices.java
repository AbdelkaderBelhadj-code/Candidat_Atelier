package com.esprit.candidatatelier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatServices {

    @Autowired
    private CandidatRepository candidatRepository;


    public Candidat addCondidat(Candidat candidat){
        return candidatRepository.save(candidat);
    }

    public Candidat updateCondidat(Candidat newCandidat, int id){
        if(candidatRepository.findById(id).isPresent()){
            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidatRepository.save(existingCandidat);
        }
        else return null;

    }
    public String deleteCandidat(int id) {
        if (candidatRepository.findById(id).isPresent()) {
            candidatRepository.deleteById(id);
            return "Candidat supprimé";
        } else return "Candidat nom supprimé";

    }


}
