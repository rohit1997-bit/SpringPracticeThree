package com.notesapp.service;

import com.notesapp.model.Notes;
import com.notesapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

   @Autowired
    private NotesRepository notesRepository;

    @Override
    public Notes createNotesForUser(@RequestBody String content, @AuthenticationPrincipal String username) {
             Notes  notes=new Notes();
             notes.setContent(content);
             notes.setOwnerUsername(username);
             return notesRepository.save(notes);
    }

    @Override
    public Notes updateNotesForUser(Long id, String content, String username) {
         Notes updatedNotes = notesRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
         updatedNotes.setContent(content);
         return notesRepository.save(updatedNotes);

    }

    @Override
    public void deleteNotesForUser(Long id, String username) {
        notesRepository.deleteById(id);
    }

    @Override
    public List<Notes> getAllNotesForUser(UserDetails username) {
        return notesRepository.findByOwnerUsername(username.getUsername());
    }
}
