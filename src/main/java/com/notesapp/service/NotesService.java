package com.notesapp.service;

import com.notesapp.model.Notes;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface NotesService {

    Notes createNotesForUser(String content , String username);

    Notes updateNotesForUser(Long id ,String content , String username);

    void deleteNotesForUser(Long id ,String username);

    List<Notes> getAllNotesForUser(UserDetails username) ;
}
