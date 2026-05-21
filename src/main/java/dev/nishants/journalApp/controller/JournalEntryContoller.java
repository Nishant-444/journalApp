package dev.nishants.journalApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nishants.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/journal")
public class JournalEntryContoller {
  private final Map<Long, JournalEntry> journalEntries = new HashMap<>();

  @GetMapping
  public List<JournalEntry> getAll() {
    return new ArrayList<>(journalEntries.values());
  }

  @PostMapping()
  public boolean createEntry(@RequestBody JournalEntry myEntry) {
    journalEntries.put(myEntry.getId(), myEntry);
    return true;
  }

  @GetMapping("/id/{id}")
  public JournalEntry getJournalEntryById(@PathVariable long id) {
    return journalEntries.get(id);
  }

  @DeleteMapping("/id/{id}")
  public JournalEntry deleteJournalEntryById(@PathVariable long id) {
    return journalEntries.remove(id);
  }

  @PutMapping("id/{id}")
  public JournalEntry updateEntry(@PathVariable long id, @RequestBody JournalEntry entity) {
    return journalEntries.put(id, entity);
  }

}
