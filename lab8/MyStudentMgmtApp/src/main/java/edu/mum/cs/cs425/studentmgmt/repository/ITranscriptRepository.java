package edu.mum.cs.cs425.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;

@Repository("transcriptRepository")
public interface ITranscriptRepository extends CrudRepository<Transcript, Long> {

}
