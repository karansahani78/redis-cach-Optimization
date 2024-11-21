package com.karan.redis.cach.optimization.Repository;

import com.karan.redis.cach.optimization.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, String> {
}
