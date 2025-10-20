package com.notesapp.controllers;


import com.notesapp.model.Notes;
import com.notesapp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

   @Autowired
    private NotesService notesService;

    @PostMapping
    public Notes createNotesForUser(@RequestBody String content , @AuthenticationPrincipal UserDetails user){
         String username = user.getUsername();
          System.out.println(username);
          return notesService.createNotesForUser(content,username);
    }

    @PutMapping("/{notesId}")
    public Notes updateNotesForUser(@PathVariable Long notesId, @RequestBody String content , @AuthenticationPrincipal UserDetails user){
        String username = user.getUsername();
        System.out.println(username);
      return notesService.updateNotesForUser(notesId,content,username);
    }

    @DeleteMapping("/{notesId}")
    public void deleteNotesForUser(@PathVariable Long notesId, @AuthenticationPrincipal UserDetails user){
        String username = user.getUsername();
        System.out.println(username);
        notesService.deleteNotesForUser(notesId,username);
    }

    @GetMapping
    public List<Notes> getAllNotesForUser(@AuthenticationPrincipal UserDetails username){
        List<Notes> notesList = notesService.getAllNotesForUser(username);
        System.out.println(username);
        notesList.forEach(System.out::println);
        return notesList;
    }

}
