package com.karan.redis.cach.optimization.Controller;

import com.karan.redis.cach.optimization.Model.Note;
import com.karan.redis.cach.optimization.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class NoteController {
    @Autowired
    private NoteService noteService;
    // save use
    @PostMapping("/notes")
    public Note saveNotes(@RequestBody Note note){
        return noteService.saveNotes(note);
    }
    // get all users
    @GetMapping
    public List<Note>fetchAllNotes(){
        return noteService.getAllNotes();
    }

    // get user by id
    @GetMapping("/{id}")
    public Optional<Note>findNoteById(@PathVariable String id){
        return noteService.fetchNoteById(id);
    }
    // update users
    @PutMapping("/{id}")
    public Note updateNotes(@PathVariable String id, @RequestBody Note note){
        return noteService.updateNotes(id,note);
    }
    // delete all users
    @DeleteMapping
    public void delete(){
        noteService.deleteAll();
    }
    // delete user by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        noteService.deleteById(id);
    }
}
