package it.sincrono.videoteca;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Classe che permette di accedere al contenuto del database

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {





}
