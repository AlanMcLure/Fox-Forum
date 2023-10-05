package net.ausiasmarch.foxforumserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.foxforumserver.entity.ReplyEntity;
import net.ausiasmarch.foxforumserver.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyApi {
    
    @Autowired
    ReplyService replyService;

    @GetMapping("/{id}")
    public ResponseEntity<ReplyEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(replyService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<ReplyEntity> create(@RequestBody ReplyEntity replyEntity) {
        return ResponseEntity.ok(replyService.create(replyEntity));
    }

    @PutMapping("")
    public ResponseEntity<ReplyEntity> update(@RequestBody ReplyEntity replyEntity) {
        return ResponseEntity.ok(replyService.update(replyEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReplyEntity> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(replyService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<ReplyEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(replyService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(replyService.populate(amount));
    }
}
