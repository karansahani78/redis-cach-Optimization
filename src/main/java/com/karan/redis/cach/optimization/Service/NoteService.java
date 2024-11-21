package com.karan.redis.cach.optimization.Service;

import com.karan.redis.cach.optimization.Model.Note;
import com.karan.redis.cach.optimization.Repository.NoteRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;
    // save notes
    @CachePut(value = "notes",key = "#note.id")
    public Note saveNotes(Note note){
        return noteRepo.save(note);
    }

    // get all notes
    public List<Note>getAllNotes(){
        return noteRepo.findAll();
    }
    // get notes by id
    @Cacheable(value = "notes",key = "#id")
    public Optional<Note> fetchNoteById(String id){
        return noteRepo.findById(id);
    }
    // update notes
    public Note updateNotes(String id, Note note) {
        Note existingNote = noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found for given id: " + id));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        existingNote.setAdded(note.getAdded());
        existingNote.setLive(note.isLive());
        return noteRepo.save(existingNote);
    }

    // delete all notes
    public void deleteAll(){
        if(noteRepo!=null){
            noteRepo.deleteAll();
        } else{
           throw  new IllegalArgumentException("Note Repo is Empty");
        }
    }
    // delete note by id
    @CacheEvict(value = "notes",key = "#id")
    public void deleteById(String id){
        noteRepo.deleteById(id);
    }
}
